package sait.frs.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import sait.frs.problemdomain.Flight;

/**
 * 
 * @author Joel Wood and Zennon Weleschuck
 * @version 1.0, June 6 2020
 *
 */

public class FlightManager {
	/**
	 * Fields for the FlightManager class
	 */
	private static final String AIRPORTS_PATH = "res/airports.txt";
	private static final String FLIGHTS_PATH = "res/flights.txt";
	public final String WEEKDAY_ANY = "Any";
	public final String WEEKDAY_SUNDAY = "Sunday";
	public final String WEEKDAY_MONDAY = "Monday";
	public final String WEEKDAY_TUESDAY = "Tuesday";
	public final String WEEKDAY_WEDNESDAY = "Wednesday";
	public final String WEEKDAY_THURSDAY = "Thursday";
	public final String WEEKDAY_FRIDAY = "Friday";
	public final String WEEKDAY_SATURDAY = "Saturday";
	private ArrayList<Flight> flights = new ArrayList<>();
	private ArrayList<String> airports = new ArrayList<>();
	
	/**
	 * Default constructor for the flight manager
	 * @throws FileNotFoundException 
	 */
	public FlightManager() throws FileNotFoundException {
		getAirports();
		getFlights();
	}
	
	/**
	 * Gets all of the airports.
	 * @return airports ArrayList of airports
	 * @throws FileNotFoundException 
	 */
	public ArrayList<String> getAirports() throws FileNotFoundException {
		FlightManager fm = new FlightManager();
		fm.populateAirports();
		return airports;	
	}
	
	/**
	 * Gets all of the flights
	 * @return ArrayList of Flight objects
	 * @throws FileNotFoundException 
	 */
	public ArrayList<Flight> getFlights() throws FileNotFoundException{
		FlightManager fm = new FlightManager();
		fm.populateFlights();
		return flights;
	}
	
	/**
	 * Finds specific airport by code
	 * @param code Airport code
	 * @return
	 */
	public String findAirportByCode(String code){
		String airportReturned = "";
		for(String a1 : airports) {
			if(a1.contains(code)) {
				airportReturned = a1;
			}
		}
		return airportReturned;
	}
	
	/**
	 * Finds a flight using code
	 * @param flight Flight code
	 * @return
	 */
	public Flight findFlightByCode(String flightCode) {
		Flight returnFlight = new Flight();
		for(Flight f1 : flights) {
			if (f1.getCode().equals(flightCode)){
				returnFlight = f1;
			}
		}
		return returnFlight;
	}
	/**
	 * Finds flights going between airports on a specified weekday
	 * @param from  From airport
	 * @param to To airport
	 * @param weekday Day of week (one of WEEKDAY_* constants). Use WEEKDAY_ANY for any day of the week.
	 * @return flights Any found Flight objects
	 */
	public ArrayList<Flight> findFlights(String from, String to, String weekday){
		ArrayList<Flight> foundFlights = new ArrayList<>();
		for(Flight f1 : flights) {
			if (f1.getFrom() == from && f1.getTo() == to && f1.getWeekday() == weekday) {
				foundFlights.add(f1);
			}
		}
		return foundFlights;
	}
	/**
	 * Populates flights from text file
	 */
	private void populateFlights() throws FileNotFoundException{
		Scanner inFile = new Scanner(new File(FLIGHTS_PATH));
		inFile.useDelimiter (",");
		
		while (inFile.hasNext()) {
			String flightCode = inFile.next();
			String airline;
			char c1 = flightCode.charAt(0);
			char c2 = flightCode.charAt(1);
			if (c1 == 'O' && c2 == 'A') {
				airline = "Otto Airlines";
			}
			else if (c1 == 'C' && c2 == 'A') {
				airline = "Conned Air";
			}
			else if (c1 == 'T' && c2 == 'B') {
				airline = "Try a Bus Airways";
			}
			else if (c1 == 'V' && c2 == 'A') {
				airline = "Vertical Airways";
			}
			else {
				airline = "Not a valid Airline";
			}
			String from = inFile.next();
			String to = inFile.next();
			String weekday = inFile.next();
			String time = inFile.next();
			int seats = inFile.nextInt();
			double costPerSeat = inFile.nextDouble();
			inFile.nextLine();
			
			Flight f = new Flight(flightCode, airline, from, to, weekday, time, seats, costPerSeat);
			
			flights.add(f);
		}//loop process all flight objects
		inFile.close();
	}
	
	/**
	 * Populates airports with the airports from CSV file
	 */
	private void populateAirports()  throws FileNotFoundException {
		Scanner inFile = new Scanner(new File(AIRPORTS_PATH));
		inFile.useDelimiter (",");
		
		while(inFile.hasNext()) {
			//String airportCode = inFile.next();
			String airportName = inFile.nextLine();
			//airports.add(airportCode); 
			airports.add(airportName);
		}//loop to process all airports
		inFile.close();
	}
	
	
	
}
