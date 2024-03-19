public class TestReq2 {
    public static void main(String[] args) {
        EWallet ew1 = new EWallet(8365214);
        EWallet ew2 = new EWallet(8365216);
        ew1.topUp(500);
        System.out.println("EWallet 1: " + ew1.checkBalance());
        System.out.println("EWallet 2: " + ew2.checkBalance());
        ew1.transfer(200, ew2);
        System.out.println("------------------");
        System.out.println("EWallet 1: " + ew1.checkBalance());
        System.out.println("EWallet 2: " + ew2.checkBalance());
        System.out.println("------------------");
        BankAccount ba = new BankAccount(1000023, 0.02);
        System.out.println("BankAccount 1: " + ba.checkBalance());
        ew1.transfer(200, ba);
        System.out.println("------------------");
        System.out.println("EWallet 1: " + ew1.checkBalance());
        System.out.println("BankAccount 1: " + ba.checkBalance());
        System.out.println("------------------");
        ba.transfer(200, ew2);
        System.out.println("BankAccount 1: " + ba.checkBalance());
        System.out.println("EWallet 2: " + ew2.checkBalance());
    }
}
