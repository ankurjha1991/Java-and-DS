

public class PrintPattern {
    public static void main(String args[]){
        int num = 5;
        int count = 1;
        int mid ;
        while(count <= num) {
            for (int i = 1; i <= (num - count); i++) {
                System.out.print(" ");
            }
            mid = count - 1;
            for(int i = 1; i<= count ; i++){
                mid++;
                System.out.print(mid);

            }
            for(int i = count - 1; i >  0 ; i--){
                --mid;
                System.out.print(mid);
            }
            count++;
            System.out.println();
        }
    }
}
