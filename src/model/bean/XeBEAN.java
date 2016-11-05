package model.bean;

public class XeBEAN {
	private int id;
	private String bienSoXe;
	private String model;
	private int soCho;
	private String hang;
	private boolean tinhTrangHoatDong;
	private String ghiChu;
	private String taiXe;
	private int idTX;
	private String diaChi;
	private String thoiGian;
	
	public XeBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public XeBEAN(int id, String bienSoXe, String model, int soCho, String hang, boolean tinhTrangHoatDong) {
		super();
		this.id = id;
		this.bienSoXe = bienSoXe;
		this.model = model;
		this.soCho = soCho;
		this.hang = hang;
		this.tinhTrangHoatDong = tinhTrangHoatDong;
	}
	
	public XeBEAN(int id, String bienSoXe, String model, int soCho, String hang) {
		super();
		this.id = id;
		this.bienSoXe = bienSoXe;
		this.model = model;
		this.soCho = soCho;
		this.hang = hang;
	}

	public XeBEAN(int id, String bienSoXe, String model, int soCho, String hang, String ghiChu) {
		super();
		this.id = id;
		this.bienSoXe = bienSoXe;
		this.model = model;
		this.soCho = soCho;
		this.hang = hang;
		this.ghiChu = ghiChu;
	}
	
	public XeBEAN(int id, String bienSoXe, String model, String taiXe, int soCho, String hang){
		super();
		this.id = id;
		this.bienSoXe = bienSoXe;
		this.model = model;
		this.taiXe = taiXe;
		this.soCho = soCho;
		this.hang = hang;
	}
	
	public XeBEAN(int id, String bienSoXe, String taiXe, String model, int soCho, String hang, String ghiChu, int idTX){
		super();
		this.id = id;
		this.bienSoXe = bienSoXe;
		this.model = model;
		this.taiXe = taiXe;
		this.soCho = soCho;
		this.hang = hang;
		this.ghiChu = ghiChu;
		this.idTX = idTX;
	}

	public XeBEAN(int id, String taiXe, String bienSoXe, int soCho) {
		super();
		this.id = id;
		this.bienSoXe = bienSoXe;
		this.taiXe = taiXe;
		this.soCho = soCho;
	}
	
	public XeBEAN(String taiXe, String bienSoXe, String diaChi, String thoiGian) {
		super();
		
		this.bienSoXe = bienSoXe;
		this.taiXe = taiXe;
		this.diaChi = diaChi;
		this.thoiGian = thoiGian;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBienSoXe() {
		return bienSoXe;
	}

	public void setBienSoXe(String bienSoXe) {
		this.bienSoXe = bienSoXe;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSoCho() {
		return soCho;
	}

	public void setSoCho(int soCho) {
		this.soCho = soCho;
	}

	public String getHang() {
		return hang;
	}

	public void setHang(String hang) {
		this.hang = hang;
	}

	public boolean isTinhTrangHoatDong() {
		return tinhTrangHoatDong;
	}

	public void setTinhTrangHoatDong(boolean tinhTrangHoatDong) {
		this.tinhTrangHoatDong = tinhTrangHoatDong;
	}

	public String getTaiXe() {
		return taiXe;
	}

	public void setTaiXe(String taiXe) {
		this.taiXe = taiXe;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public int getIdTX() {
		return idTX;
	}

	public void setIdTX(int idTX) {
		this.idTX = idTX;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}
	
}
