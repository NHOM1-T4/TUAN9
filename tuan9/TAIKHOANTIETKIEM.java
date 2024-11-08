package TAI_KHOAN;
import java.util.Scanner;
public class TAIKHOANTIETKIEM extends TAIKHOAN {
    private int soNamGui;
    private int tongSoThang;
    private double laiSuat;
    private int kyHan; //Kì hạn gửi tiền theo tháng
    private double soTienTietKiemGui;
    private double soTienGuiGanNhat;
    private int kyHanGanNhat;
    Scanner sc=new Scanner(System.in);

    public TAIKHOANTIETKIEM(String stk, String chutk, double sodu,String matkhau, String soDienThoai, double laiSuat, int kyHan) {
        super(stk,chutk,sodu,matkhau,soDienThoai);
        this.laiSuat = laiSuat;
        this.kyHan = kyHan;
    }

    public int getSoNamGui() {
        return soNamGui;
    }

    public void setSoNamGui(int soNamGui) {
        this.soNamGui = soNamGui;
    }

    public double getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(double laiSuat) {
        this.laiSuat = laiSuat;
    }

    public int getKyHan() {
        return kyHan;
    }

    public void setKyHan(int kyHan) {
        this.kyHan = kyHan;
    }

    public double getSoTienTietKiemGui() {
        return soTienTietKiemGui;
    }

    public void setSoTienTietKiemGui(double soTienTietKiemGui) {
        this.soTienTietKiemGui = soTienTietKiemGui;
    }

    public void Nhap()
    {
        System.out.println("Nhap so tien can gui tiet kiem: ");
        this.soTienTietKiemGui = sc.nextDouble();
        System.out.println("Nhap so nam gui: ");
        this.soNamGui = sc.nextInt();
        if(getSodu() >= this.soTienTietKiemGui)
            sodu -= this.soTienTietKiemGui;
        else    
            System.out.println("so du khong du de gui tien!");
    }    
    public void tinhLaiGopHangThang()
    {
        double soDuTietKiem = this.soTienTietKiemGui;
        tongSoThang = soNamGui*12;

        System.out.println("Tinh la gop hang thang: ");
        for(int thang=1; thang<=tongSoThang;thang++)
        {
            double tienLaiThang = soDuTietKiem * (laiSuat/12);
            soDuTietKiem += tienLaiThang;

            System.out.println("Thang "+thang+" so tien lai la "+tienLaiThang);
            System.out.println("so du sau thang "+thang+" la: "+soDuTietKiem);
        }
        //Cộng tổng số tiền sau kỳ hạn vào tài khoản chính
        sodu += soDuTietKiem;
        System.out.println("Tong so du trong tai khoan sau ky han "+soNamGui+" la: "+sodu);
    }
    //Phương thức tính lãi đơn và lãi kép vẫn được giữ lại
    public void laiDon()
    {
        double tienLaiDon = this.soTienTietKiemGui * (1 + this.laiSuat * this.soNamGui);
        System.out.println("So tien lai don: "+tienLaiDon);
        sodu += tienLaiDon;
    }
    public void laiKep()
    {
        double tienLaiKep = this.soTienTietKiemGui * Math.pow((1 + this.laiSuat), this.soNamGui);
        System.out.println("So tien lai kep: "+tienLaiKep);
        sodu += tienLaiKep;
    }

    public boolean guiTietKiem(TAIKHOANTHANHTOAN taiKhoanThanhToan, double soTienGui, int kyHan)
    {
        if(taiKhoanThanhToan.getSodu()>=soTienGui)
        {
            taiKhoanThanhToan.rutTien(soTienGui);
            this.soTienTietKiemGui+=soTienGui;
            this.soTienGuiGanNhat = soTienGui;
            this.kyHanGanNhat=kyHan;
            return true;
        }
        else
            return false;
    }

    public double tinhLaiGanNhat()
    {
        double lai = 0;

        double laiSuat=0;
        if(kyHanGanNhat <=3 )
            laiSuat=3;
        else if(kyHanGanNhat <= 6)
            laiSuat=4;
        else if(kyHanGanNhat<=12)
            laiSuat=5;
        else
            laiSuat=6;
        if(soTienGuiGanNhat>0)
        {
            lai = soTienGuiGanNhat * (laiSuat*0.01) * kyHanGanNhat;
            System.out.printf("Lai suat cho so tien"+soTienGuiGanNhat+" voi ky han"+kyHan+ " thang va lai suat "+laiSuat+" la: "+lai);
        }
        else
            System.out.println("Chua co so tien gui nao!");
        return lai;
    }
    @Override
    public void inTK()
    {
        super.inTK();
        System.out.println("Lai suat: "+laiSuat);
        System.out.println("so tien tiet kiem: "+soTienTietKiemGui);
    }

    @Override
    public void rutTien(double tienRut)
    {
        if(this.soTienTietKiemGui >= tienRut)
        {
            this.soTienTietKiemGui -= tienRut;
            System.out.println("Ban da rut tien thanh cong!");
        }
        else
            System.out.println("so tien trong tai khoan tiet kiem khong du!");
    }

    @Override
    public String getType()
    {
        return "Tai khoan tiet kiem";
    }
}
