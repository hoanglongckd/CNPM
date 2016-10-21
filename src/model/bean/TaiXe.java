package model.bean;

public class TaiXe {
	private int id;
	private String maTaiXe;
	private String ten;
	private String ngaySinh;

	public TaiXe() {
		super();
	}
	
	public TaiXe(int id, String maTaiXe, String ten, String ngaySinh) {
		super();
		this.id = id;
		this.maTaiXe = maTaiXe;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
	}
	
	public TaiXe(int id, String maTaiXe){
		super();
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
	
	
}
