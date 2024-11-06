
import java.util.Scanner;

abstract class TaiKhoan {
    private String soTaiKhoan;
    private String chuTaiKhoan;
    protected double soDu;
    private String matKhau;

    // Constructor
    public TaiKhoan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
        this.matKhau = matKhau;
    }

    // Lấy số tài khoản
    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    // Lấy tên chủ tài khoản
    public String getChuTaiKhoan() {
        return chuTaiKhoan;
    }

    // Xác thực mật khẩu
    public boolean xacThucMatKhau(String matKhauNhap) {
        return this.matKhau.equals(matKhauNhap);
    }

    private static Scanner sc = new Scanner(System.in);

    // Thay đổi mật khẩu
    // Thay đổi mật khẩu
public void thayDoiMatKhau(String matKhauMoi) {
    System.out.print("Nhập mật khẩu hiện tại: ");
    String matKhauNhap = sc.nextLine();
    
    // Check if the entered password matches the current password
    if (this.xacThucMatKhau(matKhauNhap)) {
        // Proceed to change the password
        this.matKhau = matKhauMoi;
        System.out.println("Mật khẩu đã được thay đổi thành công.");
    } else {
        // Inform the user about incorrect password
        System.out.println("Mật khẩu không chính xác. Vui lòng thử lại.");
    }
}
    

    // Nạp tiền vào tài khoản
    public void napTien(double soTien) {
        if (soTien > 0) {
            soDu += soTien;
            System.out.println("Nạp thành công " + soTien + " VND vào tài khoản. Số dư hiện tại: " + soDu + " VND.");
        } else {
            System.out.println("Số tiền nạp vào phải lớn hơn 0.");
        }
    }

    // Hiển thị số dư tài khoản
    public void hienThiSoDu() {
        System.out.println("Số dư tài khoản hiện tại: " + soDu + " VND.");
    }

    public abstract void rutTien(double soTien); // Phương thức rút tiền trừu tượng

    // Phương thức trừu tượng cho các tài khoản khác nhau
    public abstract void hienThiThongTin();
}

