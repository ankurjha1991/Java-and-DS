public class PermutationString {
    public static void main(String args[]){
        String str = "ank";
        PermutationString permutationString = new PermutationString();
        permutationString.permutation(str,0 , str.length() - 1);
        //System.out.println(str.substring(0));
    }

    // overall complexity - O(n * n!)
    public void permutation(String str, int l, int r){
        System.out.println("permutation = "+str);
        if(l == r){
            System.out.println(str); // O(n)
        }else{
            for(int i = l;i <= r;i++) {  // O(n!)
                //System.out.println(str);
                str = swap(str, l, i);
                //System.out.println(str);
                permutation(str,l+1, r);
                str = swap(str, l, i);
            }
        }
    }

    public String swap(String str, int l , int r){
        char arr[] = str.toCharArray();
        char temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        //System.out.println(arr);
        return String.valueOf(arr);
    }
}
