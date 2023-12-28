/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLiNhanVien;

/**
 *
 * @author HP
 */
import java.util.Date;

public class NHANVIENBC extends NHANVIEN  {

	private double Hesoluong;
	public double getHesoluong() {
		return Hesoluong;
	}
	
	
	@Override
	public double tinhPhuCap() {
	 if(super.tinhThamnien()>10)
		 return (Luongcoban * 0.1 + 500000);
	 else 
		 return (Luongcoban * 0.1 + 200000);		
	}
	
	@Override
	public double tinhThucLinh() {
		return (this.Hesoluong*Luongcoban +this.tinhPhuCap());
	}

	public NHANVIENBC() {

	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Ma Nhan vien:"+super.getManv()+ "\r\n Ho ten:"+super.getHoten()
		+ "\r\n gioi tinh:"+super.getGioitinh() 
		+ "\r\n Ngay sinh:"+super.getNgaysinh().toString()
		+ "\r\n He so luong:"+ this.getHesoluong()		
		+ "\r\n phu cap:"+this.tinhPhuCap()
		+ "\r\n thuc linh:"+this.tinhThucLinh();
	}


	public NHANVIENBC(String manv, String hoten, String gioitinh, Date ngaysinh, long soCM, Date ngayvaocoquan,
			double hesoluong) {
		super(manv, hoten, gioitinh, ngaysinh, soCM, ngayvaocoquan);
		Hesoluong = hesoluong;
	}	


	 public void Xuat(){
		 super.Xuat();
		 System.out.println("Luong Co Ban:"+String.valueOf(this.Luongcoban));
		 System.out.println("He so luong:"+String.valueOf(this.Hesoluong));
		 System.out.println("Phu cap:"+String.valueOf(this.tinhPhuCap()));
		 System.out.println("Thuc linh:"+String.valueOf(this.tinhThucLinh()));		 
	 }
	 public void Nhap(){
		super.Nhap();
		 System.out.print("He so luong");
		 this.Hesoluong= Double.parseDouble(super.sc.nextLine());				 
		
	 }
   
}