/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLiNhanVien;

/**
 *
 * @author HP
 */
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
public class BAITAP {
	static DANHSACHNHANVIEN ds;
	static Scanner sc=new Scanner(System.in);
	public static void Menu()
	{
		System.out.println("1. Nhap nhan vien");
		System.out.println("2. Xuat nhan vien");
		System.out.println("3. Sua nhan vien");
		System.out.println("4. Xoa nhan vien");
		System.out.println("5. Tinh tong quy luong");
		System.out.println("6. Ghi file");
		System.out.println("7. Doc file");
		int menuitem;		
		System.out.println("Nhap cac chuc nang tu 1->5:");
		menuitem= Integer.parseInt(sc.nextLine());
		switch (menuitem) {
		case 1:{
			int N;
			System.out.print("Nhap so nhan vien");		
			N=Integer.parseInt(sc.nextLine());	
			ds=new DANHSACHNHANVIEN();
			ds.Nhap();
			break;
		}
		case 2:{
		     ds.Xuat();
		     break;
		}
		case 3:{
                    ds.Sua();
                    break;
		}
		case 4:{
			
			System.out.print("Nhap ma nhan vien can xoa:");
			String manv=sc.nextLine();
			ds.Xoa(manv);
			break;			
		}
		case 5:{
			System.out.print("Tong quy luong:"+ds.Thongke());
			break;
		}
		case 6:{
			System.out.print("Ghi file");
			ds.WriteFile();
			break;		
		}
		case 7:{
			try {
			 Path path = Paths.get("QUANLYNHANVIEN.txt");
			 long lines =  Files.lines(path).count();
			 int N=(int)lines;
			 ds=new DANHSACHNHANVIEN();
			System.out.print("Doc file");
			ds.ReadFile();
			}catch (Exception e) {
				// TODO: handle exception
			}
			break;		
		}			
	 }		
	}
	public static void main(String[] args) {		
		
		char c='y';
		while(c=='Y'||c=='y')
		{
			Menu();
			System.out.print("Nhan phim y/Y tro ve Menu va phim bat ky de ket thuc");
			 
			c=sc.nextLine().charAt(0);			
		}				
	}
}