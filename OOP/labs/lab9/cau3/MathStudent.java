public class MathStudent extends Student{
    private String sID;
    public MathStudent(String sName, int gpa, String sID){
        super( sName, gpa);
        this.sID = sID;
    }
    
    public String getSID(){
        return this.sID;
    }
    public void setSID(String sID) {
        this.sID = sID;
    }

    public String getRank(){
        if(gpa >= 5)
            return  "Passed";
        else 
            return "Failed";
    }
    
}
