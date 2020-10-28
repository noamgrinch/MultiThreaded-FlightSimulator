package DataObjects;

import java.util.concurrent.ThreadLocalRandom;

public class Flight extends Thread{

	private int id;
	private Airport departureAirport, landingAirport;
	private Lane departureLane = null, landingLane = null;
	
	public Flight(int id,Airport departureAirport, Airport landingAirport) {
		this.departureAirport=departureAirport;
		this.landingAirport=landingAirport;
		this.id=id;
	}
	
	public int getFlightId() {
		return this.id;
	}

	@Override
	public void run() {
		
		try {
			departureLane = this.departureAirport.getFlightTower().getLane();
			System.out.println("Flight number " + this.id + " is departing in lane number " + departureLane.getId());
			Thread.sleep(ThreadLocalRandom.current().nextInt(1, 10)*500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Flight number " + this.id + " has departed from lane number " + departureLane.getId());
		this.departureAirport.getFlightTower().returnLane(departureLane);
		System.out.println("Flight number " + this.id + " is now cruising...");
		try {
			Thread.sleep(ThreadLocalRandom.current().nextInt(1, 10)*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			landingLane = this.landingAirport.getFlightTower().getLane();
			System.out.println("Flight number " + this.id + " is landing in lane number " + landingLane.getId());
			Thread.sleep(ThreadLocalRandom.current().nextInt(1, 10)*500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Flight number " + this.id + " has landed in lane number " + landingLane.getId());
		this.landingAirport.getFlightTower().returnLane(landingLane);
	}
}
