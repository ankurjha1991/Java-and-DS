public class LinkedList {
    static Node head = null;
    public static void main(String args[]){
        LinkedList ll = new LinkedList();

        //System.out.print("start ");
        ll.addNodeToEnd(1);
        ll.addNodeToEnd(2);
        ll.addNodeToEnd(3);
        ll.addNodeToEnd(4);
        ll.addNodeToEnd(5);
        //System.out.print("end ");
        //ll.printList(head);
        //System.out.print("end 2");
        ll.reverse(head);

        ll.printList(head);
    }

    void addNodeToEnd(int value){
        Node node = new Node(value);
        if(head == null){
            head = node;
        } else {
            Node next = head;
            while (next.next != null) {
                next = next.next;
            }
            next.next = node;
        }
    }

    void printList(Node head){
        while(head != null){
            System.out.print(head.value + " , ");
            head = head.next;
        }
    }

    void reverse(Node ptr){
        Node prev;
        if(/*ptr != null && ptr.next != null && */ptr.next == null){
            head = ptr;
            return;
        }
        prev = ptr;
        reverse(ptr.next);
        prev.next.next = prev;
        prev.next = null;
    }
}

class Node{
    int value;
    Node next;

    public Node(int value){
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
