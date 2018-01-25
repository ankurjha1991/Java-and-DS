public class ReverseStringRecursive {
    public static void main(String args[]){
        ReverseStringRecursive reverseStringRecursive = new ReverseStringRecursive();
        String str = "ankur";
        String output = reverseStringRecursive.reverseString(str);
        System.out.println(output);
    }

    public String reverseString(String str){
        if(str.length() == 1){
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }
}
