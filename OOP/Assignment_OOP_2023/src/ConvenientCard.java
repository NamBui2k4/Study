import java.time.Year;
public class ConvenientCard implements Payment{
	
    private String loaiThe;
	private IDCard theDinhDanh;
	private double soDuTaiKhoan;
	
	public ConvenientCard(IDCard theDinhDanh) throws CannotCreateCard{
		this.theDinhDanh = theDinhDanh;
		this.soDuTaiKhoan = 100;
		
		if(Year.now().getValue() -  Integer.parseInt(theDinhDanh.getBirth().substring(6, 10)) < 12 )
			throw new CannotCreateCard("Not enough age");
		else
			this.loaiThe = (Year.now().getValue() - Integer.parseInt(theDinhDanh.getBirth().substring(6, 10)) <= 18) ? "Student" : "Adult";
		
				
	
		
	}	
	public String getType(){
		return this.loaiThe;
	}
	public void topUp(double amount){
		this.soDuTaiKhoan += amount;
	}
	public IDCard getTheDinhDanh(){
		return this.theDinhDanh;
	}

	public boolean pay(double amount){
		if(loaiThe == "Student" && amount <= soDuTaiKhoan){
			this.soDuTaiKhoan -= amount;
			return true;
		}
		else if(loaiThe == "Adult" && amount < soDuTaiKhoan){
			this.soDuTaiKhoan -= amount + amount*0.01;
			return true;
		}
		else
			return false;
	}	
    public double checkBalance(){
		return this.soDuTaiKhoan;
	}
	public String toString(){
		return theDinhDanh+ "," + loaiThe + "," + soDuTaiKhoan;
	}
}
