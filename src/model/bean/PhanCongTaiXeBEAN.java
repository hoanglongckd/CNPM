package model.bean;

public class PhanCongTaiXeBEAN {
	private int id;
	private int idTaiXe;
	private int idXe;
	private int idCa;
	private int idThuNgay;
	
	public PhanCongTaiXeBEAN(){
		super();
	}
	public PhanCongTaiXeBEAN(int id, int idTaiXe, int idXe, int idCa, int idThuNgay){
		this.id = id;
		this.idTaiXe = idTaiXe;
		this.idXe = idXe;
		this.idCa = idCa;
		this.idThuNgay = idThuNgay;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdTaiXe() {
		return idTaiXe;
	}

	public void setIdTaiXe(int idTaiXe) {
		this.idTaiXe = idTaiXe;
	}
	
	public int getIdXe() {
		return idXe;
	}

	public void setIdXe(int idXe) {
		this.idXe = idXe;
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
	
	
}
