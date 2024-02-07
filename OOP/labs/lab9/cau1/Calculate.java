import java.lang.ArithmeticException;
class NumberOutOfRangeException extends Exception {
    public NumberOutOfRangeException(String message){
        super(message);
    }
    public NumberOutOfRangeException(){
        super();
    }
}
public class Calculate {
    private int a, b;

    public Calculate(int a, int b){
        this.a = a;
        this.b = b;
    }

    public double divide() throws ArithmeticException, NumberOutOfRangeException{
        if (b == 0)
            throw new ArithmeticException("divided by zero");
        else if(a<-1000 || a > 1000 || b<-1000 || b > 1000)
            throw new NumberOutOfRangeException("Number is outside the computation");
        else 
            return (double)a / b;
}
    public int multiply(int a, int b){
        return a*b;
    }

}


