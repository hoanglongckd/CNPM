package model.bean;

import java.sql.Date;

public class BaoDuongXeBEAN {
	private int id;
	private String chiTiet;
	private int soTien;
	private Date ngayBaoDuong;
	private Date ngayBaoDuongTiepTheo;
	private int idXe;
	
	public BaoDuongXeBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BaoDuongXeBEAN(int id, String chiTiet, int soTien, Date ngayBaoDuong, Date ngayBaoDuongTiepTheo, int idXe) {
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

	public int getSoTien() {
		return soTien;
	}

	public void setSoTien(int soTien) {
		this.soTien = soTien;
	}

	public Date getNgayBaoDuong() {
		return ngayBaoDuong;
	}

	public void setNgayBaoDuong(Date ngayBaoDuong) {
		this.ngayBaoDuong = ngayBaoDuong;
	}

	public Date getNgayBaoDuongTiepTheo() {
		return ngayBaoDuongTiepTheo;
	}

	public void setNgayBaoDuongTiepTheo(Date ngayBaoDuongTiepTheo) {
		this.ngayBaoDuongTiepTheo = ngayBaoDuongTiepTheo;
	}

	public int getIdXe() {
		return idXe;
	}

	public void setIdXe(int idXe) {
		this.idXe = idXe;
	}
	
}
