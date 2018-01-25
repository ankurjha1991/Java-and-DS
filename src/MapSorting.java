import java.util.*;

public class MapSorting {
    public static void main(String[] args) {

        /*Map<String, String> unsortMap = new HashMap<String, String>();
        unsortMap.put("Z", "z");
        unsortMap.put("B", "b");
        unsortMap.put("A", "a");
        unsortMap.put("C", "c");
        unsortMap.put("D", "d");
        unsortMap.put("E", "e");
        unsortMap.put("Y", "y");
        unsortMap.put("N", "n");
        unsortMap.put("J", "j");
        unsortMap.put("M", "m");
        unsortMap.put("F", "f");

        System.out.println("Unsort Map......");
        printMap(unsortMap);

        System.out.println("\nSorted Map......By Key");
        Map<String, String> treeMap = new TreeMap<String, String>(unsortMap);
        printMap(treeMap);*/

        /*Map<Integer,Integer> integerIntegerMap = new HashMap<>();
        integerIntegerMap.put(22,0);
        integerIntegerMap.put(12,1);
        integerIntegerMap.put(222,3);
        integerIntegerMap.put(12,3);

        System.out.println("Unsort Map......");
        printMap(integerIntegerMap);

        System.out.println("\nSorted Map......By Key");
        Map<Integer, Integer> treeMap = new TreeMap<Integer, Integer>(integerIntegerMap);
        printMap(treeMap);*/

        Map<Integer, String> map=new LinkedHashMap<Integer, String>();

        /*map.put("a", 3);
        map.put("B", 12);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);
        map.put("f", 6);
        map.put("g", 7);
        map.put("h", 8);
        map.put("i", 9);
        map.put("j", 3);
        map.put("k", 2);
        map.put("l", 1);*/

        map.put(0,"12");
        map.put(1,"22");
        map.put(2,"022");
        map.put(3,"12");
        map.put(4,"022");
        map.put(5,"1");

       /* List<Map.Entry<String, Integer>> entries = new
                ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(entries,new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b){
                return a.getValue().compareTo(b.getValue());
            }
        });


        Map<String, Integer> sortedMap = new LinkedHashMap<String,
                Integer>();
        for (Map.Entry<String, Integer> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
            //System.out.print( sortedMap.put(entry.getKey(), entry.getValue())+"  ");
        }*/
        printMap(sortByValue(map));

       /* Map<Integer, Integer> map=new LinkedHashMap<Integer, Integer>();

        map.put(30, 3);
        map.put(12, 12);
        map.put(300, 3);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        map.put(7, 7);
        map.put(8, 8);
        map.put(9, 9);
        map.put(3000, 3);
        map.put(2, 2);
        map.put(1, 1);

        List<Map.Entry<Integer, Integer>> entries = new
                ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(entries,new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b){
                return a.getValue().compareTo(b.getValue());
            }
        });


        Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer,
                Integer>();
        for (Map.Entry<Integer, Integer> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
            //System.out.print( sortedMap.put(entry.getKey(), entry.getValue())+"  ");
        }
        printMap(sortedMap);*/
        //printMap(sortByValue(map));
    }





    //pretty print a map
    public static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey()
                    + " Value : " + entry.getValue());
        }
    }

    public static <K, V> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Object>() {
            @SuppressWarnings("unchecked")
            public int compare(Object o1, Object o2) {
                return ((Comparable<V>) ((Map.Entry<K, V>) (o1)).getValue()).compareTo(((Map.Entry<K, V>) (o2)).getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<>();
        for (Iterator<Map.Entry<K, V>> it = list.iterator(); it.hasNext();) {
            Map.Entry<K, V> entry = (Map.Entry<K, V>) it.next();
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
