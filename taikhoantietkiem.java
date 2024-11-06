
import java.util.Scanner;

public class taikhoantietkiem extends TaiKhoan {
    private double laiSuat;

    // Constructor
    public taikhoantietkiem(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, double laiSuat) {
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
        this.laiSuat = laiSuat;
    }

    // Tính lãi suất cho tài khoản tiết kiệm
    public void tinhLai() {
        double tienLai = soDu * laiSuat / 100;
        System.out.println("Tai khoan nhan duoc " + tienLai + " VND tien lai.");
        napTien(tienLai);
    }

    public void rutTien(double soTien) {
        if (soTien > soDu) {
            System.out.println("So tien rut vuot qua so du tiet kiem!");
        } else if (soTien <= 0) {
            System.out.println("So tien rut phai lon hon 0.");
        } else {
            soDu -= soTien;
            System.out.println("Rut thanh cong " + soTien + " VND. So du hien tai: " + soDu + " VND.");
        }
    }
    
    public void hienThiThongTin() {
        System.out.println("Loai tai khoan: Tai khoan tiet kiem.");
        System.out.println("So tai khoan: " + getSoTaiKhoan());
        System.out.println("Chu tai khoan: " + getChuTaiKhoan());
        hienThiSoDu();
        System.out.println("Lai suat: " + laiSuat + "%.");
    }
}
