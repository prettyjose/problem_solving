package coderpad;

/*
 * To execute Java, please define "static void main" on a class
 * named coderpad.print_from_three_threads.coderpad.Solution.
 *
 * If you need more classes, simply define them inline.
 */
class MyLinkedList {
  class Node{
    int data;
    Node next;
    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }
  Node head;
  
  public void add(int data) {
    Node newNode= new Node(data);
    if(head == null)
      head = newNode;
    else{
      Node curnt = head;
      while(curnt.next!=null) 
        curnt = curnt.next;
      curnt.next = newNode;
    }
  }
  public void reverse() {
    reverse(head.next, head);
  }
  private void reverse(Node curnt, Node prev) {
    if(curnt.next == null)
      this.head = curnt;
    else
      reverse(curnt.next, curnt);
    curnt.next = prev;
    prev.next = null;
  } 
  public void printToConsole() {
    Node curnt = head;
    while(curnt.next !=null) {
      System.out.print(curnt.data + "  ");
      curnt = curnt.next;
    }
    System.out.println(curnt.data);
  }
}
class Solution{ 
  public static void main(String[] args) {
    MyLinkedList curntLL = new MyLinkedList();
    curntLL.add(1);
    curntLL.add(2);
    curntLL.add(3);
    curntLL.add(4);
    curntLL.add(5);
    System.out.print("Given linked list:  ");
    curntLL.printToConsole();

    System.out.println();

    curntLL.reverse();
    System.out.print("Reversed linked list:  ");
    curntLL.printToConsole();
  }
}
