package coderpad;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named coderpad.print_from_three_threads.coderpad.Solution.
 *
 * If you need more classes, simply define them inline.
 * 
 * Given Input String, print the frequency of each character in following format:
 * Input : SSSSSTTPPQ  Output: S5T2P2Q1
 * 
 */

class SSSSSTTPPQ_to_S5T2P2Q1_Formatting {
  public static void main(String[] args) {
     if(doTestpass())
        System.out.println("All test cases passed");
      else
        System.out.println("Test Failed");
  }
  
  public static boolean doTestpass()
    {
      boolean flag=true;
      Map<String, String> testcase=new HashMap<>();
      testcase.put("SSSSSTTPPQ","S5T2P2Q1");
      testcase.put("aaabbbnnn","a3b3n3");
      testcase.put("a","a1");
      testcase.put("aaabbbnnnaaa","a3b3n3a3");
      testcase.put("","");
      
      Set<String> key=testcase.keySet();
      for(String s : key){
         
         flag=flag && (findFrequency(s).equals(testcase.get(s)));
       }
      
      return flag;
    }
  /*
   * Returns the frequency of each character in the format : frequency followed by
   * character. example for input aaabbbnnn will return a3b3n3
   */
  public static String findFrequency(String x){
    
    if(x.isEmpty()) return "";
    StringBuilder result = new StringBuilder();
    int i=0;
    char curntChar = x.charAt(i); int curntCount=1;
    for(i=1;i<x.length();i++) {
      if(x.charAt(i) == curntChar)
        curntCount++;
      else {
        result.append(curntChar).append(curntCount);
        curntChar = x.charAt(i);
        curntCount=1;
      }
    }
    result.append(curntChar).append(curntCount);
    return result.toString();
  }
}
