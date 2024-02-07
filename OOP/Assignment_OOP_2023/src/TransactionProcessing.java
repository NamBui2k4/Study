import java.util.*;
import java.io.*;
import java.time.Year;
public class TransactionProcessing {
    private ArrayList<Payment> paymentObjects;
    private IDCardManagement idcm;
    
    public TransactionProcessing(String idCardPath, String paymentPath) {
        idcm = new IDCardManagement(idCardPath);
        readPaymentObject(paymentPath);
    
    }

    public ArrayList<Payment> getPaymentObject() {
        return this.paymentObjects;
    }

     //Requirement 3
    public boolean readPaymentObject(String path) {
         try{
             File f = new File(path);
             Scanner sc = new Scanner(f);
             ArrayList<Payment> paymentObjects = new ArrayList<Payment>();
             while(sc.hasNextLine()){
                 String line = sc.nextLine();
                 String data[] = line.split(",");
                 switch (data.length){
                    case 1:
                       
                        if(data[0].length() == 6){
                           ArrayList<IDCard> IDCardList = idcm.getIDCards();
                          
                            for(int i = 0; i < IDCardList.size(); i++){
                               String IDConvenientCard  = IDCardList.get(i).toString().substring(0, 6);
                               if(IDConvenientCard.equals(data[0])){
                                   paymentObjects.add(new ConvenientCard(IDCardList.get(i)));
                                   break;
                               }
                           }
                       }else 
                           paymentObjects.add(new EWallet(Integer.parseInt(data[0])));
                       break;
                    

                    case 2:
                        paymentObjects.add( new BankAccount(Integer.parseInt(data[0]),Double.parseDouble(data[1]) ));
                        break;
                     
                    
                        

                       
                    }
                    }
             sc.close();
             this.paymentObjects = paymentObjects;

         }catch(Exception e){
             e.printStackTrace();
         }
         return true;
    }

     //Requirement 4
    public ArrayList<ConvenientCard> getAdultConvenientCards() {
        ArrayList<ConvenientCard> Adult = new ArrayList<ConvenientCard>();

        for(int i=0; i< paymentObjects.size(); i++){

            Payment member = paymentObjects.get(i);

            if(member instanceof ConvenientCard){
                
                ConvenientCard  AdultMember = (ConvenientCard)member;
                if(AdultMember.getType() == "Adult")
                    Adult.add(AdultMember);
            }
        }
        return Adult;
    }

     //Requirement 5
    public ArrayList<IDCard> getCustomersHaveBoth() {
        ArrayList<IDCard> IDListThreeType = new ArrayList<IDCard>();
       
        for(Payment payment1 : paymentObjects){
            boolean hasBoth = false;
            if(payment1 instanceof ConvenientCard){
                ConvenientCard CvCard  = (ConvenientCard)payment1;
                IDCard IDcardOfMember = CvCard.getTheDinhDanh();

                for(Payment payment2 : paymentObjects){
                    if(payment2 instanceof BankAccount){
                        BankAccount bank = (BankAccount)payment2;
                            if(bank.getSoTaiKhoan() == IDcardOfMember.getSoDinhDanh()){

                            for(Payment payment3 : paymentObjects){
                                if(payment3 instanceof EWallet){
                                    EWallet Ew = (EWallet)payment3;
                                    if(Ew.getPhone() == IDcardOfMember.getPhone()){
                                        hasBoth = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if(hasBoth)
                            break;
                }
                if (hasBoth)
                    IDListThreeType.add(IDcardOfMember);
            }
        } 
        return IDListThreeType;
    }

    
   
    //Requirement 6
    public void processTopUp(String path) {
        try{
        File file = new File(path);
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String data[] = line.split(",");

            switch(data[0]){
                case "CC":
                for(Payment payment : paymentObjects){
                    if(payment instanceof ConvenientCard){
                        ConvenientCard CvCard = (ConvenientCard)payment;
                        String ID = CvCard.getTheDinhDanh().toString().substring(0, 6);
                        if(ID.equals(data[1]))
                            CvCard.topUp(Double.parseDouble(data[2]));
                    }
                }        
                break;

                case "BA":
                for(Payment payment : paymentObjects){
                    if(payment instanceof BankAccount){
                        BankAccount bank = (BankAccount)payment;
                        int ID = bank.getSoTaiKhoan();
                        if(Integer.parseInt(data[1]) == ID)
                            bank.topUp(Double.parseDouble(data[2]));
                    }
                }
                break;

                case "EW":
                for(Payment payment : paymentObjects){
                    if(payment instanceof EWallet) {
                        EWallet Ew = (EWallet)payment;
                        int phoneNumber = Ew.getPhone();   
                        if(phoneNumber == Integer.parseInt(data[1])){
                            Ew.topUp(Double.parseDouble(data[2]));
                        }

                    }
                }
                break;

        }
    }
    sc.close();
    }catch(Exception e){
        e.printStackTrace();
        
    }
}


     //Requirement 7
    public ArrayList<Bill> getUnsuccessfulTransactions(String path) {
        ArrayList<Bill> ListUnseccessfulTransaction = new ArrayList<Bill>();
        try{
            File file = new File(path);
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String data[] = line.split(",");
                switch(data[3]){
                    case "CC":
                    for(Payment payment : paymentObjects){
                        if(payment instanceof ConvenientCard){
                            ConvenientCard CvCard = (ConvenientCard)payment;
                            String ID = CvCard.getTheDinhDanh().toString().substring(0, 6);
                            if(ID.equals(data[4])){
                                boolean checkPay = CvCard.pay(Double.parseDouble(data[1]));
                                if (checkPay)
                                    continue;
                                else 
                                    ListUnseccessfulTransaction.add(new Bill(Integer.parseInt(data[0]),Double.parseDouble(data[1]),data[2]));
                            }
                        }
                    }
                    break;


                    case "BA":
                    for(Payment payment : paymentObjects){
                        if(payment instanceof BankAccount){
                            BankAccount bank = (BankAccount)payment;
                            int ID = bank.getSoTaiKhoan();
                            if(ID == Integer.parseInt(data[4])){
                                boolean checkPay = bank.pay(Double.parseDouble(data[1]));
                                if (checkPay)
                                    continue;
                                else 
                                    ListUnseccessfulTransaction.add(new Bill(Integer.parseInt(data[0]),Double.parseDouble(data[1]),data[2]));
                            }
                        }
                    }
                    break;


                    case "EW":
                    for(Payment payment : paymentObjects){
                        if(payment instanceof EWallet){
                            EWallet Ew = (EWallet)payment;
                            int phoneNumber = Ew.getPhone();
                            if(phoneNumber == Integer.parseInt(data[4])){
                                boolean checkPay = Ew.pay(Double.parseDouble(data[1]));
                                if (checkPay)
                                    continue;
                                else 
                                    ListUnseccessfulTransaction.add(new Bill(Integer.parseInt(data[0]),Double.parseDouble(data[1]),data[2]));
                            }
                        }
                    }
                    break;

                }
            }
        sc.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return ListUnseccessfulTransaction;
    }

     //Requirement 8
    public Bill getMaxSuccessPayment(ArrayList<Bill> ListPaymentSuccessByBA){
        Bill MaxPayment = ListPaymentSuccessByBA.get(0);  
        for(Bill payments : ListPaymentSuccessByBA){
                if(MaxPayment.getTotal() < payments.getTotal()){
                    MaxPayment = payments;
                }
            }
        return MaxPayment;
        
    }
    public BankAccount findBAThroughMaxPayment(String path,Bill MaxPayment){
        BankAccount BA = null;
        try{
            File file = new File(path);
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String data[] = line.split(",");
                if(Integer.parseInt(data[0]) == MaxPayment.getBillID()){
                    for(Payment payment : paymentObjects){
                        if(payment instanceof BankAccount){
                            BankAccount result = (BankAccount)payment;
                            if(result.getSoTaiKhoan() == Integer.parseInt(data[4])){
                                BA = result;
                            }
                        }
                    }
                }
            }
            sc.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    return BA;
    
}
    
    

    public ArrayList<BankAccount> getLargestPaymentByBA(String path) {
        ArrayList<Bill> ListPaymentSuccessByBA = new ArrayList<Bill>();
        ArrayList<BankAccount> ListLargestPaymentByBA = new ArrayList<BankAccount>();
        try{
            File file = new File(path);
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String data[] = line.split(","); 
                if(data[3].equals("BA")){
                    for(Payment payment : paymentObjects){
                        if(payment instanceof BankAccount){
                            BankAccount bank = (BankAccount)payment;
                            int ID = bank.getSoTaiKhoan();
                            if(ID == Integer.parseInt(data[4])){
                                double amount = Double.parseDouble(data[1]);
                                boolean checkPay = bank.pay(amount);
                                if (checkPay)
                                    ListPaymentSuccessByBA.add(new Bill(Integer.parseInt(data[0]),Double.parseDouble(data[1]),data[2]));        
                                }
                                
                            }
                        }
                    }
                    
                }
                Bill MaxPayment = getMaxSuccessPayment(ListPaymentSuccessByBA);
                BankAccount BA = findBAThroughMaxPayment(path,MaxPayment);
                ListLargestPaymentByBA.add(BA);
                sc.close();
            }     
        
        
        catch(Exception e){
            e.printStackTrace();
        }

        return ListLargestPaymentByBA;
    }

    //Requirement 9
   
    public void processTransactionWithDiscount(String path) {
        try{File file = new File(path);
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                String data[] = line.split(",");
                if(data[3].equals("EW") && data[2].equals("Clothing")){
                for(Payment payment2 : paymentObjects){
                    if(payment2 instanceof EWallet){
                        EWallet Ew = (EWallet) payment2;
                        int phoneNumber = Ew.getPhone();
                            if(phoneNumber == Integer.parseInt(data[4])){
                                for(Payment payment1 : paymentObjects){
                                
                                    if(payment1 instanceof ConvenientCard){

                                        ConvenientCard CvCard = (ConvenientCard)payment1;
                                        IDCard ID = CvCard.getTheDinhDanh();
                                        
                                        if(ID.getPhone() == phoneNumber && ID.getPhone() == Integer.parseInt(data[4])){
                                            
                                            String genderOfCostumer = ID.getGioiTinh();
                                            int ageOfCostumer = Year.now().getValue() - Integer.parseInt(ID.getBirth().substring(6, 10));
                            
                                            double amountPaid = Double.parseDouble(data[1]);
                                            System.out.println(genderOfCostumer + " " + ageOfCostumer + " " + amountPaid);
                                           
                                            if((genderOfCostumer.equals("Male") && ageOfCostumer < 20 && amountPaid > 500) ||(genderOfCostumer.equals("Female") && ageOfCostumer < 18 && amountPaid > 500)){
                                              
                                                Ew.pay(0.85*amountPaid);   
                                                CvCard.pay(0.85*amountPaid);
                                            }

                                            
                                        
                                        }
                                       

                                    }
                                }
                            }
                        else    
                            break;
                        }
                    }
                }
                }
        sc.close();   
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public String toString() {
        return paymentObjects.toString();
    }
}
