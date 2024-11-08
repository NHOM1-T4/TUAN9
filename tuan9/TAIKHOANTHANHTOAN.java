package TAI_KHOAN;
import java.util.Scanner;
public class TAIKHOANTHANHTOAN extends TAIKHOAN{
    private double hanMucTinDung;
    private double soNo;
    Scanner sc=new Scanner(System.in);
    public TAIKHOANTHANHTOAN(String stk, String chutk, double sodu, String matkhau, String soDienThoai,
            double hanMucTinDung) {
        super(stk, chutk, sodu, matkhau, soDienThoai);
        this.hanMucTinDung = hanMucTinDung;
        this.soNo = 0;
    }

    public double getHanMucTinDung() {
        return hanMucTinDung;
    }

    public void setHanMucTinDung(double hanMucTinDung) {
        this.hanMucTinDung = hanMucTinDung;
    }

    public double getSoNo() {
        return soNo;
    }
    @Override
    public void rutTien(double tienRut)
    {
        if(this.sodu >= tienRut)
        {
            this.sodu -= tienRut;
            System.out.println("Rut tien thanh cong.");
        }
        else if(this.sodu + hanMucTinDung >= tienRut)
        {
            System.out.println("""
                so du cua ban khong du. Ban co muon rut bang han muc tin dung khong?
                1. Co
                2. Khong       
                        """);
            System.out.println("Nhap vao lua chon: ");
            int luaChon = sc.nextInt();
            sc.nextLine();
            if(luaChon ==1)
            {
                double tienRutTuTinDung = tienRut - this.sodu;
                this.sodu=0;
                hanMucTinDung -= tienRutTuTinDung;
                soNo += tienRutTuTinDung;
                System.out.println("""
                    Rut tien thanh cong!
                    Han muc tin dung con lai: 
                """+hanMucTinDung);
                if(hanMucTinDung<=0)
                    System.out.println("Ban da su dung het han muc tin dung!");
            }
            else if(luaChon ==2)
                System.out.print("Giao dich bi huy.");
        }
        else if(this.sodu + hanMucTinDung < tienRut)
            System.out.println("so du va han muc tin dung khong du.");
    }
    public void napTien(double tienNap)
    {
        if(soNo >0)
        {
            double soTienTraNo = Math.min(tienNap,soNo);
            soNo -= soTienTraNo;
            hanMucTinDung += soTienTraNo;
            tienNap -= soTienTraNo;
            System.out.println(" Ban da tra no tu han muc tin dung ");
        }
        //Số tiền còn lại sẽ cộng vào số dư
        if(tienNap>0)
        {
            this.sodu += tienNap;
            System.out.println("so du hien tai cua ban la: "+this.sodu);
        }
        if(soNo==0)
            System.out.print("ban da tra het no.");
    }
    @Override
    public void inTK()
    {
        super.inTK();
        System.out.println("Han muc tin dung: "+hanMucTinDung);
    }
    
    @Override
    public String getType()
    {
        return "Tai khoan thanh toan";
    }
}
