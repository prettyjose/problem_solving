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
            preToPostOrder(eachInputArray, eachResultArray);
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
    private static boolean preToPostOrder(List<Integer> preOrderArray, LinkedList<Integer> postOrderArray) {

        if(preOrderArray.size() == 1){
            postOrderArray.add(0, preOrderArray.get(0));
        } else if(preOrderArray.size() > 1){

            List<Integer> leftSubArray = new ArrayList<>();
            List<Integer> rightSubArray = new ArrayList<>();

            final Integer subTreeRoot = separateLeftAndRightSubTrees(preOrderArray, leftSubArray, rightSubArray);

            if(subTreeRoot == null){ //Invalid preorder case
                postOrderArray.clear(); return Boolean.FALSE;
            }
            postOrderArray.add(0, subTreeRoot);

            if( !rightSubArray.isEmpty() ) {
                Boolean isRightSubTreePreOrderValid = preToPostOrder(rightSubArray, postOrderArray);
                if( Boolean.FALSE.equals( isRightSubTreePreOrderValid ) ){
                    return Boolean.FALSE; //Invalid preorder
                }
            }
            if( !leftSubArray.isEmpty() ){
                Boolean isLeftSubTreePreOrderValid = preToPostOrder( leftSubArray, postOrderArray );
                if( Boolean.FALSE.equals( isLeftSubTreePreOrderValid ) ){
                    return Boolean.FALSE; //Invalid preorder
                }
            }
        }
        return Boolean.TRUE;
    }
    private static Integer separateLeftAndRightSubTrees(List<Integer> preOrderArray,
                                                        List<Integer> leftSubArray, List<Integer> rightSubArray) {
        final Integer root = preOrderArray.get(0);

        int currentLeftIndex = -1;
        int currentRightIndex = preOrderArray.size();

        for (int each :
                preOrderArray) {
            if (each < root) {
                currentLeftIndex = preOrderArray.indexOf(each);
                if(currentLeftIndex > currentRightIndex){ //Invalid pre order case
                    return null;
                }
                leftSubArray.add(each);

            } else if (each > root) {
                currentRightIndex = preOrderArray.indexOf(each);
                if(currentLeftIndex > currentRightIndex){ //Invalid pre order case
                    return null;
                }
                rightSubArray.add(each);
            }
        }
        return root;
    }
}