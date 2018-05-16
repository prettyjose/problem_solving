package coderpad;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class FindRotatedArrayPivot {
  private static int getPivot(int[] array, int low, int high){
    int mid= (low+high)/2;
    //if(high<low) return -1;
    //if(low==high) return low;
    if(array[mid-1]>array[mid]) return mid;
    if(array[mid]>array[mid+1]) return mid+1;
    if(low+1==high) return -1;
    if (array[low]>=array[mid]) return getPivot(array, low, mid);
    return getPivot(array, mid, high);

  }
  
  private static int getSecondSmallestElement(int[] array) {
    int pivot = getPivot(array, 0, array.length-1);
    if(pivot == -1) pivot =0;
    // System.out.println(pivot);
    return array[(pivot+1)%array.length];
  }
  
  private static void testCode() {
    int[] arr1 = new int[]{1,2,3,4,5}; 
    int[] arr2 = new int[]{3,4,5,1,2}; 
    int[] arr3 = new int[]{2,3,4,5,6,1}; 
    int out=2;
    
    if( getSecondSmallestElement(arr1) == out &&
        getSecondSmallestElement(arr2) == out &&
        getSecondSmallestElement(arr3) == out )
      System.out.println("SUCCESS!!");
    else
      System.out.println("MODIFICATION IS REQUIRED!!");
  }
                 
  public static void main(String[] args) {
    testCode();
  }
}
