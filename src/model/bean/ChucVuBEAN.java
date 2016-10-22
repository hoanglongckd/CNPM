package model.bean;

public class ChucVuBEAN {
	private int id;
	private String maChucVu;
	private String tenChucVu;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMaChucVu() {
		return maChucVu;
	}
	public void setMaChucVu(String maChucVu) {
		this.maChucVu = maChucVu;
	}
	public String getTenChucVu() {
		return tenChucVu;
	}
	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}
	public ChucVuBEAN(int id, String maChucVu, String tenChucVu) {
		super();
		this.id = id;
		this.maChucVu = maChucVu;
		this.tenChucVu = tenChucVu;
	}
	public ChucVuBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
