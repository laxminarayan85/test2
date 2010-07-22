package com.efi.printsmith.service;

import java.awt.Graphics2D;
import java.awt.Image;
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

		// should round to 3 decimal places
		sheetX = RoundDbl(x, 3);	
		sheetY = RoundDbl(y, 3);
		
		gutterX = 0.0;
		gutterY = 0.0;
		
		if (whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_FINISH || whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH) {
			if (job.getPaperCal().getUseGutter()) {
				gutterX = job.getPaperCal().getGutterHorizontal();		
				gutterY = job.getPaperCal().getGutter();
			}	
			if (job.getPaperCal().getUseBleed()) {
				sheetX += job.getPaperCal().getBleedLeft() + job.getPaperCal().getBleedRight();
				sheetY += job.getPaperCal().getBleedTop() + job.getPaperCal().getBleedBottom();
			}
		}
		
		// know state for each
		job.getPaperCal().setDAcross(0);
		job.getPaperCal().setDDown(0);
		job.getPaperCal().setRMargin(0.0);
		job.getPaperCal().setBMargin(0.0);
		job.getPaperCal().setAcross(0);
		job.getPaperCal().setDown(0);
		job.getPaperCal().setDutchBottom(0);
		job.getPaperCal().setUsedSqrArea(0.0);
		job.getPaperCal().setParentSqrArea(0.0);
		
		/* Finish Grain Example */
		if (job.getPaperCal().getRunToFinishGrain().equals(Constants.PAPER_CALCULATOR_GRAIN_DIRECTION_NEITHER)) {
			dutch = 0;
			grain = 0;
		} else if (job.getPaperCal().getRunToFinishGrain().equals(Constants.PAPER_CALCULATOR_GRAIN_DIRECTION_MATCH_GRAIN)) {
			dutch = 0;
			grain = 1;
		} else if (job.getPaperCal().getRunToFinishGrain().equals(Constants.PAPER_CALCULATOR_GRAIN_DIRECTION_SWING_COMBINATION)) {
			dutch = 1;
			grain = 0;
		}

		parentX = job.getPaperCal().getParentSize().getWidth().doubleValue();
		parentY = job.getPaperCal().getParentSize().getHeight().doubleValue();
		runX = job.getPaperCal().getRunSize().getWidth().doubleValue();
		runY = job.getPaperCal().getRunSize().getHeight().doubleValue();

	//	parentX = PriceListUtilities.getWidthFromSizeString(job.getPaperCal().getParentSize());
//		parentY = PriceListUtilities.getLengthFromSizeString(job.getPaperCal().getParentSize());
	//	runX = PriceListUtilities.getWidthFromSizeString(job.getPaperCal().getRunSize());
	//	runY = PriceListUtilities.getLengthFromSizeString(job.getPaperCal().getRunSize());

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
			
			job.getPaperCal().setAcross(3);
			job.getPaperCal().setDown(2);
			job.getPaperCal().setDAcross(2);
			job.getPaperCal().setDDown(2);
	
			job.getPaperCal().setDutchBottom(1);
			job.getPaperCal().setUsedSqrArea(results * (sheetX * sheetY));
			job.getPaperCal().setParentSqrArea(parentX * parentY);
		} else if (whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH && 
				runX == 26 && runY == 40 && 
				sheetX == 8.5 && sheetY == 11 && 
				dutch == 1 && grain == 0 && 
				gutterX == 0.0 && gutterY == 0.0){
				
			// this is a special case where you can get one more out on a dutch
			//cut if you use 2 rows of dutch cut 
			results = 10;
			
			job.getPaperCal().setAcross(3);
			job.getPaperCal().setDown(2);
			job.getPaperCal().setDAcross(2);
			job.getPaperCal().setDDown(2);
	
			job.getPaperCal().setDutchBottom(1);
			job.getPaperCal().setUsedSqrArea(results * (sheetX * sheetY));
			job.getPaperCal().setParentSqrArea(parentX * parentY);
		}  else if (whichToStart != Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH && 
				parentX == 40 && parentY == 26 && 
				sheetY == 8.5 && sheetX == 11 && 
				dutch == 1 && grain == 0 && 
				gutterX == 0.0 && gutterY == 0.0){
				
			// this is a special case where you can get one more out on a dutch
			//cut if you use 2 rows of dutch cut 
			results = 10;
			
			job.getPaperCal().setAcross(2);
			job.getPaperCal().setDown(3);
			job.getPaperCal().setDAcross(2);
			job.getPaperCal().setDDown(2);
	
			job.getPaperCal().setDutchBottom(0);
			job.getPaperCal().setUsedSqrArea(results * (sheetX * sheetY));
			job.getPaperCal().setParentSqrArea(parentX * parentY);
		} else if (whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH && 
				runX == 40 && runY == 26 && 
				sheetY == 8.5 && sheetX == 11 && 
				dutch == 1 && grain == 0 && 
				gutterX == 0.0 && gutterY == 0.0){
				
			// this is a special case where you can get one more out on a dutch
			//cut if you use 2 rows of dutch cut 
			results = 10;
			
			job.getPaperCal().setAcross(2);
			job.getPaperCal().setDown(3);
			job.getPaperCal().setDAcross(2);
			job.getPaperCal().setDDown(2);
	
			job.getPaperCal().setDutchBottom(0);
			job.getPaperCal().setUsedSqrArea(results * (sheetX * sheetY));
			job.getPaperCal().setParentSqrArea(parentX * parentY);
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
			
			job.getPaperCal().setAcross(2);
			job.getPaperCal().setDown(3);
			job.getPaperCal().setDAcross(1);
			job.getPaperCal().setDDown(4);
	
			job.getPaperCal().setDutchBottom(0);
			job.getPaperCal().setBMargin(2.0);
			job.getPaperCal().setRMargin(11.0);
			job.getPaperCal().setUsedSqrArea(results * (sheetX * sheetY));
			job.getPaperCal().setParentSqrArea(parentX * parentY);
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
				if (job.getPaperCal().getUseFolioEdge() && whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH) {
					if (job.getPaperCal().getFolioLocation().equals(Constants.PAPER_CALCULATOR_FOLIO_TOP)) {
						ajustY = job.getPaperCal().getFolioEdge();
					} else if(job.getPaperCal().getFolioLocation().equals( Constants.PAPER_CALCULATOR_FOLIO_LEFT)) {
						ajustX = job.getPaperCal().getFolioEdge();
					}
				}
				
				//
				// Gripper edge logic, add in the gripper edge amount
				//		
				if ((job.getPaperCal().getUseGripEdgeGap() || job.getPaperCal().getUseColorBar()) && whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH) {
					
					if (job.getPaperCal().getUseGripEdgeGap()) {
						if (job.getPaperCal().getFolioLocation().equals(Constants.PAPER_CALCULATOR_GRIPPER_TOP)) {
							ajust2Y = job.getPaperCal().getGripEdgeGap();
						} else if (job.getPaperCal().getFolioLocation().equals(Constants.PAPER_CALCULATOR_GRIPPER_LEFT)) {
							ajust2X = job.getPaperCal().getGripEdgeGap();
						}
					}
					
					//
					// Take into account the color bar on the opposite side of the gripper
					//
					if (job.getPaperCal().getUseColorBar()) {
						if (job.getPaperCal().getGripLocation() == Constants.PAPER_CALCULATOR_GRIPPER_TOP){
							ajust3Y = job.getPaperCal().getColorBar();
						} else if (job.getPaperCal().getGripLocation() == Constants.PAPER_CALCULATOR_GRIPPER_LEFT){
							ajust3X = job.getPaperCal().getColorBar();
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
					if (job.getRunMethod() == "WorkAndTumble") {		// (GetJobRunDirection(job) & kJobRunDirectionRunAndTumble)
						if (job.getPaperCal().getGripLocation() == Constants.PAPER_CALCULATOR_GRIPPER_TOP){
							if (ajust2Y >= ajust3Y)
								ajustY += ajust2Y;
							else
								ajustY += ajust3Y;
						} else if (job.getPaperCal().getGripLocation() == Constants.PAPER_CALCULATOR_GRIPPER_LEFT){
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
				if (job.getPaperCal().getUseWhiteSpace() && whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH) {
					ajustX += (job.getPaperCal().getWhiteSpaceLeft() + job.getPaperCal().getWhiteSpaceRight());
					ajustY += (job.getPaperCal().getWhiteSpaceTop() + job.getPaperCal().getWhiteSpaceBottom());
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
					job.getPaperCal().setAcross(MaxPageWillFit(parentX, sheetX, gutterX));
				else
					job.getPaperCal().setAcross(0);
				
				if (parentY >= sheetY)
					job.getPaperCal().setDown(MaxPageWillFit(parentY, sheetY, gutterY));
				else
					job.getPaperCal().setDown(0);

				/* number sheets w/o dutch */
				results = job.getPaperCal().getAcross() * job.getPaperCal().getDown();				
				job.getPaperCal().setRMargin((parentX - (job.getPaperCal().getAcross() * sheetX) + (job.getPaperCal().getAcross()-1) * gutterX));
				job.getPaperCal().setBMargin((parentY - (job.getPaperCal().getDown()*sheetY)+ (job.getPaperCal().getDown()-1)*gutterY));
			
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
						if (job.getPaperCal().getUseGutter()) {
							gutterX = job.getPaperCal().getGutter();		// rotate sides
							gutterY = job.getPaperCal().getGutterHorizontal();
						}	
						if (job.getPaperCal().getUseBleed()) {
							sheetX += (job.getPaperCal().getBleedLeft() + job.getPaperCal().getBleedRight());
							sheetY += (job.getPaperCal().getBleedTop() + job.getPaperCal().getBleedBottom());
						}
					}
					
					/* see if a dutch cut is possible - and if it is calculate */
					/*	if there's more sheets on right or left */
					if (job.getPaperCal().getRMargin() >= sheetY && parentY >= sheetX )	/* calculate right side */
						rDutch = (MaxPageWillFit(job.getPaperCal().getRMargin(), sheetY, gutterY) * MaxPageWillFit(parentY, sheetX, gutterX) );
						// ROUND DOWN rDutch
					
					if ( parentX >= sheetY && job.getPaperCal().getBMargin() >= sheetX ) 	/* calc bottom */
						bDutch = ( MaxPageWillFit(parentX, sheetY, gutterY) * MaxPageWillFit(job.getPaperCal().getBMargin(), sheetX, gutterX) );
						// floor - round DOWN
					
					if (bDutch > rDutch)
						job.getPaperCal().setDutchBottom(1);	/* position dutch cut on bottom */
					else
						job.getPaperCal().setDutchBottom(0);
					
					/* its on right */
					if ( job.getPaperCal().getRMargin() >= sheetY && parentY >= sheetX )	{	
						job.getPaperCal().setDAcross(MaxPageWillFit(job.getPaperCal().getRMargin(), sheetY, gutterY));
						job.getPaperCal().setDDown(MaxPageWillFit(parentY, sheetX, gutterX));
						job.getPaperCal().setDutchBottom(0);
					}
					if (job.getPaperCal().getDutchBottom() > 0) {
						job.getPaperCal().setDAcross(MaxPageWillFit(parentX, sheetY, gutterY));
						job.getPaperCal().setDDown(MaxPageWillFit(job.getPaperCal().getBMargin(), sheetX, gutterX));

					} else {
						job.getPaperCal().setDAcross(MaxPageWillFit(job.getPaperCal().getRMargin(), sheetY, gutterY));
						job.getPaperCal().setDDown(MaxPageWillFit(parentY, sheetX, gutterX));
					}
					
					// set both to zero if the sheet want fit
					//
					if (job.getPaperCal().getDDown() == 0 || job.getPaperCal().getDAcross() == 0) {		
						job.getPaperCal().setDAcross(0);
						job.getPaperCal().setDDown(0);
					}
					
					results += (job.getPaperCal().getDAcross() * job.getPaperCal().getDDown());
				}
				
				// compute the square area used by the cut out sheets
				//
				job.getPaperCal().setUsedSqrArea((results * (sheetX * sheetY)));
				
				//
				// compute the square area used by the parent
				//
				parentX = job.getPaperCal().getParentSize().getWidth().doubleValue();
				parentY = job.getPaperCal().getParentSize().getHeight().doubleValue();
				runX = job.getPaperCal().getRunSize().getWidth().doubleValue();
				runY = job.getPaperCal().getRunSize().getHeight().doubleValue();

		//		parentX = PriceListUtilities.getWidthFromSizeString(job.getPaperCal().getParentSize());
		//		parentY = PriceListUtilities.getLengthFromSizeString(job.getPaperCal().getParentSize());
		//		runX = PriceListUtilities.getWidthFromSizeString(job.getPaperCal().getRunSize());
		//		runY = PriceListUtilities.getLengthFromSizeString(job.getPaperCal().getRunSize());

				if (whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_FINISH || whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN) {
					job.getPaperCal().setParentSqrArea(parentX * parentY);
				} else {
					job.getPaperCal().setParentSqrArea(runX * runY);
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
		
		parentX = job.getPaperCal().getParentSize().getWidth().doubleValue();
		parentY = job.getPaperCal().getParentSize().getHeight().doubleValue();
		runX = job.getPaperCal().getRunSize().getWidth().doubleValue();
		runY = job.getPaperCal().getRunSize().getHeight().doubleValue();
		finishX = job.getPaperCal().getFinishSize().getWidth().doubleValue();
		finishY = job.getPaperCal().getFinishSize().getHeight().doubleValue();
	//	parentX = PriceListUtilities.getWidthFromSizeString(job.getPaperCal().getParentSize());
	//	parentY = PriceListUtilities.getLengthFromSizeString(job.getPaperCal().getParentSize());
	//	runX = PriceListUtilities.getWidthFromSizeString(job.getPaperCal().getRunSize());
	//	runY = PriceListUtilities.getLengthFromSizeString(job.getPaperCal().getRunSize());
	//	finishX = PriceListUtilities.getWidthFromSizeString(job.getPaperCal().getFinishSize());
	//	finishY = PriceListUtilities.getLengthFromSizeString(job.getPaperCal().getFinishSize());
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
					CalcMaximumSheets(job, Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH);
					finishCuts = ExtCutCount(job, Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH);
				}
				
				// find the other options at the same time
				if (job.getOrRunCuts().equals(false))
				{
					CalcMaximumSheets(job, Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN);
					runCuts = ExtCutCount(job, Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN);
				}
				// the one asked for
				out = CalcMaximumSheets(job, whichToStart);
				break;
				
			case Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN:
				// find the other options at the same time
				if (job.getOrFinishCuts().equals(false))
				{
					CalcMaximumSheets(job, Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH);
					finishCuts = ExtCutCount(job, Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH);
				}
				
				// use run size as parent
				out = CalcMaximumSheets(job, whichToStart);
				if (job.getOrRunCuts().equals(false))
				{
					runCuts = ExtCutCount(job, whichToStart);
				}
				break;
				
			case Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH:
				// find the other options at the same time
				if (job.getOrRunCuts().equals(false))
				{
					CalcMaximumSheets(job, Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN);
					runCuts = ExtCutCount(job, Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN);
				}
				
				// use parent size
				out = CalcMaximumSheets(job, whichToStart);
				
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
		
		results.add(job.getPaperCal().getDAcross());
		results.add(job.getPaperCal().getDDown());
		results.add(job.getPaperCal().getAcross());
		results.add(job.getPaperCal().getDown());
		results.add(job.getPaperCal().getDutchBottom());
		results.add(job.getPaperCal().getUsedSqrArea());
		results.add(job.getPaperCal().getParentSqrArea());
		results.add(job.getPaperCal().getRMargin());
		results.add(job.getPaperCal().getBMargin());
		results.add(job.getPaperCal().getSwap());
		
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
		out = ((job.getPaperCal().getAcross()-1) + job.getPaperCal().getDown()-1);		/* gross estimate of cuts needed */
		if (out < 0)
			out = 0;
				
		if (whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH) {
		
			if (job.getPaperCal().getUseBleed() == true) {			// bleeds will double the cuts in the effected sides
				
				// bleeds out in the across direction
				//
				if (job.getPaperCal().getBleedLeft() > 0.0 || job.getPaperCal().getBleedRight() > 0.0) {
					out += (job.getPaperCal().getAcross()+1);
				}
				
				// bleeds out in the down direction
				//
				if (job.getPaperCal().getBleedTop() > 0.0 || job.getPaperCal().getBleedBottom() > 0.0) {
					out += (job.getPaperCal().getDown() + 1);
				}
				
				//
				// count which edges have been cut off by the formula above.
				//	If the left or right is cut then both are counted, so the edge
				//	is covered already and should be marked as done here.
				//
				if (job.getPaperCal().getBleedLeft() > 0.0 || job.getPaperCal().getBleedRight() > 0.0)
					runEdgeLeft += 1;
				if (job.getPaperCal().getBleedRight() > 0.0 || job.getPaperCal().getBleedLeft() > 0.0)
					runEdgeRight += 1;
				if (job.getPaperCal().getBleedTop() > 0.0 || job.getPaperCal().getBleedBottom() > 0.0)
					runEdgeTop += 1;
				if (job.getPaperCal().getBleedBottom() > 0.0 || job.getPaperCal().getBleedTop() > 0.0)
					runEdgeBottom += 1;
			}
			
			//
			// count up the extra cuts needed for gutters
			//
			if (job.getPaperCal().getUseGutter()) {
				if (job.getPaperCal().getGutterHorizontal() > 0.0)
					out += job.getPaperCal().getAcross() - 1;
				if (job.getPaperCal().getGutter() > 0.0)
					out += job.getPaperCal().getDown() - 1;
			}
		}
	
		if (whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_RUN || whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_PARENT_TO_FINISH) {
			
			//
			// trim all the way around
			//
			if (job.getPaperCal().getBackTrimParent()) {			// back trim cuts all the way around
				out += 4;
			}
			else {
				if (job.getPaperCal().getRMargin() > 0)			/* add trim cut for waste on right */
					out++;
				if (job.getPaperCal().getBMargin() > 0)			/* add trim cut for waste on bottom */
					out++;
			}
		}
		
		if (whichToStart == Constants.PAPER_CALCULATOR_WHICH_START_RUN_TO_FINISH) {
			if (job.getPaperCal().getTrimFourSides()) {	// back trim cuts all the way around
				
				// back trim any edge not already counted
				if (runEdgeLeft == 0)	out += 1;
				if (runEdgeRight == 0)	out += 1;
				if (runEdgeTop == 0)	out += 1;
				if (runEdgeBottom == 0)	out += 1;
			}
			else {
				if (job.getPaperCal().getUseGripEdgeGap()) {		// gripper in on
					if (job.getPaperCal().getGripEdgeGap() != 0.0) {		// gripper has a value
						out++;								// add one for the gripper
						if (job.getPaperCal().getGripLocation() == Constants.PAPER_CALCULATOR_GRIPPER_LEFT)		//job->gripSide == kEdgeLeftRight) 
							runEdgeLeft += 1;
						else
							runEdgeTop += 1;
								
						if (job.getRunMethod() == "WorkAndTumble") {		// work and tumble is on
							out++;							// add one for the oposite site
							if (job.getPaperCal().getGripLocation() == Constants.PAPER_CALCULATOR_GRIPPER_LEFT)
								runEdgeRight += 1;
							else
								runEdgeBottom += 1;
						}
					}
				}
				
				//
				// Count any extra needed by white space
				//
				if (job.getPaperCal().getUseWhiteSpace()) {
					if (job.getPaperCal().getWhiteSpaceLeft() > 0.0 && runEdgeLeft == 0) {
						runEdgeLeft += 1;
						out += 1;
					}
					if (job.getPaperCal().getWhiteSpaceRight() > 0.0 && runEdgeRight == 0) {
						runEdgeRight += 1;
						out += 1;
					}
					if (job.getPaperCal().getWhiteSpaceTop() > 0.0 && runEdgeTop == 0) {
						runEdgeTop += 1;
						out += 1;
					}
					if (job.getPaperCal().getWhiteSpaceBottom() > 0.0 && runEdgeBottom == 0) {
						runEdgeBottom += 1;
						out += 1;
					}
				}
	
				// only count a folio edge if no gripper exist on the same side as the folio edge
				if (job.getPaperCal().getUseFolioEdge() && ((job.getPaperCal().getUseGripEdgeGap() == false) 
							|| job.getPaperCal().getGripLocation() != job.getPaperCal().getFolioLocation())) {
					if (job.getPaperCal().getFolioEdge() != 0.0) {
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
				if (job.getPaperCal().getRMargin() > 0 && runEdgeRight == 0) {	/* add trim cut for waste on right */
					out++;
					runEdgeRight += 1;
				}
				
				if (job.getPaperCal().getBMargin() > 0 && runEdgeBottom == 0) {	/* add trim cut for waste on bottom */
					out++;
					runEdgeBottom += 1;
				}
				
				// Does the color bar need a seprate cut, that is no folio or gripper is already being trimmed
				if (job.getPaperCal().getUseColorBar()) {
					// color bar is on opposite side from gripper edge
					if (job.getPaperCal().getGripLocation() == Constants.PAPER_CALCULATOR_GRIPPER_TOP){
						if (runEdgeBottom == 0) {
							out++;
							runEdgeBottom += 1;
						}
					} else if (job.getPaperCal().getGripLocation() == Constants.PAPER_CALCULATOR_GRIPPER_LEFT){
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
		
		dout = (job.getPaperCal().getDAcross() * job.getPaperCal().getDDown());
		
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
		
		parentX = job.getPaperCal().getParentSize().getWidth().doubleValue();
		parentY = job.getPaperCal().getParentSize().getHeight().doubleValue();
		runX = job.getPaperCal().getRunSize().getWidth().doubleValue();
		runY = job.getPaperCal().getRunSize().getHeight().doubleValue();
		finishX = job.getPaperCal().getFinishSize().getWidth().doubleValue();
		finishY = job.getPaperCal().getFinishSize().getHeight().doubleValue();
		
	//	parentX = PriceListUtilities.getWidthFromSizeString(job.getPaperCal().getParentSize());
	//	parentY = PriceListUtilities.getLengthFromSizeString(job.getPaperCal().getParentSize());
	//	runX = PriceListUtilities.getWidthFromSizeString(job.getPaperCal().getRunSize());
	//	runY = PriceListUtilities.getLengthFromSizeString(job.getPaperCal().getRunSize());
	//	finishX = PriceListUtilities.getWidthFromSizeString(job.getPaperCal().getFinishSize());
	//	finishY = PriceListUtilities.getLengthFromSizeString(job.getPaperCal().getFinishSize());
		
		runCuts = job.getPaperCal().getCutstoRun();
		finishCuts = job.getPaperCal().getCutstoFinish();
		
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

	public byte[] GeneratePaperCalculatorImage(int width, int height) {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = image.createGraphics();
		g2d.drawRect(20, 20, 30, 50);
		g2d.dispose();
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