package com.busReservation.dto;

public class Bus {

	private int BusId;
	private String busNo;
	private boolean busType;
	public int getBusId() {
		return BusId;
	}
	public void setBusId(int busId) {
		BusId = busId;
	}
	public String getBusNo() {
		return busNo;
	}
	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}
	public boolean isBusType() {
		return busType;
	}
	public void setBusType(boolean busType) {
		this.busType = busType;
	}
	public Bus(int busId, String busNo, boolean busType) {
		BusId = busId;
		this.busNo = busNo;
		this.busType = busType;
	}
}
