import java.util.Scanner;

public class LetterNumberPrint {

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] arr = input.toCharArray();
        for(int i=0;i<arr.length;i=i+2){
            char value = arr[i+1];
            int count = Character.getNumericValue(value);
            for(int j=0;j<count;j++){
                System.out.print(arr[i]);
            }
        }
    }
}
