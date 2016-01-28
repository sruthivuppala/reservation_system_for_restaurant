package io.restaurant.model;

public class CompleteData {
		private String reservation_ID;
		private String reservation_Date;
		private String reservation_Time;
		private int reservation_Size;
		private String table_Type;
		private String reservation_Status;
		private int CID;
		
		//private int id;
		private String firstname;
		private String lastname;
		private String email;
		private String address1;
		private String address2;
		private String city;
		private int zip;
		private String state;
		private String phone;
		private String successful;
		
		
		public void setReservation_ID(String reservation_ID) {
			this.reservation_ID = reservation_ID;
		}

		public void setCID(int cID) {
			CID = cID;
		}
		

		/*public void setId(int id) {
			this.id = id;
		}*/	
			
		public void setReservation_Status(String reservation_Status) {
			this.reservation_Status = reservation_Status;
		}
		
		

		public void setSuccessful(String successful) {
			this.successful = successful;
		}

		public String getReservation_ID() {
			return reservation_ID;
		}
		
		public String getReservation_Date() {
			return reservation_Date;
		}
		public String getReservation_Time() {
			return reservation_Time;
		}
		public int getReservation_Size() {
			return reservation_Size;
		}
		public String getTable_Type() {
			return table_Type;
		}
		public String getReservation_Status() {
			return reservation_Status;
		}
		public int getCID() {
			return CID;
		}
		/*public int getId() {
			return id;
		}*/
		public String getFirstname() {
			return firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public String getEmail() {
			return email;
		}
		public String getAddress1() {
			return address1;
		}
		public String getAddress2() {
			return address2;
		}
		public String getCity() {
			return city;
		}
		public int getZip() {
			return zip;
		}
		public String getState() {
			return state;
		}
		public String getPhone() {
			return phone;
		}

		public String getSuccessful() {
			return successful;
		}
		
}
