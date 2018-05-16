package coderpad;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 * 
 * Find number whether given no. is power of 10 or not. 
 * Example :- 100(10^2), 1000 (10^3), 0.1 (10^-1), 0.01(10^-2)
 */

class IsPowerOf10 {
  public static void main(String[] args) {
     if(doTestpass())
        System.out.println("All test cases passed");
      else
        System.out.println("Test Failed");
  }
  
  public static boolean doTestpass()
    {
      boolean flag=true;
      int[] powerOfTen=new int[]{1,10,100, 1000};
      int[] NotPowerOfTen=new int[]{111,101,10010, 2000000000, -1};
    
      for(int i:powerOfTen){
        flag=flag && isPowerOf10(i);
      }
    
     for(int i:NotPowerOfTen){
        flag=flag && !isPowerOf10(i);
      }                         
      
      return flag;
    }
  /*
   * Returns true if x is power-of-10 else returns false
   */
  public static boolean isPowerOf10(int x){
    if(x<=0) //invalid cases
      return Boolean.FALSE;
    if(x==1) //terminating case
      return Boolean.TRUE;
    if(x%10 == 0)
      return isPowerOf10(x/10);
    return Boolean.FALSE;
  }
      
}
