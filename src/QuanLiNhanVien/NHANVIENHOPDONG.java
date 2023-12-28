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

public class NHANVIENHOPDONG extends NHANVIEN
{
	private double mucluong;	

	public double getMucluong() {
		return mucluong;
	}
	public void setMucluong(double mucluong) {
		this.mucluong = mucluong;
	}
	public NHANVIENHOPDONG() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NHANVIENHOPDONG(String manv, String hoten, String gioitinh, Date ngaysinh, long soCM, Date ngayvaocoquan,
			double mucluong) {
		super(manv, hoten, gioitinh, ngaysinh, soCM, ngayvaocoquan);
		this.mucluong = mucluong;
	}
	
	
	@Override
	public double tinhPhuCap() {
		 if(super.tinhThamnien()>2)
			 return (this.mucluong * 0.1 + 100000);
		 else 
			 return (this.mucluong * 0.1 + 100000);		
	}
	@Override
	public double tinhThucLinh() {
		return (this.mucluong+super.Luongcoban+this.tinhPhuCap());
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Ma Nhan vien:"+super.getManv()+ "\r\n Ho ten:"+super.getHoten()
		+ "\r\n Gioi tinh:"+super.getGioitinh() 
		+ "\r\n Ngay sinh:"+super.getNgaysinh().toString()
		+ "\r\n Muc luong:"+ this.getMucluong()		
		+ "\r\n Phu cap:"+this.tinhPhuCap()
		+ "\r\n Thuc linh:"+this.tinhThucLinh();
	}
	 public void Xuat(){
		 super.Xuat();
		
		 System.out.println("Muc luong:"+String.valueOf(this.mucluong));
		 System.out.println("Phu cap:"+String.valueOf(this.tinhPhuCap()));
		 System.out.println("Thuc linh:"+String.valueOf(this.tinhThucLinh()));		 
	 }
	 public void Nhap(){
		 super.Nhap();
		 System.out.print("muc luong");
		 this.mucluong= Double.parseDouble(super.sc.nextLine());		 
	 }
}