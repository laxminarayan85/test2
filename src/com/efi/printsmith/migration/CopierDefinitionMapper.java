package com.efi.printsmith.migration;

import java.io.File;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.CostCenter;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.PreferencesSequenceValues;
import com.efi.printsmith.data.SalesCategory;
import com.efi.printsmith.service.DataService;
import com.efi.printsmith.service.PricingService;
import com.efi.printsmith.data.Matrix;
import com.efi.printsmith.data.MatrixElement;
import com.efi.printsmith.service.CopierService;
import com.efi.printsmith.data.PreferencesDefaultPresses;

public class CopierDefinitionMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(CopierDefinitionMapper.class);

	public void importFile(File uploadedFile) throws Exception {

	}

	public ModelBase importTokens(String[] fieldTokens, String[] importTokens)
			throws Exception {
		log.info("Entering CopierDefinitionMapper->importTokens");
		CopierDefinition copierDefinition = new CopierDefinition();
		DataService dataService = new DataService();
		CopierService copierService = new CopierService();
		SalesCategory salesCategory = null;
		Matrix matrix = new Matrix();
		boolean defaultBW = false;
		boolean defaultColor = false;
		boolean defaultLF = false;
		for (int x = 1; x <= 15; x++) {
			MatrixElement matrixElement = new MatrixElement();
			boolean addSalesCategory = false;
			for (int i = 0; i < fieldTokens.length; i++) {
				String currentImportToken = importTokens[i];
				String currentFieldToken = fieldTokens[i];

				if ("recno".equals(currentFieldToken)) {
					copierDefinition.setPrevId(currentImportToken);
				} else if ("name".equals(currentFieldToken)) {
					copierDefinition.setName(currentImportToken);
				} else if ("machine ID".equals(currentFieldToken)) {
					copierDefinition.setCopyID(Utilities
							.tokenToInt(currentImportToken));
				} else if ("days per year".equals(currentFieldToken)) {
					copierDefinition.setDaysOpen(Utilities
							.tokenToInt(currentImportToken));
				} else if ("hours per day".equals(currentFieldToken)) {
					copierDefinition.setHoursOpen(Utilities
							.tokenToInt(currentImportToken));
				} else if ("speed".equals(currentFieldToken)) {
					copierDefinition.setCopyMinutes(Utilities
							.tokenToDouble(currentImportToken));
				} else if ("efficiency".equals(currentFieldToken)) {
					copierDefinition.setPercentUsage(Utilities
							.tokenToDouble(currentImportToken) * 100);
				} else if ("maintenance".equals(currentFieldToken)) {
					copierDefinition.setMonthlyMaintenance(Utilities
							.tokenToDouble(currentImportToken));
				} else if ("payment".equals(currentFieldToken)) {
					copierDefinition.setMonthlyPayment(Utilities
							.tokenToDouble(currentImportToken));
				} else if ("machine".equals(currentFieldToken)) {
					copierDefinition.setMachineName(currentImportToken);
				} else if ("labor".equals(currentFieldToken)) {
					copierDefinition.setLaborCopy(Utilities
							.tokenToDouble(currentImportToken));
				} else if ("toner".equals(currentFieldToken)) {
					copierDefinition.setTonerCopy(Utilities
							.tokenToDouble(currentImportToken));
				} else if ("developer".equals(currentFieldToken)) {
					copierDefinition.setDeveloperCopy(Utilities
							.tokenToDouble(currentImportToken));
				} else if ("copy range[1]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("copy range[2]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("copy range[3]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("copy range[4]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("copy range[5]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("copy range[6]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("copy range[7]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("copy range[8]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("copy range[9]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("copy range[10]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("copy range[11]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("copy range[12]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("stockfactor[1]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("stockfactor[2]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("stockfactor[3]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("stockfactor[4]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("stockfactor[5]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("stockfactor[6]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("id".equals(currentFieldToken)) {
					copierDefinition.setCopierId(currentImportToken);
				} else if ("markup".equals(currentFieldToken)) {
					/* TODO */
				} else if ("charges[1]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService.getByPrevId(
								"ChargeDefinition", currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							copierDefinition.addCharges(chargeDefinition);
						}
					}
				} else if ("charges[2]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService.getByPrevId(
								"ChargeDefinition", currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							copierDefinition.addCharges(chargeDefinition);
						}
					}
				} else if ("charges[3]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService.getByPrevId(
								"ChargeDefinition", currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							copierDefinition.addCharges(chargeDefinition);
						}
					}
				} else if ("charges[4]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService.getByPrevId(
								"ChargeDefinition", currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							copierDefinition.addCharges(chargeDefinition);
						}
					}
				} else if ("charges[5]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService.getByPrevId(
								"ChargeDefinition", currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							copierDefinition.addCharges(chargeDefinition);
						}
					}
				} else if ("charges[6]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService.getByPrevId(
								"ChargeDefinition", currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							copierDefinition.addCharges(chargeDefinition);
						}
					}
				} else if ("charges[7]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService.getByPrevId(
								"ChargeDefinition", currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							copierDefinition.addCharges(chargeDefinition);
						}
					}
				} else if ("charges[8]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService.getByPrevId(
								"ChargeDefinition", currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							copierDefinition.addCharges(chargeDefinition);
						}
					}
				} else if ("charges[9]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService.getByPrevId(
								"ChargeDefinition", currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							copierDefinition.addCharges(chargeDefinition);
						}
					}
				} else if ("charges[10]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService.getByPrevId(
								"ChargeDefinition", currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							copierDefinition.addCharges(chargeDefinition);
						}
					}
				} else if ("chart qty[1]".equals(currentFieldToken) && x == 1) {
					matrixElement.setQty(Utilities.tokenToInt(currentImportToken));
				} else if ("chart qty[2]".equals(currentFieldToken) && x == 2) {
					matrixElement.setQty(Utilities.tokenToInt(currentImportToken));
				} else if ("chart qty[3]".equals(currentFieldToken) && x == 3) {
					matrixElement.setQty(Utilities.tokenToInt(currentImportToken));
				} else if ("chart qty[4]".equals(currentFieldToken) && x == 4) {
					matrixElement.setQty(Utilities.tokenToInt(currentImportToken));
				} else if ("chart qty[5]".equals(currentFieldToken) && x == 5) {
					matrixElement.setQty(Utilities.tokenToInt(currentImportToken));
				} else if ("chart qty[6]".equals(currentFieldToken) && x == 6) {
					matrixElement.setQty(Utilities.tokenToInt(currentImportToken));
				} else if ("chart qty[7]".equals(currentFieldToken) && x == 7) {
					matrixElement.setQty(Utilities.tokenToInt(currentImportToken));
				} else if ("chart qty[8]".equals(currentFieldToken) && x == 8) {
					matrixElement.setQty(Utilities.tokenToInt(currentImportToken));
				} else if ("chart qty[9]".equals(currentFieldToken) && x == 9) {
					matrixElement.setQty(Utilities.tokenToInt(currentImportToken));
				} else if ("chart qty[10]".equals(currentFieldToken) && x == 10) {
					matrixElement.setQty(Utilities.tokenToInt(currentImportToken));
				} else if ("chart qty[11]".equals(currentFieldToken) && x == 11) {
					matrixElement.setQty(Utilities.tokenToInt(currentImportToken));
				} else if ("chart qty[12]".equals(currentFieldToken) && x == 12) {
					matrixElement.setQty(Utilities.tokenToInt(currentImportToken));
				} else if ("chart qty[13]".equals(currentFieldToken) && x == 13) {
					matrixElement.setQty(Utilities.tokenToInt(currentImportToken));
				} else if ("chart qty[14]".equals(currentFieldToken) && x == 14) {
					matrixElement.setQty(Utilities.tokenToInt(currentImportToken));
				} else if ("chart qty[15]".equals(currentFieldToken) && x == 15) {
					matrixElement.setQty(Utilities.tokenToInt(currentImportToken));
				} else if ("chart original[1]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart original[2]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart original[3]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart original[4]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart original[5]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart original[6]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart original[7]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart original[8]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart original[9]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart original[10]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[1]".equals(currentFieldToken) && x == 1) {
					matrixElement.setPrice1(Utilities.tokenToDouble(currentImportToken));
				} else if ("chart factor[2]".equals(currentFieldToken) && x == 2) {
					matrixElement.setPrice1(Utilities.tokenToDouble(currentImportToken));
				} else if ("chart factor[3]".equals(currentFieldToken) && x == 3) {
					matrixElement.setPrice1(Utilities.tokenToDouble(currentImportToken));
				} else if ("chart factor[4]".equals(currentFieldToken) && x == 4) {
					matrixElement.setPrice1(Utilities.tokenToDouble(currentImportToken));
				} else if ("chart factor[5]".equals(currentFieldToken) && x == 5) {
					matrixElement.setPrice1(Utilities.tokenToDouble(currentImportToken));
				} else if ("chart factor[6]".equals(currentFieldToken) && x == 6) {
					matrixElement.setPrice1(Utilities.tokenToDouble(currentImportToken));
				} else if ("chart factor[7]".equals(currentFieldToken) && x == 7) {
					matrixElement.setPrice1(Utilities.tokenToDouble(currentImportToken));
				} else if ("chart factor[8]".equals(currentFieldToken) && x == 8) {
					matrixElement.setPrice1(Utilities.tokenToDouble(currentImportToken));
				} else if ("chart factor[9]".equals(currentFieldToken) && x == 9) {
					matrixElement.setPrice1(Utilities.tokenToDouble(currentImportToken));
				} else if ("chart factor[10]".equals(currentFieldToken) && x == 10) {
					matrixElement.setPrice1(Utilities.tokenToDouble(currentImportToken));
				} else if ("chart factor[11]".equals(currentFieldToken) && x == 11) {
					matrixElement.setPrice1(Utilities.tokenToDouble(currentImportToken));
				} else if ("chart factor[12]".equals(currentFieldToken) && x == 12) {
					matrixElement.setPrice1(Utilities.tokenToDouble(currentImportToken));
				} else if ("chart factor[13]".equals(currentFieldToken) && x == 13) {
					matrixElement.setPrice1(Utilities.tokenToDouble(currentImportToken));
				} else if ("chart factor[14]".equals(currentFieldToken) && x == 14) {
					matrixElement.setPrice1(Utilities.tokenToDouble(currentImportToken));
				} else if ("chart factor[15]".equals(currentFieldToken) && x == 15) {
					matrixElement.setPrice1(Utilities.tokenToDouble(currentImportToken));
				} else if ("chart factor[16]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[17]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[18]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[19]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[20]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[21]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[22]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[23]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[24]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[25]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[26]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[27]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[28]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[29]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[30]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[31]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[32]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[33]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[34]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[35]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[36]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[37]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[38]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[39]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[40]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[41]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[42]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[43]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[44]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[45]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[46]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[47]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[48]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[49]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[50]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[51]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[52]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[53]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[54]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[55]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[56]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[57]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[58]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[59]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[60]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[61]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[62]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[63]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[64]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[65]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[66]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[67]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[68]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[69]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[70]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[71]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[72]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[73]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[74]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[75]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[76]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[77]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[78]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[79]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[80]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[81]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[82]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[83]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[84]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[85]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[86]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[87]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[88]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[89]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[90]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[91]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[92]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[93]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[94]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[95]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[96]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[97]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[98]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[99]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[100]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[101]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[102]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[103]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[104]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[105]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[106]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[107]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[108]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[109]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[110]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[111]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[112]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[113]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[114]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[115]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[116]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[117]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[118]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[119]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[120]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[121]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[122]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[123]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[124]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[125]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[126]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[127]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[128]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[129]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[130]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[131]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[132]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[133]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[134]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[135]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[136]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[137]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[138]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[139]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[140]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[141]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[142]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[143]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[144]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[145]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[146]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[147]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[148]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[149]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor[150]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[1]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[2]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[3]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[4]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[5]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[6]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[7]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[8]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[9]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[10]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[11]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[12]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[13]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[14]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[15]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[16]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[17]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[18]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[19]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[20]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[21]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[22]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[23]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[24]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[25]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[26]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[27]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[28]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[29]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[30]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[31]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[32]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[33]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[34]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[35]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[36]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[37]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[38]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[39]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[40]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[41]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[42]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[43]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[44]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[45]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[46]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[47]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[48]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[49]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[50]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[51]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[52]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[53]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[54]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[55]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[56]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[57]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[58]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[59]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[60]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[61]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[62]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[63]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[64]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[65]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[66]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[67]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[68]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[69]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[70]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[71]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[72]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[73]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[74]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[75]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[76]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[77]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[78]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[79]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[80]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[81]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[82]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[83]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[84]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[85]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[86]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[87]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[88]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[89]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[90]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[91]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[92]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[93]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[94]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[95]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[96]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[97]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[98]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[99]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[100]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[101]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[102]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[103]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[104]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[105]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[106]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[107]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[108]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[109]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[110]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[111]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[112]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[113]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[114]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[115]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[116]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[117]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[118]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[119]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[120]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[121]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[122]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[123]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[124]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[125]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[126]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[127]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[128]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[129]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[130]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[131]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[132]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[133]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[134]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[135]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[136]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[137]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[138]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[139]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[140]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[141]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[142]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[143]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[144]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[145]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[146]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[147]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[148]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[149]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("chart factor2[150]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("method".equals(currentFieldToken)) {
					if (currentImportToken.equals("0"))
						copierDefinition.setMethod("none");
					else if (currentImportToken.equals("1"))
						copierDefinition.setMethod("CostPlus");
					else if (currentImportToken.equals("2"))
						copierDefinition.setMethod("FlateRate");
					else if (currentImportToken.equals("3"))
						copierDefinition.setMethod("CopiesAndOriginals");
					else if (currentImportToken.equals("4"))
						copierDefinition.setMethod("CopiesPerOriginal");
					else if (currentImportToken.equals("5"))
						copierDefinition.setMethod("TotalOfAllCopies");
					else if (currentImportToken.equals("6"))
						copierDefinition.setMethod("SquareAreaAndOriginals");
					else if (currentImportToken.equals("7"))
						copierDefinition.setMethod("TotalSquareArea");
					else if (currentImportToken.equals("8"))
						copierDefinition.setMethod("SquareAreaAndCopies");
					else if (currentImportToken.equals("9"))
						copierDefinition.setMethod("SquareAreaPerCopy");
				
				} else if ("schedule type".equals(currentFieldToken)) {
					if (currentImportToken.equals("1") == true)
						copierDefinition.setMatrixType("CopyCost");
					else if (currentImportToken.equals("2") == true)
						copierDefinition.setMatrixType("DiscountTable");
					else if (currentImportToken.equals("3") == true)
						copierDefinition.setMatrixType("StepTable");
					else if (currentImportToken.equals("4") == true)
						copierDefinition.setSquareAreaType("MarkupTable" );
				} else if ("stock price".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == true)
						copierDefinition.setStockPriceMethod("none");
					else if (currentImportToken.equals("1") == true)
						copierDefinition
								.setStockPriceMethod("IncludedInRate");
					else if (currentImportToken.equals("2") == true)
						copierDefinition.setStockPriceMethod("MarkedUpStockCost");
					else if (currentImportToken.equals("3") == true)
						copierDefinition.setStockPriceMethod("FromCopier1InStockDefinition");
					else if (currentImportToken.equals("4") == true)
						copierDefinition.setStockPriceMethod("FromCopier2InStockDefinition");
					else if (currentImportToken.equals("5") == true)
						copierDefinition.setStockPriceMethod("FromCopier3InStockDefinition");
				} else if ("second side".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == true)
						copierDefinition.setPriceTwoSide("none");
					else if (currentImportToken.equals("1") == true)
						copierDefinition.setPriceTwoSide("NotChangingPrice");
					else if (currentImportToken.equals("2") == true)
						copierDefinition.setPriceTwoSide("UsingFirstSideRate");
					else if (currentImportToken.equals("3") == true)
						copierDefinition.setPriceTwoSide("UsingSecondSideRate");
					else if (currentImportToken.equals("4") == true)
						copierDefinition.setPriceTwoSide("CountingAsMoreOrininals");
					else if (currentImportToken.equals("5") == true)
						copierDefinition.setPriceTwoSide("UsingSide2Factor");
				} else if ("sales category".equals(currentFieldToken)) {
						salesCategory = (SalesCategory)dataService.getByPrevId("SalesCategory", currentImportToken);
						if (salesCategory != null)
							copierDefinition.setSalesCat(salesCategory);
						else {
							salesCategory = new SalesCategory();
							salesCategory.setPrevId(currentImportToken);
							salesCategory = (SalesCategory)dataService.addUpdate(salesCategory);
							addSalesCategory = true;
						}
					
				} else if ("sales cat name".equals(currentFieldToken)) {
					if (addSalesCategory == true) {
						salesCategory.setName(currentImportToken);
						salesCategory = (SalesCategory)dataService.addUpdate(salesCategory);
						salesCategory.setId(salesCategory.getId());
						copierDefinition.setSalesCat(salesCategory);
					}
				} else if ("flat rate".equals(currentFieldToken)) {
					copierDefinition.setFlateRate(Utilities.tokenToDouble(currentImportToken));
				} else if ("flat markup".equals(currentFieldToken)) {
					/* TODO */
				} else if ("base rate".equals(currentFieldToken)) {
					copierDefinition.setBaseRate(Utilities.tokenToDouble(currentImportToken));
				} else if ("base markup".equals(currentFieldToken)) {
					/* TODO */
				} else if ("stock markup".equals(currentFieldToken)) {
					copierDefinition.setStockMarkup(Utilities
							.tokenToDouble(currentImportToken));
				} else if ("copy markup".equals(currentFieldToken)) {
					copierDefinition.setCopyMarkup(Utilities
							.tokenToDouble(currentImportToken));
				} else if ("back factor".equals(currentFieldToken)) {
					copierDefinition.setSideTwoFactor(Utilities
							.tokenToDouble(currentImportToken));
				} else if ("use factors".equals(currentFieldToken)) {
					/* TODO */
				} else if ("only copies".equals(currentFieldToken)) {
					/* TODO */
				} else if ("ignore side 2".equals(currentFieldToken)) {
					/* TODO */
				} else if ("total all copies".equals(currentFieldToken)) {
					/* TODO */
				} else if ("use originals".equals(currentFieldToken)) {
					/* TODO */
				} else if ("o stock markup".equals(currentFieldToken)) {
					/* TODO */
				} else if ("special".equals(currentFieldToken)) {
					/* TODO */
				} else if ("rstatus".equals(currentFieldToken)) {
					/* TODO */
				} else if ("rtype".equals(currentFieldToken)) {
					/* TODO */
				} else if ("not used".equals(currentFieldToken)) {
					/* TODO */
				} else if ("device ID".equals(currentFieldToken)) {
					copierDefinition.setOemDeviceID(currentImportToken);
				} else if ("output desc".equals(currentFieldToken)) {
					copierDefinition.setOutputDescrip(currentImportToken);
				} else if ("sequence".equals(currentFieldToken)) {
					/* TODO */
				} else if ("oldid".equals(currentFieldToken)) {
					/* TODO */
				} else if ("monthly overhead".equals(currentFieldToken)) {
					copierDefinition.setMonthlyBurdenRate(Utilities
							.tokenToDouble(currentImportToken));
				} else if ("monthly labor".equals(currentFieldToken)) {
					copierDefinition.setMonthlyLabor(Utilities
							.tokenToDouble(currentImportToken));
				} else if ("monthly click cost".equals(currentFieldToken)) {
					copierDefinition.setClickCost(Utilities
							.tokenToDouble(currentImportToken));
				} else if ("production location ID".equals(currentFieldToken)) {
					/* TODO */
				} else if ("production location".equals(currentFieldToken)) {
					copierDefinition.setProductionLocation(currentImportToken);
				} else if ("cost center ID".equals(currentFieldToken)) {
					/* TODO */
				} else if ("cost center".equals(currentFieldToken)) {
					if (currentImportToken.equals("") == false) {
						CostCenter costCenter = dataService
								.getByCostCenterName(currentImportToken);
						if (costCenter == null) {
							costCenter = new CostCenter();
							costCenter.setName(currentImportToken);
							costCenter = (CostCenter)dataService.addUpdate(costCenter);
						}
						copierDefinition.setCostCenter(currentImportToken);
					}
						
				} else if ("machine name ID".equals(currentFieldToken)) {
					/* TODO */
				} else if ("machine name".equals(currentFieldToken)) {
					copierDefinition.setMachineName(currentImportToken);
				} else if ("setup time".equals(currentFieldToken)) {
					/* TODO */
				} else if ("labor rate".equals(currentFieldToken)) {
					copierDefinition.setHourCostRate(Utilities
							.tokenToDouble(currentImportToken));
				} else if ("minimum".equals(currentFieldToken)) {
					/* TODO */
				} else if ("sheet area type[1]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == true)
						copierDefinition.setSquareAreaType("AreaRunSize");
					else if (currentImportToken.equals("64") == true)
						copierDefinition.setSquareAreaType("AreaFinishSize");
				} else if ("sheet area type[2]".equals(currentFieldToken)){
					/* TODO */
				} else if ("waste chart".equals(currentFieldToken)) {
					/* TODO */
				} else if ("max sheet X".equals(currentFieldToken)) {
					/* TODO */
				} else if ("max sheet".equals(currentFieldToken)) {
					copierDefinition.setMaxSize(currentImportToken);
				} else if ("max sheet Y".equals(currentFieldToken)) {
					/* TODO */
				} else if ("min sheet X".equals(currentFieldToken)) {
					/* TODO */
				} else if ("min sheet".equals(currentFieldToken)) {
					copierDefinition.setMinSize(currentImportToken);
				} else if ("min sheet Y".equals(currentFieldToken)) {
					/* TODO */
				} else if ("max roll width".equals(currentFieldToken)) {
					/* TODO */
				} else if ("min roll width".equals(currentFieldToken)) {
					/* TODO */
				} else if ("extra float[1]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("extra float[2]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("extra float[3]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("extra float[4]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("extra[1]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("extra[2]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("extra[3]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("default BW".equals(currentFieldToken)) {
					if (currentImportToken.equals("1") == true) {
						defaultBW = true;
					}
				} else if ("default Color".equals(currentFieldToken)) {
					if (currentImportToken.equals("1") == true) {
						defaultColor = true;
					}
				} else if ("default LF".equals(currentFieldToken)) {
					if (currentImportToken.equals("1") == true) {
						defaultLF = true;
					}
				} else if ("capable BW".equals(currentFieldToken)) {
					copierDefinition.setBlackwhite(Utilities
							.tokenToBooleanValue(currentImportToken));
				} else if ("capable Color".equals(currentFieldToken)) {
					copierDefinition.setColor(Utilities
							.tokenToBooleanValue(currentImportToken));
				} else if ("capable LF".equals(currentFieldToken)) {
					copierDefinition.setLargeFormat(Utilities
							.tokenToBooleanValue(currentImportToken));
				} else if ("use waste".equals(currentFieldToken)) {
					/* TODO */
				} else if ("is costing definition".equals(currentFieldToken)) {
					copierDefinition.setCostingCopy(Utilities
							.tokenToBooleanValue(currentImportToken));
				} else if ("digital integration".equals(currentFieldToken)) {
					copierDefinition.setIntegratedDevice(Utilities
							.tokenToBooleanValue(currentImportToken));
				} else if ("interpolate".equals(currentFieldToken)) {
					copierDefinition.setInterpolateMatrix(Utilities
							.tokenToBooleanValue(currentImportToken));
				}
			}
			matrix.addElements(matrixElement);
		}
		matrix = (Matrix)dataService.addUpdate(matrix);
//		copierDefinition.setCopierMatrix(matrix);
		double machineCostPerCopy = copierService.calculateMachineCostPerCopy(copierDefinition);
		copierDefinition.setMachineCostPerCopy(machineCostPerCopy);
		copierDefinition = (CopierDefinition)dataService.addUpdate(copierDefinition);
		copierDefinition.setId(copierDefinition.getId());
		if (defaultBW == true) {
			PreferencesDefaultPresses defaultCopier = (PreferencesDefaultPresses)dataService.getSingle("PreferencesDefaultPresses");
			if (defaultCopier == null) {
				defaultCopier = new PreferencesDefaultPresses();
			}
			defaultCopier.setDefaultBWCopier(copierDefinition);
			dataService.addUpdate(defaultCopier);
		}
		if (defaultColor == true) {
			PreferencesDefaultPresses defaultCopier = (PreferencesDefaultPresses)dataService.getSingle("PreferencesDefaultPresses");
			if (defaultCopier == null) {
				defaultCopier = new PreferencesDefaultPresses();
			}
			defaultCopier.setDefaultColorCopier(copierDefinition);
			dataService.addUpdate(defaultCopier);
		}
		if (defaultLF == true) {
			PreferencesDefaultPresses defaultCopier = (PreferencesDefaultPresses)dataService.getSingle("PreferencesDefaultPresses");
			if (defaultCopier == null) {
				defaultCopier = new PreferencesDefaultPresses();
			}
			defaultCopier.setDefaultLargeFormat(copierDefinition);
			dataService.addUpdate(defaultCopier);
		}
		if (copierDefinition.getCopierId() != null
				&& copierDefinition.getCopierId().length() > 0) {
			PreferencesSequenceValues sequenceValues = dataService.getSequenceValues();
			sequenceValues.setCopierDefinition(Long.parseLong(copierDefinition.getCopierId()));
			dataService.addUpdate(sequenceValues);
		}
		log.info("Leaving CopierDefinitionMapper->importTokens");
		return null;
	}
}
