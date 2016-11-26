package model.bean;

public class DieuPhoiBEAN {
	
	private int id;
	private String diaChi;
	private int loaiXe;
	private String thoiGianBatDau;
	private String thoiGianKetThuc;
	private int idPhanCong;
	private String bienSoXe;
	private int soKM;
	private int thanhTien;
	
	public DieuPhoiBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DieuPhoiBEAN(int id, String diaChi, int loaiXe, String thoiGianBatDau, String thoiGianKetThuc, int idPhanCong) {
		super();
		this.id = id;
		this.diaChi = diaChi;
		this.loaiXe = loaiXe;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.idPhanCong = idPhanCong;
	}

	public DieuPhoiBEAN(int id, String diaChi) {
		super();
		this.id = id;
		this.diaChi = diaChi;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDiaChi() {
		return diaChi;
	}
	
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	public String getThoiGianBatDau() {
		return thoiGianBatDau;
	}
	
	public void setThoiGianBatDau(String thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}
	
	public String getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}
	
	public void setThoiGianKetThuc(String thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	
	public int getIdPhanCong() {
		return idPhanCong;
	}
	
	public void setIdPhanCong(int idPhanCong) {
		this.idPhanCong = idPhanCong;
	}

	public int getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(int loaiXe) {
		this.loaiXe = loaiXe;
	}

	public String getBienSoXe() {
		return bienSoXe;
	}

	public void setBienSoXe(String bienSoXe) {
		this.bienSoXe = bienSoXe;
	}

	public int getSoKM() {
		return soKM;
	}

	public void setSoKM(int soKM) {
		this.soKM = soKM;
	}

	public int getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(int thanhTien) {
		this.thanhTien = thanhTien;
	}
	

}
