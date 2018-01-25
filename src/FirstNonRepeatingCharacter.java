import java.util.ArrayList;
import java.util.List;

public class FirstNonRepeatingCharacter {
    public static final int MAX_CHAR_COUNT = 256;

    public static void findFirstNonRepeateingCharacter(String str){
        List<Character> DLL = new ArrayList<>();
        boolean[] repeated = new boolean[MAX_CHAR_COUNT];

        for(int i=0; i<str.length(); i++){
            char x = str.charAt(i);
            //System.out.println((int)x);
            if(!repeated[x]){
                if(DLL.contains(x)){
                    DLL.remove((Character) x);
                    repeated[x] = true;
                }else{
                    DLL.add(x);
                }
            }
            if(DLL.size() > 0)
                System.out.println("First non-repeating charater : "+DLL.get(0));
        }


    }
    public static void main(String args[]){
        findFirstNonRepeateingCharacter("geeksforgeeksandgeeksquizfor"); //geeksforgeeksandgeeksquizfor
    }
}
