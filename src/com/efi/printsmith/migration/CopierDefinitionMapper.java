package com.efi.printsmith.migration;

import java.util.ArrayList;

import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.ModelBase;

public class CopierDefinitionMapper extends ImportMapper {
	public ModelBase importTokens(ArrayList<String> fieldTokens, ArrayList<String> importTokens) throws Exception {
		CopierDefinition copierDefinition = new CopierDefinition();
		
		for (int i=0; i < fieldTokens.size(); i++) {
			String currentImportToken = importTokens.get(i);
			
			if ("recno".equals(currentImportToken)) {
				copierDefinition.setPrevId(currentImportToken);
			} else if ("name".equals(currentImportToken)) {
				/* TODO */
			} else if ("machine ID".equals(currentImportToken)) {
				copierDefinition.setOemDeviceID(currentImportToken);
			} else if ("days per year".equals(currentImportToken)) {
				copierDefinition.setDaysOpen(Utilities.tokenToInt(currentImportToken));
			} else if ("hours per day".equals(currentImportToken)) {
				copierDefinition.setHoursOpen(Utilities.tokenToInt(currentImportToken));
			} else if ("speed".equals(currentImportToken)) {
				copierDefinition.setCopyMinutes(Utilities.tokenToInt(currentImportToken));
			} else if ("efficiency".equals(currentImportToken)) {
				/* TODO */
			} else if ("maintenance".equals(currentImportToken)) {
				copierDefinition.setMonthlyMaintenance(Utilities.tokenToInt(currentImportToken));
			} else if ("payment".equals(currentImportToken)) {
				copierDefinition.setMonthlyPayment(Utilities.tokenToDouble(currentImportToken));
			} else if ("machine".equals(currentImportToken)) {
				/* TODO */
			} else if ("labor".equals(currentImportToken)) {
				copierDefinition.setLaborCopy(Utilities.tokenToDouble(currentImportToken));
			} else if ("toner".equals(currentImportToken)) {
				copierDefinition.setTonerCopy(Utilities.tokenToInt(currentImportToken));
			} else if ("developer".equals(currentImportToken)) {
				copierDefinition.setDeveloperCopy(Utilities.tokenToInt(currentImportToken));
			} else if ("copy range[1]".equals(currentImportToken)) {
				/* TODO */
			} else if ("copy range[2]".equals(currentImportToken)) {
				/* TODO */
			} else if ("copy range[3]".equals(currentImportToken)) {
				/* TODO */
			} else if ("copy range[4]".equals(currentImportToken)) {
				/* TODO */
			} else if ("copy range[5]".equals(currentImportToken)) {
				/* TODO */
			} else if ("copy range[6]".equals(currentImportToken)) {
				/* TODO */
			} else if ("copy range[7]".equals(currentImportToken)) {
				/* TODO */
			} else if ("copy range[8]".equals(currentImportToken)) {
				/* TODO */
			} else if ("copy range[9]".equals(currentImportToken)) {
				/* TODO */
			} else if ("copy range[10]".equals(currentImportToken)) {
				/* TODO */
			} else if ("copy range[11]".equals(currentImportToken)) {
				/* TODO */
			} else if ("copy range[12]".equals(currentImportToken)) {
				/* TODO */
			} else if ("stockfactor[1]".equals(currentImportToken)) {
				/* TODO */
			} else if ("stockfactor[2]".equals(currentImportToken)) {
				/* TODO */
			} else if ("stockfactor[3]".equals(currentImportToken)) {
				/* TODO */
			} else if ("stockfactor[4]".equals(currentImportToken)) {
				/* TODO */
			} else if ("stockfactor[5]".equals(currentImportToken)) {
				/* TODO */
			} else if ("stockfactor[6]".equals(currentImportToken)) {
				/* TODO */
			} else if ("id".equals(currentImportToken)) {
				copierDefinition.setCopierId(currentImportToken);
			} else if ("markup".equals(currentImportToken)) {
				copierDefinition.setCopyMarkup(Utilities.tokenToInt(currentImportToken));
			} else if ("charges[1]".equals(currentImportToken)) {
				/* TODO */
			} else if ("charges[2]".equals(currentImportToken)) {
				/* TODO */
			} else if ("charges[3]".equals(currentImportToken)) {
				/* TODO */
			} else if ("charges[4]".equals(currentImportToken)) {
				/* TODO */
			} else if ("charges[5]".equals(currentImportToken)) {
				/* TODO */
			} else if ("charges[6]".equals(currentImportToken)) {
				/* TODO */
			} else if ("charges[7]".equals(currentImportToken)) {
				/* TODO */
			} else if ("charges[8]".equals(currentImportToken)) {
				/* TODO */
			} else if ("charges[9]".equals(currentImportToken)) {
				/* TODO */
			} else if ("charges[10]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart qty[1]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart qty[2]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart qty[3]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart qty[4]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart qty[5]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart qty[6]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart qty[7]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart qty[8]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart qty[9]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart qty[10]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart qty[11]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart qty[12]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart qty[13]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart qty[14]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart qty[15]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart original[1]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart original[2]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart original[3]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart original[4]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart original[5]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart original[6]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart original[7]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart original[8]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart original[9]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart original[10]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[1]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[2]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[3]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[4]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[5]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[6]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[7]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[8]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[9]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[10]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[11]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[12]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[13]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[14]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[15]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[16]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[17]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[18]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[19]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[20]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[21]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[22]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[23]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[24]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[25]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[26]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[27]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[28]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[29]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[30]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[31]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[32]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[33]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[34]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[35]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[36]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[37]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[38]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[39]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[40]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[41]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[42]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[43]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[44]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[45]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[46]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[47]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[48]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[49]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[50]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[51]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[52]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[53]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[54]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[55]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[56]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[57]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[58]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[59]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[60]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[61]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[62]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[63]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[64]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[65]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[66]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[67]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[68]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[69]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[70]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[71]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[72]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[73]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[74]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[75]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[76]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[77]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[78]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[79]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[80]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[81]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[82]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[83]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[84]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[85]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[86]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[87]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[88]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[89]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[90]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[91]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[92]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[93]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[94]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[95]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[96]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[97]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[98]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[99]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[100]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[101]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[102]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[103]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[104]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[105]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[106]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[107]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[108]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[109]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[110]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[111]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[112]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[113]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[114]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[115]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[116]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[117]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[118]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[119]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[120]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[121]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[122]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[123]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[124]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[125]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[126]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[127]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[128]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[129]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[130]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[131]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[132]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[133]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[134]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[135]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[136]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[137]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[138]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[139]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[140]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[141]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[142]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[143]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[144]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[145]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[146]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[147]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[148]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[149]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor[150]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[1]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[2]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[3]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[4]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[5]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[6]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[7]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[8]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[9]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[10]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[11]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[12]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[13]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[14]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[15]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[16]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[17]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[18]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[19]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[20]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[21]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[22]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[23]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[24]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[25]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[26]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[27]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[28]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[29]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[30]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[31]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[32]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[33]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[34]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[35]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[36]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[37]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[38]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[39]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[40]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[41]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[42]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[43]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[44]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[45]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[46]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[47]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[48]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[49]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[50]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[51]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[52]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[53]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[54]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[55]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[56]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[57]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[58]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[59]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[60]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[61]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[62]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[63]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[64]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[65]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[66]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[67]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[68]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[69]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[70]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[71]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[72]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[73]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[74]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[75]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[76]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[77]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[78]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[79]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[80]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[81]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[82]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[83]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[84]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[85]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[86]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[87]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[88]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[89]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[90]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[91]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[92]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[93]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[94]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[95]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[96]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[97]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[98]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[99]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[100]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[101]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[102]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[103]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[104]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[105]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[106]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[107]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[108]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[109]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[110]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[111]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[112]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[113]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[114]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[115]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[116]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[117]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[118]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[119]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[120]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[121]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[122]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[123]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[124]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[125]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[126]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[127]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[128]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[129]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[130]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[131]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[132]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[133]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[134]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[135]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[136]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[137]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[138]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[139]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[140]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[141]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[142]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[143]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[144]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[145]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[146]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[147]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[148]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[149]".equals(currentImportToken)) {
				/* TODO */
			} else if ("chart factor2[150]".equals(currentImportToken)) {
				/* TODO */
			} else if ("method".equals(currentImportToken)) {
				/* TODO */
			} else if ("schedule type".equals(currentImportToken)) {
				/* TODO */
			} else if ("stock price".equals(currentImportToken)) {
				/* TODO */
			} else if ("second side".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales cat name".equals(currentImportToken)) {
				/* TODO */
			} else if ("flat rate".equals(currentImportToken)) {
				/* TODO */
			} else if ("flat markup".equals(currentImportToken)) {
				/* TODO */
			} else if ("base rate".equals(currentImportToken)) {
				/* TODO */
			} else if ("base markup".equals(currentImportToken)) {
				/* TODO */
			} else if ("stock markup".equals(currentImportToken)) {
				/* TODO */
			} else if ("copy markup".equals(currentImportToken)) {
				copierDefinition.setCopyMarkup(Utilities.tokenToInt(currentImportToken));
			} else if ("back factor".equals(currentImportToken)) {
				/* TODO */
			} else if ("use factors".equals(currentImportToken)) {
				/* TODO */
			} else if ("only copies".equals(currentImportToken)) {
				/* TODO */
			} else if ("ignore side 2".equals(currentImportToken)) {
				/* TODO */
			} else if ("total all copies".equals(currentImportToken)) {
				/* TODO */
			} else if ("use originals".equals(currentImportToken)) {
				/* TODO */
			} else if ("o stock markup".equals(currentImportToken)) {
				/* TODO */
			} else if ("special".equals(currentImportToken)) {
				/* TODO */
			} else if ("rstatus".equals(currentImportToken)) {
				/* TODO */
			} else if ("rtype".equals(currentImportToken)) {
				/* TODO */
			} else if ("not used".equals(currentImportToken)) {
				/* TODO */
			} else if ("device ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("output desc".equals(currentImportToken)) {
				/* TODO */
			} else if ("sequence".equals(currentImportToken)) {
				/* TODO */
			} else if ("oldid".equals(currentImportToken)) {
				/* TODO */
			} else if ("monthly overhead".equals(currentImportToken)) {
				/* TODO */
			} else if ("monthly labor".equals(currentImportToken)) {
				copierDefinition.setMonthlyLabor(Utilities.tokenToDouble(currentImportToken));
			} else if ("monthly click cost".equals(currentImportToken)) {
				copierDefinition.setClickCost(Utilities.tokenToDouble(currentImportToken));
			} else if ("production location ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("production location".equals(currentImportToken)) {
				copierDefinition.setProductionLocation(currentImportToken);
			} else if ("cost center ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("cost center".equals(currentImportToken)) {
				copierDefinition.setCostCenter(currentImportToken);
			} else if ("machine name ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("machine name".equals(currentImportToken)) {
				copierDefinition.setMachineName(currentImportToken);
			} else if ("setup time".equals(currentImportToken)) {
				/* TODO */
			} else if ("labor rate".equals(currentImportToken)) {
				copierDefinition.setLaborCopy(Utilities.tokenToDouble(currentImportToken));
			} else if ("minimum".equals(currentImportToken)) {
				/* TODO */
			} else if ("sheet area type[1]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sheet area type[2]".equals(currentImportToken)) {
				/* TODO */
			} else if ("waste chart".equals(currentImportToken)) {
				/* TODO */
			} else if ("max sheet X".equals(currentImportToken)) {
				/* TODO */
			} else if ("max sheet".equals(currentImportToken)) {
				/* TODO */
			} else if ("max sheet Y".equals(currentImportToken)) {
				/* TODO */
			} else if ("min sheet X".equals(currentImportToken)) {
				/* TODO */
			} else if ("min sheet".equals(currentImportToken)) {
				/* TODO */
			} else if ("min sheet Y".equals(currentImportToken)) {
				/* TODO */
			} else if ("max roll width".equals(currentImportToken)) {
				/* TODO */
			} else if ("min roll width".equals(currentImportToken)) {
				/* TODO */
			} else if ("extra float[1]".equals(currentImportToken)) {
				/* TODO */
			} else if ("extra float[2]".equals(currentImportToken)) {
				/* TODO */
			} else if ("extra float[3]".equals(currentImportToken)) {
				/* TODO */
			} else if ("extra float[4]".equals(currentImportToken)) {
				/* TODO */
			} else if ("extra[1]".equals(currentImportToken)) {
				/* TODO */
			} else if ("extra[2]".equals(currentImportToken)) {
				/* TODO */
			} else if ("extra[3]".equals(currentImportToken)) {
				/* TODO */
			} else if ("default BW".equals(currentImportToken)) {
				/* TODO */
			} else if ("default Color".equals(currentImportToken)) {
				/* TODO */
			} else if ("default LF".equals(currentImportToken)) {
				/* TODO */
			} else if ("capable BW".equals(currentImportToken)) {
				copierDefinition.setBlackwhite(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("capable Color".equals(currentImportToken)) {
				copierDefinition.setColor(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("capable LF".equals(currentImportToken)) {
				copierDefinition.setLargeFormat(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("use waste".equals(currentImportToken)) {
				/* TODO */
			} else if ("is costing definition".equals(currentImportToken)) {
				copierDefinition.setCostingCopy(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("digital integration".equals(currentImportToken)) {
				copierDefinition.setIntegratedDevice(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("interpolate".equals(currentImportToken)) {
				/* TODO */
			}
		}
		return copierDefinition;
	}
}
