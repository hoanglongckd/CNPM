package model.bean;

public class TheoDoiNhanVienBEAN {
	int id;
	String ngaynghi;
	boolean coPhep;
	String lydo;
	int idNhanVien;
	String name;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNgaynghi() {
		return ngaynghi;
	}
	public void setNgaynghi(String ngaynghi) {
		this.ngaynghi = ngaynghi;
	}
	public boolean isCoPhep() {
		return coPhep;
	}
	
	public int getCoPhep(){
		if(coPhep == true) return 1;
		return 0;
	}
	
	public void setCoPhep(boolean coPhep) {
		this.coPhep = coPhep;
	}
	
	public String getPhep(){
		if(coPhep== true){
			return "Có";
		}
		else{
			return "Không";
		}
	}
	
	
	public String getLydo() {
		return lydo;
	}
	public void setLydo(String lydo) {
		this.lydo = lydo;
	}
	public int getIdNhanVien() {
		return idNhanVien;
	}
	public void setIdNhanVien(int idNhanVien) {
		this.idNhanVien = idNhanVien;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TheoDoiNhanVienBEAN(int id, String ngaynghi, boolean coPhep, String lydo, int idNhanVien) {
		super();
		this.id = id;
		this.ngaynghi = ngaynghi;
		this.coPhep = coPhep;
		this.lydo = lydo;
		this.idNhanVien = idNhanVien;
	}
	
	public TheoDoiNhanVienBEAN(String ngaynghi, boolean coPhep, String lydo, int idNhanVien) {
		super();
		id = 0;
		this.ngaynghi = ngaynghi;
		this.coPhep = coPhep;
		this.lydo = lydo;
		this.idNhanVien = idNhanVien;
	}
	public TheoDoiNhanVienBEAN() {
		super();
	}
	public TheoDoiNhanVienBEAN(int id, String ngaynghi, boolean coPhep, String lydo, int idNhanVien, String name) {
		super();
		this.id = id;
		this.ngaynghi = ngaynghi;
		this.coPhep = coPhep;
		this.lydo = lydo;
		this.idNhanVien = idNhanVien;
		this.name = name;
	}
}
