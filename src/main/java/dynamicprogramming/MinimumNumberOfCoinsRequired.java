package dynamicprogramming;

import java.util.*;

public class MinimumNumberOfCoinsRequired {
    private static int nMin;

    public static void main(String[] args) {

        int n=0;
        //if change array is unsorted, you sort it first and apply the same logic.
//        int r=22; int[] change=new int[]{15,14,13,12,11,10,5,2,1}; int smallest=1; int expected = 2;
//        int r=63; int[] change=new int[]{25,10,5,1};int smallest=1; int expected = 6;
//        int r=63; int[] change=new int[]{25,10,5,2,1};int smallest=1; int expected = 5;
        int r=63; int[] change=new int[]{25,21,10,5,1};int smallest=1; int expected = 3;

        nMin=r/smallest;
        List<Integer> curntCoinSet=new ArrayList<>(change.length);
        for(int each:change){
            curntCoinSet.add(each);
        }

        recurFunc(r,n,curntCoinSet );
        
        System .out.println( ((expected == nMin)? "Success" : "Failure") );
    }

    private static void recurFunc(int r, int n, List<Integer> curntCoinSet){

        if(r==0){
            if(n>0 && n<nMin){
//                System .out.println ("nMin="+n);
//                System.out.println("r="+r+"first="+((curntCoinSet.isEmpty())?"":curntCoinSet.get(0) ));
                nMin=n;
            }
            return;
        }
        if(curntCoinSet.isEmpty()){
            return;
        }

        int change = curntCoinSet.remove(0);
        List<Integer> nextBatchOfCoinSet = new ArrayList<>(curntCoinSet);

//        System.out.println("enter");
//        System .out.println ("n="+n+"r="+r+"first="+change);
        recurFunc(r,n,nextBatchOfCoinSet );
//        System.out.println("came back");

        int factor=r/change;
        n += factor;
        r = r%change;
        if(n >= nMin) return;

//            System.out.println("enter");
//            System .out.println ("n="+n+"r="+r+"first="+change);
        recurFunc( r,n,curntCoinSet );
//            System.out.println("came back");




    }


}
