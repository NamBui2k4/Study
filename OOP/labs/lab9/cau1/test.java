import java.lang.ArithmeticException;

public class test {
    public static void main(String[] args){
    Calculate x = new Calculate(1000,122124);
    try{
        System.out.println(x.divide());
    }catch(ArithmeticException e){
        System.out.println(e.toString());
    }catch(NumberOutOfRangeException error){
        System.out.println(error.toString());
    }
    }
}
