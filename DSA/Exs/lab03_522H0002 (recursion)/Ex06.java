import java.util.*;
public class Ex06<E extends Comparable<E>> {

    // a)
    public static <E extends Comparable<E>> E minimum(E input[]) {
        E result = null;
        for(int i = 0; i < input.length - 1; i++){
            for(int j = i+1; j < input.length; j++) {
                if (input[i].compareTo(input[j]) > 0) {
                    E temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
        }
        result = input[0];
        return result;
    }

    // b)
    public static int  sumInt(Integer input[]){
        int result = 0;
        for(int i = 0; i < input.length - 1; i++){
            result += input[i];

        }
        return result;
    }

    public static double  sumDouble(Double input[]){
        double result = 0.0;
        for(int i = 0; i < input.length - 1; i++){
            result += input[i];

        }
        return result;
    }

    // c)
    public static int count(Integer input[]) {
        int count = 0;
        for (int i = 0; i < input.length - 1; i++) {
            count += 1;
        }
        return count;
    }

    public static  void main(String[] args){
        System.out.println( minimum( new Character[] {'a','b','x','u','c'}) );
        System.out.println( minimum( new Integer[] {1,2,3,4,5,6}) );
        System.out.println( minimum( new Double[] {1.2/2,7.1/8,4.3/3,7.1} ) );


        System.out.println( sumInt( new Integer[] {1,2,3,4,5,6}) );
        System.out.println( sumDouble( new Double[] {1.2/2,7.1/8,4.3/3,7.1} ) );

        System.out.println( count( new Integer[] {1,2,3,4,5,6}) );

    }
}