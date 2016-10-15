package model.bean;

public class BaoDuongXeBEAN {
	private int id;
	private String chiTiet;
	private long soTien;
	private String ngayBaoDuong;
	private String ngayBaoDuongTiepTheo;
	private int idXe;
	
	public BaoDuongXeBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BaoDuongXeBEAN(int id, String chiTiet, long soTien, String ngayBaoDuong, String ngayBaoDuongTiepTheo, int idXe) {
		super();
		this.id = id;
		this.chiTiet = chiTiet;
		this.soTien = soTien;
		this.ngayBaoDuong = ngayBaoDuong;
		this.ngayBaoDuongTiepTheo = ngayBaoDuongTiepTheo;
		this.idXe = idXe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChiTiet() {
		return chiTiet;
	}

	public void setChiTiet(String chiTiet) {
		this.chiTiet = chiTiet;
	}

	public long getSoTien() {
		return soTien;
	}

	public void setSoTien(long soTien) {
		this.soTien = soTien;
	}

	public String getNgayBaoDuong() {
		return ngayBaoDuong;
	}

	public void setNgayBaoDuong(String ngayBaoDuong) {
		this.ngayBaoDuong = ngayBaoDuong;
	}

	public String getNgayBaoDuongTiepTheo() {
		return ngayBaoDuongTiepTheo;
	}

	public void setNgayBaoDuongTiepTheo(String ngayBaoDuongTiepTheo) {
		this.ngayBaoDuongTiepTheo = ngayBaoDuongTiepTheo;
	}

	public int getIdXe() {
		return idXe;
	}

	public void setIdXe(int idXe) {
		this.idXe = idXe;
	}
	
}
