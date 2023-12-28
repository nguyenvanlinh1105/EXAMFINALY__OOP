/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GhiFile;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        QLNV DS = new QLNV();
        int luaChon =0;
        do{
           System.out.println("---MENU----");
            System.out.println("1. Them nhan vien");
            System.out.println("2. In nhan vien");
            System.out.println("3. Ghi nhan vien vao file");
            System.out.println("4. Doc danh sach nhan vien từ file");
            luaChon = sc.nextInt();
            if(luaChon ==1){
                DS.themNhanVien();
            }else if(luaChon ==2){
                DS.hienThiNhanVien();
            }else if(luaChon==3){
                DS.WriteFile();
            }else if(luaChon==4){
                DS.ReadFile();
                DS.hienThiNhanVien();
            }else{
                break;
            }

        }while(luaChon!=0);
        
    }
}
