// https://tekmarathon.com/2013/03/11/creating-our-own-hashmap-in-java/

public class HashmapCustomImplimentation {
    public static void main(String args[]){
        HashmapCustom hashmap = new HashmapCustom();

        hashmap.put(new HashmapCustom.Employee(1001,"Ankur"),"Computer");
        hashmap.put(new HashmapCustom.Employee(1002,"Nitin"),"Electrical");
        hashmap.put(new HashmapCustom.Employee(1003,"Vishu"),"Machanical");
        hashmap.put(new HashmapCustom.Employee(1004,"Vishal"),"civil");

        hashmap.put(new HashmapCustom.Employee(1005,"Dipanker"),"Instumentation");
        hashmap.put(new HashmapCustom.Employee(1004,"Vishal"),"civil/mechanical");

        hashmap.printMap();
    }
}
class HashmapCustom{

    private final int CAPACITY = 4;
    private HashmapEntry map[] = new HashmapEntry[CAPACITY];

    static class Employee{

        private int id;
        private String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int hashCode() {
            return id % 10;
        }

        @Override
        public boolean equals(Object obj) {
            Employee emp = (Employee) obj;
            return this.id == emp.id;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Employee{");
            sb.append("id=").append(id);
            sb.append(", name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    class HashmapEntry{

        Employee key;
        String deparment;
        HashmapEntry next;
        int hash;

        public HashmapEntry(Employee key, String deparment) {
            this.key = key;
            this.deparment = deparment;
        }

        public Employee getKey() {
            return key;
        }

        public void setKey(Employee key) {
            this.key = key;
        }

        public String getDeparment() {
            return deparment;
        }

        public void setDeparment(String deparment) {
            this.deparment = deparment;
        }

        public HashmapEntry getNext() {
            return next;
        }

        public void setNext(HashmapEntry next) {
            this.next = next;
        }

        public int getHash() {
            return hash;
        }

        public void setHash(int hash) {
            this.hash = hash;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("HashmapEntry{");
            sb.append("key=").append(key);
            sb.append(", deparment='").append(deparment).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }


    private int getSupplementalHash(int h) {
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private int getBucketIndex(int hash){
        return hash & (CAPACITY - 1);
    }

    public void put(Employee key, String department){
        int empHashCode = key.hashCode();
        System.out.println("empHashCode = "+empHashCode);

        int hashCode = getSupplementalHash(empHashCode);
        System.out.println("hashCode = "+hashCode);

        int bucketList = getBucketIndex(hashCode);
        System.out.println("bucketList = "+bucketList);

        HashmapEntry entry = map[bucketList];

        while(entry != null){
            System.out.println("Collision detected for key = " + key.getId() + ", adding element to the existing bucket");
            if(entry.getKey().getId() == key.getId()){
                System.out.println("duplicate key value pair, replacing existing key = "+key.getId() + " with value = "+department);
                entry.setDeparment(department);
                return;
            }
            entry = entry.getNext();
        }
        System.out.println("PUT adding key:" + key.getId() + ", value:" + department);
        HashmapEntry newEntry = new HashmapEntry(key,department);

        newEntry.next = map[bucketList];

        map[bucketList] = newEntry;

    }

    public HashmapEntry get(Employee key){
        int empHashCode = key.hashCode();
        System.out.println("empHashCode = "+empHashCode);

        int hashCode = getSupplementalHash(empHashCode);
        System.out.println("hashCode = "+hashCode);

        int bucketList = getBucketIndex(hashCode);
        System.out.println("bucketList = "+bucketList);

        HashmapEntry entry = map[bucketList];

        while(entry != null){
            System.out.println("Traversing the list inside the bucket for the key : "+ entry.getKey().getId());
            if(entry.getKey().getId() == key.getId()){
                System.out.println("Value found.");
                return entry;
            }
            entry = entry.getNext();
        }
        System.out.println("Nothing found.");
        return null;
    }

    public void printMap(){
        for(int i=0; i < CAPACITY; i++){
            HashmapEntry entry = map[i];
            if(entry != null){
                while(entry != null){
                    System.out.print("position = "+i+" , value = "+entry.toString());
                    entry = entry.getNext();
                }
            }else{
                System.out.print("position = "+i+" , value = "+entry);
            }
        }
    }
}

