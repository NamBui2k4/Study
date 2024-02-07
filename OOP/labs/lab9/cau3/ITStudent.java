public class ITStudent extends Student{
    private int sID;
    public ITStudent(String sName, int gpa, int sID) {
        super(sName, gpa);
        this.sID = sID;
    }
    public int getSID(){
        return this.sID;
    }
    public void setSID(int sID) {
        this.sID = sID;
    }

    @Override
    public String getRank(){
        if (this.gpa <= 5)
            return "C";
        else if (this.gpa <= 8 && this.gpa > 5 )
            return "B";
        else 
            return "A";
    }

}
