public class BankAccount implements Payment, Transfer{
    private int soTaiKhoan;
    private double tiLeLaiSuat;
    private double soDuTaiKhoan; 

    public BankAccount(int soTaiKhoan, double tiLeLaiSuat){
        this.soTaiKhoan = soTaiKhoan;
        this.tiLeLaiSuat = tiLeLaiSuat;
        this.soDuTaiKhoan = 50;
    }
    
    public boolean pay(double amount){
		if(this.soDuTaiKhoan < 50)
            return false;
        if(amount + 50 <= soDuTaiKhoan){
            soDuTaiKhoan -= amount;
            return true;
        }
        else return false;
	}
    public int getSoTaiKhoan(){
        return soTaiKhoan;
    }
    public double checkBalance(){
		return this.soDuTaiKhoan;
	}

    public boolean transfer (double amount, Transfer to){
        double soTienChuyen  = amount + amount * Transfer.transferFee;
        double soTienNhan = amount;
        if(to instanceof BankAccount){
            if (amount < soDuTaiKhoan + 50){
                BankAccount newBankAccount = (BankAccount)to;
                newBankAccount.capNhatSoDuTaiKhoan(soTienNhan);
                soDuTaiKhoan -= soTienChuyen; 
                return true;

                
            }
        if (to instanceof EWallet){
            if(amount < soDuTaiKhoan){
                EWallet newEWallet = (EWallet)to;
                newEWallet.capNhatSoDuTaiKhoan(soTienNhan);
                soDuTaiKhoan -= soTienChuyen; 
                return true;
            }
        }
        }
        return false;
    }
    
    public void topUp(double amount){
		this.soDuTaiKhoan += amount;
	}

    public void capNhatSoDuTaiKhoan(double amount){
        this.soDuTaiKhoan += amount; 
    }
	public String toString(){
		return soTaiKhoan + "," + tiLeLaiSuat + "," + soDuTaiKhoan;
	}

}
