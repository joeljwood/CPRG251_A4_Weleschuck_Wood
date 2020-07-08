package sait.frs.manager;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.*;

import sait.frs.problemdomain.Flight;
import sait.frs.problemdomain.Reservation;

public class ReservationManager {
	private ArrayList<Reservation> reservations = new ArrayList<Reservation>();

	public ReservationManager() {
		// constructor???
	}

	public Reservation makeReservation(Flight flight, String name, String citizenship) {
		// add try catch for null or empty name and citiznship
		// add try cathc to see if flight has seats availble
		Reservation r1 = new Reservation(flight, name, citizenship);
		return r1;

		// random access write
		/*
		 * RandomAccessFile randomFile = new RandomAccessFile("reservations.dat", "rw");
		 * for (Reservation ReservationArray: reservations) { randomFile.writeUTF();
		 * System.out.println(ReservationArray.toString()); } randomFile.close();
		 * System.out.println("Done.");
		 */
	}

	/**public reservations findReservations(String code, String airline, String name){
		if ((code.equals(code)) or (airline.equals(airline)) or (name.equals(name))) {
			return reservations;
		}else {
	System.out.print("no reservation found");
		}
	}

	public Reservation findReservationByCode(String Code) {
		// write code here
		return Reservation;
	}*/

	public void persist() {
		// write code here which saves to file?
	}

	private int getAvailableSeats(Flight flight) {
		return flight.getSeats();
	}

	private String generateReservationCode(Flight flight) {
		String code;
		if (flight.isDomestic()) {
			code = "D";
		} else {
			code = "I";
		}
		code = code + (Math.random() * (10000 - 1000 + 1) + 1000);
		return code;
	}

	private void populateFromBinary() {
		final int record = 168;// (7*20->)140 + (7*2->)28 = 168
		String code = "";
		String flightCode = "";
		String airline = "";
		String name = "";
		String citizenship = "";
		double cost = 0.0;
		boolean active = true;

		try {
			RandomAccessFile randomFile = new RandomAccessFile("reservations.dat", "rw");
			long fileSize = randomFile.length();
			randomFile.seek(0);
			long NumRecords = fileSize / record;
			for (int j = 0; j < NumRecords; j++) {

				name = randomFile.readUTF();
				for (int i = 0; i < 20 - name.length(); i++) {
					randomFile.readByte();
				}
				citizenship = randomFile.readUTF();
				for (int i = 0; i < 20 - citizenship.length(); i++) {
					randomFile.readByte();
				}
				flightCode = randomFile.readUTF();
				for (int i = 0; i < 20 - flightCode.length(); i++) {
					randomFile.readByte();
				}
				code = randomFile.readUTF();
				for (int i = 0; i < 20 - code.length(); i++) {
					randomFile.readByte();
				}
				airline = randomFile.readUTF();
				for (int i = 0; i < 20 - airline.length(); i++) {
					randomFile.readByte();
				}
				cost =Double.parseDouble(randomFile.readUTF());
				for (int i = 0; i < 20 - String.valueOf(cost).length(); i++) {
					randomFile.readByte();
				}
				active = Boolean.parseBoolean(randomFile.readUTF());
				for (int i = 0; i < 20 - String.valueOf(active).length(); i++) {
					randomFile.readByte();
				}
			}
			randomFile.close();
			Reservation r1 = new Reservation(flightCode, name, citizenship, code, airline, cost, active);
		
		} catch (java.io.IOException e) {
			e.getMessage();
		}
	}

}
