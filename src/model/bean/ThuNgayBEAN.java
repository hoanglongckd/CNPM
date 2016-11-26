package model.bean;

public class ThuNgayBEAN {
	private int id;
	private String tenThuNgay;
	
	public ThuNgayBEAN(){
		super();
	}
	public ThuNgayBEAN(int id, String tenThuNgay){
		this.id = id;
		this.tenThuNgay = tenThuNgay;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenThuNgay() {
		return tenThuNgay;
	}

	public void setTenCa(String tenThuNgay) {
		this.tenThuNgay = tenThuNgay;
	}
}
