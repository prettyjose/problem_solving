package coderpad;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class FindTopIps {
  
  private static String attentionSeekers(String[] ipLogs) {
  
    String curntIp;
    Map<String, Integer> map = new HashMap<String, Integer>();
    int topCount=0;
    String attentionSeekers="";//use this instead of new String() for string pool reltd reasons.
    
    
    for(String str: ipLogs) {
      curntIp = str.split("-")[0].trim();
      int x=(map.containsKey(curntIp))? (map.get(curntIp)+1): 1;
      map.put(curntIp, x );
      if(x>topCount) {
        attentionSeekers = curntIp + " ";
      }
      else if (x==topCount)
        attentionSeekers += curntIp + " "; //StringBuilder is equally preferred. 
    }
    return attentionSeekers.trim();
  
  }
  
  public static void main(String[] args) {
    String[] ipLogs = new String[]{ "10.0.0.1 -frank [10/dec/17 10:14:27]", "10.0.0.2-frank [10/dec/17 10:14:28]","10.0.0.2-nancy [10/dec/17 10:14:28]", "10.0.0.1 -frank [10/dec/17 10:14:27]" };
    
    String[] ipLogs2 = new String[]{ "10.0.0.0 -frank [10/dec/17 10:14:27]","10.0.0.1 -frank [10/dec/17 10:14:27]", "10.0.0.2-frank [10/dec/17 10:14:28]","10.0.0.2-nancy [10/dec/17 10:14:28]", "10.0.0.1 -frank [10/dec/17 10:14:27]" };
       
    if("10.0.0.1".equals(attentionSeekers(ipLogs)) || "10.0.0.1 10.0.0.2".equals(attentionSeekers(ipLogs2)))
      System.out.println("PASS");
    else
       System.out.println("FAIL");
                         }
}
