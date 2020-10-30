package Program;

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

public class Main {

	
	public static void main(String[] args) {
		

		ExecutorService e = Executors.newCachedThreadPool();
		List<Lane> lanes = new ArrayList<Lane>();
		for(int i=0;i<4;i++) {
			lanes.add(new Lane(i));
		}
		FlightTower f1 = new FlightTowerImpl(lanes);
		lanes = new ArrayList<Lane>();
		for(int i=0;i<4;i++) {
			lanes.add(new Lane(10 + i));
		}
		FlightTower f2 = new FlightTowerImpl(lanes);
		lanes = new ArrayList<Lane>();
		for(int i=0;i<4;i++) {
			lanes.add(new Lane(100 + i));
		}
		FlightTower f3 = new FlightTowerImpl(lanes);
		Airport a1 = new Airport(f1);
		Airport a2 = new Airport(f2);
		Airport a3 = new Airport(f3);
		Airport[] airports = {null,a1,a2,a3};
		Airline elal = new Airline("ELAL");
		Aircraft air = new Aircraft("AIR-FORCE-1");
		for(int i=0;i<15;i++) {
			int depart = ThreadLocalRandom.current().nextInt(1, 4);
			elal.getCoordinator().addFlight((new Flight(i,airports[depart],airports[(depart)%4],air)));
		}
		e.execute(elal);
		e.shutdown();

		
	}

}
