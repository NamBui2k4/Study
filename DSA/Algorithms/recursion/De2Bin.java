public class De2Bin {
    public static String DeToBin(int a){
        return (a > 0) ? DeToBin(a/2) + a%2 : "";
    }
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        System.out.println(DeToBin(a));
    }
}
