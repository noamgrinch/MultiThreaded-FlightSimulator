package DataObjects;

import java.util.HashSet;
import java.util.Set;

public class Airline implements Runnable{
	
	private String name;
	private Set<Aircraft> aircrafts;
	private FlightsCoordinator flightsCoordinator;
	
	public Airline() {
		this.aircrafts = new HashSet<Aircraft>();
		this.flightsCoordinator = new FlightsCoordinatorImpl();
	}
	
	public Airline(String name) {
		this.name=name;
		this.aircrafts = new HashSet<Aircraft>();
		this.flightsCoordinator = new FlightsCoordinatorImpl();
	}
	
	public void addAircraft(Aircraft aircraft) {
		this.aircrafts.add(aircraft);
	}
	
	public Set<Aircraft> getAircrafts(){
		return this.aircrafts;
	}
	
	public String getName() {
		return this.name;
	}
	
	public FlightsCoordinator getCoordinator() {
		return this.flightsCoordinator;
	}

	@Override
	public void run() {
		this.flightsCoordinator.start();	
	}

}
