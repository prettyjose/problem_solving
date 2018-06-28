package linkedlist;

class LinkedList {
    public Node getHead() {
        return head;
    }

    private Node head;

    class Node{

        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }
    public void add(int i) {
        Node newNode = new Node(i);
        newNode.next = head;
        head = newNode;
    }
    public void print(){
        Node current = head;
        System.out.println();
        while(current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public void reverseInBatches(int batchSize) {
        head = reverseInBatches(head, batchSize);
    }

    private Node reverseInBatches(Node batchFirst, int batchSize) {
        Node current = batchFirst;
        Node prev = null;
        Node next;
        int i = 0;
        while(current != null && i < batchSize){
            next =  current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }
        if(current != null){
            //KEY LOGIC
            batchFirst.next = reverseInBatches(current, batchSize);
        }
        return prev;
    }
}
