package model.bean;

public class DonGiaBEAN {
	private int id;
	private int giaTien;
	
	public DonGiaBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DonGiaBEAN(int id, int giaTien) {
		super();
		this.id = id;
		this.giaTien = giaTien;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(int giaTien) {
		this.giaTien = giaTien;
	}
	
}
