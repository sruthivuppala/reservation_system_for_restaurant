package io.restaurant.model;

public class Reservation {
	
	private String reservation_ID;
	private String reservation_Date;
	private String reservation_Time;
	private int reservation_Size;
	private String table_Type;
	private String reservation_Status;
	private int CID;
	
	public String getReservation_ID() {
		return reservation_ID;
	}
	public void setReservation_ID(String reservation_ID) {
		this.reservation_ID = reservation_ID;
	}
	public String getReservation_Date() {
		return reservation_Date;
	}
	public void setReservation_Date(String reservation_Date) {
		this.reservation_Date = reservation_Date;
	}
	public String getReservation_Time() {
		return reservation_Time;
	}
	public void setReservation_Time(String reservation_Time) {
		this.reservation_Time = reservation_Time;
	}
	public int getReservation_Size() {
		return reservation_Size;
	}
	public void setReservation_Size(int reservation_Size) {
		this.reservation_Size = reservation_Size;
	}
	public String getTable_Type() {
		return table_Type;
	}
	public void setTable_Type(String table_Type) {
		this.table_Type = table_Type;
	}
	public String getReservation_Status() {
		return reservation_Status;
	}
	public void setReservation_Status(String reservation_Status) {
		this.reservation_Status = reservation_Status;
	}
	public int getCID() {
		return CID;
	}
	public void setCID(int cID) {
		this.CID = cID;
	}
	
}
