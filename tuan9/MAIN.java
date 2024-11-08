package TAI_KHOAN;
import java.util.Scanner;
public class MAIN 
{
    public static boolean kiemTraMatKhauHopLe(String matKhau) 
    {
        return matKhau.length() >=5 &&
                matKhau.matches(".*\\d.*") && 
                matKhau.matches(".*[a-zA-Z].*") &&
                matKhau.matches(".*[!@#$%^&*()].*");
    }
    
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        DANHSACHTAIKHOAN DS= new DANHSACHTAIKHOAN();

        String stk;
        String chutk;
        String soDienThoai;
        String matkhau;
        int count;

        while(true)
        {
            System.out.println("""
                1. Dang ky tai khoan
                2. Dang nhap tai khoan
                3. Quen mat khau
                4. Dang xuat
                Moi ban nhap vao lua chon
            """);
            int luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon)
            {
                case 1:
                    System.out.println("""
                        1. Tai khoan tiet kiem
                        2. Tai khoan thanh toan
                        Moi ban nhap vao su lua chon: 
                    """);
                    int type =sc.nextInt();
                    sc.nextLine();
                    if(type==1)
                    {
                        System.out.println("Nhap vao so tai khoan: ");
                        stk = sc.nextLine();
                        System.out.println("Nhap vao ten tai khoan: ");
                        chutk = sc.nextLine();
                        System.out.println("Nhap vao so dien thoai: ");
                        soDienThoai = sc.nextLine();
                        System.out.println("Nhap vao mat khau: ");
                        matkhau =sc.nextLine();

                        count=1;
                        if(!DS.kiemTraTrung(stk, chutk))
                        {
                            if(!kiemTraMatKhauHopLe(matkhau))
                            {
                                while(count<=5 && !kiemTraMatKhauHopLe(matkhau))
                                {
                                    System.out.println("Mat khau cua ban chua du manh va khong hop le.");
                                    System.out.println("Tao lai mat khau: ");
                                    matkhau =sc.nextLine();
                                    if(kiemTraMatKhauHopLe(matkhau))
                                    {
                                        System.out.println("Nhap lai suat: ");
                                        double laiSuat =sc.nextDouble();
                                        System.out.println("Nhap ki han(thang): ");
                                        int kyHan =sc.nextInt();
                                        TAIKHOANTIETKIEM tktk=new TAIKHOANTIETKIEM(stk,chutk,50000, matkhau,soDienThoai,laiSuat,kyHan);
                                        DS.themTK(tktk);
                                        System.out.println("Tai khoan moi dang ky la: ");
                                        System.out.println("so tai khoan: "+stk);
                                        System.out.println("ten tai khoan: "+chutk);
                                        System.out.println("so du: "+50000);
                                        System.out.println("So dien thoai: "+soDienThoai);
                                        System.out.println("Lai suat: "+laiSuat);
                                        break;
                                    }
                                    else    
                                        count++;
                                }
                                if(count>5)
                                    System.out.print("Tao tai khoan khong thanh cong.");
                            }
                            else
                            {
                                System.out.print("Nhap lai suat :");
                                double laiSuat = sc.nextDouble();
                                System.out.print("Nhap ky han: ");
                                int kiHan = sc.nextInt();
                                TAIKHOANTIETKIEM tktk = new TAIKHOANTIETKIEM(stk, chutk, 50000,matkhau, soDienThoai, laiSuat, kiHan);
                                DS.themTK(tktk);
                                System.out.println("Dang ky tai khoan thanh cong!"); 
                                System.out.println("Tai khoan moi dang ky la: ");
                                System.out.println("so tai khoan: "+stk);
                                System.out.println("ten tai khoan: "+chutk);
                                System.out.println("so du: "+50000);
                                System.out.println("So dien thoai: "+soDienThoai);
                                System.out.println("Lai suat: "+laiSuat);
                            }
                        }
                        // Đăng ký tài khoản thanh toán
                        else if(type==2)
                        {
                            System.out.println("Nhap so tai khoan thanh toan: ");
                            stk = sc.nextLine();
                            System.out.println("Nhap ten tai khoan thanh toan:");
                            chutk = sc.nextLine();
                            System.out.print("Nhap vao so dien thoai: ");
                            soDienThoai =sc.nextLine();
                            System.out.print("Nhap mat khau cho tai khoan: ");
                            matkhau = sc.nextLine();
                            count=1;
                            if(!DS.kiemTraTrung(stk, chutk))
                            {
                                if(!kiemTraMatKhauHopLe(matkhau))
                                {
                                    while(count<=5 && !kiemTraMatKhauHopLe(matkhau))
                                    {
                                        System.out.println("Mat khau cua ban chua du manh.");
                                        System.out.println("Tao lai mat khau: ");
                                        matkhau=sc.nextLine();
                                        if(kiemTraMatKhauHopLe(matkhau))
                                        {
                                            System.out.println("Nhap vao phi duy tri: ");
                                            double phiDuyTri = sc.nextDouble();
                                            TAIKHOANTHANHTOAN tktt = new TAIKHOANTHANHTOAN(stk, chutk, 50000, matkhau, soDienThoai, phiDuyTri);
                                            DS.themTK(tktt);
                                            System.out.println("Dang ky tai khoan thanh cong.");
                                        }
                                    }
                                }
                                else
                                {
                                    System.out.println("Nhap vao phi duy tri: ");
                                    double phiDuyTri = sc.nextDouble();
                                    TAIKHOANTHANHTOAN tktt = new TAIKHOANTHANHTOAN(stk, chutk, 50000, matkhau, soDienThoai, phiDuyTri);
                                    DS.themTK(tktt);
                                    System.out.println("Dang ky tai khoan thanh cong.");
                                }
                            }
                            else
                                System.out.print("so tai khoan da ton tai.");
                        }

                    }
                    break;
                case 2:
                {
                    System.out.println("Nhap tai khoan can dang nhap: ");
                    stk=sc.nextLine();
                    TAIKHOAN tk=DS.timTaikhoan(stk);
                    if(tk!=null)
                    {
                        System.out.println("Nhap mat khau tai khoan can dang nhap: ");
                        matkhau = sc.nextLine();

                        int dem=1;
                        while(!tk.kiemTraMatKhau(matkhau))
                        {
                            dem++;
                            System.out.printf("Mat khau sai. Nhap lai mat khau tai khoan");
                            matkhau=sc.nextLine();
                            if(dem > 3)
                                break;
                        }
                        if(tk.kiemTraMatKhau(matkhau))
                        {
                            System.out.println("So tai khoan: "+tk.getstk());
                            System.out.println("ten tai khoan: "+tk.chutk);
                            while(true)
                            {
                                System.out.println("\n1.Nap tien");
                                System.out.println("2.Rut tien");
                                System.out.println("3.Chuyen khoan");
                                System.out.println("4.Xem so du");
                                System.out.println("5.Doi mat khau");
                                if(tk instanceof TAIKHOANTIETKIEM)
                                {
                                    System.out.println("""
                                        6.Tinh lai
                                        7.Tinh lai so tien gui tu tai khoan thanh toan
                                    """);
                                }
                                if(tk instanceof TAIKHOANTHANHTOAN)
                                {
                                    System.out.println("""
                                        8.Xem han muc tin dung
                                        9.Rut tien tu tai khoan thanh toan
                                        10.Gui tien vao tai khoan tiet kiem
                                    """);
                                }
                                System.out.println("11.Dang xuat");
                                System.out.println("nhap vao su lua chon: ");
                                int n=sc.nextInt();
                                sc.nextLine();
                                switch(n)
                                {
                                    case 1:
                                        System.out.println("Nhap so tien can nap: ");
                                        double tienNap=sc.nextDouble();
                                        tk.napTien(tienNap);
                                        System.out.println("so tien trong tai khoan la: "+tk.getSodu());
                                        break;
                                    case 2:
                                        System.out.println("Nhap so tien can rut: ");
                                        double tienRut =sc.nextDouble();
                                        int lan=1;
                                        if(tk.getSodu() >= tienRut)
                                        {
                                            tk.rutTien(tienRut);
                                            System.out.println("so tien trong tai khoan la: "+tk.getSodu());
                                        }
                                        else
                                            System.out.print("so du khong du de rut");
                                        break;
                                    case 3:
                                        System.out.println("Nhap so tai khoan nhan: ");
                                        String stkNhan =sc.nextLine();
                                        TAIKHOAN tkNhan = DS.timTaikhoan(stkNhan);

                                        if(tkNhan!=null)
                                        {
                                            System.out.println("Tai khoan nhan:"+tkNhan.getstk()+tkNhan.chutk);
                                            System.out.println("Nhap so tien can chuyen: ");
                                            double tienChuyen =sc.nextDouble();
                                            tk.chuyenTien(tkNhan, tienChuyen);
                                        }
                                        else
                                            System.out.print("khong tim thay tai khoan nhan");
                                        break;
                                    case 4:
                                        System.out.println("so du hien tai cua ban la: "+tk.getSodu());
                                        break;
                                    case 5:
                                        tk.doiMatKhau();
                                        break;
                                    case 6:
                                        if(tk instanceof TAIKHOANTIETKIEM)
                                        {
                                            TAIKHOANTIETKIEM tktk = (TAIKHOANTIETKIEM) tk;
                                            tktk.Nhap();
                                            System.out.println("tinh lai gop hang thang ");
                                            tktk.tinhLaiGopHangThang();
                                            tktk.laiDon();
                                            tktk.laiKep();
                                        }
                                        else
                                            System.out.print("Khong ton tai tai khoan tiet kiem.");
                                        break;
                                    case 7:
                                        if(tk instanceof TAIKHOANTIETKIEM)
                                        {
                                            double lai=((TAIKHOANTIETKIEM)tk).tinhLaiGanNhat();
                                        }
                                        else
                                            System.out.print("Khong ton tai tai khoan tiet kiem");
                                        break;
                                    case 8:
                                        if(tk instanceof TAIKHOANTHANHTOAN)
                                        {
                                            TAIKHOANTHANHTOAN tktt=(TAIKHOANTHANHTOAN) tk;
                                            System.out.println("Han muc tin dung cua ban la: "+tktt.getHanMucTinDung());
                                        }
                                        else
                                            System.out.print("Khong ton tai tai khoan thanh toan.");
                                        break;
                                    case 9:
                                        if(tk instanceof TAIKHOANTHANHTOAN)
                                        {
                                            TAIKHOANTHANHTOAN tktt = (TAIKHOANTHANHTOAN) tk;
                                            System.out.println("Nhap so tien ban muon rut: ");
                                            double tienRutt =sc.nextDouble();
                                            sc.nextLine();
                                            tktt.rutTien(tienRutt);
                                            if(tktt.getSoNo()>0)
                                            {
                                                System.out.println("ban hien co so no: "+tktt.getSoNo());
                                                System.out.println("""
                                                    ban co muon nap tien vao so du de tra no khong
                                                    1.Co
                                                    2.Khong
                                                        """);
                                                int choice =sc.nextInt();
                                                sc.nextLine();
                                                if(choice==1)
                                                {
                                                    System.out.println("Nhap so tien nap: ");
                                                    double tienNapp = sc.nextDouble();
                                                    sc.nextLine();
                                                    tktt.napTien(tienNapp);
                                                }
                                                else if(choice==2)
                                                {
                                                    System.out.println("Giao dich bi huy");
                                                }
                                            }
                                            else
                                                System.out.print("Ban khong co so no.");
                                        }
                                        else
                                            System.out.print("Tai khoan thanh toan khong ton tai");
                                        break;
                                    case 10:
                                        if(tk instanceof TAIKHOANTHANHTOAN)
                                        {
                                            System.out.println("Nhap vao so tai khoan tiet kiem: ");
                                            String stktietkiem = sc.nextLine();
                                            TAIKHOANTIETKIEM tktk =(TAIKHOANTIETKIEM) DS.timTaikhoan(stktietkiem);
                                            if(tktk!=null)
                                            {
                                                System.out.println("Nhap so tien can gui tiet kiem: ");
                                                double soTienGuiTietKiem = sc.nextDouble();
                                                System.out.println("NHap ky han gui(theo thang): ");
                                                int kyHan = sc.nextInt();
                                                sc.nextLine();

                                                //Gửi tiền vào tài khoản tiết kiệm
                                                if(tktk.guiTietKiem((TAIKHOANTHANHTOAN) tk, soTienGuiTietKiem, kyHan))
                                                    System.out.println("Gui tien vao tai khoan tiet kiem thanh cong!");
                                                else
                                                    System.out.println("So du khong du!");
                                            }
                                        }
                                        else
                                            System.out.println("Khong tim thay so tai khoan tiet kiem!");
                                        break;
                                    case 11:
                                        System.out.println("Ban da chon dang xuat!");
                                        break;
                                    default:
                                        System.out.println("Loi lua chon");
                                        break;
                                }
                            }
                        }
                        else
                            System.out.print("Tai khoan khong hop le.");
                    }
                    else
                        System.out.println("Tai khoan khong ton tai.");
                    break;
                }
                case 3:
                {
                    System.out.println("Nhap so tai khoan quen mat khau: ");
                    stk =sc.nextLine();
                    TAIKHOAN tk=DS.timTaikhoan(stk);
                    if(tk!=null)
                    {
                        tk.quenMatKhau();
                    }
                    else
                        System.out.print("Tai khoan khong ton tai.");
                    break;
                }
                case 4:
                    System.out.println("Ban da chon dang xuat");
                    break;
                default:
                    System.out.println("Loi lua chon.");
                    break;

            }
        }
    }
}
