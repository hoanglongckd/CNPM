package model.bean.NhanVien;

public class ChucVuBEAN {
	private int id;
	private String maChucVu;
	private String tenChucVu;
	
	public ChucVuBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChucVuBEAN(int id, String bienSoXe, String model, int soCho, String hang, boolean tinhTrangHoatDong) {
		super();
		this.id = id;
		this.maChucVu = maChucVu;
		this.tenChucVu = tenChucVu;
		
	}

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
	
}
