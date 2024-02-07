public class test {
    public static void main(String[] args) {
        Student student1 = new Student("Nam", 2004, "522H0002",10 );
        Student student2 = new Student("Hao" , 2004, "522H0100",0 );
        PersonModel <Student> student = new PersonModel<Student>();
        student.add(student1);
        student.add(student2);
        student.display();
        


    }
}

