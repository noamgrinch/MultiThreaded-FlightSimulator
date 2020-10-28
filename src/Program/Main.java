package Program;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import DataObjects.DepartureLane;
import DataObjects.Flight;
import DataObjects.LandingLane;

public class Main {
	
	public static void main(String[] args) {

		ExecutorService e = Executors.newCachedThreadPool();

		List<LandingLane> llanes = new ArrayList<LandingLane>();
		List<DepartureLane> dlanes = new ArrayList<DepartureLane>();
		for(int i=0;i<5;i++) {
			llanes.add(new LandingLane(i));
			dlanes.add(new DepartureLane(10+i));
		}

		for(int i=0;i<5;i++) {
			e.execute(new Flight(i,llanes.get(ThreadLocalRandom.current().nextInt(0, 5)),dlanes.get(ThreadLocalRandom.current().nextInt(0, 5))));
		}
		// If shutdown() is no called, the threads are being labeled as Non-daemon threads.
		// Due to that fact the JVM will not halt when they are terminated.
		e.shutdown();
		
	}

}
