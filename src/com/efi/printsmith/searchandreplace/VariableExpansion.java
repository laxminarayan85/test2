package com.efi.printsmith.searchandreplace;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

import gnu.regexp.RE;
import gnu.regexp.REException;
import gnu.regexp.REMatch;
import gnu.regexp.REMatchEnumeration;

import java.util.Hashtable;

public class VariableExpansion {

  protected String startToken = "${";
  protected String endToken = "}";

  static protected Hashtable _variables = new Hashtable();

  public VariableExpansion() {}

  public VariableExpansion(String startToken, String endToken)
  {
    this.startToken = startToken;
    this.endToken = endToken;
  }

  protected void expandVariables(StringBuffer out, String in, String pattern, VariableMapper mapper)
      throws REException
  {
    RE re = new RE(pattern.toString());
    REMatchEnumeration matches = re.getMatchEnumeration(in);
    while ((matches != null) && (matches.hasMoreMatches(out))) {
      REMatch match = matches.nextMatch();

      String variable = match.toString(1);
      String value = null;
      if (variable != null)
        value = mapper.getVariableValue(variable);
      if (value == null)
        out.append(match.toString());
      else {
        expandVariables(out,value,pattern,mapper);
      }
    }
  }

  public String expandVariables(String in, VariableMapper mapper)
      throws REException
  {
    if (in == null)
      return null;

    StringBuffer buffer = new StringBuffer(in.length());

    String escapedStart = SearchAndReplaceUtil.escape(startToken);
    String escapedEnd = SearchAndReplaceUtil.escape(endToken);

    StringBuffer pattern = new StringBuffer();
    pattern.append(escapedStart);
    pattern.append("([\\._a-zA-Z0-9]*)");
    pattern.append(escapedEnd);

    expandVariables(buffer,in,pattern.toString(),mapper);

    return buffer.toString();
  }


}