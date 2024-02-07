public class Dec2Hex {
    public static String De2Hex(int n){
        return (n > 0) ? De2Hex(n/16) + "0123456789ABCDEF".charAt(n%16) : "";
    }
    public static void main(String[] args) throws Exception {
        int a = Integer.parseInt(args[0]);
        System.out.println(De2Hex(a));

      
    }
}
