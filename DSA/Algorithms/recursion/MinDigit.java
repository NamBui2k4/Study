public class MinDigit {
    public static int findMinDigit(int a){
        if(a <= 10)
            return a;
        int r = a%10;
        int v = a/10;
        if(r >= findMinDigit(v))
            r = findMinDigit(v);
        return r;
    }

    public static void main(String[] args){
        System.out.println(findMinDigit(Integer.parseInt(args[0])));
    }
}
