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
		int sides1 = 1;
		int sides2 = 1;
		String method = "";
		for (int x = 1; x <= 15; x++) {
			for (int i = 0; i < fieldTokens.length; i++) {
				String currentImportToken = importTokens[i];
				String currentFieldToken = fieldTokens[i];
				String qtyString = "qty[" + Integer.toString(x) + "]";
				String sides1String = "side1[" + Integer.toString(sides1) + "]";
				String sides2String = "side2[" + Integer.toString(sides2) + "]";
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
				} else if ("schedule type".equals(currentFieldToken)) {
					if (currentImportToken.equals("1"))
						matrix = matrixService.newStampSchedule();
					else if (currentImportToken.equals("4"))
						matrix = matrixService.newPaperPrice(1);
					else if (currentImportToken.equals("5"))
						matrix = matrixService.newPaperPrice(2);
					else
						matrix = matrixService.newPaperPrice(1);
				} else if ("ID".equals(currentFieldToken)) {
					matrix.setPrevId(currentImportToken);
				} else if ("name".equals(currentFieldToken)) {
					//paperPrice.setName(currentImportToken);
				} else if (qtyString.equals(currentFieldToken)) {
					qty = Utilities.tokenToInt(currentImportToken);
				} else if (sides1String.equals(currentFieldToken) && qty > 0) {
					matrixElement = matrix.getElements().get(x-1);
					matrixElement.setQty(qty);
					switch (x) {
					case 1:
						matrixElement.setPrice1(Utilities.tokenToDouble(currentImportToken));
						break;
					case 2:
						matrixElement.setPrice2(Utilities.tokenToDouble(currentImportToken));
						break;
					case 3:
						matrixElement.setPrice3(Utilities.tokenToDouble(currentImportToken));
						break;
					case 4:
						matrixElement.setPrice4(Utilities.tokenToDouble(currentImportToken));
						break;
					case 5:
						matrixElement.setPrice5(Utilities.tokenToDouble(currentImportToken));
						break;
					case 6:
						matrixElement.setPrice6(Utilities.tokenToDouble(currentImportToken));
						break;
					case 7:
						matrixElement.setPrice7(Utilities.tokenToDouble(currentImportToken));
						break;
					case 8:
						matrixElement.setPrice8(Utilities.tokenToDouble(currentImportToken));
						break;
					case 9:
						matrixElement.setPrice9(Utilities.tokenToDouble(currentImportToken));
						break;
					case 10:
						matrixElement.setPrice10(Utilities.tokenToDouble(currentImportToken));
						break;
					}
					sides1++;
				} else if (sides2String.equals(currentFieldToken) && qty > 0) {
					matrixElement = matrix.getElements().get(x-1);
					matrixElement.setQty(qty);
					switch (x) {
					case 1:
						matrixElement.setPrice11(Utilities.tokenToDouble(currentImportToken));
						break;
					case 2:
						matrixElement.setPrice12(Utilities.tokenToDouble(currentImportToken));
						break;
					case 3:
						matrixElement.setPrice13(Utilities.tokenToDouble(currentImportToken));
						break;
					case 4:
						matrixElement.setPrice14(Utilities.tokenToDouble(currentImportToken));
						break;
					case 5:
						matrixElement.setPrice15(Utilities.tokenToDouble(currentImportToken));
						break;
					case 6:
						matrixElement.setPrice16(Utilities.tokenToDouble(currentImportToken));
						break;
					case 7:
						matrixElement.setPrice17(Utilities.tokenToDouble(currentImportToken));
						break;
					case 8:
						matrixElement.setPrice18(Utilities.tokenToDouble(currentImportToken));
						break;
					case 9:
						matrixElement.setPrice19(Utilities.tokenToDouble(currentImportToken));
						break;
					case 10:
						matrixElement.setPrice20(Utilities.tokenToDouble(currentImportToken));
						break;
					}
					sides2++;
				}
			}
		}
		log.info("Leaving PriceScheduleMapper->importTokens");
		((PaperPrice) matrix).setMethod(method);
		return matrix;
	}
}