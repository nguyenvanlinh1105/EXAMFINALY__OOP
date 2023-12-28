package NGUYENVANLINH;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
public class DS {
    Hashtable<String,String> list= new Hashtable();
    protected Scanner sc;
    int dem = 1;

    public DS() {
        sc= new Scanner(System.in);
    }

    public void themBenhNhan() {
        int luaChon = 0;
        do {
            System.out.println("Ban muon nhap nao?");
            System.out.println("1. Nhap ");
            System.out.println("2. Nhap ");
            System.out.println("0. Dung them !");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                case 1: {
                    BenhNhan Bn = new BenhNhanBaoHiemYTe();
                    BenhNhanBaoHiemYTe bnyt = (BenhNhanBaoHiemYTe) Bn;
                    bnyt.NhapBNBHYT();
                    DSBenhNhan.put(bnyt.getMaBenhNhan(), bnyt);
                    break;
                }
                case 2: {
                    BenhNhan Bn = new BenhNhanBaoHiemXaHoi();
                    BenhNhanBaoHiemXaHoi bnxh = (BenhNhanBaoHiemXaHoi) Bn;
                    bnxh.NhapBNBHXH();
                    DSBenhNhan.put(bnxh.getMaBenhNhan(), bnxh);
                    break;
                }
            }
            dem++;
        } while (luaChon != 0);
    }
    public void xoa(){
        System.out.println("Nhap vao ma can xoa:");
        String maXoa = sc.nextLine();
        sc.nextLine();
        if (list.containsKey(maXoa)) {
            list.remove(maXoa);
            System.out.println("Da xoa   co ma " + maXoa);
        } else {
            System.out.println("Khong tim thay benh nhan voi ma benh nhan " + maXoa + " trong danh sach!");
        }
    }
    public void xoaBenhNhan() {
        System.out.println("Nhap vao ma benh nhan can xoa:");
        String maBN = sc.nextLine();
        sc.nextLine();
        if (DSBenhNhan.containsKey(maBN)) {
            DSBenhNhan.remove(maBN);
            System.out.println("Da xoa benh nhan co ma " + maBN);
        } else {
            System.out.println("Khong tim thay benh nhan voi ma benh nhan " + maBN + " trong danh sach!");
        }
    }

    public void timKiemBenhNhan() {
        System.out.println("Nhap vao ma benh nhan can tim:");
        int maBN = sc.nextInt();
        sc.nextLine();
        if (DSBenhNhan.containsKey(maBN)) {
            BenhNhan benhNhan = DSBenhNhan.get(maBN);
            benhNhan.HienThiTTBN();
        } else {
            System.out.println("Khong co benh nhan nao co ma benh nhan " + maBN + " trong danh sach");
        }
    }

    public void HienThiDS() {
        System.out.println("-----DANH SACH BENH NHAN-----");
        for (String maBN : DSBenhNhan.keySet()) {
            BenhNhan benhNhan = DSBenhNhan.get(maBN);
            System.out.println("Thong tin benh nhan co ma " + maBN);
            benhNhan.HienThiTTBN();
            System.out.println("------*------");
        }
    }

    public void tinhTongTienChoTungLoaiBenhNhan() {
        double tinhTongTienBNBHYT = 0;
        double tinhTongTienBNBHXH = 0;
        for (BenhNhan benhNhan : DSBenhNhan.values()) {
            if (benhNhan instanceof BenhNhanBaoHiemYTe) {
                tinhTongTienBNBHYT += benhNhan.TinhHoaDonVienPhi();
            } else if (benhNhan instanceof BenhNhanBaoHiemXaHoi) {
                tinhTongTienBNBHXH += benhNhan.TinhHoaDonVienPhi();
            }
        }
        System.out.println("Tong tien vien phi cho loai benh nhan BHYT la: " + tinhTongTienBNBHYT);
        System.out.println("Tong tien vien phi cho loai benh nhan BHXH la: " + tinhTongTienBNBHXH);
    }

   @Override
public void WriteFile() {
    FileWriter fw = null;
    try {
        String strInfor = "";
        fw = new FileWriter("C:\\Users\\HP\\Downloads\\NguyenVanLinh_CK_JAVA\\src\\De1\\QUANLIBENHNHAN.txt"); // Corrected file name
        String maBHXH_maBHYT;
        for (BenhNhan benhNhan : DSBenhNhan.values()) {
            if (benhNhan instanceof BenhNhanBaoHiemXaHoi) {
                maBHXH_maBHYT = ((BenhNhanBaoHiemXaHoi) benhNhan).getMaBHXH();
                strInfor += "2,";
                strInfor+=((BenhNhanBaoHiemXaHoi) benhNhan).getMaBHXH()+",";
            } else if (benhNhan instanceof BenhNhanBaoHiemYTe) {
                maBHXH_maBHYT = ((BenhNhanBaoHiemYTe) benhNhan).getMaBHYT();
                strInfor += "1,";//0
                strInfor+=((BenhNhanBaoHiemYTe) benhNhan).getMaBHYT()+",";//1

            }
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YY"); 
            strInfor += benhNhan.getMaBenhNhan() + ","//2
                    + benhNhan.getHoTen() + ","// 3
                    + formatter.format(benhNhan.getNgayNhapVien()) + ","//4 
                    + String.valueOf(benhNhan.isPhong()) + "\r\n";//5
        }
        fw.write(strInfor);
        System.out.println("Ghi vào tệp thành công.");
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (fw != null) {
                fw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

@Override
public void ReadFile() {
    FileReader fr = null;
    try {
        fr = new FileReader("C:\\Users\\HP\\Downloads\\NguyenVanLinh_CK_JAVA\\src\\NguyenVanLinh\\QUANLIBENHNHAN.txt");

        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            String[] strInfor = line.split(",");

            String loaiBenhNhan = strInfor[0];
            String maBHXH_maBHYT = strInfor[1];
            String maBenhNhan = strInfor[2];
            String hoTen = strInfor[3];
            Date ngayNhapVien = new SimpleDateFormat("dd-MM-yyyy").parse(strInfor[4]);
            boolean phong = Boolean.parseBoolean(strInfor[5]);

            BenhNhan benhNhan = null;
            if (loaiBenhNhan.equals("1")) {
                String maBHYT = maBHXH_maBHYT;
                benhNhan = new BenhNhanBaoHiemYTe(maBHYT, maBenhNhan, hoTen, ngayNhapVien, phong);
            } else if (loaiBenhNhan.equals("2")) {
                String maBHXH = maBHXH_maBHYT;
                benhNhan = new BenhNhanBaoHiemXaHoi(maBHXH, maBenhNhan, hoTen, ngayNhapVien, phong);
            }

            DSBenhNhan.put(benhNhan.getMaBenhNhan(), benhNhan);
        }
        System.out.println("Đọc tệp thành công.");
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (fr != null) {
                fr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

}
