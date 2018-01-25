import java.util.HashMap;
import java.util.Map;

public class LRUCacheImplementation {
    public static void main(String args[]){
        LRUChace lruChace = new LRUChace(4);
        lruChace.addElement(11,100);
        lruChace.getElement(11);
        lruChace.addElement(11,1000);
        lruChace.printDLL();
        lruChace.addElement(22,200);
        lruChace.addElement(33,300);
        lruChace.printDLL();
        lruChace.getElement(22);
        //lruChace.printDLL();
        lruChace.addElement(44,400);
        lruChace.printDLL();
        lruChace.addElement(55,500);
        lruChace.printDLL();
        lruChace.addElement(66,600);
        lruChace.getElement(22);
        lruChace.addElement(77,700);
        lruChace.addElement(88,800);
        lruChace.addElement(77,1700);
        lruChace.addElement(99,900);
        lruChace.printDLL();
    }
}

class LRUChace{
    Map<Integer, DoubleLLNode> lru;
    DoubleLLNode head = null;
    DoubleLLNode tail = null;
    int initialCapacity;

    public LRUChace(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        lru = new HashMap<>(initialCapacity);
    }

    void addElement(int key, int value){

        if(lru.containsKey(key)){
            DoubleLLNode node = lru.get(key);
            node.value = value;
            //lru.put(key,node);
            remove(node);
            setHead(node);
        }else {
            if (lru.size() >= initialCapacity) {
                lru.remove(tail.key);
                remove(tail);
            }
            DoubleLLNode node = new DoubleLLNode(key,value);
            lru.put(key, node);
            setHead(node);
        }

    }

    int getElement(int key){
        int value = -1;
        if(lru.containsKey(key)){
            DoubleLLNode node = lru.get(key);
            value = node.value;
            remove(node);
            setHead(node);
        }
        return value;
    }

    void remove(DoubleLLNode node){
        if(node != null){
            if(node.prev != null){
                node.prev.next = node.next;
            }else{
                this.head = node;
            }

            if(node.next != null){
                node.next.prev = node.prev;
            }else{
                this.tail = node.prev;
            }
        }
    }

    void setHead(DoubleLLNode node){
        if(node != null){
            if( head != null && head != node){
                node.next = head;
                head.prev = node;
                head = node;
            }else{
                head = node;
                tail = head;
            }
        }
    }

    void printHashMap(){
        System.out.println("printHashMap");
        for (Map.Entry<Integer, DoubleLLNode> entry : lru.entrySet()) {
            Integer key = entry.getKey();
            DoubleLLNode node = entry.getValue();
            System.out.println("key = "+key+" , value = "+node.value);
        }
    }

    void printDLL(){
        System.out.println("printDLL");
        DoubleLLNode tempNode = head;
        while(tempNode != null){
            System.out.println("key = "+tempNode.key+" , value = "+tempNode.value);
            tempNode = tempNode.next;
        }
    }
}

class DoubleLLNode{
    int key;
    int value;
    DoubleLLNode next;
    DoubleLLNode prev;

    public DoubleLLNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
