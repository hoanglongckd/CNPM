package model.bean;

public class DashBoardBEAN {
	int soNhanVien = 0;
	int soTaiXe = 0;
	int soXe = 0;
	int soDieuPhoi = 0;
	int soVangNghi = 0;
	int soXeBaoDuong = 0;
	
	public DashBoardBEAN() {
		super();
	}

	public DashBoardBEAN(int soNhanVien, int soTaiXe, int soXe, int soDieuPhoi, int soVangNghi,
			int soXeBaoDuong) {
		super();
		this.soNhanVien = soNhanVien;
		this.soTaiXe = soTaiXe;
		this.soXe = soXe;
		this.soDieuPhoi = soDieuPhoi;
		this.soVangNghi = soVangNghi;
		this.soXeBaoDuong = soXeBaoDuong;
	}

	public int getSoNhanVien() {
		return soNhanVien;
	}

	public void setSoNhanVien(int soNhanVien) {
		this.soNhanVien = soNhanVien;
	}

	public int getSoTaiXe() {
		return soTaiXe;
	}

	public void setSoTaiXe(int soTaiXe) {
		this.soTaiXe = soTaiXe;
	}

	public int getSoXe() {
		return soXe;
	}

	public void setSoXe(int soXe) {
		this.soXe = soXe;
	}

	public int getSoDieuPhoi() {
		return soDieuPhoi;
	}

	public void setSoDieuPhoi(int soDieuPhoi) {
		this.soDieuPhoi = soDieuPhoi;
	}

	public int getSoVangNghi() {
		return soVangNghi;
	}

	public void setSoVangNghi(int soVangNghi) {
		this.soVangNghi = soVangNghi;
	}

	public int getSoXeBaoDuong() {
		return soXeBaoDuong;
	}

	public void setSoXeBaoDuong(int soXeBaoDuong) {
		this.soXeBaoDuong = soXeBaoDuong;
	}
	
}
