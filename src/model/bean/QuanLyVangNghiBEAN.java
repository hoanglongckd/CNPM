package model.bean;

public class QuanLyVangNghiBEAN {
	int id;
	int idNhanVien;
	int tongNgayNghi;
	String maNV;
	String tenNV;
	String ngayNghi;
	String lyDo;
	boolean coPhep;
	
	public QuanLyVangNghiBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuanLyVangNghiBEAN(int idNhanVien, String maNV) {
		super();
		this.idNhanVien = idNhanVien;
		this.maNV = maNV;
	}

	public QuanLyVangNghiBEAN(int idNhanVien, String ngayNghi, String lyDo, boolean coPhep) {
		super();
		this.idNhanVien = idNhanVien;
		this.ngayNghi = ngayNghi;
		this.lyDo = lyDo;
		this.coPhep = coPhep;
	}

	public QuanLyVangNghiBEAN(int idNhanVien, int tongNgayNghi, String maNV, String tenNV) {
		super();
		this.idNhanVien = idNhanVien;
		this.tongNgayNghi = tongNgayNghi;
		this.maNV = maNV;
		this.tenNV = tenNV;
	}

	public QuanLyVangNghiBEAN(String ngayNghi, String lyDo, boolean coPhep, int id) {
		super();
		this.id = id;
		this.ngayNghi = ngayNghi;
		this.lyDo = lyDo;
		this.coPhep = coPhep;
	}
	
	public QuanLyVangNghiBEAN(int idNhanVien, String maNV, String ngayNghi, String lyDo, boolean coPhep) {
		super();
		this.idNhanVien = idNhanVien;
		this.maNV = maNV;
		this.ngayNghi = ngayNghi;
		this.lyDo = lyDo;
		this.coPhep = coPhep;
	}

	public QuanLyVangNghiBEAN(String maNV, int id, String ngayNghi, String lyDo, boolean coPhep, int idNhanVien) {
		super();
		this.id = id;
		this.maNV = maNV;
		this.ngayNghi = ngayNghi;
		this.lyDo = lyDo;
		this.coPhep = coPhep;
		this.idNhanVien = idNhanVien;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdNhanVien() {
		return idNhanVien;
	}

	public void setIdNhanVien(int idNhanVien) {
		this.idNhanVien = idNhanVien;
	}

	public int getTongNgayNghi() {
		return tongNgayNghi;
	}

	public void setTongNgayNghi(int tongNgayNghi) {
		this.tongNgayNghi = tongNgayNghi;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getNgayNghi() {
		return ngayNghi;
	}

	public void setNgayNghi(String ngayNghi) {
		this.ngayNghi = ngayNghi;
	}

	public String getLyDo() {
		return lyDo;
	}

	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}

	public boolean isCoPhep() {
		return coPhep;
	}

	public void setCoPhep(boolean coPhep) {
		this.coPhep = coPhep;
	}
	
	
	
}
