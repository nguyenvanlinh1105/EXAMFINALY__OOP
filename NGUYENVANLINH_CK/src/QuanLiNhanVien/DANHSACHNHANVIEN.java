/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLiNhanVien;

/**
 *
 * @author HP
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

public class DANHSACHNHANVIEN implements IInputOutput {
	
	private Hashtable<String, NHANVIEN> list;

	public DANHSACHNHANVIEN()
	{
            this.list=new Hashtable<String, NHANVIEN>();
	}
	
	public void Nhap()
	{
            Scanner sc=new Scanner(System.in);
            char c='y';
            while(c=='y'|| c=='Y')
		{
                    NHANVIEN nhanvien=null;
		    char k=' ';
		    System.out.print("Nhap ky tu 'B' Nhan vien bien Che va 'H' nhan vien hop dong");
                    k=sc.nextLine().charAt(0);
		    if(k=='B' || k=='b')
		    	nhanvien=new NHANVIENBC();
		    else if(k=='H' || k=='h')
		    	nhanvien=new NHANVIENHOPDONG();			
		        nhanvien.Nhap();
			this.list.put(nhanvien.getManv(),nhanvien);
			System.out.print("Nhap ky tu 'Y' hay 'y' de tiep tuc và phim bat ky de ket thuc");
			c=sc.nextLine().charAt(0);
		}		
	}
	public void Xuat()
	{
            for (NHANVIEN nhanvien :  list.values()) 
                    nhanvien.Xuat();		
	}
	
	public NHANVIEN Tim(String manv)
	{	  
            return this.list.get(manv);
	}
	public void Xoa(String manv)
	{		
            this.list.remove(manv);
	}
	public void MenuEdit()
	 {
            System.out.println("Nhan cac phim tu 1->5");
            System.out.println("1. Ho ten:");
            System.out.println("2. Nam sinh:");
            System.out.println("3. Gioi tinh:");
            System.out.println("4. So chung minh:");
            System.out.println("5. Ngay vao co quang:");		 
	 }
	public void Sua()
	 {
            Scanner sc=new Scanner(System.in);	
            System.out.print("Nhap ma nhan vien can tim");
            String manv=sc.nextLine();
	    NHANVIEN NV=Tim(manv);
            char c='Y';
            while (c=='Y'|| c=='y'){
                MenuEdit();	     
                int item=Integer.parseInt(sc.nextLine());

                switch (item) {
                    case 1: {
                            System.out.println("1. Nhap ho ten can sua");
                            String hoten=sc.nextLine();
                            NV.setHoten(hoten);
                    }
                    case 2: {	
                        try {
                            System.out.println("2. Nhap ngay sinh can sua:");			
                           SimpleDateFormat d=new SimpleDateFormat("dd/MM/yyyy");
                           Date ngaysinh=d.parse(sc.nextLine());
                           NV.setNgaysinh(ngaysinh);
                       } catch (Exception e) {
                                   // TODO: handle exception
                           }
                    }
                    case 3: {
                        System.out.println("3. Nhap gioi tinh can sua");
                        String gioitinh=sc.nextLine();
                        NV.setGioitinh(gioitinh);
                   }
                   case 4: {
                        System.out.println("4. Nhap so chung minh can sua");
                        long sochungminh=Long.parseLong(sc.nextLine());
                        NV.setSoCM(sochungminh);
                   }
                   case 5: {
                        try {
                        System.out.println("2. Nhap ngay vao co quang can sua");			
                        SimpleDateFormat d=new SimpleDateFormat("dd/MM/yyyy");	
                        Date ngayvaocoquang=d.parse(sc.nextLine());
                        NV.setNgayvaocoquan(ngayvaocoquang);
                       }catch (Exception e) {
                                       // TODO: handle exception
                            }
                   }	
                }
                System.out.print("Ban co tiep tuc sua nhan phim 'Y' tiep tuc va phim bat ky ket thuc");
                       c=sc.nextLine().charAt(0);
                }//end while
                this.list.replace(NV.getManv(), NV);	
	}	 
	public double Thongke()
	{
		double tongluong=0;
		for (NHANVIEN nhanvien : this.list.values())
			tongluong +=nhanvien.tinhThucLinh();		
		return tongluong;
	}
	@Override
        public void ReadFile() {
            FileReader fr;
            try {
            fr = new FileReader("QUANLYNHANVIEN.txt");
            BufferedReader br = new BufferedReader(fr);
            String s;
            int i=0;		
            while((s = br.readLine()) != null)
            {
                String [] strinfor=s.split("[,]+");
                NHANVIEN nhanvien=null;

                DateFormat d=new SimpleDateFormat("dd-MM-yyyy");
                String manv=strinfor[1];	
                String hoten=strinfor[2];
                String gioitinh=strinfor[3];
                Date ngaysinh=d.parse(strinfor[4]);
                long socm=Long.parseLong(strinfor[5]);
                Date ngayvaocoquan=d.parse(strinfor[6]);
                if(strinfor[0].equals("B"))
                {
                    double hesoluong=Double.parseDouble(strinfor[7]); 
                    nhanvien=new NHANVIENBC(manv,hoten,gioitinh,ngaysinh,socm,ngayvaocoquan,hesoluong); 
                }
                else if(strinfor[0].equals("H"))
                {
                    double mucluong=Double.parseDouble(strinfor[7]); 
                    nhanvien=new NHANVIENHOPDONG(manv,hoten,gioitinh,ngaysinh,socm,ngayvaocoquan,mucluong); 					
                }
                this.list.put(nhanvien.getManv(),nhanvien);

                }
                fr.close();

                }catch (Exception e) {
                // TODO: handle exception
                }		
            }

	@Override
	public void WriteFile() {
		FileWriter fw;
		try {
                    String strInfor="";
                    fw=new FileWriter("QUANLYNHANVIEN.txt");			
                    double hesoluong_mucluong; 
                    for (NHANVIEN nhanvien : list.values())
                    {					
                        if(nhanvien instanceof NHANVIENBC)
                        {							
                            hesoluong_mucluong= ((NHANVIENBC)nhanvien).getHesoluong();
                            strInfor +="B,";
                        }
                        else
                        {
                            hesoluong_mucluong= ((NHANVIENHOPDONG)nhanvien).getMucluong();
                            strInfor +="H,";
                        }
                        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                            strInfor +=nhanvien.getManv() + ","
                                    + nhanvien.getHoten()+","
                                    + nhanvien.getGioitinh()+","
                                    + formatter.format(nhanvien.getNgaysinh()) + ","
                                    + String.valueOf(nhanvien.getSoCM())+ ","
                                    + formatter.format(nhanvien.getNgayvaocoquan())+ ","+hesoluong_mucluong+"\r\n";						  
                        }
                            fw.write(strInfor);
                            fw.close();	
			} catch (IOException e) {				
	
			}		
	}

}