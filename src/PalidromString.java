public class PalidromString {
    public static void main(String args[]){
        PalidromString palidromString = new PalidromString();
        String str = "rotor";
        boolean result = palidromString.checkPalindrome(str.toCharArray(),0,str.length()-1);
        System.out.println(str +" is palindrom : "+result);
    }

    public boolean checkPalindrome(char[] arr, int start, int end){
        if(start < end){
            if(arr[start] == arr[end]){
                return checkPalindrome(arr,++start,--end);
            }else{
                return false;
            }

        }else {
            return true;
        }
    }
}
