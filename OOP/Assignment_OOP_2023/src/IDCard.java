public class IDCard {
      private int    soDinhDanh;
      private String hoTen;
      private String gioiTinh;
      private String Birth;
      private String diaChi;
      private int    Phone;

      public IDCard(int soDinhDanh, String hoTen, String gioiTinh, String Birth,String diaChi, int Phone) {
            this.soDinhDanh = soDinhDanh;
            this.hoTen = hoTen;
            this.gioiTinh = gioiTinh;
            this.Birth = Birth; 
            this.diaChi = diaChi;
            this.Phone = Phone;
      }

      public String getBirth(){
            return Birth;
      }
      public int getPhone(){
            return Phone;
      }
      public int getSoDinhDanh(){
            return soDinhDanh;
      }
      public String getGioiTinh(){
            return gioiTinh;
      }
      public String toString() {
            return soDinhDanh + "," + hoTen + "," + gioiTinh + "," + Birth + "," + diaChi + "," + Phone;
            
      }
}
