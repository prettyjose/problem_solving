package coderpad;

import java.io.*;
import java.util.*;


class MostConsecutiveCharCount {
  private static int[] getMaxConsecutiveChar(String in) {
    int[] result = new int[]{0,1};
    char current=in.charAt(0); int currentCount=1;
    for(int i=0; i<in.length()-1; i++) {
      
      if(in.charAt(i+1) == current) {
        currentCount++;
        if (i==in.length()-2 && currentCount>result[1]) {//last character case
          result[0]=i-currentCount+2;
          result[1] = currentCount;
        } 
      }
      
      if(in.charAt(i+1) != current) { 
        if(currentCount>result[1]) {
          result[0]=i-currentCount+1;
          result[1] = currentCount;
        } 
          current = in.charAt(i+1); currentCount=1;
        
      }
    }
    return result;
  }
  private static void testCalculator() {
    String in1= "aabbbccdd";    int[] out1=new int[]{2,3};
    String in2= "aabbccddbb";   int[] out2=new int[]{0,2};
    String in3= "abc";          int[] out3=new int[]{0,1};
    String in4= "abccc";        int[] out4=new int[]{2,3};
    
    // Arrays.stream(getMaxConsecutiveChar(in4)).forEach((x)->{System.out.println(x);});
    
    if( Arrays.equals(getMaxConsecutiveChar(in1), out1) &&   
      Arrays.equals(getMaxConsecutiveChar(in2), out2) &&
      Arrays.equals(getMaxConsecutiveChar(in3), out3) &&
      Arrays.equals(getMaxConsecutiveChar(in4), out4) )
      System.out.println("SUCCESS!!");
    else
      System.out.println("MODIFICATION IS REQUIRED!!");
  }
  public static void main(String[] args) {
    testCalculator();
  }
}
