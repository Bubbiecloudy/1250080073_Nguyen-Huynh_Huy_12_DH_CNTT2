package Lab4;
import java.util.Scanner;

class HangHoa {
    protected String maHang;
    protected String tenHang;
    protected long donGia;

    public HangHoa() {
        this.maHang = "";
        this.tenHang = "";
        this.donGia = 0;
    }

    public HangHoa(String maHang, String tenHang, long donGia) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.donGia = donGia;
    }

    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public long getDonGia() {
        return donGia;
    }

    public void nhap(Scanner scanner) {
        System.out.print("Nhap ma hang: ");
        maHang = scanner.nextLine();
        System.out.print("Nhap ten hang: ");
        tenHang = scanner.nextLine();
        System.out.print("Nhap don gia: ");
        donGia = scanner.nextLong();
        scanner.nextLine();
    }

    public void xuat() {
        System.out.println("Ma hang: " + maHang);
        System.out.println("Ten hang: " + tenHang);
        System.out.println("Don gia: " + donGia);
    }
}

class HangDienMay extends HangHoa {
    private int thoiGianBaoHanh;
    private int dienAp;
    private int congSuat;

    public HangDienMay() {
        super();
        this.thoiGianBaoHanh = 0;
        this.dienAp = 0;
        this.congSuat = 0;
    }

    public HangDienMay(String maHang, String tenHang, long donGia, int thoiGianBaoHanh, int dienAp, int congSuat) {
        super(maHang, tenHang, donGia);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.dienAp = dienAp;
        this.congSuat = congSuat;
    }

    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public int getDienAp() {
        return dienAp;
    }

    public int getCongSuat() {
        return congSuat;
    }

    @Override
    public void nhap(Scanner scanner) {
        super.nhap(scanner);
        System.out.print("Nhap thoi gian bao hanh (thang): ");
        thoiGianBaoHanh = scanner.nextInt();
        System.out.print("Nhap dien ap: ");
        dienAp = scanner.nextInt();
        System.out.print("Nhap cong suat: ");
        congSuat = scanner.nextInt();
        scanner.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Thoi gian bao hanh: " + thoiGianBaoHanh + " thang");
        System.out.println("Dien ap: " + dienAp + "V");
        System.out.println("Cong suat: " + congSuat + "W");
    }
}

class HangThucPham extends HangHoa {
    private String ngaySanXuat;
    private String ngayHetHan;

    public HangThucPham() {
        super();
        this.ngaySanXuat = "";
        this.ngayHetHan = "";
    }

    public HangThucPham(String maHang, String tenHang, long donGia, String ngaySanXuat, String ngayHetHan) {
        super(maHang, tenHang, donGia);
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
    }

    public String getNgaySanXuat() {
        return ngaySanXuat;
    }

    public String getNgayHetHan() {
        return ngayHetHan;
    }

    @Override
    public void nhap(Scanner scanner) {
        super.nhap(scanner);
        System.out.print("Nhap ngay san xuat (dd/MM/yyyy): ");
        ngaySanXuat = scanner.nextLine();
        System.out.print("Nhap ngay het han (dd/MM/yyyy): ");
        ngayHetHan = scanner.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Ngay san xuat: " + ngaySanXuat);
        System.out.println("Ngay het han: " + ngayHetHan);
    }
}

public class Bai04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Nhap thong tin hang dien may ===");
        HangDienMay dienMay = new HangDienMay();
        dienMay.nhap(scanner);
        System.out.println("\n=== Thong tin hang dien may ===");
        dienMay.xuat();

        System.out.println("\n=== Nhap thong tin hang thuc pham ===");
        HangThucPham thucPham = new HangThucPham();
        thucPham.nhap(scanner);
        System.out.println("\n=== Thong tin hang thuc pham ===");
        thucPham.xuat();

        scanner.close();
    }
}

