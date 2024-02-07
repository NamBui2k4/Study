abstract class Student{
    protected String SName;
    protected int gpa;
    public Student(String sName, int gpa) {
        this.SName = sName;
        this.gpa = gpa;
    }

    public String getSName() {
        return this.SName;
    }

    public void setSName(String sName) {
        this.SName = sName;
    }
    public int getGpa(){
        return this.gpa;
    }
    public void setGpa(int gpa) {
        this.gpa = gpa;
    }
    public String toString(){
        return "name: " + this.SName + ", gpa: " + this.gpa;
    }
    
    public abstract String getRank();
}