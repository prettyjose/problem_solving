package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BSTUtil {

    static boolean preToPostOrder(List<Integer> preOrderArray, LinkedList<Integer> postOrderArray) {

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
    static Integer separateLeftAndRightSubTrees(List<Integer> preOrderArray,
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

    /*public static LinkedList<Integer> preToPostOrder(List<Integer> preOrderArray, LinkedList<Integer> postOrderArray) {
//        List<Integer> inOrderArray = new ArrayList<Integer>(preOrderArray);
//        inOrderArray.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        });

        if(preOrderArray.size() == 1){
            postOrderArray.add(0, preOrderArray.get(0));
        } else if(preOrderArray.size() > 1){

            List<Integer> leftSubArray = new ArrayList<>();
            List<Integer> rightSubArray = new ArrayList<>();

            final Integer subTreeRoot = separateLeftAndRightSubTrees(preOrderArray, leftSubArray, rightSubArray);

            if(subTreeRoot == null){ //Invalid preorder case
                return null;
            }
            postOrderArray.add(0, subTreeRoot);

            preToPostOrder(rightSubArray, postOrderArray);
            preToPostOrder(leftSubArray, postOrderArray);
        }
        return postOrderArray;
    }

    public static Integer separateLeftAndRightSubTrees(List<Integer> preOrderArray,
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
    }*/
}
