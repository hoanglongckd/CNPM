package model.bean;

public class CaLamViecBEAN {
	private int id;
	private String tenCa;
	
	public CaLamViecBEAN(){
		super();
	}
	public CaLamViecBEAN(int id, String tenCa){
		this.id = id;
		this.tenCa = tenCa;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenCa() {
		return tenCa;
	}

	public void setTenCa(String tenCa) {
		this.tenCa = tenCa;
	}
	
	
}
