
public class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        next = null;
    }

    public Boolean checkForLoop(){
        Node cur;
        Node next;
        cur = this;
        if(cur.next == null) return Boolean.FALSE;
        next = this.next;
        while(cur.next != null && next.next != null && next.next.next != null){
            next = next.next.next;
            cur = cur.next;

            if(cur == next)
                return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void print(){
        Node cur = this;
        for(int i=1;i<6;i++){//while(cur.next !=null){
            System.out.println(cur.data + " " + ((cur.next==null)? "true":"false"));
//            System.out.println(cur.data + " " + cur.next.data);
            cur = cur.next;
        }
    }

    public static void main(String[]  args){
        Node first = new Node(0);
        Node cur = first;
        Node next;
        for(int i=1;i<5;i++){
            next = new Node(i);
            cur.next = next;
            cur = next;
        }
        cur.next = first;
//        cur.next = first.next.next;

//        first.print();
        System.out.println();
        System.out.println((first.next.next.checkForLoop())? "Loop Exists" : "No Loop");
    }
}
