/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLiNhanVien;

/**
 *
 * @author HP
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public abstract class NHANVIEN implements INHANVIEN 
{
	private String Manv;	
	private String Hoten;
	private String Gioitinh;
	private Date Ngaysinh;
	private long SoCM;
	private Date Ngayvaocoquan;		
	public String getManv() {
		return Manv;
	}
	public void setManv(String manv) {
		Manv = manv;
	}
	public String getHoten() {
		return Hoten;
	}
	public void setHoten(String hoten) {
		Hoten = hoten;
	}
	public String getGioitinh() {
		return Gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		Gioitinh = gioitinh;
	}
	public Date getNgaysinh() {
		return Ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		Ngaysinh = ngaysinh;
	}
	public long getSoCM() {
		return SoCM;
	}
	public void setSoCM(long soCM) {
		SoCM = soCM;
	}
	public Date getNgayvaocoquan() {
		return Ngayvaocoquan;
	}
	public void setNgayvaocoquan(Date ngayvaocoquan) {
		Ngayvaocoquan = ngayvaocoquan;
	}
	protected Scanner sc;	
	public NHANVIEN() {
		super();
		this.sc=new Scanner(System.in);
	}
	public NHANVIEN(String manv, String hoten, String gioitinh, Date ngaysinh, long soCM, Date ngayvaocoquan){
		super();
		Manv = manv;
		Hoten = hoten;
		Gioitinh = gioitinh;
		Ngaysinh = ngaysinh;
		SoCM = soCM;
		Ngayvaocoquan = ngayvaocoquan;
		this.sc=new Scanner(System.in);
	}
	protected int tinhThamnien() {
		Calendar cl_NgayVao=new GregorianCalendar();
		cl_NgayVao.setTime(this.Ngayvaocoquan);
		Calendar cl_Ngayhientai=new GregorianCalendar();
		cl_Ngayhientai.setTime(Calendar.getInstance().getTime());		
		return (cl_Ngayhientai.get(Calendar.YEAR)-cl_NgayVao.get(Calendar.YEAR));		
	}
	public  void Nhap()
	{
		try {
		System.out.print("Nhap ma nhan vien:");
		this.Manv=this.sc.nextLine();
		System.out.print("Nhap ho ten:");
		this.Hoten=this.sc.nextLine();		
		System.out.print("Nhap gioi tinh:");
		this.Gioitinh=this.sc.nextLine();
		System.out.print("Nhap so chung minh:");
		this.SoCM=Long.parseLong(this.sc.nextLine());
		DateFormat d=new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Nhap ngay sinh:");
		this.Ngaysinh=d.parse(this.sc.nextLine());
		System.out.print("Nhap ngay vao co quan:");
		this.Ngayvaocoquan=d.parse(this.sc.nextLine());
		}
		catch(Exception ex)
		{ }
		
	}	
	public void Xuat(){
		 System.out.println("Luong Co Ban:"+String.valueOf(this.Luongcoban));
		System.out.println("Ma sinh vien:"+this.Manv);	
		System.out.println("Ho ten:"+this.Hoten);		
		System.out.println("Gioi tinh:"+this.Gioitinh);		
		System.out.println("So chung minh:"+String.valueOf(this.SoCM));		
		System.out.println("Nhap ngay sinh:"+this.Ngaysinh.toString());		
	}	
	public abstract String toString();	
}