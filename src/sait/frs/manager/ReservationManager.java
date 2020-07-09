package sait.frs.manager;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

import sait.frs.problemdomain.Flight;
import sait.frs.problemdomain.Reservation;

public class ReservationManager {
	private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	Scanner scan = new Scanner(System.in);

	public ReservationManager() {

	}

	public Reservation makeReservation(Flight flight, String name, String citizenship) {
		// add try catch for null or empty name and citiznship
		// add try cathc to see if flight has seats availble
		Reservation r1 = new Reservation(flight, name, citizenship);
		reservations.add(r1);
		return r1;

	}

	public ArrayList<Reservation> findReservations(String code, String airline, String name) {
		ArrayList<Reservation> foundReservations = new ArrayList<>();
		for (Reservation r1 : reservations) {
			// if(r1.getCode().equals(code)) and if(r1.getAirline().equals(airline)) and
			// if(r1.getName().equals(name)){
			if (r1.getCode().equals(code)) {
				if (r1.getAirline().equals(airline)) {
					if (r1.getName().equals(name)) {
						foundReservations.add(r1);
						return foundReservations;
					}
				}

			}
		}
		return null;
	}

	public Reservation findReservationByCode(String code) {
		Reservation returnCode = new Reservation();
		for (Reservation r1 : reservations) {
			if (r1.getCode().equals(code)) {
				returnCode = r1;
			}
		}
		return returnCode; 
	}

	public void persist() throws IOException {
		RandomAccessFile randomFile = new RandomAccessFile("reservations.dat", "rw");
		long position = randomFile.getFilePointer();
		 if (search.equals(code)) { Reservation r1 = new Reservation(name,
				  citizenship, flightCode, codeInFile, airline, cost, active); return r1; } }
				  System.out.println("code not found"); randomFile.close(); return null;
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
				cost = Double.parseDouble(randomFile.readUTF());
				for (int i = 0; i < 20 - String.valueOf(cost).length(); i++) {
					randomFile.readByte();
				}
				active = Boolean.parseBoolean(randomFile.readUTF());
				for (int i = 0; i < 20 - String.valueOf(active).length(); i++) {
					randomFile.readByte();
				}
				Reservation r1 = new Reservation(flightCode, name, citizenship, code, airline, cost, active);
				reservations.add(r1);
			}
			randomFile.close();

		} catch (java.io.IOException e) {
			e.getMessage();
		}
	}

}
