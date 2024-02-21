public class IDCard {
      private int    soDinhDanh;
      private String hoTen;
      private String gioiTinh;
      private String ngayThangNamSinh;
      private String diaChi;
      private int    soDienThoai;

      public IDCard(int soDinhDanh, String hoTen, String gioiTinh, String ngayThangNamSinh,String diaChi, int soDienThoai) {
            this.soDinhDanh = soDinhDanh;
            this.hoTen = hoTen;
            this.gioiTinh = gioiTinh;
            this.ngayThangNamSinh = ngayThangNamSinh; 
            this.diaChi = diaChi;
            this.soDienThoai = soDienThoai;
      }

      public String getNgayThangNamSinh(){
            return ngayThangNamSinh;
      }
      public int getSoDienThoai(){
            return soDienThoai;
      }
      public int getSoDinhDanh(){
            return soDinhDanh;
      }
      public String getGioiTinh(){
            return gioiTinh;
      }
      public String toString() {
            return soDinhDanh + "," + hoTen + "," + gioiTinh + "," + ngayThangNamSinh + "," + diaChi + "," + soDienThoai;
            
      }
}
