class Question3 {
    public static void print(int[] a, int n){
            if (n == 1)
                System.out.print(a[n] + " " + a[n - 1] );
        print(a, n - 1);
    }
    // 
    public static void main(String[] args) {
        int	a[] = {1, 2, 3, 4};
        print(a,a.length - 1);
    }
}