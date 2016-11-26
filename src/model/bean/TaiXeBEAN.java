package model.bean;

public class TaiXeBEAN {
	private int id;
	private String maTaiXe;
	private String hoTen;
	private String ngaySinh;
	
	public TaiXeBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaiXeBEAN(int id, String maTaiXe, String hoTen, String ngaySinh) {
	
		super();
		this.id = id;
		this.maTaiXe = maTaiXe;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
	}
	public TaiXeBEAN(int id, String maTaiXe){
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

}
