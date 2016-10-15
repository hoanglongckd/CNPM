package model.bean;

public class TaiXe {
	private int id;
	private String maTaiXe;
//	private String password;
	private String ten;
	private String ngaySinh;
//	private int idChucVu;
	
	public TaiXe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TaiXe(int id, String maTaiXe, String password, String ten, String ngaySinh, int idChucVu) {
		super();
		this.id = id;
		this.maTaiXe = maTaiXe;
//		this.password = password;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
//		this.idChucVu = idChucVu;
	}
	
	public TaiXe(int id,String maTaiXe){
		this.id = id;
		this.maTaiXe = maTaiXe;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMaTaiXe() {
		return maTaiXe;
	}
	public void setMaTaiXe(String maTaiXe) {
		this.maTaiXe = maTaiXe;
	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
//	public int getIdChucVu() {
//		return idChucVu;
//	}
//	public void setIdChucVu(int idChucVu) {
//		this.idChucVu = idChucVu;
//	}
	
	
}
