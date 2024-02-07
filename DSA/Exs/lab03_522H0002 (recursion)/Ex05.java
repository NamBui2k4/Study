public class Ex05 {
//  * from Decimal to Binary
    public static String DecimaToBinary(int n){
        if(n==0)
            return Integer.toString(0);
        return  DecimaToBinary(n/2) + Integer.toString(n%2);
    }   //   DecimaToBinary(7)
        //          "1" +  DecimaToBinary(3)
        //          "1" + "1" +  DecimaToBinary(1)
        //          "1" + "1" +  "1" +  DecimaToBinary(0)

// * from HexaDecimal to Binary

    public static String HexaToBinary(char c){
        int num = Integer.parseInt(Character.toString(c), 16);
        String binary = Integer.toBinaryString(num);

        while(binary.length() < 4){// note: a Hexa character is 4-digit binary string
            binary = "0" + binary; // ensure that maximum length of a binary is 4
        }                          // Ex: Integer.toBinaryString(Integer.parseInt("3",16)))
                                   //      => "11"
                                   //however, it's actually 0011
        return binary;
    }
    public static String HexaToBinary(String hexString){
        if (hexString.length() == 0) {
            return "";
        }
        char firstChar = hexString.charAt(0);
        String remainingString = hexString.substring(1);
        return HexaToBinary(firstChar) + HexaToBinary(remainingString);
    }
// "1" => 1
//  "A" => ?
//  "A" (16) => 11
//  * print an array
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