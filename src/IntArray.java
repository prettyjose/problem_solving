import java.util.Random;

public class IntArray {

    int[] arr;
    public IntArray(int n) {
        arr= new int[n];
        Random random = new Random();
        for(int i=0;i<n;i++) {
            arr[i] = random.nextInt(2);
        }
    }
    public IntArray(int[] arr){
        this.arr = arr;
    }
    public void print(){
        for(int each: arr){
            System.out.print(" " + each);
        }
        System.out.println();
    }
    public void sort(){
        for(int i=0, j=arr.length-1; i<j; i++, j--){
            while(i<j && arr[i] == 0) i++;
            while(i<j && arr[j] == 1) j--;
            if(i>=j) break;
            //swap
            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];
        }
    }
    public void printStartPositionOf1InAscSortedArray(){
        System.out.println("\nStart Position Of 1 In Asc Sorted Array :: " + (arr.length - getCountOfX(1, 0, arr.length-1)));
    }

    public void printCountOf1(){
        System.out.println("\nCount of 1 :: " + getCountOfX(1, 0, arr.length-1));
    }

    private int getCountOfX(int x, int start, int end) {
        /*if(end == start + 1){
            if(arr[start] == x && arr[end] == x)
                return 2;
            else if(arr[start] == x || arr[end] == x)
                return 1;
            else
                return 0;
        }else */if(start == end){
            if(arr[start] == x)
                return 1;
            else
                return 0;
        }
        int mid = (start + end)/2;
        return getCountOfX(x, start, mid) + getCountOfX(x, mid+1, end);
    }

    public static void main(String[] args) {

//        int[] arr= new int[]{0,1,0,1,1,0,0,1,0,1};
//        IntArray zeroesAndOnes = new IntArray(arr);

        IntArray zeroesAndOnes = new IntArray(11);

        zeroesAndOnes.print();
        zeroesAndOnes.sort();
        System.out.println();
        zeroesAndOnes.print();

        zeroesAndOnes.printCountOf1();
        zeroesAndOnes.printStartPositionOf1InAscSortedArray();
    }
}

