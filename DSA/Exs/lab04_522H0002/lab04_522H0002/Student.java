public class Student{
    private String name;
    private double Mathematics,programming,DSA1;

    public Student(String name,double Mathematics, double programming, double DSA1){
        this.name = name;
        this.Mathematics = Mathematics;
        this.programming = programming;
        this.DSA1 = DSA1;
    }
    public String getName(){
        return name;
    }
    public double getMathematics(){
        return Mathematics;
    }
    public double getProgramming(){
        return programming;
    }

    public double getDSA1(){
        return DSA1;
    } 
    public double averageGrade(){
        return (1/3)*(Mathematics + programming + DSA1);
    }
    @Override
    public String toString(){
        return name + ", " + Mathematics + ", " + programming + ", " + DSA1;  
    }
}