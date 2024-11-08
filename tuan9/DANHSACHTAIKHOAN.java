package TAI_KHOAN;
import java.util.Hashtable;
public class DANHSACHTAIKHOAN {
    //tạo một đối tượng Hashtable có tên DS
    Hashtable<String, TAIKHOAN> DS = new Hashtable<>();

    public DANHSACHTAIKHOAN(){ }
    public void themTK(TAIKHOAN tk)
    {
        this.DS.put(tk.getstk(), tk);
    }
    public void intk()
    {
        //Lấy tất cả các giá trị từ Hashtable DS.
        //Sử dụng vòng lặp forEach để duyệt qua từng đối tượng o trong tập giá trị vừa lấy được
        this.DS.values().forEach(o -> o.inTK());
    }
    public boolean kiemTraTrung(String stk,String tenTk)
    {
        // Kiểm tra xem số tài khoản đã tồn tại trong DS hay chưa
        if(DS.containsKey(stk))
        {
            System.out.println("so tai khoan da ton tai!");
            return true;
        }
        // Duyệt qua tất cả các giá trị (TAIKHOAN) trong DS
        for(TAIKHOAN tk: DS.values())
        {
            //Kiểm tra tên chủ tài khoản có trùng với tenTk không (không phân biệt hoa thường)
            if(tk.chutk.equalsIgnoreCase(tenTk))
            {
                return true;
            }
        }
        return false;
    }
    public TAIKHOAN timTaikhoan(String stk)
    {
        return this.DS.get(stk);
    }
    public void inTKTT()
    {
        boolean  tktt = false;
        for(TAIKHOAN tk:this.DS.values())
        {
            if("Tai khoan thanh toan".equals(tk.getType()))
            {
                tk.inTK();
                tktt = true;
            }
        }
        if (!tktt)
            System.out.println("Danh sach tai khoan thanh toan rong.");
    }
    public void inTKTK()
    {
        boolean tktk = false;
        for(TAIKHOAN tk: this.DS.values())
        {
            if("Tai khoan tiet kiem".equals(tk.getType()))
            {
                tk.inTK();
                tktk=true;
            }
        }
        if(!tktk)
            System.out.println("Dan sach tai khoan tiet kiem rong.");
    }
}
