package Lab4;

import java.util.ArrayList;
import java.util.Scanner;

class Sach {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private long gia;

    public Sach() {
        this.maSach = "";
        this.tenSach = "";
        this.tacGia = "";
        this.gia = 0;
    }

    public Sach(String maSach, String tenSach, String tacGia, long gia) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.gia = gia;
    }

    public String getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public long getGia() {
        return gia;
    }

    public long getGiaSauGiam() {
        return gia;
    }

    public void xuat() {
        System.out.println("Ma sach: " + maSach + ", Ten sach: " + tenSach + ", Tac gia: " + tacGia + ", Gia: " + gia);
    }

    public void nhap(Scanner scanner) {
        System.out.print("Nhap ma sach: ");
        maSach = scanner.nextLine();
        System.out.print("Nhap ten sach: ");
        tenSach = scanner.nextLine();
        System.out.print("Nhap tac gia: ");
        tacGia = scanner.nextLine();
        System.out.print("Nhap gia: ");
        gia = Long.parseLong(scanner.nextLine());
    }
}

class SachVanHoc extends Sach {
    private int lanXuatBan;

    public SachVanHoc() {
        super();
        this.lanXuatBan = 0;
    }

    public SachVanHoc(String maSach, String tenSach, String tacGia, long gia, int lanXuatBan) {
        super(maSach, tenSach, tacGia, gia);
        this.lanXuatBan = lanXuatBan;
    }

    public int getLanXuatBan() {
        return lanXuatBan;
    }

    @Override
    public long getGiaSauGiam() {
        if (getGia() > 300000) {
            return (long) (getGia() * 0.8);
        }
        return getGia();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Lan xuat ban: " + lanXuatBan);
    }

    @Override
    public void nhap(Scanner scanner) {
        super.nhap(scanner);
        System.out.print("Nhap lan xuat ban: ");
        lanXuatBan = Integer.parseInt(scanner.nextLine());
    }
}

class SachGiaoKhoa extends Sach {
    private int lop;
    private String nhaXuatBan;

    public SachGiaoKhoa() {
        super();
        this.lop = 0;
        this.nhaXuatBan = "";
    }

    public SachGiaoKhoa(String maSach, String tenSach, String tacGia, long gia, int lop, String nhaXuatBan) {
        super(maSach, tenSach, tacGia, gia);
        this.lop = lop;
        this.nhaXuatBan = nhaXuatBan;
    }

    public int getLop() {
        return lop;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    @Override
    public long getGiaSauGiam() {
        if (nhaXuatBan.equalsIgnoreCase("Giao Duc")) {
            return (long) (getGia() * 0.9);
        }
        return getGia();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Lop: " + lop + ", Nha xuat ban: " + nhaXuatBan);
    }

    @Override
    public void nhap(Scanner scanner) {
        super.nhap(scanner);
        System.out.print("Nhap lop: ");
        lop = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhap nha xuat ban: ");
        nhaXuatBan = scanner.nextLine();
    }
}

public class Bai05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Sach> danhSachSach = new ArrayList<>();

        SachVanHoc vanHoc = new SachVanHoc("VH001", "Truyen Kieu", "Nguyen Du", 400000, 5);
        SachGiaoKhoa giaoKhoa = new SachGiaoKhoa("GK001", "Toan 10", "Hoang Xuan", 250000, 10, "Giao Duc");

        danhSachSach.add(vanHoc);
        danhSachSach.add(giaoKhoa);

        System.out.println("\nNhap thong tin cho cac quyen sach:");
        for (Sach sach : danhSachSach) {
            System.out.println("Nhap thong tin cho sach:");
            sach.nhap(scanner);
        }

        System.out.println("\nThong tin cac quyen sach sau khi giam gia:");
        for (Sach sach : danhSachSach) {
            sach.xuat();
            System.out.println("Gia sau giam: " + sach.getGiaSauGiam());
        }

        Sach sachGiaMax = danhSachSach.get(0);
        for (Sach sach : danhSachSach) {
            if (sach.getGiaSauGiam() > sachGiaMax.getGiaSauGiam()) {
                sachGiaMax = sach;
            }
        }

        System.out.println("\nSach co gia lon nhat sau khi giam:");
        sachGiaMax.xuat();
        System.out.println("Gia sau giam: " + sachGiaMax.getGiaSauGiam());
    }
}

