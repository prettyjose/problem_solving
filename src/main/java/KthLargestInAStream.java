import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class KthLargestInAStream{
    public static void main (String[] args) throws IOException {
        final InputStream expectedInputAsStream = KthLargestInAStream.class.getClassLoader()
                .getResourceAsStream("KthLargestElementInAStreamInput.txt");

        File expectedOutputFile = new File(KthLargestInAStream.class.getClassLoader()
                .getResource("KthLargestElementInAStreamExpectedOutput.txt")
                .getPath());
        BufferedReader reader = new BufferedReader(new FileReader(expectedOutputFile)); //buffering is just to improve the performance.

        Scanner sc = new Scanner(expectedInputAsStream);
        int nTestCase = sc.nextInt();
        List<List<Integer>> allResults = new ArrayList<>(nTestCase);
        boolean testResult = Boolean.TRUE;
        for( ;nTestCase>= 1; nTestCase-- ){
            int k = sc.nextInt();
            int length = sc.nextInt();
            List<Integer> eachInputArray = new ArrayList<>();
            List<Integer> eachResultArray = new ArrayList<>();
            StringBuilder kthLargestOnes = new StringBuilder();
            for(int i = 0; i< length; i++){
                eachInputArray.add(sc.nextInt());
                Collections.sort(eachInputArray);

                int currentKthLargest = (k> eachInputArray.size())? -1 : eachInputArray.get(eachInputArray.size() - k);
                kthLargestOnes.append(currentKthLargest + " ");
                eachResultArray.add(currentKthLargest);
            }
            testResult = testResult && reader.readLine().equals(kthLargestOnes.toString().trim());
            allResults.add(eachResultArray);
        }

        for(List<Integer> eachResultArray: allResults){
            for(int each: eachResultArray){
                System.out.print(each + " ");
            }
            System.out.println();
        }
        System.out.println("Test Succeeded? : " + testResult);
    }
}
