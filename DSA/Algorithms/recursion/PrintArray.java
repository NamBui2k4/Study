public class PrintArray {
            public static void print(int arr[], int n ){
                if(n == 0){
                    System.out.print(arr[0] + " ");
                    return;
                }
                    
                print(arr, n - 1 );
                System.out.print(arr[n] + " ");
            }
        
            public static void print(int[] arr){
                print(arr, arr.length - 1);
            }
            public static  void main(String[]args){
               System.out.print(Integer.toBinaryString(Integer.parseInt("3",16)));
                
            }
        
}
