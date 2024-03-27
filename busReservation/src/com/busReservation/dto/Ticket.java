package com.busReservation.dto;

public class Ticket {

	private int ticketId;
	private String passengerName;
	private String date;
	private Bus bus;
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public Ticket(int ticketId, String passengerName, String date, Bus bus) {
	
		this.ticketId = ticketId;
		this.passengerName = passengerName;
		this.date = date;
		this.bus = bus;
	}
	
}
