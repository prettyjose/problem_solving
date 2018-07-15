package trees;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BalancedBST {
    private static final File inOrderBulkInputFile;

    static {
        inOrderBulkInputFile = new File(PreToPostOrderWithBulkInput.class
                .getClassLoader()
                .getResource("InOrderBulkInput.txt")
                .getPath());
    }
    public static void main (String[] args) {
        Scanner sc= null;
        try {
            sc = new Scanner(inOrderBulkInputFile);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found or loaded"); e.printStackTrace();
        }

        int nTestCase = sc.nextInt();
        List<BSTNode> result = new ArrayList<>(nTestCase);
        for(; nTestCase>= 1; nTestCase--){
            int length = sc.nextInt();
            int[] bst_Inorder_Traversal = new int[length];
            for(int i = 0; i< length; i++){
                bst_Inorder_Traversal[i] = sc.nextInt();
            }
            BSTNode root = buildBalancedTreeRecursively(bst_Inorder_Traversal,
                    0, bst_Inorder_Traversal.length - 1);
            result.add(root);
        }

        for(BSTNode eachBSTRoot : result){
            BST balancedBSTInstance  = new BST();
            balancedBSTInstance.setRoot(eachBSTRoot);

            balancedBSTInstance.printPreOrder();
        }
    }
    private static BSTNode buildBalancedTreeRecursively(int[] bst_inorder_traversal, int start, int end) {
        if(start > end){
            return null;
        }
        if(start == end){
            return new BSTNode(bst_inorder_traversal[start]); //Only 1 element is left
        }
        int mid = start + Math.floorDiv((end-start), 2);
        //It's given that n/2th element will be the root node at any point of insertion.
        BSTNode subTreeRootNode = new BSTNode(bst_inorder_traversal[mid]);
        subTreeRootNode.setLeft(buildBalancedTreeRecursively(bst_inorder_traversal, start, mid-1));
        subTreeRootNode.setRight(buildBalancedTreeRecursively(bst_inorder_traversal, mid+1, end));
        return subTreeRootNode;
    }
}