public class ProductOddDigit {
        //  * product of digits of integer a 
            public static int productOddDigits(int n){
                if(n == 0)
                    return 1;
                int temp = n%10;
                if(temp%2 == 0)
                    return 1 * productOddDigits(n/10);
                return temp * productOddDigits(n/10);
            }   // pro(192168) => 1 * pro(19216)
                //                1 * 1 * pro(1921)
                //                1 * 1 * 1 * pro(192)
                //                1 * 1 * 1 * 1 * pro(19)
                //                1 * 1 * 1 * 1 * 9 * pro(1)
                //                1 * 1 * 1 * 1 * 9 * 1 * pro(0)
                //                1 * 1 * 1 * 1 * 9 * 1 * 1
        
            public static  void main(String[]args){
               System.out.print(Integer.toBinaryString(Integer.parseInt("3",16)));
                
            }

            
}
