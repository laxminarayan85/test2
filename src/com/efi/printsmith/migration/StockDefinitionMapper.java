package com.efi.printsmith.migration;

import java.util.ArrayList;

import com.efi.printsmith.data.Account;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.StockDefinition;

public class StockDefinitionMapper extends ImportMapper {
	public ModelBase importTokens(ArrayList<String> fieldTokens, ArrayList<String> importTokens) throws Exception {
		StockDefinition stockDefinition = new StockDefinition();
		
		for (int i=0; i < fieldTokens.size(); i++) {
			String currentImportToken = importTokens.get(i);
			
			if ("recno".equals(currentImportToken)) {
				/* TODO */
			} else if ("group".equals(currentImportToken)) {
				/* TODO */
			}  else if ("class".equals(currentImportToken)) {
				/* TODO */
			}  else if ("name".equals(currentImportToken)) {
				/* TODO */
			}  else if ("color".equals(currentImportToken)) {
				/* TODO */
			}  else if ("vendor".equals(currentImportToken)) {
				/* TODO */
			}  else if ("sets".equals(currentImportToken)) {
				/* TODO */
			}  else if ("id".equals(currentImportToken)) {
				/* TODO */
			}  else if ("unit".equals(currentImportToken)) {
				/* TODO */
			}  else if ("parent size".equals(currentImportToken)) {
				/* TODO */
			}  else if ("run size".equals(currentImportToken)) {
				/* TODO */
			}  else if ("vendor stock no".equals(currentImportToken)) {
				/* TODO */
			}  else if ("parentx".equals(currentImportToken)) {
				/* TODO */
			}  else if ("parenty".equals(currentImportToken)) {
				/* TODO */
			}  else if ("runx".equals(currentImportToken)) {
				/* TODO */
			}  else if ("runy".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s1cost".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s1addm".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s1markup".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s1limit".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s2cost".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s2addm".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s2markup".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s2limit".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s3cost".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s3addm".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s3markup".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s3limit".equals(currentImportToken)) {
				/* TODO */
			}  else if ("blank units[1]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("blank units[2]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("blank units[3]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("blank cost[1]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("blank cost[2]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("blank cost[3]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("schedule".equals(currentImportToken)) {
				/* TODO */
			}  else if ("press id".equals(currentImportToken)) {
				/* TODO */
			}  else if ("copyID".equals(currentImportToken)) {
				/* TODO */
			}  else if ("copyID2".equals(currentImportToken)) {
				/* TODO */
			}  else if ("copier[1]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("copier[2]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("press name".equals(currentImportToken)) {
				/* TODO */
			}  else if ("cut rate".equals(currentImportToken)) {
				/* TODO */
			}  else if ("minimum cut".equals(currentImportToken)) {
				/* TODO */
			}  else if ("charges[1]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("charges[2]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("charges[3]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("charges[4]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("charges[5]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("charges[6]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("charges[7]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("charges[8]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("charges[9]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("charges[10]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("omarkup".equals(currentImportToken)) {
				/* TODO */
			}  else if ("oCopy2".equals(currentImportToken)) {
				/* TODO */
			}  else if ("oCopy1".equals(currentImportToken)) {
				/* TODO */
			}  else if ("autoCalc".equals(currentImportToken)) {
				/* TODO */
			}  else if ("special".equals(currentImportToken)) {
				/* TODO */
			}  else if ("min level".equals(currentImportToken)) {
				/* TODO */
			}  else if ("min order".equals(currentImportToken)) {
				/* TODO */
			}  else if ("weight".equals(currentImportToken)) {
				/* TODO */
			}  else if ("price expires".equals(currentImportToken)) {
				/* TODO */
			}  else if ("rstatus".equals(currentImportToken)) {
				/* TODO */
			}  else if ("rtype".equals(currentImportToken)) {
				/* TODO */
			}  else if ("not used byte".equals(currentImportToken)) {
				/* TODO */
			}  else if ("vendor id".equals(currentImportToken)) {
				/* TODO */
			}  else if ("group name".equals(currentImportToken)) {
				/* TODO */
			}  else if ("coat".equals(currentImportToken)) {
				/* TODO */
			}  else if ("type".equals(currentImportToken)) {
				/* TODO */
			}  else if ("generic color id".equals(currentImportToken)) {
				/* TODO */
			}  else if ("generic color name".equals(currentImportToken)) {
				/* TODO */
			}  else if ("generic finish id".equals(currentImportToken)) {
				/* TODO */
			}  else if ("generic finish name".equals(currentImportToken)) {
				/* TODO */
			}  else if ("grade id".equals(currentImportToken)) {
				/* TODO */
			}  else if ("grade name".equals(currentImportToken)) {
				/* TODO */
			}  else if ("mill".equals(currentImportToken)) {
				/* TODO */
			}  else if ("mWeight".equals(currentImportToken)) {
				/* TODO */
			}  else if ("caliper".equals(currentImportToken)) {
				/* TODO */
			}  else if ("lot count".equals(currentImportToken)) {
				/* TODO */
			}  else if ("carton count".equals(currentImportToken)) {
				/* TODO */
			}  else if ("carton weight".equals(currentImportToken)) {
				/* TODO */
			}  else if ("sheets per skid".equals(currentImportToken)) {
				/* TODO */
			}  else if ("weight per skid".equals(currentImportToken)) {
				/* TODO */
			}  else if ("basic size x".equals(currentImportToken)) {
				/* TODO */
			}  else if ("basic size".equals(currentImportToken)) {
				/* TODO */
			}  else if ("basic size y".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s1cwt".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s2cwt".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s3cwt".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s4cost".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s4cwt".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s4addm".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s4markup".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s4limit".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s5cost".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s5cwt".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s5addm".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s5markup".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s5limit".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s6cost".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s6cwt".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s6addm".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s6markup".equals(currentImportToken)) {
				/* TODO */
			}  else if ("s6limit".equals(currentImportToken)) {
				/* TODO */
			}  else if ("blank units[4]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("blank units[5]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("blank units[6]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("blank cost[4]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("blank cost[5]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("blank cost[6]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("copyID3".equals(currentImportToken)) {
				/* TODO */
			}  else if ("copier[3]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("price changed date".equals(currentImportToken)) {
				/* TODO */
			}  else if ("last modification date".equals(currentImportToken)) {
				/* TODO */
			}  else if ("comment".equals(currentImportToken)) {
				/* TODO */
			}  else if ("measure".equals(currentImportToken)) {
				/* TODO */
			}  else if ("thickness type".equals(currentImportToken)) {
				/* TODO */
			}  else if ("markup flags".equals(currentImportToken)) {
				/* TODO */
			}  else if ("pcw recycle percent".equals(currentImportToken)) {
				/* TODO */
			}  else if ("forest managment ID".equals(currentImportToken)) {
				/* TODO */
			}  else if ("coc expand 1".equals(currentImportToken)) {
				/* TODO */
			}  else if ("coc expand 2".equals(currentImportToken)) {
				/* TODO */
			}  else if ("fsc certified".equals(currentImportToken)) {
				/* TODO */
			}  else if ("sfi certified".equals(currentImportToken)) {
				/* TODO */
			}  else if ("green seal certified".equals(currentImportToken)) {
				/* TODO */
			}  else if ("coc expand 4".equals(currentImportToken)) {
				/* TODO */
			}  else if ("coc expand 5".equals(currentImportToken)) {
				/* TODO */
			}  else if ("coc expand 6".equals(currentImportToken)) {
				/* TODO */
			}  else if ("coc expand 7".equals(currentImportToken)) {
				/* TODO */
			}  else if ("coc expand 8".equals(currentImportToken)) {
				/* TODO */
			}  else if ("coc expand 9".equals(currentImportToken)) {
				/* TODO */
			}  else if ("priced in sets".equals(currentImportToken)) {
				/* TODO */
			}  else if ("short grain".equals(currentImportToken)) {
				/* TODO */
			}  else if ("no broken carton".equals(currentImportToken)) {
				/* TODO */
			}  else if ("envelope".equals(currentImportToken)) {
				/* TODO */
			}  else if ("imported".equals(currentImportToken)) {
				/* TODO */
			}  else if ("is inventory shell".equals(currentImportToken)) {
				/* TODO */
			}  else if ("allow negative inventory".equals(currentImportToken)) {
				/* TODO */
			}  else if ("isMetric".equals(currentImportToken)) {
				/* TODO */
			}  else if ("roll stock".equals(currentImportToken)) {
				/* TODO */
			}  else if ("inventory change log[1]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("inventory change log[2]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("inventory change log[3]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("inventory change log[4]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("inventory change log[5]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("inventory change log[6]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("inventory change log[7]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("inventory change log[8]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("inventory change log[9]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("inventory change log[10]".equals(currentImportToken)) {
				/* TODO */
			}  else if ("inventory shell acct".equals(currentImportToken)) {
				/* TODO */
			}  else if ("inventory shell acct title".equals(currentImportToken)) {
				/* TODO */
			}
		}
		return stockDefinition;
	}
}
