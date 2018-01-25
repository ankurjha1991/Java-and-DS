import java.util.Scanner;

public class VersionCompare {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String version1 = scanner.nextLine();
        String version2 = scanner.nextLine();
        //System.out.print(version1);
        //System.out.print(version2);
        /*char[] arr = input.toCharArray();
        for(int i=0;i<arr.length;i=i+2){
            char value = arr[i+1];
            int count = Character.getNumericValue(value);
            for(int j=0;j<count;j++){
                System.out.print(arr[i]);
            }
        }*/
        int firstPositionVersion1 = version1.indexOf(".",0);
        //int secondPositionVersion1 = version1.indexOf(".",2);

        int firstPositionVersion2 = version2.indexOf(".",0);
        //int secondPositionVersion2 = version1.indexOf(".",2);

        System.out.println(firstPositionVersion1);
        System.out.println(firstPositionVersion2);

        System.out.println(version1.substring(0,firstPositionVersion1));
        System.out.println(version2.substring(0,firstPositionVersion2));

        int number1 =  Integer.parseInt(version1.substring(0,firstPositionVersion1));
        int number2 =  Integer.parseInt(version2.substring(0,firstPositionVersion2));

        System.out.println(number1);
        System.out.println(number2);
    }
}
