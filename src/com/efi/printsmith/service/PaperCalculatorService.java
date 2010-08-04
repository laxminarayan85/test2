package com.efi.printsmith.service;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.persistence.EntityManagerFactory;

import com.efi.printsmith.data.*;
import org.apache.log4j.Logger;

import net.digitalprimates.persistence.hibernate.utils.HibernateUtil;
import net.digitalprimates.persistence.hibernate.utils.services.HibernateService;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
import org.jfree.util.PaintUtilities;
import org.jfree.util.StrokeList;

import com.efi.printsmith.data.Invoice;
//import com.efi.printsmith.pricing.utilities.PriceListUtilities;
import com.efi.printsmith.Constants;

public class PaperCalculatorService extends SnowmassHibernateService {
	protected static final String PERSISTENCE_UNIT = "printsmith_db";

//	private static final String  = null;

	protected static Logger log = Logger.getLogger(EstimatorService.class);
	
	protected static EntityManagerFactory entityManagerFactory = null;

	//
	//
	//
	private double RoundDbl(double input, int decimalCnt)
	{
		double	results;
		BigDecimal tmp = new BigDecimal(input);
		tmp = tmp.setScale(decimalCnt,BigDecimal.ROUND_HALF_UP);
		results = tmp.doubleValue();
		return(results);
	}
	
	//********************************************************************************
	//	MaxPageWillFit - compute the max number of pages that will fit with this
	//						gutter in between.
	//********************************************************************************
		private int MaxPageWillFit(double parent, double sheet, double gutter)
	{
		int		results = 0;
		
		if (parent >= sheet) {
			
			results = 1;
			
			//
			// find the point at which no more will fit
			//
			while((sheet * (double)results) + ((double)(results - 1) * gutter) < parent && results < 400) 
				++results;
			
			//
			// reality check
			//
			if ((sheet * (double)results) + ((double)(results - 1) * gutter) > parent) --results;
			
			//
			// one sheet will not fit with gutter
			//
			if (results == 1 && ((sheet+gutter) > parent) ) --results;			
		}
		
		if (results < 0)
		{
			results = 0;
		}
		
		return(results);
	}


	private int LocalCalcOut(JobBase job, double x, double y, int whichToStart) throws NumberFormatException, ParseException {
		int		results = 0;
		double		parentX,parentY;	/* working vars parent sheet size */
		double		runX,runY;			// local working copies
		double		sheetX,sheetY;	/* working vars parent sheet size */
		double		ajustX, ajustY;		//xfactor;
		double		ajust2X, ajust2Y;	//xfactor;
		double		ajust3X, ajust3Y;	//xfactor;
		double		gutterX, gutterY;	// working gutters
		int			dutch = 0, grain = 0;
		long		rDutch = 0;	/* dutch cut count on right */
		long		bDutch = 0;	/* dutch cut count on bottom */
		PaperCalculator	papercal = job.getPaperCal();

		// should round to 3 decimal places
		sheetX = RoundDbl(x, 3);	
		sheetY = RoundDbl(y, 3);
		
		gutterX = 0.0;
		gutterY = 0.0;
		
		if (whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_FINISH || whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH) {
			if (papercal.getUseGutter().booleanValue() == true) {
				gutterX = papercal.getGutterHorizontal().doubleValue();		
				gutterY = papercal.getGutter().doubleValue();
			}	
			if (papercal.getUseBleed().booleanValue() == true) {
				sheetX += papercal.getBleedLeft().doubleValue() + papercal.getBleedRight().doubleValue();
				sheetY += papercal.getBleedTop().doubleValue() + papercal.getBleedBottom().doubleValue();
			}
		}
		
		// know state for each
		papercal.setdAcross(0);
		papercal.setdDown(0);
		papercal.setrMargin(0.0);
		papercal.setbMargin(0.0);
		papercal.setAcross(0);
		papercal.setDown(0);
		papercal.setDutchBottom(0);
		papercal.setUsedSqrArea(0.0);
		papercal.setParentSqrArea(0.0);
		
		/* Finish Grain Example */
		if (papercal.getRunToFinishGrain().equals(Constants.PAPER_CALCULATOR_GRAIN_DIRECTION_NEITHER)) {
			dutch = 0;
			grain = 0;
		} else if (papercal.getRunToFinishGrain().equals(Constants.PAPER_CALCULATOR_GRAIN_DIRECTION_MATCH_GRAIN)) {
			dutch = 0;
			grain = 1;
		} else if (papercal.getRunToFinishGrain().equals(Constants.PAPER_CALCULATOR_GRAIN_DIRECTION_SWING_COMBINATION)) {
			dutch = 1;
			grain = 0;
		}

		parentX = job.getParentSize().getWidth().doubleValue();
		parentY = job.getParentSize().getHeight().doubleValue();
		runX = job.getRunSize().getWidth().doubleValue();
		runY = job.getRunSize().getHeight().doubleValue();

		// these are the special case sheet sizes and output options.
		//
		if (whichToStart != Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH && 
				parentX == 26 && parentY == 40 && 
				sheetX == 8.5 && sheetY == 11 && 
				dutch == 1 && grain == 0 && 
				gutterX == 0.0 && gutterY == 0.0){
				
			/* this is a special case where you can get one more out on a dutch
			cut if you use 2 rows of dutch cut */
			results = 10;
			
			papercal.setAcross(3);
			papercal.setDown(2);
			papercal.setdAcross(2);
			papercal.setdDown(2);
	
			papercal.setDutchBottom(1);
			papercal.setUsedSqrArea(results * (sheetX * sheetY));
			papercal.setParentSqrArea(parentX * parentY);
		} else if (whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH && 
				runX == 26 && runY == 40 && 
				sheetX == 8.5 && sheetY == 11 && 
				dutch == 1 && grain == 0 && 
				gutterX == 0.0 && gutterY == 0.0){
				
			// this is a special case where you can get one more out on a dutch
			//cut if you use 2 rows of dutch cut 
			results = 10;
			
			papercal.setAcross(3);
			papercal.setDown(2);
			papercal.setdAcross(2);
			papercal.setdDown(2);
	
			papercal.setDutchBottom(1);
			papercal.setUsedSqrArea(results * (sheetX * sheetY));
			papercal.setParentSqrArea(parentX * parentY);
		}  else if (whichToStart != Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH && 
				parentX == 40 && parentY == 26 && 
				sheetY == 8.5 && sheetX == 11 && 
				dutch == 1 && grain == 0 && 
				gutterX == 0.0 && gutterY == 0.0){
				
			// this is a special case where you can get one more out on a dutch
			//cut if you use 2 rows of dutch cut 
			results = 10;
			
			papercal.setAcross(2);
			papercal.setDown(3);
			papercal.setdAcross(2);
			papercal.setdDown(2);
	
			papercal.setDutchBottom(0);
			papercal.setUsedSqrArea(results * (sheetX * sheetY));
			papercal.setParentSqrArea(parentX * parentY);
		} else if (whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH && 
				runX == 40 && runY == 26 && 
				sheetY == 8.5 && sheetX == 11 && 
				dutch == 1 && grain == 0 && 
				gutterX == 0.0 && gutterY == 0.0){
				
			// this is a special case where you can get one more out on a dutch
			//cut if you use 2 rows of dutch cut 
			results = 10;
			
			papercal.setAcross(2);
			papercal.setDown(3);
			papercal.setdAcross(2);
			papercal.setdDown(2);
	
			papercal.setDutchBottom(0);
			papercal.setUsedSqrArea(results * (sheetX * sheetY));
			papercal.setParentSqrArea(parentX * parentY);
		}  else if (whichToStart != Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH && 
				parentX == 28 && (parentY == 35 || parentY == 34) && 
				sheetY == 8.5 && sheetX == 11 && 
				dutch == 1 && grain == 0 && 
				gutterX == 0.0 && gutterY == 0.0){
				
			// When using a (28 X 35) or (28 X 34) parent and a (8.5 X 11) finish then the dutch cut
			//	can be flip to get more out, normaly the algorithms calc the most sheets out and then 
			//	check any left over room for dutch cuts, that would yeld (9) up with a small margin
			//	on the right and bottom.  To get this right (1) column would need to be removed from
			//	the up count so the margin would allow for a flipped dutch cut.  Hench the special case. 
			//	
			// since 11/17 gets 5 out you can get twice as many 8.5/11's - this does it 
			results = 10;
			
			papercal.setAcross(2);
			papercal.setDown(3);
			papercal.setdAcross(1);
			papercal.setdDown(4);
	
			papercal.setDutchBottom(0);
			papercal.setbMargin(2.0);
			papercal.setrMargin(11.0);
			papercal.setUsedSqrArea(results * (sheetX * sheetY));
			papercal.setParentSqrArea(parentX * parentY);
		} else if (sheetY != 0 && sheetX != 0) {

				ajustX = 0.0;
				ajustY = 0.0;
				ajust2X = 0.0;
				ajust2Y = 0.0;
				ajust3X = 0.0;
				ajust3Y = 0.0;
				
				//
				// Folio edge logic, add in the folio edge amount
				//
				if (papercal.getUseFolioEdge().booleanValue() == true && whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH) {
					if (papercal.getFolioLocation().equals(Constants.PAPER_CALCULATOR_FOLIO_TOP)) {
						ajustY = papercal.getFolioEdge().doubleValue();
					} else if(papercal.getFolioLocation().equals( Constants.PAPER_CALCULATOR_FOLIO_LEFT)) {
						ajustX = papercal.getFolioEdge().doubleValue();
					}
				}
				
				//
				// Gripper edge logic, add in the gripper edge amount
				//		
				if ((papercal.getUseGripEdgeGap().booleanValue() == true || papercal.getUseColorBar().booleanValue() == true) && whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH) {
					
					if (papercal.getUseGripEdgeGap().booleanValue() == true) {
						if (papercal.getFolioLocation().equals(Constants.PAPER_CALCULATOR_GRIPPER_TOP)) {
							ajust2Y = papercal.getGripEdgeGap().doubleValue();
						} else if (papercal.getFolioLocation().equals(Constants.PAPER_CALCULATOR_GRIPPER_LEFT)) {
							ajust2X = papercal.getGripEdgeGap().doubleValue();
						}
					}
					
					//
					// Take into account the color bar on the opposite side of the gripper
					//
					if (papercal.getUseColorBar().booleanValue() == true) {
						if (papercal.getGripLocation().equals(Constants.PAPER_CALCULATOR_GRIPPER_TOP)){
							ajust3Y = papercal.getColorBar().doubleValue();
						} else if (papercal.getGripLocation().equals(Constants.PAPER_CALCULATOR_GRIPPER_LEFT)){
							ajust3X = papercal.getColorBar().doubleValue();
						} 
					}
					
					// 
					// if folio edge is bigger then use it for gripper size
					//
					if (ajust2X > ajustX) ajustX = ajust2X;
					if (ajust2Y > ajustY) ajustY = ajust2Y;
					
					//
					// work and tumble adds another gripper or color bar to the opposite side, which ever is larger
					//
					if (job.getRunMethod().equals("WorkAndTumble")) {		// (GetJobRunDirection(job) & kJobRunDirectionRunAndTumble)
						if (papercal.getGripLocation().equals(Constants.PAPER_CALCULATOR_GRIPPER_TOP)){
							if (ajust2Y >= ajust3Y)
								ajustY += ajust2Y;
							else
								ajustY += ajust3Y;
						} else if (papercal.getGripLocation().equals(Constants.PAPER_CALCULATOR_GRIPPER_LEFT)){
							if (ajust2X >= ajust3X)
								ajustX += ajust2X;
							else
								ajustX += ajust3X;
						} 

					//
					// ONLY the color bar takes up space on the opposite end of the sheet
					//
					} else {
						ajustX += ajust3X;
						ajustY += ajust3Y;
					}
				}
				
				//
				// White space - subtract the edge amounts around the run sheet
				//		
				if (papercal.getUseWhiteSpace().booleanValue() == true && whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH) {
					ajustX += (papercal.getWhiteSpaceLeft().doubleValue() + papercal.getWhiteSpaceRight().doubleValue());
					ajustY += (papercal.getWhiteSpaceTop().doubleValue() + papercal.getWhiteSpaceBottom().doubleValue());
				}
				
				//
				// subtract the used portion of the paper, taking out gripper and folio edges
				//
				if (whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN || whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_FINISH) {
					parentX = RoundDbl((parentX - ajustX), 3);
					parentY = RoundDbl((parentY - ajustY), 3);
				}
				else if (whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH) {
					parentX = RoundDbl((runX - ajustX), 3);
					parentY = RoundDbl((runY - ajustY), 3);
				}
				
				//
				// compute the maximum number of pages that will fit with a gutter in between
				//
				if (parentX >= sheetX)
					papercal.setAcross(MaxPageWillFit(parentX, sheetX, gutterX));
				else
					papercal.setAcross(0);
				
				if (parentY >= sheetY)
					papercal.setDown(MaxPageWillFit(parentY, sheetY, gutterY));
				else
					papercal.setDown(0);

				/* number sheets w/o dutch */
				results = papercal.getAcross().intValue() * papercal.getDown().intValue();				
				papercal.setrMargin((parentX - (papercal.getAcross().intValue() * sheetX) + (papercal.getAcross().intValue()-1) * gutterX));
				papercal.setbMargin((parentY - (papercal.getDown().intValue()*sheetY)+ (papercal.getDown().intValue()-1)*gutterY));
			
				//
				// add the DUTCH or Swing cut numbers to the results
				//
				if (dutch == 1 && results > 0) {
					
					sheetX = RoundDbl(x, 3);
					sheetY = RoundDbl(y, 3);					
					
					//
					// add to the paper size, gutters and bleeds.
					//		
					if (whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_FINISH || whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH) {
						if (papercal.getUseGutter().booleanValue() == true) {
							gutterX = papercal.getGutter().doubleValue();		// rotate sides
							gutterY = papercal.getGutterHorizontal().doubleValue();
						}	
						if (papercal.getUseBleed().booleanValue() == true) {
							sheetX += (papercal.getBleedLeft().doubleValue() + papercal.getBleedRight().doubleValue());
							sheetY += (papercal.getBleedTop().doubleValue() + papercal.getBleedBottom().doubleValue());
						}
					}
					
					/* see if a dutch cut is possible - and if it is calculate */
					/*	if there's more sheets on right or left */
					if (papercal.getrMargin().doubleValue() >= sheetY && parentY >= sheetX )	/* calculate right side */
						rDutch = (MaxPageWillFit(papercal.getrMargin().doubleValue(), sheetY, gutterY) * MaxPageWillFit(parentY, sheetX, gutterX) );
						// ROUND DOWN rDutch
					
					if ( parentX >= sheetY && papercal.getbMargin().doubleValue() >= sheetX ) 	/* calc bottom */
						bDutch = ( MaxPageWillFit(parentX, sheetY, gutterY) * MaxPageWillFit(papercal.getbMargin().doubleValue(), sheetX, gutterX) );
						// floor - round DOWN
					
					if (bDutch > rDutch)
						papercal.setDutchBottom(1);	/* position dutch cut on bottom */
					else
						papercal.setDutchBottom(0);
					
					/* its on right */
					if ( papercal.getrMargin().doubleValue() >= sheetY && parentY >= sheetX )	{	
						papercal.setdAcross(MaxPageWillFit(papercal.getrMargin().doubleValue(), sheetY, gutterY));
						papercal.setdDown(MaxPageWillFit(parentY, sheetX, gutterX));
						papercal.setDutchBottom(0);
					}
					if (papercal.getDutchBottom() > 0) {
						papercal.setdAcross(MaxPageWillFit(parentX, sheetY, gutterY));
						papercal.setdDown(MaxPageWillFit(papercal.getbMargin().doubleValue(), sheetX, gutterX));

					} else {
						papercal.setdAcross(MaxPageWillFit(papercal.getrMargin().doubleValue(), sheetY, gutterY));
						papercal.setdDown(MaxPageWillFit(parentY, sheetX, gutterX));
					}
					
					// set both to zero if the sheet want fit
					//
					if (papercal.getdDown().intValue() == 0 || papercal.getdAcross().intValue() == 0) {		
						papercal.setdAcross(0);
						papercal.setdDown(0);
					}
					
					results += (papercal.getdAcross().intValue() * papercal.getdDown().intValue());
				}
				
				// compute the square area used by the cut out sheets
				//
				papercal.setUsedSqrArea((results * (sheetX * sheetY)));
				
				//
				// compute the square area used by the parent
				//
				parentX = job.getParentSize().getWidth().doubleValue();
				parentY = job.getParentSize().getHeight().doubleValue();
				runX = job.getRunSize().getWidth().doubleValue();
				runY = job.getRunSize().getHeight().doubleValue();

				if (whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_FINISH || whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN) {
					papercal.setParentSqrArea(parentX * parentY);
				} else {
					papercal.setParentSqrArea(runX * runY);
				}
		}
		
		return results;
	}
	
	
	//********************************************************************************
	//	CalcMaximumSheets returns the maximum number of sheets that can be taken from
	//	the parent size given a completely filled in SheetRec. It recognizes
	//	all modifiers such as dutch cut and match grain.
	//	
	//	This routine also sets up all the parameters necessary to generate the
	//	cutout diagram.
	//********************************************************************************
	private int CalcMaximumSheets(JobBase job, int whichToStart) throws Exception {

		double		parentX,parentY;	/* working vars parent sheet size */
		double		runX,runY;			// local working copies
		double		finishX,finishY;	// local working copies
		int			grain = 0;
		int			out = 0;
		int			out1 = 0;		/* temp values to figure out maximum */
		int			out2 = 0;	/* temp values to figure out maximum */
		
		parentX = job.getParentSize().getWidth().doubleValue();
		parentY = job.getParentSize().getHeight().doubleValue();
		runX = job.getRunSize().getWidth().doubleValue();
		runY = job.getRunSize().getHeight().doubleValue();
		finishX = job.getFinishSize().getWidth().doubleValue();
		finishY = job.getFinishSize().getHeight().doubleValue();

		grain = 0;
		
		/* Finish Grain */
		if (job.getPaperCal().getRunToFinishGrain().equals(Constants.PAPER_CALCULATOR_GRAIN_DIRECTION_MATCH_GRAIN)) {
			grain = 1;
		}

		if ((parentX > 0 && parentY > 0) || (runX > 0 && runY > 0) || (finishX > 0 && finishY > 0))
		{
			//
			// allow for a grain swap in the paper direction
			//
			if (grain == 0)
			{	// try alternate rotation
				switch (whichToStart)
				{	
					case Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_FINISH:
						// old form
						out2 = LocalCalcOut(job, finishY, finishX, whichToStart);
						break;
						
					case Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN:
						// use run size as parent
						out2 = LocalCalcOut(job, runY, runX, whichToStart);
						break;
						
					case Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH:
						// use parent size
						out2 = LocalCalcOut(job, finishY, finishX, whichToStart);
						break;
				}
				
				if (out2 < 0)
				{
					out2 = 0;
				}
			}
			//
			// perform the requested sheet combination in the normal sheet dimensions
			//
			switch (whichToStart)
			{	
				case Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_FINISH:
					out1 = LocalCalcOut(job, finishX, finishY, whichToStart); 
					break;
						
				case Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN:
					// use run size as parent
					out1 = LocalCalcOut(job, runX, runY, whichToStart);
					break;
					
				case Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH:
					// use parent size
					out1 = LocalCalcOut(job, finishX, finishY, whichToStart); 
					break;
			}
			
			if (out1 < 0)
			{
				out1 = 0;
			}
			
			//
			// if the first direction has more, then revert all internal numbers to that size output
			//
			if (out2 > out1)
			{
				switch (whichToStart)
				{	
					case Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_FINISH:
						// use parent size
						LocalCalcOut(job, finishY, finishX, whichToStart);
						break;
						
					case Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN:
						// use run size as parent
						LocalCalcOut(job, runY, runX, whichToStart);
						break;
						
					case Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH:
						// use parent size
						LocalCalcOut(job, finishY, finishX, whichToStart);
						break;
				}
				
				//
				// tell the image creation to swap the sheets for better fit
				//
				job.getPaperCal().setSwap(true);
				out = out2;
			}
			else {
				//
				// image creation should use the sheet sizes as entered
				//
				job.getPaperCal().setSwap(false);
				out = out1;
			}
		}
		
		return out;
	}	// CalcSheet

	//
	// main public function to compute the sheets out for a given combination and the
	//		CUT counts for both the Parent to run AND the run to finish
	//
	public List CalcOut(JobBase job, int whichToStart) throws Exception {
	
		int 	out= 0;
		int		runOut = 0;
		int		finishOut = 0;
		int		runCuts;
		int		finishCuts;

		ArrayList results = new ArrayList();
		
		if (job == null) {
			throw new InvalidParameterException("Null job passed to CalcOut");
		}
		log.info("CalcOut called with job: " + job.getId());
		
		// store off the original cut counts, in case they are overridden
		//
		runCuts = job.getPaperCal().getCutstoRun();
		finishCuts = job.getPaperCal().getCutstoFinish();

		switch (whichToStart)
		{	
			case Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_FINISH:
				// find the other options at the same time
				if (job.getOrFinishCuts().equals(false))
				{
					finishOut = CalcMaximumSheets(job, Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH);
					finishCuts = ExtCutCount(job, Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH);
				}
				
				// find the other options at the same time
				if (job.getOrRunCuts().equals(false))
				{
					runOut = CalcMaximumSheets(job, Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN);
					runCuts = ExtCutCount(job, Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN);
				}
				// the one asked for
				out = CalcMaximumSheets(job, whichToStart);
				break;
				
			case Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN:
				// find the other options at the same time
				if (job.getOrFinishCuts().equals(false))
				{
					finishOut = CalcMaximumSheets(job, Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH);
					finishCuts = ExtCutCount(job, Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH);
				}
				
				// use run size as parent
				runOut = out = CalcMaximumSheets(job, whichToStart);
				if (job.getOrRunCuts().equals(false))
				{
					runCuts = ExtCutCount(job, whichToStart);
				}
				break;
				
			case Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH:
				// find the other options at the same time
				if (job.getOrRunCuts().equals(false))
				{
					runOut = CalcMaximumSheets(job, Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN);
					runCuts = ExtCutCount(job, Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN);
				}
				
				// use parent size
				finishOut = out = CalcMaximumSheets(job, whichToStart);
				
				if (job.getOrFinishCuts().equals(false))
				{
					finishCuts = ExtCutCount(job, whichToStart);
				}
				break;
		}
		
		log.info("CalcOut returned: " + out);
		
		results.add(out);
		
		results.add(runCuts);
		results.add(finishCuts);
		
		results.add(job.getPaperCal().getdAcross());
		results.add(job.getPaperCal().getdDown());
		results.add(job.getPaperCal().getAcross());
		results.add(job.getPaperCal().getDown());
		results.add(job.getPaperCal().getDutchBottom());
		results.add(job.getPaperCal().getUsedSqrArea());
		results.add(job.getPaperCal().getParentSqrArea());
		results.add(job.getPaperCal().getrMargin());
		results.add(job.getPaperCal().getbMargin());
		results.add(job.getPaperCal().getSwap());
		
		results.add(runOut);
		results.add(finishOut);
		
		return results;
	}
	
	//********************************************************************************
	//	ExtCutCount - the extended paper cutter calculations
	//********************************************************************************
	private int  ExtCutCount(JobBase job, int whichToStart)
	{
		int		out,cuts;
		int		dout;
		int		runEdgeLeft = 0;
		int		runEdgeRight= 0;
		int		runEdgeTop = 0;
		int		runEdgeBottom = 0;
		
		//
		// Count of pages across minus (1) plus the number of pages down - (1)
		//
		out = ((job.getPaperCal().getAcross().intValue()-1) + job.getPaperCal().getDown().intValue()-1);		/* gross estimate of cuts needed */
		if (out < 0)
			out = 0;
				
		if (whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH) {
		
			if (job.getPaperCal().getUseBleed().booleanValue() == true) {			// bleeds will double the cuts in the effected sides
				
				// bleeds out in the across direction
				//
				if (job.getPaperCal().getBleedLeft().doubleValue() > 0.0 || job.getPaperCal().getBleedRight().doubleValue() > 0.0) {
					out += (job.getPaperCal().getAcross().intValue()+1);
				}
				
				// bleeds out in the down direction
				//
				if (job.getPaperCal().getBleedTop().doubleValue() > 0.0 || job.getPaperCal().getBleedBottom().doubleValue() > 0.0) {
					out += (job.getPaperCal().getDown().intValue() + 1);
				}
				
				//
				// count which edges have been cut off by the formula above.
				//	If the left or right is cut then both are counted, so the edge
				//	is covered already and should be marked as done here.
				//
				if (job.getPaperCal().getBleedLeft().doubleValue() > 0.0 || job.getPaperCal().getBleedRight().doubleValue() > 0.0)
					runEdgeLeft += 1;
				if (job.getPaperCal().getBleedRight().doubleValue() > 0.0 || job.getPaperCal().getBleedLeft().doubleValue() > 0.0)
					runEdgeRight += 1;
				if (job.getPaperCal().getBleedTop().doubleValue() > 0.0 || job.getPaperCal().getBleedBottom().doubleValue() > 0.0)
					runEdgeTop += 1;
				if (job.getPaperCal().getBleedBottom().doubleValue() > 0.0 || job.getPaperCal().getBleedTop().doubleValue() > 0.0)
					runEdgeBottom += 1;
			}
			
			//
			// count up the extra cuts needed for gutters
			//
			if (job.getPaperCal().getUseGutter().booleanValue() == true) {
				if (job.getPaperCal().getGutterHorizontal().doubleValue() > 0.0)
					out += job.getPaperCal().getAcross().intValue() - 1;
				if (job.getPaperCal().getGutter().doubleValue() > 0.0)
					out += job.getPaperCal().getDown().intValue() - 1;
			}
		}
	
		if (whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN || whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_FINISH) {
			
			//
			// trim all the way around
			//
			if (job.getPaperCal().getBackTrimParent().booleanValue() == true) {			// back trim cuts all the way around
				out += 4;
			}
			else {
				if (job.getPaperCal().getrMargin().doubleValue() > 0)			/* add trim cut for waste on right */
					out++;
				if (job.getPaperCal().getbMargin().doubleValue() > 0)			/* add trim cut for waste on bottom */
					out++;
			}
		}
		
		if (whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH) {
			if (job.getPaperCal().getTrimFourSides().booleanValue() == true) {	// back trim cuts all the way around
				
				// back trim any edge not already counted
				if (runEdgeLeft == 0)	out += 1;
				if (runEdgeRight == 0)	out += 1;
				if (runEdgeTop == 0)	out += 1;
				if (runEdgeBottom == 0)	out += 1;
			}
			else {
				if (job.getPaperCal().getUseGripEdgeGap().booleanValue() == true) {		// gripper in on
					if (job.getPaperCal().getGripEdgeGap().doubleValue() != 0.0) {		// gripper has a value
						out++;								// add one for the gripper
						if (job.getPaperCal().getGripLocation().equals(Constants.PAPER_CALCULATOR_GRIPPER_LEFT))		//job->gripSide == kEdgeLeftRight) 
							runEdgeLeft += 1;
						else
							runEdgeTop += 1;
								
						if (job.getRunMethod().equals("WorkAndTumble")) {		// work and tumble is on
							out++;							// add one for the oposite site
							if (job.getPaperCal().getGripLocation().equals(Constants.PAPER_CALCULATOR_GRIPPER_LEFT))
								runEdgeRight += 1;
							else
								runEdgeBottom += 1;
						}
					}
				}
				
				//
				// Count any extra needed by white space
				//
				if (job.getPaperCal().getUseWhiteSpace().booleanValue() == true) {
					if (job.getPaperCal().getWhiteSpaceLeft().doubleValue() > 0.0 && runEdgeLeft == 0) {
						runEdgeLeft += 1;
						out += 1;
					}
					if (job.getPaperCal().getWhiteSpaceRight().doubleValue() > 0.0 && runEdgeRight == 0) {
						runEdgeRight += 1;
						out += 1;
					}
					if (job.getPaperCal().getWhiteSpaceTop().doubleValue() > 0.0 && runEdgeTop == 0) {
						runEdgeTop += 1;
						out += 1;
					}
					if (job.getPaperCal().getWhiteSpaceBottom().doubleValue() > 0.0 && runEdgeBottom == 0) {
						runEdgeBottom += 1;
						out += 1;
					}
				}
	
				// only count a folio edge if no gripper exist on the same side as the folio edge
				if (job.getPaperCal().getUseFolioEdge().booleanValue() == true && ((job.getPaperCal().getUseGripEdgeGap() == false) 
							|| false == job.getPaperCal().getGripLocation().equals(job.getPaperCal().getFolioLocation()))) {
					if (job.getPaperCal().getFolioEdge().doubleValue() != 0.0) {
						if (job.getPaperCal().getFolioLocation().equals(Constants.PAPER_CALCULATOR_FOLIO_LEFT) && runEdgeLeft == 0) {
							runEdgeLeft += 1;
							out++;
						}
						else if (job.getPaperCal().getFolioLocation().equals(Constants.PAPER_CALCULATOR_FOLIO_TOP) && runEdgeTop == 0) {
							runEdgeTop += 1;
							out++;
						}
					}
				}
				
				// add the margin area cut if any exist and the side has not all ready been cut	
				if (job.getPaperCal().getrMargin().doubleValue() > 0 && runEdgeRight == 0) {	/* add trim cut for waste on right */
					out++;
					runEdgeRight += 1;
				}
				
				if (job.getPaperCal().getbMargin().doubleValue() > 0 && runEdgeBottom == 0) {	/* add trim cut for waste on bottom */
					out++;
					runEdgeBottom += 1;
				}
				
				// Does the color bar need a seprate cut, that is no folio or gripper is already being trimmed
				if (job.getPaperCal().getUseColorBar().booleanValue() == true) {
					// color bar is on opposite side from gripper edge
					if (job.getPaperCal().getGripLocation().equals(Constants.PAPER_CALCULATOR_GRIPPER_TOP)){
						if (runEdgeBottom == 0) {
							out++;
							runEdgeBottom += 1;
						}
					} else if (job.getPaperCal().getGripLocation().equals(Constants.PAPER_CALCULATOR_GRIPPER_LEFT)){
						if (runEdgeRight == 0) {
							out++;
							runEdgeRight += 1;
						}
					}
				}
			}
		}
		
		//
		// calculate the cuts for swing/dutch cut pages
		//
		
		dout = (job.getPaperCal().getdAcross().intValue() * job.getPaperCal().getdDown().intValue());
		
		if (dout > 0) {		/* add 2 cuts for busting out swing cut sheets plus 1 trim cut */
			if (dout > 1) --dout;	// if greater than (1) then only cut in between each sheet
			dout+=1;		
		}
		else if (dout < 0)	// if dutch cut exist then we don't want to subtract from the number of cuts
			dout = 0;
	
		/*************************************************************************
			for now - not figuring additional trim cuts on swing cut sheets for 
			waste on right or bottom. To do this we'd have to calculate the total
			dimensions of main and swing cuts in each direction to determine if 
			there's any pure spoilage. We'll see if it's needed after testing.
		 *************************************************************************/
		cuts = out + dout;
			
		if (cuts < 0)
			cuts = 0;
	
		return(cuts);
	} /* ExtCutCount */
	

	//********************************************************************************
	// CalculateCutCounts - sets the cut counts for this paper sheet combinations
	//********************************************************************************
	public List CalculateCutCounts(JobBase job) throws Exception
	{
		ArrayList results = new ArrayList();
		
		double		parentX,parentY;	/* working vars parent sheet size */
		double		runX,runY;			// local working copies
		double		finishX,finishY;	// local working copies
		int		runCuts;
		int		finishCuts;
		
		parentX = job.getParentSize().getWidth().doubleValue();
		parentY = job.getParentSize().getHeight().doubleValue();
		runX = job.getRunSize().getWidth().doubleValue();
		runY = job.getRunSize().getHeight().doubleValue();
		finishX = job.getFinishSize().getWidth().doubleValue();
		finishY = job.getFinishSize().getHeight().doubleValue();
				
		runCuts = job.getPaperCal().getCutstoRun().intValue();
		finishCuts = job.getPaperCal().getCutstoFinish().intValue();
		
		if ((parentX > 0 && parentY > 0) || (finishX > 0 && finishY > 0) || (runX > 0 && runY > 0))
		{			
			if (job.getOrRunCuts().equals(false))
			{
				CalcMaximumSheets(job, Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN);
				
				runCuts = ExtCutCount(job, Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN);
			}
			if (job.getOrFinishCuts().equals(false))
			{
				CalcMaximumSheets(job, Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH);
				
				finishCuts = ExtCutCount(job, Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH);
			}
		}
		
		results.add(runCuts);
		results.add(finishCuts);
		
		return(results);
	} /* CalculateCutCounts */		

	//  -- xx --
	//  --------  
	//  |      |  
	//  |      |  
	//  |      |  
	//  |	   |  
	//	--------
	private void PaintXDim(Graphics2D g, Rectangle r,double dim, int dv)
		{
			Font		c;			// 
			FontMetrics fm;
			int				lineht;				// 
			int				charht;				// used to offset line from text baseline
			int				charwidth;			// width of string
			int				ypos;				// 
			String			buf;				// for setting up text to print
			int				xpos;				// 
			int				x;					// 
			double 			scale = 1.0;
			Rectangle		box = new Rectangle();
			
			if (dim > 0 && r.width > 0 && r.height > 0)
			{
				box.setRect(r.x*scale, r.y*scale, r.width*scale, r.height*scale);

				c=new Font("Courier",Font.PLAIN,9);
				g.setFont(c);
				buf = String.valueOf(dim);

				fm = g.getFontMetrics();
				lineht = fm.getHeight();
				charht = lineht / 2;
				charwidth = fm.stringWidth(buf);
				
				x = box.x + (((box.width) - charwidth) / 2);
				ypos = (box.y + dv + 2) - charht;
				xpos = box.x + 2;
				g.setColor(Color.gray);
				g.drawLine(xpos, ypos, x-5, ypos);	
				g.drawString(buf, x, ypos + charht);
				g.drawLine(x + charwidth + 2, ypos, box.y+box.width-3, ypos);
				g.setColor(Color.black);
			}
		}	// PaintXDim

		//
		//  ------  |
		//  |    |  |
		//  |    |  XX
		//  |    |  |
		//  |	 |  |
		//	------
		//
		private void PaintYDim(Graphics2D g, Rectangle r,double dim, int dv)
		{
			Font		c;			// 
			FontMetrics fm;
			int				lineht;				// 
			int				charwide;			// used to offset line from text baseline
			int				ypos;				// 
			int				cpos;				// 
			String			buf;				// for setting up text to print
			int				xpos;				// 
			double 			scale = 1.0;
			Rectangle		box = new Rectangle();
			
			if (dim > 0 && r.width > 0 && r.height > 0)
			{
				box.setRect(r.x*scale, r.y*scale, r.width*scale, r.height*scale);

				c=new Font("Courier",Font.PLAIN,9);
				g.setFont(c);
				buf = String.valueOf(dim);
				
				fm = g.getFontMetrics();
				lineht = fm.getHeight();
				cpos = box.y + (box.height/2) + lineht/2;
				charwide = fm.stringWidth(buf);
								
				xpos = box.x + box.width + dv + (charwide / 2);				
				ypos = (box.x+box.width) - 3;
				g.setColor(Color.gray);
				g.drawLine(xpos, box.y, xpos, cpos-8);	
				g.drawLine(xpos, cpos+4, xpos, box.y+box.height);
				
				xpos = box.x+box.width + dv;
				
				g.drawString(buf, xpos, cpos);
				g.setColor(Color.black);
			}
		}	// PaintYDim
		
	// default image when values are not properly set
	//
	private void DrawNoImageAvailable(Graphics2D g, Rectangle r) {
	    float strokeThickness = 3.0f;
		Rectangle	box = new Rectangle();
	    BasicStroke stroke = new BasicStroke(strokeThickness);
	    g.setStroke(stroke);

	    g.setColor(Color.gray);
		box.setRect(r.x+20, r.y+20, r.width-20, r.height-20);

		g.drawOval(box.x,box.y,box.width,box.height);
		g.drawLine(box.x, box.y, box.x+box.width, box.y+box.height);
	}
	
	//*******************************************************************************
	//	PaintColorBar - draw a (cyclic) color bar across box.
	//
	//
	//*******************************************************************************
	static void PaintColorBar(Graphics2D g, Rectangle2D.Double box)
	{
		Boolean			orientation;		// e.g., horizontal or vertical
		Boolean			lastCell = false;	// 
		double			size;				// length of "short" edge (of box)
		int				i = 0;				// counter (used for color selection)
		Rectangle2D.Double			node = new Rectangle2D.Double();				// 
		Rectangle2D.Double			cell = new Rectangle2D.Double();				// 
		Rectangle2D.Double			r1 = new Rectangle2D.Double();					// 
		Rectangle2D.Double			r2 = new Rectangle2D.Double();					// 
		
		//
		// setup direction and size of cells
		//
		orientation = (box.height) > (box.width);
		size = orientation ? (box.width) : (box.height);
	//	SetDblRect(&node, box->left, box->top, box->left + size, box->top + size);
		node.setRect(box.x, box.y, size, size);		// make square of small side
		
		do
		{
			if (i > 0)
			{	// iterations 1 - N
				if (orientation)
				{	// move down
				//	OffsetDblRect(&node, 0, size);
					node.y += size;
				}
				else
				{	// move right
				//	OffsetDblRect(&node, size, 0);
					node.x += size;
				}
			}
			
			if (orientation)
			{	// move down
				if (node.y >= box.y+box.height)
					lastCell = true;
			}
			else
			{	// move right
				if (node.x >= box.x+box.width)
					lastCell = true;
			}
			
			switch (i++ % 7)
			{	// select a color
				case 0:
				{
				//	ForeColor(cyanColor);
					g.setColor(Color.cyan);
					break;
				}
				case 1:
				{
				//	ForeColor(blueColor);
					g.setColor(Color.blue);
					break;
				}
				case 2:
				{
				//	ForeColor(magentaColor);
					g.setColor(Color.magenta);
					break;
				}
				case 3:
				{
				//	ForeColor(redColor);
					g.setColor(Color.red);
					break;
				}
				case 4:
				{
				//	ForeColor(yellowColor);
					g.setColor(Color.yellow);
					break;
				}
				case 5:
				{
				//	ForeColor(greenColor);
					g.setColor(Color.green);
					break;
				}
				case 6:
				{
				//	ForeColor(blackColor);
					g.setColor(Color.black);
					break;
				}
			}
			
		//	DblRectToShortRect( box, &r1);
		//	DblRectToShortRect( &node, &r2);
		//	SectRect(&r1, &r2, &cell);
			
			Rectangle2D.intersect(box, node, cell);
			

			//
			// if the image gets scales out of existence, then use a line in place
			//
			if (cell.height <  2)
			{
			//	MoveTo(cell.left,cell.bottom);
			//	LineTo(cell.right,cell.bottom);
				g.drawLine((int)cell.x, (int)cell.y, (int)(cell.x+cell.width), (int)cell.y);
			}
			else
			{
			//	PaintRect(&cell);
				g.fill(cell);
			}
		}
		while (!lastCell);
	}	// PaintColorBar

		
	private void CreateCutDiagram(JobBase job, int whichToStart, Graphics2D g, Rectangle imageArea)
	{		
		PaperCalculator	papercal = job.getPaperCal();
		Point			origin = new Point();
		double			aspect = 1.0;			// for now always is set to 1.0
		double			parentX,parentY;	/* working vars parent sheet size */
		double			runX,runY;			// local working copies
		double			finishX,finishY;	// local working copies
		Rectangle2D.Double		tmpRect = new Rectangle2D.Double();				// 
		Rectangle2D.Double		baseRect = new Rectangle2D.Double();
		Rectangle2D.Double		sheetRect = new Rectangle2D.Double(); 
		Rectangle2D.Double		folioRect = new Rectangle2D.Double();				// 
		Rectangle2D.Double		headGripRect = new Rectangle2D.Double();			// 
		Rectangle2D.Double		tailGripRect = new Rectangle2D.Double();			// 
		Rectangle2D.Double		colorbarRect = new Rectangle2D.Double();			// 
		Rectangle2D.Double		whitespaceRectL = new Rectangle2D.Double();			// 
		Rectangle2D.Double		whitespaceRectT = new Rectangle2D.Double();			// 
		Rectangle2D.Double		whitespaceRectR = new Rectangle2D.Double();			// 
		Rectangle2D.Double		whitespaceRectB = new Rectangle2D.Double();			// 
		Rectangle2D.Double		formRect = new Rectangle2D.Double();				// full value
		Rectangle2D.Double		dutchRect = new Rectangle2D.Double();				// 
		Rectangle2D.Double		trimRect = new Rectangle2D.Double();				// 
		Rectangle2D.Double		bleedRect = new Rectangle2D.Double();				// 
		double			marginL = 0;			// base to image margin (pixels)
		double			marginT = 0;			// base to image margin (pixels) (bigger to account for xdim)
		double			marginR = 45;			// base to image margin (pixels) (bigger to account for ydim)
		double			marginB = 15;			// volatile ... base to image margin (pixels)
		double			inset = 0;				// volatile ... some current inset
		double			width = 0;				// volatile ... some current width
		double			height = 0;				// volatile ... some current height
		double			basewidth = 0;				// volatile ... some current width
		double			baseheight = 0;				// volatile ... some current height
		double			dutchwidth = 0;			// volatile ... overall width of dutch content
		double			dutchheight = 0;		// volatile ... overall height of dutch content
		int				dutch = 0, grain = 0;
		double			xscale = 1.0;			// helper for determining scale
		double			yscale = 1.0;			// helper for determining scale
		double			scale = 1.0;			// base (i.e., r) to art scale
		String			buf;					// volatile
		double			gutterH = 0.0;			// scaled form of job-> gutter horizontal
		double			gutterV = 0.0;			// scaled form of job-> gutter vertical
		double			bleedL = 0.0;			// scaled form of job-> bleed left
		double			bleedT = 0.0;			// scaled form of job-> bleed top
		double			bleedR = 0.0;			// scaled form of job-> bleed right
		double			bleedB = 0.0;			// scaled form of job-> bleed bottom
		Rectangle		r1 = new Rectangle();
		Rectangle		r2 = new Rectangle();					// temp buffers
		Rectangle2D		intersectRect = new Rectangle();	// volatile ... grip to folio intersection(s)
	//	Pattern			intersectPat;			// pattern for painting grip to folio intersection(s)
		Rectangle2D.Double		labelRect = new Rectangle2D.Double();		// 
		int				lineht;					// volatile ... current line height
		int				numlines = 0;			// 
		int				i;						// volatile ... loop control
		int				row = 0;				// volatile ... current signature/dutch row
		int				column = 0;				// volatile ... current signature/dutch column
		int				dAcross;	
		int				dDown;
		Point2D.Double	sheetSize = new Point2D.Double();				// x/y of sheet (run or parent)
		Point2D.Double	trimSize = new Point2D.Double();				// x/y of trimmed page (i.e., trim marks and things the utilize the same rect)
		Point			xy = new Point();				// volatile ... for capturing text dimensions
		double			colorBarWidth = 0.25;	// 1/4 inch
		BasicStroke 	strokeTwoPixel = new BasicStroke(2.0f);

		baseRect.setRect(imageArea.x, imageArea.y, imageArea.width, imageArea.height);
		
		if (baseRect.x > 0 || baseRect.y > 0)
		{	// don't want to build margin into picture
			baseRect.x = 0;
			baseRect.y = 0;
		}
	
		parentX = job.getParentSize().getWidth().doubleValue();
		parentY = job.getParentSize().getHeight().doubleValue();
		runX = job.getRunSize().getWidth().doubleValue();
		runY = job.getRunSize().getHeight().doubleValue();
		finishX = job.getFinishSize().getWidth().doubleValue();
		finishY = job.getFinishSize().getHeight().doubleValue();
		dAcross = papercal.getdAcross().intValue();
		dDown = papercal.getdDown().intValue();
			
		// default image when the sizes are not within normal parameters
		//
		switch (whichToStart)
		{	
			case Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_FINISH:
				if (parentX <= 0 || parentY <= 0 || finishX <= 0 || finishY <= 0) {
					DrawNoImageAvailable(g, imageArea);
					return;
				}
				break;
			case Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN:
				if ((parentX <= 0 || parentY <= 0 || runX <= 0 || runY <= 0)) {
					DrawNoImageAvailable(g, imageArea);
					return;
				}
				break;
			case Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH:
				if ((runX <= 0 || runY <= 0 || finishX <= 0 || finishY <= 0)) {
					DrawNoImageAvailable(g, imageArea);
					return;
				}
				break;
		}	
		
		/* Finish Grain Example */
		if (papercal.getRunToFinishGrain().equals(Constants.PAPER_CALCULATOR_GRAIN_DIRECTION_NEITHER)) {
			dutch = 0;
			grain = 0;
		} else if (papercal.getRunToFinishGrain().equals(Constants.PAPER_CALCULATOR_GRAIN_DIRECTION_MATCH_GRAIN)) {
			dutch = 0;
			grain = 1;
		} else if (papercal.getRunToFinishGrain().equals(Constants.PAPER_CALCULATOR_GRAIN_DIRECTION_SWING_COMBINATION)) {
			dutch = 1;
			grain = 0;
		}
		
		switch (whichToStart)
		{	
			case Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_FINISH:
				// parent to run sheet and sheet items (up to and including the form itself ... nothing within the form ... that comes later (after this switch block))
				sheetSize.x = parentX;
				sheetSize.y = parentY;
				
				if (papercal.getSwap().booleanValue() == true && grain == 0) {
					trimSize.x = finishY;
					trimSize.y = finishX;
				} else {
					trimSize.x = finishX;
					trimSize.y = finishY;
				}
								
				width = (sheetSize.x);
				height = (sheetSize.y);
				basewidth = width;
				baseheight = height;
				xscale = (baseRect.width - (marginL + marginR)) / (width);
				yscale = (baseRect.height - (marginT + marginB)) / (height);
				scale = (yscale < xscale) ? yscale : xscale;
					
				// calc and set sheet rect
				width = ((sheetSize.x) * scale);
				height = ((sheetSize.y) * scale);
				sheetRect.setRect(baseRect.x + marginL, baseRect.y + marginT, width, height);
				formRect.setRect(sheetRect);	// initial state

				// draw the sheet
				g.setColor(Color.gray);
				r1.setRect(sheetRect);
				g.drawRect(r1.x,r1.y,r1.width, r1.height);

				PaintXDim(g,r1,basewidth, -4);
				PaintYDim(g,r1,baseheight, 12);
				break;
				
			case Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN:
				// parent to run sheet and sheet items (up to and including the form itself ... nothing within the form ... that comes later (after this switch block))
				sheetSize.x = parentX;
				sheetSize.y = parentY;
				
				if (papercal.getSwap().booleanValue() == true && grain == 0) {
					trimSize.x = runY;
					trimSize.y = runX;
				} else {
					trimSize.x = runX;
					trimSize.y = runY;
				}
				// calc base (pixel) to art (abstract) scale
				width = (sheetSize.x);
				height = (sheetSize.y);
				basewidth = width;
				baseheight = height;
				xscale = (baseRect.width - (marginL + marginR)) / (width);
				yscale = (baseRect.height - (marginT + marginB)) / (height);
				scale = (yscale < xscale) ? yscale : xscale;
				
				// calc and set sheet rect
				width = ((sheetSize.x) * scale);
				height = ((sheetSize.y) * scale);
				sheetRect.setRect(baseRect.x + marginL, baseRect.y + marginT, width, height);
				formRect.setRect(sheetRect);	// initial state
				
				// render...
				// draw the sheet
				g.setColor(Color.gray);
				
				r1.setRect(sheetRect);
				g.drawRect(r1.x,r1.y,r1.width, r1.height);
								
				PaintXDim(g,r1,basewidth, -4);
				PaintYDim(g,r1,baseheight, 12);
				break;
				
			case Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH:
				// run to finish sheet and sheet items (up to and including the form itself ... nothing within the form ... that comes later (after this switch block))
				sheetSize.x = runX;
				sheetSize.y = runY;
				if (papercal.getSwap().booleanValue() == true && grain == 0) {
					trimSize.x = finishY;
					trimSize.y = finishX;
				} else {
					trimSize.x = finishX;
					trimSize.y = finishY;
				}
				
				width = (sheetSize.x);
				height = (sheetSize.y);
				basewidth = width;
				baseheight = height;
				xscale = (baseRect.width - (marginL + marginR)) / (width);
				yscale = (baseRect.height - (marginT + marginB)) / (height);
				scale = (yscale < xscale) ? yscale : xscale;
					
				// calc and set sheet rect
				width = ((sheetSize.x) * scale);
				height = ((sheetSize.y) * scale);
				sheetRect.setRect(baseRect.x + marginL, baseRect.y + marginT, width, height);
				formRect.setRect(sheetRect);	// initial state
				
				// initialize folio rect ... top or left side of sheet
				//
				if (papercal.getUseFolioEdge().booleanValue() == true) {
					width = ((papercal.getFolioEdge().doubleValue()) * scale);
					folioRect.setRect(sheetRect);

					if (papercal.getFolioLocation().equals(Constants.PAPER_CALCULATOR_FOLIO_TOP)) {
						folioRect.height =  width;
						
						if (formRect.y < folioRect.height)
						{	// update (i.e., inset) the form
							formRect.y = folioRect.height;
							formRect.height -= width;
						}

					} else if(papercal.getFolioLocation().equals( Constants.PAPER_CALCULATOR_FOLIO_LEFT)) {
						folioRect.width = width;
						
						if (formRect.x < folioRect.width)
						{	// update (i.e., inset) the form
							formRect.x = folioRect.width;
							formRect.width -= width;
						}
					}
				}
				
				//
				// initialize the Gripper edge
				// top or left side of sheet ... work and tumble happens during paint operation 
				if (papercal.getUseGripEdgeGap().booleanValue() == true)
				{	
					width = papercal.getGripEdgeGap().doubleValue()*scale;
					headGripRect.setRect(sheetRect);
					
					if (papercal.getGripLocation().equals(Constants.PAPER_CALCULATOR_GRIPPER_TOP)) {
						headGripRect.height = width;
						tailGripRect.setRect(headGripRect);
						
						if (papercal.getUseFolioEdge().booleanValue() == true && papercal.getFolioLocation().equals(Constants.PAPER_CALCULATOR_FOLIO_TOP))
						{	// grip and folio share the same edge
							headGripRect.width -= ((headGripRect.width) / 2.0);
						}
						
						if (formRect.y < headGripRect.height)
						{	// update (i.e., inset) the form
							formRect.y = headGripRect.height;
							
							if (papercal.getUseFolioEdge().booleanValue() == true && papercal.getFolioLocation().equals(Constants.PAPER_CALCULATOR_FOLIO_TOP))
							{	// grip and folio share the same edge
								if (headGripRect.height > folioRect.height) {
									formRect.height -= (headGripRect.height-folioRect.height);
								}
							} else {
								formRect.height -= width;
							}
						}

						if (job.getRunMethod().equals("WorkAndTumble"))
						{	// finish work and tumble (tail) grip (and form inset)
							// place the tail grip
							tailGripRect.y = (sheetRect.y+sheetRect.height) - tailGripRect.height;
							
							if (formRect.y+formRect.height > sheetRect.height - width)
							{	// update (i.e., inset) the form
								formRect.height = (sheetRect.height - width) - formRect.y;
							}
						}
					} else if (papercal.getGripLocation().equals(Constants.PAPER_CALCULATOR_GRIPPER_LEFT)) {
						headGripRect.width = width;
						tailGripRect.setRect(headGripRect);
						
						if (papercal.getUseFolioEdge().booleanValue() == true && papercal.getFolioLocation().equals( Constants.PAPER_CALCULATOR_FOLIO_LEFT))
						{	// grip and folio share the same edge
							headGripRect.height -= ((headGripRect.height) / 2.0);
						}
						
						if (formRect.x < headGripRect.width)
						{	// update (i.e., inset) the form
							formRect.x = headGripRect.width;
							formRect.width -= width;
						}

						if (job.getRunMethod().equals("WorkAndTumble"))
						{	// finish work and tumble (tail ... right side) grip (and form inset)
							
							// place the tail grip
							tailGripRect.x = (sheetRect.x+sheetRect.width)-tailGripRect.width;
							
							if (formRect.x+formRect.width > sheetRect.width - width)
							{	// update (i.e., inset) the form
								formRect.width = (sheetRect.width - width) - formRect.x;
							}

						}
					}
				}
				
				//
				// initilize the color bar area
				//
				if (papercal.getUseColorBar().booleanValue() == true)
				{	// initialize color bar rect ... bottom or right side of sheet ... work and tumble happens during paint operation
					colorBarWidth = papercal.getColorBar().doubleValue();
					width = colorBarWidth * scale;
					inset = 0;	// todo - expose inset value to user
					colorbarRect.setRect(sheetRect);
					
					if (papercal.getGripLocation().equals(Constants.PAPER_CALCULATOR_GRIPPER_TOP)) {
						colorbarRect.height = width;
						colorbarRect.y = (sheetRect.y + sheetRect.height) - width;
						colorbarRect.x += inset;		// logic allows colorbars to be inset from sheet edge
						colorbarRect.width -= inset;	// logic allows colorbars to be inset from sheet edge

						if (formRect.y+formRect.height > colorbarRect.y)
						{	// update (i.e., inset) the form
							formRect.height = (colorbarRect.y);
						}

						if (job.getRunMethod().equals("WorkAndTumble"))
						{	// work and tumble (head) color bar form inset
							if (formRect.y < sheetRect.y + inset + width)
							{	// update (i.e., inset) the form
								formRect.y = sheetRect.y + inset + width;
							}
						}

					} else if (papercal.getGripLocation().equals(Constants.PAPER_CALCULATOR_GRIPPER_LEFT)) {
						colorbarRect.width = width;
						colorbarRect.x = (sheetRect.x + sheetRect.width) - width;
						colorbarRect.x += inset;		// logic allows colorbars to be inset from sheet edge
						colorbarRect.height -= inset;	// logic allows colorbars to be inset from sheet edge
						colorbarRect.x -= inset;
						
						if (formRect.x+formRect.width > colorbarRect.x)
						{	// update (i.e., inset) the form
							formRect.width = colorbarRect.x;
						}
						if (job.getRunMethod().equals("WorkAndTumble"))
						{	// work and tumble (left side) color bar form inset
							if (formRect.x < sheetRect.x + inset + width)
							{	// update (i.e., inset) the form
								formRect.x = sheetRect.x + inset + width;
							}
						}
					}
				}
					
				if (papercal.getUseWhiteSpace().booleanValue() == true)
				{	// reduce form (rect) by white space (white space rect becomes old form rect)
					if (papercal.getWhiteSpaceLeft().doubleValue() > 0.0) {
						whitespaceRectL.setRect(formRect);
						whitespaceRectL.width = papercal.getWhiteSpaceLeft().doubleValue() * scale;
						formRect.x += papercal.getWhiteSpaceLeft().doubleValue() * scale;
						formRect.width -= papercal.getWhiteSpaceLeft().doubleValue() * scale;
					}
					if (papercal.getWhiteSpaceTop().doubleValue() > 0.0) {
						whitespaceRectT.setRect(formRect);
						whitespaceRectT.height = papercal.getWhiteSpaceTop().doubleValue() * scale;
						formRect.y += papercal.getWhiteSpaceTop().doubleValue() * scale;
						formRect.height -= papercal.getWhiteSpaceTop().doubleValue() * scale;
					}
					if (papercal.getWhiteSpaceRight().doubleValue() > 0.0) {
						whitespaceRectR.setRect(formRect);
						whitespaceRectR.x = (formRect.x + formRect.width) - papercal.getWhiteSpaceRight().doubleValue() * scale;
						whitespaceRectR.width = papercal.getWhiteSpaceRight().doubleValue() * scale;
						formRect.width -= papercal.getWhiteSpaceRight().doubleValue() * scale;		
					}
					if (papercal.getWhiteSpaceBottom().doubleValue() > 0.0) {
						whitespaceRectB.setRect(formRect);
						whitespaceRectB.y = (formRect.y + formRect.height) - papercal.getWhiteSpaceBottom().doubleValue() * scale;
						whitespaceRectB.height = papercal.getWhiteSpaceBottom().doubleValue() * scale;
						formRect.height -= papercal.getWhiteSpaceBottom().doubleValue() * scale;
					}
				}
					
				if (papercal.getUseGutter().booleanValue() == true) {
					gutterH = papercal.getGutterHorizontal().doubleValue() * scale;
					gutterV = papercal.getGutter().doubleValue() * scale;
				}
				
				if (papercal.getUseBleed().booleanValue() == true) {			// bleeds will double the cuts in the effected sides
					bleedL = papercal.getBleedLeft().doubleValue() * scale;
					bleedT = papercal.getBleedTop().doubleValue() * scale;
					bleedR = papercal.getBleedRight().doubleValue() * scale;
					bleedB = papercal.getBleedBottom().doubleValue() * scale;
				}
				
				// 
				// Start of image render pages inside the parent sheet
				//
				g.setColor(Color.lightGray);
				g.fill(formRect);
				
				r1.setRect(sheetRect);
				g.drawRect(r1.x,r1.y,r1.width, r1.height);
				
				PaintXDim(g,r1,basewidth, -4);
				PaintYDim(g,r1,baseheight, 12);
					
				if (papercal.getUseFolioEdge().booleanValue() == true)
				{	// paint the folio
					g.setColor(Color.green);	
					g.fill(folioRect);
				}
					
				if (papercal.getUseGripEdgeGap().booleanValue() == true)
				{	// paint the grip(s)					
					g.setColor(Color.red);	
					g.fill(headGripRect);
					
					if (papercal.getUseFolioEdge().booleanValue() == true)
					{	// paint area(s) where folio and grip intersect with a red/green hatch
						r1.setRect(headGripRect);
						r2.setRect(folioRect);
						
						if (r1.width > r2.width)
							r1.width = r2.width;
						if (r1.height > r2.height)
							r1.height = r2.height;
						intersectRect.setRect(r1);
						
					//	StuffHex(&intersectPat,"\p1122448811224488");				// slant line
						g.setColor(Color.orange);	
						g.fill(intersectRect);
					}
					
					if (job.getRunMethod().equals("WorkAndTumble"))
					{	// paint the tail grip
						g.setColor(Color.red);	
						g.fill(tailGripRect);
						
						if (papercal.getUseFolioEdge().booleanValue() == true && papercal.getUseGripEdgeGap().booleanValue() == true)
						{	// paint area(s) where folio and grip intersect with a red/green hatch
							
							r1.setRect(tailGripRect);
							r2.setRect(folioRect);
							if (r1.width > r2.width)
								r1.width = r2.width;
							if (r1.height > r2.height)
								r1.height = r2.height;
							intersectRect.setRect(r1);
							
						//	StuffHex(&intersectPat,"\p1122448811224488");				// slant line
							g.setColor(Color.orange);	
							g.fill(intersectRect);
						}
					}
				}
					
				if (papercal.getUseColorBar().booleanValue() == true && colorBarWidth > 0)
				{	// paint the color bar(s)
					PaintColorBar(g, colorbarRect);
					
					if (job.getRunMethod().equals("WorkAndTumble"))
					{	// draw it again across the sheet (work and tumble) ... don't forget that we're staying within the sheet
						width = colorBarWidth * scale;
						inset = 0;	// todo - expose inset value to user
						
						if (papercal.getGripLocation().equals(Constants.PAPER_CALCULATOR_GRIPPER_TOP)) {
							colorbarRect.y -= (sheetRect.height - ((inset * 2) + width));
						} else {
							colorbarRect.x -= (sheetRect.width - ((inset * 2) + width));
						}
						PaintColorBar(g, colorbarRect);
					}
				}

				if (papercal.getUseWhiteSpace().booleanValue() == true)
				{	// paint the white space
					g.setColor(Color.gray);	
					g.fill(whitespaceRectT);
					g.fill(whitespaceRectL);
					g.fill(whitespaceRectB);
					g.fill(whitespaceRectR);
				}
				break;
				}
		
		// 
		////////////////////////////////////////////////////////////////////////////////////////////////////
		// Draw in page images inside the parent sheet, minus the grippers, folio, color bars
		//
		if (trimSize.x > 0.0 && trimSize.y > 0.0)
		{	// compose and paint the form *content* (we already know the overall form size/orientation)
			width = ((trimSize.x) * scale);
			height = ((trimSize.y) * scale * aspect);	// todo - aspect is used to express match grain
			
			////////////////////////////////////////////////////////////////////////////
				
			trimRect.setRect(0, 0, width, height);
			bleedRect.setRect(0, 0, width, height);
			bleedRect.width += (bleedL + bleedR);
			bleedRect.height += (bleedT + bleedB);
			
			if ((whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH && papercal.getBackTrimRun().booleanValue() == true) || 
						((whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN || whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_FINISH) && 
									papercal.getBackTrimRun().booleanValue() == true))
			{	// set origin so that items are centered in the form
				width = (papercal.getAcross().doubleValue() * (bleedRect.width + gutterH)) - gutterH;
				height = (papercal.getDown().doubleValue() * (bleedRect.height + gutterV)) - gutterV;
				if (dutch == 1)
				{	// add dutch compensation
					if (papercal.getDutchBottom().intValue() > 0)
					{	// under main signature
						if (dAcross > 0)
						{	
							dutchwidth = (dAcross * (bleedRect.height + gutterV)) - gutterV;
							if (dutchwidth > width)
							{	// use this signature height instead
								width = dutchwidth;
							}
						}
						if (dDown > 0)
						{	
							height += (dDown * (bleedRect.width + gutterH)) - gutterH;
						}
					}
					else
					{	// right of main signature
						if (dAcross > 0)
						{	// compensate for dutch section too
							width += (dAcross * (bleedRect.height + gutterV)) - gutterV;
						}
						if (dDown > 0)
						{	
							dutchheight = (dDown * (bleedRect.width + gutterH)) - gutterH;
							if (dutchheight > height)
							{	// use this signature height instead
								height = dutchheight;
							}
						}
					}
				}
				
				
				origin.x = (int)(formRect.x + (((formRect.width) - width) / 2.0));
				origin.y = (int)(formRect.y + (((formRect.height) - height) / 2.0));
			}
			else
			{	// set origin to upper left (of form)
				origin.x = (int)formRect.x;
				origin.y = (int)formRect.y;
			}
			
			row = 0;
			while (row < papercal.getDown().intValue())
			{	// draw L->R :: 0 - N-1, T->B :: 0 - N-1 (start each iteration from origin)
				bleedRect.x = origin.x;
				bleedRect.y = origin.y;
				for (i = 0; i < row; i++)
				{	// move to row
					bleedRect.y += bleedRect.height + gutterV;
				}
				
				column = 0;	// left-most column
				while (column < papercal.getAcross().intValue())
				{	
					if (column > 0)
					{	// select next column (1-N)
						bleedRect.x += bleedRect.width + gutterH;
					}
					trimRect.x = bleedRect.x;
					trimRect.y = bleedRect.y;
					trimRect.x += bleedL;
					trimRect.y += bleedT;
					
					if (column == 0 && row == 0)
					{	// cache this rect ... we use it later to rendering a trim dimensions tag
						labelRect.setRect(trimRect);
					}
					
					if (bleedRect.equals(trimRect) == false)
					{	// flood fill the bleed
						g.setColor(Color.blue);	
						g.fill(bleedRect);
					}
					
					// fill trim (we're relying on an opaque drawing environment)
					g.setColor(Color.white);
					g.fill(trimRect);
										
					// stroke trim (for visual clarity)
					g.setColor(Color.lightGray);
					g.draw(trimRect);
					g.setColor(Color.black);
					
					++column;
				}
				++row;
			}
			
			if (sheetRect.equals(labelRect) == false)
			{	// paint the trim dimensions tag
				r1.setRect(labelRect);
				PaintXDim(g,r1,trimSize.x, 11);
				PaintYDim(g,r1,trimSize.y, 6);
			}

			// DUTCH CUT //
			if (dutch > 0 && dDown > 0 && dAcross > 0)
			{	// there are dutch cut items to render
				dutchRect.setRect(formRect);
				if (papercal.getDutchBottom().intValue() > 0)
				{	// calculate space remaining below (standard set)
					dutchRect.x = origin.x;
					dutchRect.y = origin.y + (row * (bleedRect.height + gutterV));
				}
				else
				{	// calculate space remaining right (of standard set)
					dutchRect.x = origin.x + (column * (bleedRect.width + gutterH));
					dutchRect.y = origin.y;
				}
				
				// rotate the trim
				width = ((trimSize.x) * scale);
				height = ((trimSize.y) * scale * aspect);	// todo - aspect is used to express match grain
				
				////////////////////////////////////////////////////////////////////////////
				
				// remember ... we're rotated!
				trimRect.setRect(0, 0, height, width);
				bleedRect.setRect(0, 0, height, width);
				bleedRect.width += (bleedT + bleedB);
				bleedRect.height += (bleedL + bleedR);
				
				////////////////////////////////////////////////////////////////////////////
				
				row = 0;
				while (row < dDown)
				{	// from a UL basis ... draw L->R,T->B
					bleedRect.x = dutchRect.x;
					bleedRect.y = dutchRect.y;
					
					for (i = 0; i < row; i++)
					{	// move to row
						bleedRect.y += bleedRect.height + gutterV;
					}
					
					column = 0;	// left-most column
					while (column < dAcross)
					{	
						if (column > 0)
						{	// select next column (1-N)
							bleedRect.x += bleedRect.width + gutterH;
						}						
						// remember ... we're rotated!
						trimRect.x = bleedRect.x;
						trimRect.y = bleedRect.y;
						trimRect.x += bleedT;
						trimRect.y += bleedR;
						
						if (column == 0 && row == 0)
						{	// cache this rect ... we use it later to rendering a trim dimensions tag
							labelRect.setRect(trimRect);
						}
						
						if (bleedRect.equals(trimRect) == false)
						{	// flood fill the bleed
							g.setColor(Color.blue);
							g.fill(bleedRect);
						}
						
						// fill trim (we're relying on an opaque drawing environment)
						g.setColor(Color.white);
						g.fill(trimRect);

						// stroke trim (for visual clarity)
						g.setColor(Color.lightGray);
						g.draw(trimRect);
						g.setColor(Color.black);

						++column;
					}
					++row;
				}
				
				if (sheetRect.equals(labelRect) == false)
				{	// paint a trim dimensions tag
					r1.setRect(labelRect);
					PaintXDim(g,r1,trimSize.y, 11);
					PaintYDim(g,r1,trimSize.x, 6);
				}				
			}
			
			////////////////////////////////////////////////////////////////////////////
			
			switch (whichToStart)
			{	
				case Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_FINISH:
					break;
				case Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN:
					if (job.getOrRunOut().booleanValue() == true)
					{	// If the "Run Out" is overridden show an "X" across the diagram and the word "Overridden"
						
					    g.setStroke(strokeTwoPixel);
					    g.setColor(Color.red);
					    
						// build a square rect that is the same as the short edge of the sheet
						if (sheetRect.width > sheetRect.height)
						{
							tmpRect.setRect(0, 0, sheetRect.height, sheetRect.height);
						}
						else
						{
							tmpRect.setRect(0, 0, sheetRect.width, sheetRect.width);
						}
						tmpRect.x = sheetRect.x;
						tmpRect.y = sheetRect.y;
											
						g.drawLine((int)tmpRect.x,(int) tmpRect.y,(int) (tmpRect.x+tmpRect.width-2), (int)(tmpRect.y+tmpRect.height-2));
						g.drawLine((int)(tmpRect.x+tmpRect.width), (int)tmpRect.y, (int)(tmpRect.x-2), (int)(tmpRect.y+tmpRect.height-2));
					}
					break;
				case Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH:
					//job->usePaperCalcUp == 0 && 
					if (job.getNumUp() != papercal.getRunout().intValue())		// job->finishOut
					{
					    g.setStroke(strokeTwoPixel);
					    g.setColor(Color.red);
						
						// build a square rect that is the same as the short edge of the sheet
						if (sheetRect.width > sheetRect.height)
						{
							tmpRect.setRect(0, 0, sheetRect.height, sheetRect.height);
						}
						else
						{
							tmpRect.setRect(0, 0, sheetRect.width, sheetRect.width);
						}
						
						tmpRect.x = sheetRect.x;
						tmpRect.y = sheetRect.y;
						
						g.drawOval((int)tmpRect.x, (int)tmpRect.y, (int)tmpRect.width, (int)tmpRect.height);
						g.drawLine((int)tmpRect.x,(int) tmpRect.y,(int) (tmpRect.x+tmpRect.width-2), (int)(tmpRect.y+tmpRect.height-2));
					}
					break;
			}	
			
			// if the ledger is active, print the text to the right of the image
			//
		}
	}
	
	public byte[] GeneratePaperCalculatorImage(JobBase job, int whichToStart, int width, int height) {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		Rectangle	r = new Rectangle();
		
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);		// erase to a white background
		g.setColor(Color.black);
		r.setRect(0, 0, width, height);
		g.translate(5,10);			// leave space on the left and top
				
		CreateCutDiagram(job, whichToStart, g, r);
		
		g.dispose();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
		//	ImageIO.write(image, "PNG", new File("/Users/bknabel/BRADSEXCELLENTPNG.png"));
			ImageIO.write(image, "PNG", out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] imageBytes = out.toByteArray(); 
		return imageBytes;
	}
}