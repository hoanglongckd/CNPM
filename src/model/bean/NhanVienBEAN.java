package model.bean;

public class NhanVienBEAN {
	private int id;
	private String maNhanVien;
	private String hoTen;
	private String ngaySinh;
	private int chucVu;
	private String password;
	
	public NhanVienBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhanVienBEAN(int id, String maNhanVien, String hoTen, String ngaySinh, int chucVu) {
	
		super();
		this.id = id;
		this.maNhanVien = maNhanVien;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.chucVu = chucVu;
	}
	
	

	public NhanVienBEAN(int id, String maNhanVien, String hoTen, String ngaySinh, int chucVu,
			String password) {
		super();
		this.id = id;
		this.maNhanVien = maNhanVien;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.chucVu = chucVu;
		this.password = password;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		this.hoTen = hoTen ;
	}
	
	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public int getChucVu() {
		return chucVu;
	}

	public void setChucVu(int chucVu) {
		this.chucVu = chucVu ;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
}
