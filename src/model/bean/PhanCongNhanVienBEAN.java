package model.bean;

public class PhanCongNhanVienBEAN {
	private int id;
	private int idNhanVien;
	private int idCa;
	private int idThuNgay;
	
	public PhanCongNhanVienBEAN(){
		super();
	}
	public PhanCongNhanVienBEAN(int id, int idNhanVien, int idCa, int idThuNgay){
		this.id = id;
		this.idNhanVien = idNhanVien;
		this.idCa = idCa;
		this.idThuNgay = idThuNgay;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdNhanVien() {
		return idNhanVien;
	}

	public void setIdNhanVien(int idNhanVien) {
		this.idNhanVien = idNhanVien;
	}
	
	public int getIdCa() {
		return idCa;
	}

	public void setIdCa(int idCa) {
		this.idCa = idCa;
	}
	
	public int getIdThuNgay() {
		return idThuNgay;
	}

	public void setIdThuNgay(int idThuNgay) {
		this.idThuNgay = idThuNgay;
	}
	public boolean themPhanCongNhanVien(PhanCongNhanVienBEAN phanCongNhanVienBEAN) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
