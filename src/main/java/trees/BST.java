package trees;

import java.util.*;

public class BST
{
    private BSTNode root;
    public BST(){
        this.root=null;
    }
    public void setRoot(BSTNode root){
        this.root=root;
    }

    public static void main(String[] args) {

        BST bstInstance=new BST();

        bstInstance.grow();
        bstInstance.printInorder ();
        bstInstance.printPreOrder();
        bstInstance.printPostOrder();

        bstInstance.printHorizontally();

        //TODO: vertical traversal.
//        bstInstance.printVertically();

        bstInstance.printLeafNodes();
    }

    private void printLeafNodes() {
        ArrayList<Integer> preOrder = new ArrayList<>();

        Arrays.stream(BSTConstants.NODES_IN_INSERTION_ORDER).forEach( (node) -> preOrder.add(node) );

        System.out.println();System.out.println("\n:::Print Leaf Nodes from PreOrder:::");
        System.out.print("Leaf Nodes are ");

        printLeafNodes(preOrder);
    }
    private void printLeafNodes(List<Integer> preOrder) {
        if(preOrder.size() == 0){
            return;
        }
        if(preOrder.size() == 1){
            System.out.print(preOrder.get(0) + " "); return;
        }

        ArrayList<Integer> leftSubTree = new ArrayList<>();
        ArrayList<Integer> rightSubTree = new ArrayList<>();

        BSTUtil.separateLeftAndRightSubTrees(preOrder, leftSubTree, rightSubTree);

        printLeafNodes(leftSubTree);
        printLeafNodes(rightSubTree);
    }

    public void grow(){
        Arrays.stream(BSTConstants.NODES_IN_INSERTION_ORDER).forEach(this::add);
    }

    public void add(int data) {
        if(root == null){
            setRoot(new BSTNode(data));
        }else{
            add(root, data);
        }
    }
    private void add(BSTNode currentNode, int data) {
        if(currentNode.getData() == data){
            return;
        } else if(data < currentNode.getData()){
            if(currentNode.getLeft() == null){
                currentNode.setLeft(new BSTNode(data)); return;
            } else{
                currentNode = currentNode.getLeft();
            }
        } else{
            if(currentNode.getRight() == null){
                currentNode.setRight(new BSTNode(data)); return;
            } else{
                currentNode = currentNode.getRight();
            }
        }
        add(currentNode, data);
    }

    public void printPreOrder(){
        System .out.println ();
        System.out.print("PREORDER: ");
        traversePreOrder(root);
    }
    private void traversePreOrder (BSTNode currentBSTNode){
        if(currentBSTNode ==null){
            return;
        }

        System.out.print(currentBSTNode.getData() + " ");

        traversePreOrder (currentBSTNode.getLeft());
        traversePreOrder (currentBSTNode.getRight());
    }

    public void printInorder(){
        System .out.println ();
        System.out.print("INORDER: ");
        traverseInorder(root);
    }
    private void traverseInorder (BSTNode currentBSTNode){
        if(currentBSTNode ==null){
            return;
        }
        traverseInorder (currentBSTNode.getLeft());
        System .out.print(currentBSTNode.getData()+" ");
        traverseInorder (currentBSTNode.getRight());

    }

    public void printPostOrder(){
        System .out.println ();
        System.out.print("POSTORDER: ");
        traversePostOrder(root);
    }
    private void traversePostOrder (BSTNode currentBSTNode){
        if(currentBSTNode ==null){
            return;
        }
        traversePostOrder (currentBSTNode.getLeft());
        traversePostOrder (currentBSTNode.getRight());
        System.out.print(currentBSTNode.getData()+" ");
    }

    public void printHorizontally(){
        System .out.println ();
        System.out.print("HORIZONTAL: ");
        Queue<BSTNode> currentLevel=new LinkedList<>();
        currentLevel.add(root);
        traverseHorizontally(currentLevel );
    }
    private void traverseHorizontally (Queue<BSTNode> currentLevel){
        if(currentLevel.isEmpty())
            return;

        Queue<BSTNode> nextLevel=new LinkedList<>();
        System.out.println();
        while(currentLevel.peek()!= null ){
            BSTNode each=currentLevel.poll();
            if(each.getLeft()!=null)
                nextLevel.add(each.getLeft());
            if(each.getRight()!=null)
                nextLevel.add(each.getRight());
            System.out.print(each.getData() +" ");
        }
        traverseHorizontally(nextLevel);
    }

     /*public void printVertically() {
        System .out.println ();
        System.out.print("VERTICAL: ");
        getDepthInLeft(root, 0);
        traverseVertical(root);
    }

    private void getDepthInLeft(BSTNode currentNode, int fromLeft,
                                    List<BSTNode> visitedNodes,
                                    Map<Integer, List<BSTNode>> levelWiseList) {
        if(currentNode.getRight() != null){
            List<BSTNode> eachLevelList = levelWiseList.get(fromLeft);
            if(eachLevelList == null){
                eachLevelList = new ArrayList<>();
            }
            if(visitedNodes.contains(currentNode)){
                fromLeft--;
            }else{
                fromLeft++;
            }

            eachLevelList.add(currentNode);
//            levelWiseList.put(fromLeft, eachLevelList);
            visitedNodes.add(currentNode);
            getDepthInLeft(currentNode, fromLeft, visitedNodes, levelWiseList);
        }
    }
    private BSTNode getDepthInLeft(BSTNode currentNode, int fromLeft) {
        if(currentNode == null){
            return currentNode;
        }
        BSTNode nextNode = getDepthInLeft(currentNode.getLeft(), fromLeft);
        if(nextNode == null){
            fromLeft++;
            List<BSTNode> eachLevelList  = new ArrayList<>();
            Map<Integer, List<BSTNode>> levelList = new HashMap<>();
            eachLevelList.add(currentNode);
            levelList.put(fromLeft, eachLevelList);
            List<BSTNode> visitedNodes = new ArrayList<>();
            visitedNodes.add(currentNode);
            getDepthInLeft(currentNode, fromLeft, visitedNodes, levelList);
        }
        return nextNode;
    }

    private void traverseVertical(BSTNode root) {

    }*/
}