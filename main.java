import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Scanner;
import java.util.InputMismatchException;

public class main{
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Tạo tài khoản tiết kiệm
        taikhoantietkiem tkTietKiem = new taikhoantietkiem("123456789", "Buu", 20000000, "nbkvipro123", 3.0);

        // Tạo tài khoản thanh toán
        taikhoanthanhtoan tkThanhToan = new taikhoanthanhtoan("123456789", "Buu", 20000000, "nbkvipro123",1000000);

        while (true) {
            try {
                System.out.println("\n--- Quan li tai khoan ---");
                System.out.println("1. Dang nhap tai khoan tiet kiem ");
                System.out.println("2. Dang nhap tai khoan thanh toan");
                System.out.println("3. Thoat");
                System.out.print("Chon chuc nang: ");
                int chon = scanner.nextInt();
                scanner.nextLine(); // Đọc kí tự xuống dòng sau khi nhập số

                switch (chon) {
                    case 1:
                        quanLyTaiKhoan(tkTietKiem);
                        break;
                    case 2:
                        quanLyTaiKhoan(tkThanhToan);
                        break;
                    case 3:
                        System.out.println("Chuong trinh ket thuc.");
                        return;
                    default:
                        System.out.println("Lua chon khong hop le. Vui long thu lai.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Vui long nhap so hop le.");
                scanner.nextLine(); // Đọc kí tự còn lại trong scanner
            }
        }
    }

    // Quản lý tài khoản chung cho các loại tài khoản
    public static void quanLyTaiKhoan(TaiKhoan taiKhoan) {
        System.out.print("Nhap mat khau: ");
        String matKhauNhap = scanner.nextLine();

        if (taiKhoan.xacThucMatKhau(matKhauNhap)) {
            System.out.println("Dang nhap thanh cong!");

            // Hiển thị số tài khoản và chủ tài khoản
            System.out.println("So tai khoan: " + taiKhoan.getSoTaiKhoan());
            System.out.println("Chu tai khoan: " + taiKhoan.getChuTaiKhoan());

            taiKhoan.hienThiThongTin(); // Hiển thị thêm các thông tin tài khoản khác
            
            while (true) {
                try {
                    System.out.println("\n--- Chon chuc nang ---");
                    System.out.println("1. Nap tien");
                    System.out.println("2. Rut tien");
                    if (taiKhoan instanceof taikhoantietkiem) {
                        System.out.println("3. Tinh lai");
                    } else if (taiKhoan instanceof taikhoanthanhtoan) {
                        System.out.println("3. Thanh toan");
                    }
                    System.out.println("4. Thay doi mat khau");
                    System.out.println("5. Quay lai");
                    System.out.print("Chon chuc nang: ");
                    int luaChon = scanner.nextInt();
                    scanner.nextLine(); // Đọc kí tự xuống dòng

                    switch (luaChon) {
                        case 1:
                            System.out.print("Nhap so tien muon nap: ");
                            double soTienNap = scanner.nextDouble();
                            taiKhoan.napTien(soTienNap);
                            break;
                        case 2:
                            System.out.print("Nhap so tien muon rut: ");
                            double soTienRut = scanner.nextDouble();
                            taiKhoan.rutTien(soTienRut);
                            break;
                        case 3:
                            if (taiKhoan instanceof taikhoantietkiem) {
                                ((taikhoantietkiem) taiKhoan).tinhLai();
                            } else if (taiKhoan instanceof taikhoanthanhtoan) {
                                System.out.print("Nhap so tien muon thanh toan: ");
                                double soTienThanhToan = scanner.nextDouble();
                                ((taikhoanthanhtoan) taiKhoan).rutTien(soTienThanhToan);
                            }
                            break;
                        case 4:
                            System.out.print("Nhap mat khau moi: ");
                            String matKhauMoi = scanner.nextLine();
                            taiKhoan.thayDoiMatKhau(matKhauMoi);
                            break;
                        case 5:
                            return;
                        default:
                            System.out.println("Lua chon khong hop le, vui long thu lai.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Vui long nhap thong tin hop le.");
                    scanner.nextLine(); // Đọc kí tự còn lại
                }
            }
        } else {
            System.out.println("Mat khau khong chinh xac.");
        }
    }
}
