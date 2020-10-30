package DataObjects;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class FlightsCoordinatorImpl implements FlightsCoordinator{
	
	ExecutorService e;
	BlockingQueue<Flight> flights;
	
	
	public FlightsCoordinatorImpl() {
		e = Executors.newCachedThreadPool();
		flights = new LinkedBlockingQueue<Flight>();
	}

	@Override
	public void addFlight(Flight flight) {
		flights.add(flight);
	}

	@Override
	public void start() {
		for(int i=0;i<flights.size();i++) {
			e.execute(flights.poll());
		}
		// If shutdown() is no called, the threads are being labeled as Non-daemon threads.
		// Due to that fact the JVM will not halt when they are terminated.
		e.shutdown();
	}

	@Override
	public void generateFlights() {

	}
	

}
