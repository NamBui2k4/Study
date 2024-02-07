public class Student extends Person {
    private String id;
    private int score;   

    public Student(String name, int birthYear,String id, int score){
        super(name, birthYear);
        this.score = score;
        this.id = id;
    }

    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }
    public int getScore(){
        return this.score;
    }

    public void setScore(int score){
         this.score = score;
    }

    @Override
    public String toString() {
    return "Student{ name: " + this.name + ", birth year: " + this.birthYear + ", id: " + this.id + ", score:  " + this.score + "}";
}
}