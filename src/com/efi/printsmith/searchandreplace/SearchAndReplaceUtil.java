package com.efi.printsmith.searchandreplace;

/**
 * Title:        SearchAndReplaceUtil
 * Description:  ???
 * Copyright:    Copyright (c) 2000-2001
 * Company:      printCafe, Inc.
 * @author
 * @version 1.0
 */

import gnu.regexp.RE;
import gnu.regexp.REException;
import gnu.regexp.REMatchEnumeration;

import java.util.Vector;

public class SearchAndReplaceUtil{

  static protected String escape(String in)
  {
    if (in == null)
      return null;

    int strLength = in.length();
    StringBuffer buf = new StringBuffer(strLength * 2);
    for (int i = 0; i < strLength; i++) {
      buf.append("\\");
      buf.append(in.charAt(i));
    }

    return buf.toString();
  }

  static public String variableExpansion(String in, VariableMapper mapper)
      throws REException
  {
    VariableExpansion expander = new VariableExpansion();
    return expander.expandVariables(in,mapper);
  }

  static public String searchAndReplace(String in, String search, String replace)
      throws REException
  {
    if ((search == null) || (search.length() == 0))
      return in;

    StringBuffer out = new StringBuffer(in.length());

    RE re = new RE(escape(search));
    REMatchEnumeration matches = re.getMatchEnumeration(in);
    while ((matches != null) && (matches.hasMoreMatches(out))) {
      matches.nextMatch();
      out.append(replace);
    }

    return out.toString();
  }

  public static String createMessage(Vector args, String message){
    if(args!=null && args.size()>0){
      for(int i=0;i<args.size();i++){
        String msgStart = "";
        String msgEnd = "";
        String keyString = "%"+(i+1)+"%";
        int flag = message.indexOf(keyString);
        if(flag >= 0){
          msgStart = message.substring(0,flag);
          msgEnd = message.substring(flag+keyString.length(),message.length());
          message = msgStart+args.get(i)+msgEnd;
        }
      }
    }
    return message;
  }
}

//end class