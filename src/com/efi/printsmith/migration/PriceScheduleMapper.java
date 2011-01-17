package com.efi.printsmith.migration;

import java.io.File;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.BasicSize;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.PaperPrice;
import com.efi.printsmith.data.StampSchedule;
import com.efi.printsmith.data.Matrix;
import com.efi.printsmith.data.MatrixElement;
import com.efi.printsmith.service.MatrixService;
import com.efi.printsmith.integration.xpedx.XpdexImportParams;
import com.efi.printsmith.data.enums.PriceScheduleMethod;

public class PriceScheduleMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(PriceScheduleMapper.class);
	public void importFile(File uploadedFile) throws Exception {
		
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens, XpdexImportParams importParams) {
		return null;
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens)
			throws Exception {
		log.info("Entering PriceScheduleMapper->importTokens");
		MatrixService matrixService = new MatrixService();
		Matrix matrix = null;
		MatrixElement matrixElement = null;
		int qty = 0;
		String prevId = "";
		String method = "";
		String type = "";
		Boolean addPrice1 = false;
		Boolean addPrice2 = false;
		for (int x = 1; x <= 15; x++) {
			int sides1 = 1;
			int sides2 = 1;
			for (int i = 0; i < fieldTokens.length; i++) {
				String currentImportToken = importTokens[i];
				String currentFieldToken = fieldTokens[i];
				String qtyString = "qty[" + Integer.toString(x) + "]";
				String sides1String = "side1[" + Integer.toString(sides1) + "]";
				String sides2String = "side 2[" + Integer.toString(sides2) + "]";
				if ("recno".equals(currentFieldToken)) {
					/* TODO */
				} else if ("rtype".equals(currentFieldToken)) {
					/* TODO */
				} else if ("record type".equals(currentFieldToken)) {
					if (currentImportToken.equals("0"))
						method = PriceScheduleMethod.UsePressSheets.name();
					else if (currentImportToken.equals("1"))
						method = PriceScheduleMethod.UseOrderedQuantity.name();
					else if (currentImportToken.equals("2"))
						method = PriceScheduleMethod.UseSheetsAndBinderyWaste.name();
					else if (currentImportToken.equals("3"))
						method = PriceScheduleMethod.UseOrderedQuantityPerSheet.name();
				} else if ("schedule type".equals(currentFieldToken) && x == 1) {
					if (currentImportToken.equals("1")) {
						matrix = new StampSchedule();
					}
					else if (currentImportToken.equals("4")) {
						matrix = new PaperPrice();
						((PaperPrice) matrix).setType(1);
					}
					else if (currentImportToken.equals("5")) {
						matrix = new PaperPrice();
						((PaperPrice) matrix).setType(2);
					}
					else {
						break;
					}
					type = currentImportToken;
				} else if ("ID".equals(currentFieldToken)) {
					prevId = currentImportToken;
				} else if ("name".equals(currentFieldToken)) {
					if (type.equals("4") || type.equals("5"))
						((PaperPrice) matrix).setName(currentImportToken);
					//paperPrice.setName(currentImportToken);
				} else if (qtyString.equals(currentFieldToken)) {
					matrixElement = new MatrixElement();
					matrixElement.setQty(Utilities.tokenToInt(currentImportToken));
					if (x == 15)
						matrixElement.setLastLine(true);
					else
						matrixElement.setLastLine(false);
					qty = Utilities.tokenToInt(currentImportToken);
					addPrice1 = true;
					addPrice2 = true;
				} else if ("side1[1]".equals(currentFieldToken)
						&& x == 1) {
					if (matrixElement != null)
						matrixElement.setPrice1(Utilities
								.tokenToDouble(currentImportToken));
				} else if ("side1[2]".equals(currentFieldToken)
						&& x == 2) {
					if (matrixElement != null)
						matrixElement.setPrice1(Utilities
								.tokenToDouble(currentImportToken));
				} else if ("side1[3]".equals(currentFieldToken)
						&& x == 3) {
					if (matrixElement != null)
						matrixElement.setPrice1(Utilities
								.tokenToDouble(currentImportToken));
				} else if ("side1[4]".equals(currentFieldToken)
						&& x == 4) {
					if (matrixElement != null)
						matrixElement.setPrice1(Utilities
								.tokenToDouble(currentImportToken));
				} else if ("side1[5]".equals(currentFieldToken)
						&& x == 5) {
					if (matrixElement != null)
						matrixElement.setPrice1(Utilities
								.tokenToDouble(currentImportToken));
				} else if ("side1[6]".equals(currentFieldToken)
						&& x == 6) {
					if (matrixElement != null)
						matrixElement.setPrice1(Utilities
								.tokenToDouble(currentImportToken));
				} else if ("side1[7]".equals(currentFieldToken)
						&& x == 7) {
					if (matrixElement != null)
						matrixElement.setPrice1(Utilities
								.tokenToDouble(currentImportToken));
				} else if ("side1[8]".equals(currentFieldToken)
						&& x == 8) {
					if (matrixElement != null)
						matrixElement.setPrice1(Utilities
								.tokenToDouble(currentImportToken));
				} else if ("side1[9]".equals(currentFieldToken)
						&& x == 9) {
					if (matrixElement != null)
						matrixElement.setPrice1(Utilities
								.tokenToDouble(currentImportToken));
				} else if ("side1[10]".equals(currentFieldToken)
						&& x == 10) {
					if (matrixElement != null)
						matrixElement.setPrice1(Utilities
								.tokenToDouble(currentImportToken));
				} else if ("side1[11]".equals(currentFieldToken)
						&& x == 11) {
					if (matrixElement != null)
						matrixElement.setPrice1(Utilities
								.tokenToDouble(currentImportToken));
				} else if ("side1[12]".equals(currentFieldToken)
						&& x == 12) {
					if (matrixElement != null)
						matrixElement.setPrice1(Utilities
								.tokenToDouble(currentImportToken));
				} else if ("side1[13]".equals(currentFieldToken)
						&& x == 13) {
					if (matrixElement != null)
						matrixElement.setPrice1(Utilities
								.tokenToDouble(currentImportToken));
				} else if ("side1[14]".equals(currentFieldToken)
						&& x == 14) {
					if (matrixElement != null)
						matrixElement.setPrice1(Utilities
								.tokenToDouble(currentImportToken));
				} else if ("side1[15]".equals(currentFieldToken)
						&& x == 15) {
					matrixElement.setPrice1(Utilities
							.tokenToDouble(currentImportToken));
					matrixElement.setLastLine(true);
				} else if ("side1[16]".equals(currentFieldToken) && x == 1) {
					if (matrixElement != null)
						matrixElement.setPrice2(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[17]".equals(currentFieldToken) && x == 2) {
					if (matrixElement != null)
						matrixElement.setPrice2(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[18]".equals(currentFieldToken) && x == 3) {
					if (matrixElement != null)
						matrixElement.setPrice2(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[19]".equals(currentFieldToken) && x == 4) {
					if (matrixElement != null)
						matrixElement.setPrice2(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[20]".equals(currentFieldToken) && x == 5) {
					if (matrixElement != null)
						matrixElement.setPrice2(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[21]".equals(currentFieldToken) && x == 6) {
					if (matrixElement != null)
						matrixElement.setPrice2(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[22]".equals(currentFieldToken) && x == 7) {
					if (matrixElement != null)
						matrixElement.setPrice2(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[23]".equals(currentFieldToken) && x == 8) {
					if (matrixElement != null)
						matrixElement.setPrice2(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[24]".equals(currentFieldToken) && x == 9) {
					if (matrixElement != null)
						matrixElement.setPrice2(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[25]".equals(currentFieldToken) && x == 10) {
					if (matrixElement != null)
						matrixElement.setPrice2(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[26]".equals(currentFieldToken) && x == 11) {
					if (matrixElement != null)
						matrixElement.setPrice2(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[27]".equals(currentFieldToken) && x == 12) {
					if (matrixElement != null)
						matrixElement.setPrice2(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[28]".equals(currentFieldToken) && x == 13) {
					if (matrixElement != null)
						matrixElement.setPrice2(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[29]".equals(currentFieldToken) && x == 14) {
					if (matrixElement != null)
						matrixElement.setPrice2(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[30]".equals(currentFieldToken) && x == 15) {
					if (matrixElement != null)
						matrixElement.setPrice2(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[31]".equals(currentFieldToken) && x == 1) {
					if (matrixElement != null)
						matrixElement.setPrice3(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[32]".equals(currentFieldToken) && x == 2) {
					if (matrixElement != null)
						matrixElement.setPrice3(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[33]".equals(currentFieldToken) && x == 3) {
					if (matrixElement != null)
						matrixElement.setPrice3(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[34]".equals(currentFieldToken) && x == 4) {
					if (matrixElement != null)
						matrixElement.setPrice3(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[35]".equals(currentFieldToken) && x == 5) {
					if (matrixElement != null)
						matrixElement.setPrice3(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[36]".equals(currentFieldToken) && x == 6) {
					if (matrixElement != null)
						matrixElement.setPrice3(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[37]".equals(currentFieldToken) && x == 7) {
					if (matrixElement != null)
						matrixElement.setPrice3(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[38]".equals(currentFieldToken) && x == 8) {
					if (matrixElement != null)
						matrixElement.setPrice3(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[39]".equals(currentFieldToken) && x == 9) {
					if (matrixElement != null)
						matrixElement.setPrice3(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[40]".equals(currentFieldToken) && x == 10) {
					if (matrixElement != null)
						matrixElement.setPrice3(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[41]".equals(currentFieldToken) && x == 11) {
					if (matrixElement != null)
						matrixElement.setPrice3(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[42]".equals(currentFieldToken) && x == 12) {
					if (matrixElement != null)
						matrixElement.setPrice3(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[43]".equals(currentFieldToken) && x == 13) {
					if (matrixElement != null)
						matrixElement.setPrice3(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[44]".equals(currentFieldToken) && x == 14) {
					if (matrixElement != null)
						matrixElement.setPrice3(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[45]".equals(currentFieldToken) && x == 15) {
					if (matrixElement != null)
						matrixElement.setPrice3(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[46]".equals(currentFieldToken) && x == 1) {
					if (matrixElement != null)
						matrixElement.setPrice4(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[47]".equals(currentFieldToken) && x == 2) {
					if (matrixElement != null)
						matrixElement.setPrice4(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[48]".equals(currentFieldToken) && x == 3) {
					if (matrixElement != null)
						matrixElement.setPrice4(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[49]".equals(currentFieldToken) && x == 4) {
					if (matrixElement != null)
						matrixElement.setPrice4(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[50]".equals(currentFieldToken) && x == 5) {
					if (matrixElement != null)
						matrixElement.setPrice4(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[51]".equals(currentFieldToken) && x == 6) {
					if (matrixElement != null)
						matrixElement.setPrice4(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[52]".equals(currentFieldToken) && x == 7) {
					if (matrixElement != null)
						matrixElement.setPrice4(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[53]".equals(currentFieldToken) && x == 8) {
					if (matrixElement != null)
						matrixElement.setPrice4(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[54]".equals(currentFieldToken) && x == 9) {
					if (matrixElement != null)
						matrixElement.setPrice4(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[55]".equals(currentFieldToken) && x == 10) {
					if (matrixElement != null)
						matrixElement.setPrice4(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[56]".equals(currentFieldToken) && x == 11) {
					if (matrixElement != null)
						matrixElement.setPrice4(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[57]".equals(currentFieldToken) && x == 12) {
					if (matrixElement != null)
						matrixElement.setPrice4(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[58]".equals(currentFieldToken) && x == 13) {
					if (matrixElement != null)
						matrixElement.setPrice4(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[59]".equals(currentFieldToken) && x == 14) {
					if (matrixElement != null)
						matrixElement.setPrice4(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[60]".equals(currentFieldToken) && x == 15) {
					if (matrixElement != null)
						matrixElement.setPrice4(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[61]".equals(currentFieldToken) && x == 1) {
					if (matrixElement != null)
						matrixElement.setPrice5(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[62]".equals(currentFieldToken) && x == 2) {
					if (matrixElement != null)
						matrixElement.setPrice5(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[63]".equals(currentFieldToken) && x == 3) {
					if (matrixElement != null)
						matrixElement.setPrice5(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[64]".equals(currentFieldToken) && x == 4) {
					if (matrixElement != null)
						matrixElement.setPrice5(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[65]".equals(currentFieldToken) && x == 5) {
					if (matrixElement != null)
						matrixElement.setPrice5(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[66]".equals(currentFieldToken) && x == 6) {
					if (matrixElement != null)
						matrixElement.setPrice5(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[67]".equals(currentFieldToken) && x == 7) {
					if (matrixElement != null)
						matrixElement.setPrice5(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[68]".equals(currentFieldToken) && x == 8) {
					if (matrixElement != null)
						matrixElement.setPrice5(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[69]".equals(currentFieldToken) && x == 9) {
					if (matrixElement != null)
						matrixElement.setPrice5(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[70]".equals(currentFieldToken) && x == 10) {
					if (matrixElement != null)
						matrixElement.setPrice5(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[71]".equals(currentFieldToken) && x == 11) {
					if (matrixElement != null)
						matrixElement.setPrice5(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[72]".equals(currentFieldToken) && x == 12) {
					if (matrixElement != null)
						matrixElement.setPrice5(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[73]".equals(currentFieldToken) && x == 13) {
					if (matrixElement != null)
						matrixElement.setPrice5(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[74]".equals(currentFieldToken) && x == 14) {
					if (matrixElement != null)
						matrixElement.setPrice5(Utilities.tokenToDouble(currentImportToken));
				} else if ("side1[75]".equals(currentFieldToken) && x == 15) {
					if (matrixElement != null)
						matrixElement.setPrice5(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[1]".equals(currentFieldToken) && x == 1) {
					if (matrixElement != null)
						matrixElement.setPrice11(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[2]".equals(currentFieldToken) && x == 2) {
					if (matrixElement != null)
						matrixElement.setPrice11(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[3]".equals(currentFieldToken) && x == 3) {
					if (matrixElement != null)
						matrixElement.setPrice11(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[4]".equals(currentFieldToken) && x == 4) {
					if (matrixElement != null)
						matrixElement.setPrice11(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[5]".equals(currentFieldToken) && x == 5) {
					if (matrixElement != null)
						matrixElement.setPrice11(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[6]".equals(currentFieldToken) && x == 6) {
					if (matrixElement != null)
						matrixElement.setPrice11(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[7]".equals(currentFieldToken) && x == 7) {
					if (matrixElement != null)
						matrixElement.setPrice11(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[8]".equals(currentFieldToken) && x == 8) {
					if (matrixElement != null)
						matrixElement.setPrice11(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[9]".equals(currentFieldToken) && x == 9) {
					if (matrixElement != null)
						matrixElement.setPrice11(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[10]".equals(currentFieldToken) && x == 10) {
					if (matrixElement != null)
						matrixElement.setPrice11(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[11]".equals(currentFieldToken) && x == 11) {
					if (matrixElement != null)
						matrixElement.setPrice11(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[12]".equals(currentFieldToken) && x == 12) {
					if (matrixElement != null)
						matrixElement.setPrice11(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[13]".equals(currentFieldToken) && x == 13) {
					if (matrixElement != null)
						matrixElement.setPrice11(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[14]".equals(currentFieldToken) && x == 14) {
					if (matrixElement != null)
						matrixElement.setPrice11(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[15]".equals(currentFieldToken) && x == 15) {
					if (matrixElement != null)
						matrixElement.setPrice11(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[16]".equals(currentFieldToken) && x == 1) {
					if (matrixElement != null)
						matrixElement.setPrice12(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[17]".equals(currentFieldToken) && x == 2) {
					if (matrixElement != null)
						matrixElement.setPrice12(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[18]".equals(currentFieldToken) && x == 3) {
					if (matrixElement != null)
						matrixElement.setPrice12(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[19]".equals(currentFieldToken) && x == 4) {
					if (matrixElement != null)
						matrixElement.setPrice12(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[20]".equals(currentFieldToken) && x == 5) {
					if (matrixElement != null)
						matrixElement.setPrice12(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[21]".equals(currentFieldToken) && x == 6) {
					if (matrixElement != null)
						matrixElement.setPrice12(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[22]".equals(currentFieldToken) && x == 7) {
					if (matrixElement != null)
						matrixElement.setPrice12(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[23]".equals(currentFieldToken) && x == 8) {
					if (matrixElement != null)
						matrixElement.setPrice12(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[24]".equals(currentFieldToken) && x == 9) {
					if (matrixElement != null)
						matrixElement.setPrice12(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[25]".equals(currentFieldToken) && x == 10) {
					if (matrixElement != null)
						matrixElement.setPrice12(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[26]".equals(currentFieldToken) && x == 11) {
					if (matrixElement != null)
						matrixElement.setPrice12(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[27]".equals(currentFieldToken) && x == 12) {
					if (matrixElement != null)
						matrixElement.setPrice12(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[28]".equals(currentFieldToken) && x == 13) {
					if (matrixElement != null)
						matrixElement.setPrice12(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[29]".equals(currentFieldToken) && x == 14) {
					if (matrixElement != null)
						matrixElement.setPrice12(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[30]".equals(currentFieldToken) && x == 15) {
					if (matrixElement != null)
						matrixElement.setPrice12(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[31]".equals(currentFieldToken) && x == 1) {
					if (matrixElement != null)
						matrixElement.setPrice13(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[32]".equals(currentFieldToken) && x == 2) {
					if (matrixElement != null)
						matrixElement.setPrice13(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[33]".equals(currentFieldToken) && x == 3) {
					if (matrixElement != null)
						matrixElement.setPrice13(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[34]".equals(currentFieldToken) && x == 4) {
					if (matrixElement != null)
						matrixElement.setPrice13(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[35]".equals(currentFieldToken) && x == 5) {
					if (matrixElement != null)
						matrixElement.setPrice13(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[36]".equals(currentFieldToken) && x == 6) {
					if (matrixElement != null)
						matrixElement.setPrice13(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[37]".equals(currentFieldToken) && x == 7) {
					if (matrixElement != null)
						matrixElement.setPrice13(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[38]".equals(currentFieldToken) && x == 8) {
					if (matrixElement != null)
						matrixElement.setPrice13(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[39]".equals(currentFieldToken) && x == 9) {
					if (matrixElement != null)
						matrixElement.setPrice13(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[40]".equals(currentFieldToken) && x == 10) {
					if (matrixElement != null)
						matrixElement.setPrice13(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[41]".equals(currentFieldToken) && x == 11) {
					if (matrixElement != null)
						matrixElement.setPrice13(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[42]".equals(currentFieldToken) && x == 12) {
					if (matrixElement != null)
						matrixElement.setPrice13(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[43]".equals(currentFieldToken) && x == 13) {
					if (matrixElement != null)
						matrixElement.setPrice13(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[44]".equals(currentFieldToken) && x == 14) {
					if (matrixElement != null)
						matrixElement.setPrice13(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[45]".equals(currentFieldToken) && x == 15) {
					if (matrixElement != null)
						matrixElement.setPrice13(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[46]".equals(currentFieldToken) && x == 1) {
					if (matrixElement != null)
						matrixElement.setPrice14(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[47]".equals(currentFieldToken) && x == 2) {
					if (matrixElement != null)
						matrixElement.setPrice14(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[48]".equals(currentFieldToken) && x == 3) {
					if (matrixElement != null)
						matrixElement.setPrice14(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[49]".equals(currentFieldToken) && x == 4) {
					if (matrixElement != null)
						matrixElement.setPrice14(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[50]".equals(currentFieldToken) && x == 5) {
					if (matrixElement != null)
						matrixElement.setPrice14(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[51]".equals(currentFieldToken) && x == 6) {
					if (matrixElement != null)
						matrixElement.setPrice14(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[52]".equals(currentFieldToken) && x == 7) {
					if (matrixElement != null)
						matrixElement.setPrice14(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[53]".equals(currentFieldToken) && x == 8) {
					if (matrixElement != null)
						matrixElement.setPrice14(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[54]".equals(currentFieldToken) && x == 9) {
					if (matrixElement != null)
						matrixElement.setPrice14(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[55]".equals(currentFieldToken) && x == 10) {
					if (matrixElement != null)
						matrixElement.setPrice14(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[56]".equals(currentFieldToken) && x == 11) {
					if (matrixElement != null)
						matrixElement.setPrice14(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[57]".equals(currentFieldToken) && x == 12) {
					if (matrixElement != null)
						matrixElement.setPrice14(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[58]".equals(currentFieldToken) && x == 13) {
					if (matrixElement != null)
						matrixElement.setPrice14(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[59]".equals(currentFieldToken) && x == 14) {
					if (matrixElement != null)
						matrixElement.setPrice14(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[60]".equals(currentFieldToken) && x == 15) {
					if (matrixElement != null)
						matrixElement.setPrice14(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[61]".equals(currentFieldToken) && x == 1) {
					if (matrixElement != null)
						matrixElement.setPrice15(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[62]".equals(currentFieldToken) && x == 2) {
					if (matrixElement != null)
						matrixElement.setPrice15(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[63]".equals(currentFieldToken) && x == 3) {
					if (matrixElement != null)
						matrixElement.setPrice15(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[64]".equals(currentFieldToken) && x == 4) {
					if (matrixElement != null)
						matrixElement.setPrice15(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[65]".equals(currentFieldToken) && x == 5) {
					if (matrixElement != null)
						matrixElement.setPrice15(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[66]".equals(currentFieldToken) && x == 6) {
					if (matrixElement != null)
						matrixElement.setPrice15(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[67]".equals(currentFieldToken) && x == 7) {
					if (matrixElement != null)
						matrixElement.setPrice15(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[68]".equals(currentFieldToken) && x == 8) {
					if (matrixElement != null)
						matrixElement.setPrice15(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[69]".equals(currentFieldToken) && x == 9) {
					if (matrixElement != null)
						matrixElement.setPrice15(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[70]".equals(currentFieldToken) && x == 10) {
					if (matrixElement != null)
						matrixElement.setPrice15(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[71]".equals(currentFieldToken) && x == 11) {
					if (matrixElement != null)
						matrixElement.setPrice15(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[72]".equals(currentFieldToken) && x == 12) {
					if (matrixElement != null)
						matrixElement.setPrice15(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[73]".equals(currentFieldToken) && x == 13) {
					if (matrixElement != null)
						matrixElement.setPrice15(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[74]".equals(currentFieldToken) && x == 14) {
					if (matrixElement != null)
						matrixElement.setPrice15(Utilities.tokenToDouble(currentImportToken));
				} else if ("side 2[75]".equals(currentFieldToken) && x == 15) {
					if (matrixElement != null)
						matrixElement.setPrice15(Utilities.tokenToDouble(currentImportToken));
				}
			}
			matrix.addElements(matrixElement);
			matrix.setHeader1(1L);
			matrix.setHeader2(2L);
			matrix.setHeader3(3L);
			matrix.setHeader4(4L);
			matrix.setHeader5(5L);
			matrix.setHeader6(6L);
			matrix.setHeader7(7L);
			matrix.setHeader8(8L);
			matrix.setHeader9(9L);
			matrix.setHeader10(10L);
		}
		log.info("Leaving PriceScheduleMapper->importTokens");
		((PaperPrice) matrix).setMethod(method);
		return matrix;
	}
}