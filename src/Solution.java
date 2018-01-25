import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {

    public static void main(String args[]){

        Map<Integer, String> mapString=new LinkedHashMap<Integer, String>();
        Map<Integer, Integer> mapInteger=new LinkedHashMap<Integer, Integer>();

        Scanner scanner = new Scanner(System.in);
        /*Scanner scanner = null;;//= new Scanner(System.in);

        File file = new File("input.txt");
        //System.err.println(file.getAbsolutePath());

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
        int count = scanner.nextInt();
        scanner.nextLine();
        String[] str = new String[count+1];
        for(int i=0;i <count;i++){
            str[i] = scanner.nextLine();
        }
        int column = scanner.nextInt();
        boolean reverse = scanner.nextBoolean();
        String sortType = scanner.next();
        /*for(int i=0;i < count;i++){
            //str[i] = scanner.nextLine();
            System.out.println(str[i]);
        }*/
        //System.out.println("column = " + column);
        //System.out.println("reverse = " + reverse);
        //System.out.println("sortType = " + sortType);
        for(int i=0;i < count;i++){
            //str[i] = scanner.nextLine();
            //System.out.println(str[i]);
            String numberStr = "";
            char[] arr = str[i].toCharArray();
            //System.out.println(arr.length);
            int spaceCount = 1;
            int start = 0;
            int end = 0;
            boolean foundCol = false;
            for(int j=0;j<arr.length;j++){
                if(!foundCol && spaceCount == column){
                    start = j;
                    foundCol = true;
                }
                if(!foundCol && arr[j] == ' '){
                    spaceCount++;
                }
                if(foundCol){
                        if(arr[j] == ' ') {
                            end = j;
                            break;
                        }
                        if(j == arr.length -1) {
                            end = j+1;
                            break;
                        }
                }
            }
            //System.out.println("start = "+start+" , end = "+end);
            if(end >= arr.length){
                numberStr = str[i].substring(start);
            } else{
                numberStr = str[i].substring(start,end);
            }
            if(sortType.equalsIgnoreCase("numeric")) {
                int value = 0;
                try {
                    value = Integer.valueOf(numberStr);
                } catch (NumberFormatException ex) {
                    value = 0;
                }

                mapInteger.put(i, value);

                //printMap(sortByValue(mapInteger, reverse), str);
            }else{
                mapString.put(i, numberStr);

                //printMap(sortByValue(mapString, reverse), str);
            }
        }

        if(sortType.equalsIgnoreCase("numeric")) {
            printMap(sortByValue(mapInteger, reverse), str);
        }else{
            printMap(sortByValue(mapString, reverse), str);
        }

    }

    public static <K, V> Map<K, V> sortByValue(Map<K, V> map, boolean reverseValue) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Object>() {
            @SuppressWarnings("unchecked")
            public int compare(Object o1, Object o2) {
                if(reverseValue) {
                    return ((Comparable<V>) ((Map.Entry<K, V>) (o2)).getValue()).compareTo(((Map.Entry<K, V>) (o1)).getValue());
                }else{
                    return ((Comparable<V>) ((Map.Entry<K, V>) (o1)).getValue()).compareTo(((Map.Entry<K, V>) (o2)).getValue());
                }
            }
        });

        Map<K, V> result = new LinkedHashMap<>();
        for (Iterator<Map.Entry<K, V>> it = list.iterator(); it.hasNext();) {
            Map.Entry<K, V> entry = (Map.Entry<K, V>) it.next();
            result.put(entry.getKey(), entry.getValue());
            //System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }

        return result;
    }

    public static <K, V> void printMap(Map<K, V> map,String[] str) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            //System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
            System.out.println(str[Integer.valueOf((Integer) entry.getKey())]);
        }
    }
}
