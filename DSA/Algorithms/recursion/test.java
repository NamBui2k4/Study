public class test {
        //  * product of digits of integer a 
        public static void print(int arr[], int n ){
            if(n == 0){
                System.out.print(arr[0] + " ");
                return;
            }
            print(arr, n - 1);
            System.out.print(arr[n]+ " ");

        }
        public static void print(int[] arr){
            print(arr, arr.length - 1);
        }
        
            public static  void main(String[]args){
             int a[]    = { 1 , 2 , 3 , 4, 5, 6, 7, 8, 9};
             print(a);
            }

            


    
}
