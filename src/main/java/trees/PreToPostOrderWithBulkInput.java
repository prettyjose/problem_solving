package trees;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class PreToPostOrderWithBulkInput {
    private static final File PreOrderBulkInputFile;

    static {
        PreOrderBulkInputFile = new File(PreToPostOrderWithBulkInput.class
                .getClassLoader()
                .getResource("PreOrderBulkInput.txt")
                .getPath());
    }

    public static void main (String[] args) {

        Scanner sc= null;
        try {
            sc = new Scanner(PreOrderBulkInputFile);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found or loaded"); e.printStackTrace();
        }
        int nTestCase = sc.nextInt();
        List<LinkedList<Integer>> result = new ArrayList<>(nTestCase);
        for(; nTestCase>= 1; nTestCase--){
            int length = sc.nextInt();
            List<Integer> eachInputArray = new ArrayList<>();
            LinkedList<Integer> eachResultArray = new LinkedList<>();
            for(int i = 0; i< length; i++){
                eachInputArray.add(sc.nextInt());
            }
            BSTUtil.preToPostOrder(eachInputArray, eachResultArray);
            result.add(eachResultArray);
        }
        for(List<Integer> eachResultArray: result){
            if(eachResultArray.isEmpty()){
                System.out.println("Given Preorder does not belong to a BST.");
                continue;
            }
            for(int each: eachResultArray){
                System.out.print(each + " ");
            }
            System.out.println();
        }
    }
}