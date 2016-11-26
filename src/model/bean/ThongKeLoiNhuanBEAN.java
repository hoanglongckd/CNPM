package model.bean;

public class ThongKeLoiNhuanBEAN {
	private String bienSoXe;
	private long tienTaiXeTra;
	private long tienBaoDuong;
	
	public ThongKeLoiNhuanBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ThongKeLoiNhuanBEAN(String bienSoXe, long tienTaiXeTra, long tienBaoDuong) {
		super();
		this.bienSoXe = bienSoXe;
		this.tienTaiXeTra = tienTaiXeTra;
		this.tienBaoDuong = tienBaoDuong;
	}

	public String getBienSoXe() {
		return bienSoXe;
	}

	public void setBienSoXe(String bienSoXe) {
		this.bienSoXe = bienSoXe;
	}

	public long getTienTaiXeTra() {
		return tienTaiXeTra;
	}

	public void setTienTaiXeTra(long tienTaiXeTra) {
		this.tienTaiXeTra = tienTaiXeTra;
	}

	public long getTienBaoDuong() {
		return tienBaoDuong;
	}

	public void setTienBaoDuong(long tienBaoDuong) {
		this.tienBaoDuong = tienBaoDuong;
	}
	
}
