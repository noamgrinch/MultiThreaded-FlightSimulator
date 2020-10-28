package DataObjects;

public class Airport {
	
	private FlightTower flightTower;
	
	public Airport(FlightTower flightTower) {
		this.flightTower=flightTower;
	}
	
	public FlightTower getFlightTower() {
		return this.flightTower;
	}

}
