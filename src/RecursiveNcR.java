import java.io.*;
import java.util.*;

/*
 *find nCr recursively
 nCr = n-1Cr + n-1Cr-1
 */

class RecursiveNcR {
  
  
  public static int ncr(int n, int r) {
    if(n==r) return 1;
    if(r==1) return n;
    return ncr(n-1, r) + ncr(n-1, r-1);
  }
  
  
  public static void main(String[] args) {
    Boolean flag = Boolean.TRUE;
    int[][] inputs = new int[][]{{10,3},{4,2},{3,2}};
    int[] output={120,6,3};
    int i=0;
    
    for(int[] each: inputs) {
      flag = flag && output[i++] == ncr(each[0], each[1]);
    }

    System.out.println();
    System.out.println((flag)? "SUCCESS":"MODIFY");
    
  }
}