package linkedlist;

public class FindNthFromEndOperation implements Operation {
    private int n;

    @Override
    public OperationEnum getName(){
        return OperationEnum.FIND_NTH_FROM_LAST;
    }

    public int getN() {
        return n;
    }

    @Override
    public void setInput(int input){
        n = input;
    }

    public void execute(LinkedList linkedList){

        LinkedList.Node currentNode = linkedList.getHead();
        int i;
        for(i = 1; i< n; i++) {
            if(currentNode != null){
                currentNode = currentNode.next;
            }
            else{
                break;
            }
        }
        if(currentNode == null && i<=n) {
            System.out.println("Requested operation can't be done. The linkedlist doesn't contain " + n + " elements. ");
            return;
        }

        LinkedList.Node precedingNode = linkedList.getHead();

        if(currentNode != null){
            while(currentNode.next != null){
                precedingNode = precedingNode.next;
                currentNode = currentNode.next;
            }
        }

        linkedList.print();

        System.out.println("Nth item from end: " + precedingNode.data);
    }
}
