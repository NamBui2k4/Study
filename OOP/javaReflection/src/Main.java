import stackjava.com.reflection.*;
public class Main{
    public static void main(String[] args) throws ClassNotFoundException {
        Customer customer = new Customer();
        customer.setName("kai");
        customer.setAge(25);
        
        Demo demo = new Demo();

        demo.demoReflection(customer);
    
        }
}