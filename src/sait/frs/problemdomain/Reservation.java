package sait.frs.problemdomain;

import java.io.RandomAccessFile;

import sait.frs.exception.InvalidFlightCodeException;
import sait.frs.problemdomain.Flight;

public class Reservation {
	 private String code;
	 private String flightCode;
	 private String airline;
	 private String name;
	 private String citizenship;
	 private double cost;
	 private boolean active;
	
	 public Reservation() {
		 
	 }
	 
	 public Reservation(Flight flight, String name, String citizenship) {
		 this.name = name;
		 this.citizenship = citizenship;
		 this.flightCode  = flight.getCode();
		 this.code = getCode();
		 this.airline = getAirline();
		 this.cost = flight.getCostPerSeat();
		 this.active = isActive();
		 
		 /**try {
			 RandomAccessFile randomFile = new RandomAccessFile("reservations.dat", "rw");
			 long  fileSize = randomFile.length();
			 randomFile.seek(fileSize);
			 
			 randomFile.writeUTF(this.name);
			 for (int i = 0;i <20-name.length(); i++ ) {
				 randomFile.writeByte(20);
			 }
			 randomFile.writeUTF(this.citizenship);
			 for (int i = 0;i <20-citizenship.length(); i++ ) {
				 randomFile.writeByte(20);
			 }
			 randomFile.writeUTF(this.flightCode);
			 for (int i = 0;i <20-flightCode.length(); i++ ) {
				 randomFile.writeByte(20);
			 }
			 randomFile.writeUTF(this.code);
			 for (int i = 0;i <20-code.length(); i++ ) {
				 randomFile.writeByte(20);
			 }
			 randomFile.writeUTF(this.airline);
			 for (int i = 0;i <20-airline.length(); i++ ) {
				 randomFile.writeByte(20);
			 }
			 randomFile.writeDouble(this.cost);
			 for (int i = 0;i <20-String.valueOf(cost).length(); i++ ) {
				 randomFile.writeByte(20);
			 }
			 randomFile.writeBoolean(this.active);
			 for (int i = 0;i <20-String.valueOf(active).length(); i++ ) {
				 randomFile.writeByte(20);
			 }
			 randomFile.close();
			 
		 }catch (java.io.IOException e) {
				e.getMessage();
			}*/
		 }
		 

	 public Reservation(String FlightCode, String name, String citizenship, 
			 String code, String airline, double cost, boolean active) {
		 this.name = name;
		 this.citizenship = citizenship;
		 this.flightCode  = FlightCode;
		 this.code = code;
		 this.airline = airline;
		 this.cost = cost;
		 this.active = active;
	 }
	 
	 public Reservation(Flight flight, String name, String citizenship, String code) throws InvalidFlightCodeException {
		 this.name = name;
		 this.citizenship = citizenship;
		 this.flightCode  = flight.getCode();
		 this.code = code;
		 this.airline = flight.getAirline();
		 this.cost = flight.getCostPerSeat();
		 this.active = true;
	 }
	 
	 
	 
	 public String getCode() {
		 return code; 
	 }

	public void setCode(String string) {
		this.code = code;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public String getAirline() {
		return airline;
	}

	public String getName() {
		return name;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public double getCost() {
		return cost;
	}

	public boolean isActive() {
		return active;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	/**@Override
	public String toString() {
		return "Reservation [code=" + code + ", flightCode=" + flightCode + ", airline=" + airline + ", name=" + name
				+ ", citizenship=" + citizenship + ", cost=" + cost + ", active=" + active + "]";
	}*/
	
	@Override
	public String toString() {
		return  code ;
	}
	 
	 
}
