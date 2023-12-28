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
public class NhanVien {
    private String maNhanVien;
    private String hoTen;
    private int tuoi;
    private float luong;
    private Scanner sc;
    public NhanVien() {
        sc= new Scanner(System.in);
    }

    public NhanVien(String maNhanVien, String hoTen, int tuoi, float luong) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.luong = luong;
    }
    
    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }
    public void NhapNV(){
        System.out.print("Nhap ma nhan vien:");
        this.maNhanVien = sc.nextLine();
        System.out.print("Nhap ho va ten nhan vien:");
        this.hoTen= sc.nextLine();
        System.out.print("Nhap tuoi cua nhan vien:");
        this.tuoi= sc.nextInt(); 
        System.out.print("Nhap luong nhan vien:");
        this.luong= sc.nextFloat();  
    }
    public void InNV(){
        System.out.println("Ma nhan vien la: "+this.maNhanVien);
        System.out.println("Ho va ten cua nhan vien la: "+this.hoTen);
        System.out.println("Tuoi cua nhan vien la: "+this.tuoi);
        System.out.println("Luong cua nhan vien la: "+this.luong);
    }
    
}
