
import java.util.Scanner;

class taikhoanthanhtoan extends TaiKhoan {
    private double hanMucThauChi;

    public taikhoanthanhtoan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, double hanMucThauChi) {
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
        this.hanMucThauChi = hanMucThauChi;
    }

    @Override
    public void rutTien(double soTien) {
        if (soTien <= 0) {
            System.out.println("So tien rut phai lon hon 0.");
        } else if (soTien > soDu + hanMucThauChi) {
            System.out.println("So tien rut vuot qua han muc thau chi!");
        } else {
            soDu -= soTien;
            System.out.println("Rut thanh cong " + soTien + " VND. So du hien tai: " + soDu + " VND.");
        }
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("Loai tai khoan: Tai khoan thanh toan.");
        System.out.println("So tai khoan: " + getSoTaiKhoan());
        System.out.println("Chu tai khoan: " + getChuTaiKhoan());
        hienThiSoDu();
        System.out.println("Han muc thau chi: " + hanMucThauChi + " VND.");
    }
}

