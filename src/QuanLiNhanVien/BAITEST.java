/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLiNhanVien;

/**
 *
 * @author HP
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class BAITEST {
    public static void main(String[] args) {
        DANHSACHNHANVIEN ds= new DANHSACHNHANVIEN();
	Scanner sc=new Scanner(System.in);
        int menuitem;	
	do{
		System.out.println("1. Nhap nhan vien");
		System.out.println("2. Xuat nhan vien");
		System.out.println("3. Sua nhan vien");
		System.out.println("4. Xoa nhan vien");
		System.out.println("5. Tinh tong quy luong");
		System.out.println("6. Ghi file");
		System.out.println("7. Doc file");	
		System.out.println("Nhap cac chuc nang tu 1->5:");
		menuitem= Integer.parseInt(sc.nextLine());
		switch (menuitem) {
		case 1:{
                    int N;
                    System.out.print("Nhap so nhan vien");		
                    N=Integer.parseInt(sc.nextLine());	
                    for(int i= 1;i<=N;i++){
                        System.out.println("Nhap nhan vien thu "+i+" :");
                        ds.Nhap();
                     }
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
                        System.out.print("Doc file:");
                        ds.ReadFile();
                    }catch (Exception e) {
                        // TODO: handle exception
                    }
                    break;		
		}			
	 }		
	}while(menuitem!=0);
	

}
}