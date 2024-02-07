public class Hex2Bin {
    // * from HexaDecimal to Binary
        public static String De2Bin(int a){
            return (a > 0) ? De2Bin(a/2) + a%2 : "";
        }

        public static String HexaToBinary(String a){
            if (a.isEmpty())
                return "";
            char last = a.charAt(a.length() - 1); // get character
            String sub = a.substring(0, a.length() - 1); // get base case

            return HexaToBinary(sub) + De2Bin("0123456789ABCDEF".indexOf(last)) ;
        }
        
        public static void main(String[]args){
           System.out.print(HexaToBinary("2E"));
        }
    }