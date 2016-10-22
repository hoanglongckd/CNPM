package model.bean;

public class NhanVienVangNghiBEAN {
	String maNv;
	String tenNV;
	int tongNgayNghi;
	public String getMaNv() {
		return maNv;
	}
	public void setMaNv(String maNv) {
		this.maNv = maNv;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public int getTongNgayNghi() {
		return tongNgayNghi;
	}
	public void setTongNgayNghi(int tongNgayNghi) {
		this.tongNgayNghi = tongNgayNghi;
	}
	public NhanVienVangNghiBEAN(String maNv, String tenNV, int tongNgayNghi) {
		super();
		this.maNv = maNv;
		this.tenNV = tenNV;
		this.tongNgayNghi = tongNgayNghi;
	}
	public NhanVienVangNghiBEAN() {
		super();
	}
}
