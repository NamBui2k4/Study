public class test {
    public static int factorial(int n ){
        if(n == 0)
            return 1;
        return n*factorial(n -1);
    }
    public static int combine(int n,int k){
        return factorial(n)/(factorial( n - k)*factorial(k));
    }
    public static void main(String[] args) {
        System.err.println(combine(7,2));   
    }
}
