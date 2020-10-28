package Program;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import DataObjects.Airport;
import DataObjects.Flight;
import DataObjects.FlightTower;
import DataObjects.Lane;

public class Main {

	
	public static void main(String[] args) {
		

		ExecutorService e = Executors.newCachedThreadPool();
		List<Lane> lanes = new ArrayList<Lane>();
		for(int i=0;i<7;i++) {
			lanes.add(new Lane(i));
		}
		FlightTower f1 = new FlightTower(lanes);
		lanes = new ArrayList<Lane>();
		for(int i=0;i<7;i++) {
			lanes.add(new Lane(10 + i));
		}
		FlightTower f2 = new FlightTower(lanes);
		Airport a1 = new Airport(f1);
		Airport a2 = new Airport(f2);
			

		for(int i=0;i<5;i++) {
			e.execute(new Flight(i,a1,a2));
		}
		// If shutdown() is no called, the threads are being labeled as Non-daemon threads.
		// Due to that fact the JVM will not halt when they are terminated.
		e.shutdown();
		
	}

}
