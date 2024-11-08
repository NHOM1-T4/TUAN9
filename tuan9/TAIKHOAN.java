package TAI_KHOAN;
import java.util.Random;
import java.util.Scanner;
public abstract class TAIKHOAN {
    private String stk;
    public String chutk;
    protected double sodu;
    private String matkhau;
    private String soDienThoai;
    Scanner sc=new Scanner(System.in);
    TAIKHOAN(){    }
    public TAIKHOAN(String stk, String chutk, double sodu, String matkhau,String soDienThoai) {
        this.stk = stk;
        this.chutk = chutk;
        this.sodu = 50000;
        this.matkhau = matkhau;
        this.soDienThoai=soDienThoai;
    }
    public String getstk()
    {
        return this.stk;
    }
    public double getSodu()
    {
        return this.sodu;
    }
    public String getsoDienThoai()
    {
        return this.soDienThoai;
    }
    public static boolean kiemTraMatKhauManh(String matKhau) 
    {
        return matKhau.length() >=5 &&
                matKhau.matches(".*\\d.*") && 
                matKhau.matches(".*[a-zA-Z].*") &&
                matKhau.matches(".*[!@#$%^&*()].*");
    }
    public boolean kiemTraMatKhau(String matKhau)
    {
        return this.matkhau.equals(matKhau);
    }
    // Phương thức đổi mật khẩu
    public void doiMatKhau()
    {
        System.out.println("nhap mat khau cu: ");
        String matKhauCu = sc.nextLine();
        if(kiemTraMatKhau(matKhauCu))
        {
            System.out.println("nhap mat khau moi: ");
            String matKhauMoi = sc.nextLine();
            if(kiemTraMatKhauManh(matKhauMoi))
            {
                matkhau = matKhauMoi;
                System.out.println("doi mat khau thanh cong");
            }
            else
                System.out.println("mat khau moi khong du manh");
        }
        else    
            System.out.println("mat khau cu khong chinh xac");
    }
    public void napTien(double tienNap)
    {
        if(tienNap>=0)
        {
            this.sodu += tienNap;
            System.out.println("Nap tien thanh cong!");
        }
        else
            System.out.print("so tien nap khong hop le!");
    }
    public abstract void rutTien(double tienRut);
    public void inTK()
    {
        System.out.println("so tai khoan: "+stk);
        System.out.println("ten tai khoan: "+chutk);
        System.out.println("so du: "+sodu);
    }
    public void chuyenTien(TAIKHOAN tkNhan,double soTien)
    {
        if(this.sodu >=soTien)
        {
            if(soTien>0)
            {
                this.sodu -= soTien;
                tkNhan.sodu += soTien;
                System.out.println("Chuyen tien thanh cong!");
            }
            else    
                System.out.print("so tien khong hop le!");
        }
        else
            System.out.print("So du khong du!");
    }
    // Phương thức tạo OTP
    public String taoOTP()
    {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        System.out.println("OTP da gui toi so dien thoai "+soDienThoai+": "+otp);
        return String.valueOf(otp);
    }
    // Phương thức quên mật khẩu (OTP)
    public void quenMatKhau()
    {
        String otp = taoOTP();
        System.out.println("nhap ma OTP: ");
        String otpNhap = sc.nextLine();
        if(otp.equals(otpNhap))
        {
            System.out.println("nhap mat khau moi: ");
            String matKhauMoi = sc.nextLine();
            if(kiemTraMatKhauManh(matKhauMoi))
            {
                matkhau = matKhauMoi;
                System.out.println("doi mat khau thanh cong");
            }
            else   
                System.out.println("mat khau moi khong du manh");
        }
        else
            System.out.println("OTP khong chinh xac");
    }
    public abstract String getType();
}
