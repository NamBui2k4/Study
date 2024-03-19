//Dont modify this file

interface Transfer {
    public static final double transferFee = 0.05;
    public static final double soDuTaiKhoan = 0;
    public boolean transfer (double amount, Transfer to);
    public double checkBalance();
}
