public class FlattenLinkedList {


    public static void main(String args[]){

        FlattenNode flattenNode = new FlattenNode(5);
        flattenNode.setDown(new FlattenNode(7));
        flattenNode.getDown().setDown(new FlattenNode(8));
        flattenNode.getDown().getDown().setDown(new FlattenNode(30));
        flattenNode.setRight(new FlattenNode(10));
        flattenNode.getRight().setDown(new FlattenNode(20));
        flattenNode.getRight().setRight(new FlattenNode(19));
        flattenNode.getRight().getRight().setDown(new FlattenNode(22));
        flattenNode.getRight().getRight().getDown().setDown(new FlattenNode(50));
        flattenNode.getRight().getRight().setRight(new FlattenNode(28));
        flattenNode.getRight().getRight().getRight().setDown(new FlattenNode(35));
        flattenNode.getRight().getRight().getRight().getDown().setDown(new FlattenNode(40));
        flattenNode.getRight().getRight().getRight().getDown().getDown().setDown(new FlattenNode(45));

        //System.out.println(flattenNode.down.down.value);
        FlattenLinkedList ll = new FlattenLinkedList();
        //ll.printFlatenList(flattenNode);
        FlattenNode head;
        head = ll.flatten(flattenNode);
        ll.printList(head);

    }

    void printList(FlattenNode head){
        while(head != null){
            System.out.print(head.value + " , ");
            head = head.down;
        }
    }

    FlattenNode flatten(FlattenNode node){
        if(node == null || node.right == null)
            return node;

        node.right = flatten(node.right);

        node = merge(node, node.right);

        return node;
    }

    FlattenNode merge(FlattenNode a , FlattenNode b){
        if(a == null)
            return b;

        if(b == null)
            return a;

        FlattenNode newNode;

        if(a.value < b.value){
            newNode = a;
            newNode.down = merge(a.down, b);
        }else{
            newNode = b;
            newNode.down = merge(a, b.down);
        }

        return newNode;
    }

    void printFlatenList(FlattenNode node){
        if(node == null)
            return;
        //printFlatenList(node.right);
        //printFlatenList(node.down);
        if(node.down == null && node.right != null)
            printFlatenList(node.right);
        else if(node.right == null && node.down != null)
            printFlatenList(node.down);
        else if(node.down != null && node.right != null && node.right.value < node.down.value) {
            printFlatenList(node.right);
            printFlatenList(node.down);
        }
        else if(node.down != null && node.right != null && node.right.value >= node.down.value) {
            printFlatenList(node.down);
            printFlatenList(node.right);
        }

        System.out.print(node.value + ", ");

    }


}
class FlattenNode{
    int value;
    FlattenNode right;
    FlattenNode down;

    public FlattenNode(int value) {
        this.value = value;
        this.right = null;
        this.down = null;
    }

    public FlattenNode(int value, FlattenNode right, FlattenNode down) {
        this.value = value;
        this.right = right;
        this.down = down;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public FlattenNode getRight() {
        return right;
    }

    public void setRight(FlattenNode right) {
        this.right = right;
    }

    public FlattenNode getDown() {
        return down;
    }

    public void setDown(FlattenNode down) {
        this.down = down;
    }
}
