package Program;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

import DataObjects.Aircraft;
import DataObjects.Airline;
import DataObjects.Airport;
import DataObjects.Flight;
import DataObjects.FlightTower;
import DataObjects.FlightTowerImpl;
import DataObjects.Lane;
import Utilities.Utilities;

public class Main {
	
	public static int LANES = 4, PREFIX = 10,AIRPORTS = 3;

	
	public static void main(String[] args) {
		

		ExecutorService e = Executors.newCachedThreadPool();
		List<Airport> airports = Utilities.generateAirports(Utilities.generateFlightTowers(PREFIX, LANES, AIRPORTS));
		Airline elal = new Airline("ELAL","EL");
		Aircraft air1 = new Aircraft("ARIK-1");
		for(int i=0;i<8;i++) {
			int depart = ThreadLocalRandom.current().nextInt(0, 3);
			Flight tmp = new Flight(elal.getTicker() + i,airports.get(depart),airports.get((depart)%4),air1,
					LocalDate.of(2020, Month.JANUARY, 5),LocalDate.of(2020, Month.JANUARY, 8));
			elal.getCoordinator().addFlight(tmp);
		}
		Airline lufthansa = new Airline("Lufthansa","LF");
		Aircraft air2 = new Aircraft("LUF-1");
		for(int i=0;i<8;i++) {
			int depart = ThreadLocalRandom.current().nextInt(0, 3);
			Flight tmp = new Flight(lufthansa.getTicker() + i,airports.get(depart),airports.get((depart)%4),air2,
					LocalDate.of(2020, Month.JANUARY, 5),LocalDate.of(2020, Month.JANUARY, 8));
			lufthansa.getCoordinator().addFlight(tmp);
		}
		e.execute(elal);
		e.execute(lufthansa);
		e.shutdown();

		
	}

}
