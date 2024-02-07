import java.util.*;
public class main{
    public static int factorial(int n ){
        if(n == 0)
            return 1;
        return n*factorial(n -1);
    }
    public static int combine(int n,int k){
        return factorial(n)/(factorial( n - k)*factorial(k));
    }
    
    
        public static boolean contains(int[] arr, int num) {
            for (int i : arr) {
                if (i == num) {
                    return true;
                }
            }
            return false;
        }
    

    public static int matrix(int [] list, int n){
        int b = combine(list.length,2);
        int g = 0;
        
        while(g < b){
            Random rand = new Random();
            String Matrixs = "";
            int i = 0;
            int frequency[] = new int[list.length];
            while(true){
                int temp = rand.nextInt(list.length - 1);
                if(contains(frequency,temp))
                    continue;
                else
                    frequency[i] = temp;

                if (i == temp )
                    continue;
                Matrixs += Integer.toString(list[i]) + "x" + Integer.toString(list[temp])+ " ";
                i++;
                if(i == n){
                    break;
                }
            }
                String listMatrix[] = Matrixs.split(" ");
                int j = 0;
                int bigO[] = new int 
                while(true){
                    int index = rand.nextInt(listMatrix.length - 1);
                    
                    j++;
                    if()
                }
            

            g++;
    }
           
}
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        do{
            n = sc.nextInt();
        }while(n <= 100 && n >= 2);
        int n2 = n + 1;
        int i = 0;
        int list[] = new int[n2];
        while(i < n2){
            int temp = sc.nextInt();
            list[i++] = temp;
        };
        sc.close();
        System.out.println(matrix(list, n));
        
    }
}