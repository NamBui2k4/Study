public class EWallet implements Payment, Transfer {
	private int Phone;
    private double soDuTaiKhoan;

    public EWallet(int Phone){
        this.Phone = Phone;
        this.soDuTaiKhoan = 0;
    }

    public void topUp(double amount){
        this.soDuTaiKhoan += amount; 
    }

    public boolean pay(double amount){
		if(amount <= soDuTaiKhoan){
            soDuTaiKhoan -= amount;
            return true;
        }
        else 
            return false;
	}
    public double checkBalance(){
		return this.soDuTaiKhoan;
	}
    public int getPhone() { 
        return Phone; 
    }

    public void capNhatSoDuTaiKhoan(double amount){
        this.soDuTaiKhoan += amount;
    }

    public boolean transfer (double amount, Transfer to){
        double soTienChuyen  = amount + amount * Transfer.transferFee;
        double soTienNhan = amount;
        if(to instanceof BankAccount){
            if (amount < soDuTaiKhoan + 50){
                BankAccount newBankAccount = (BankAccount)to;
                newBankAccount.capNhatSoDuTaiKhoan(soTienNhan);
                soDuTaiKhoan -= soTienChuyen;     
            }
            return true;
        }
        
        if (to instanceof EWallet){
            if(amount < soDuTaiKhoan){
                EWallet newWallet = (EWallet)to;
                newWallet.capNhatSoDuTaiKhoan(soTienNhan);
                soDuTaiKhoan -= soTienChuyen;   
            }
           
            return true;
        }
        
        return false;
        }


    
       
    
	public String toString(){
		return  + Phone + "," + soDuTaiKhoan;
	}
}
