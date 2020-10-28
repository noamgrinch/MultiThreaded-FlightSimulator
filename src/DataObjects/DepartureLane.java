package DataObjects;

public class DepartureLane extends Lane{

	public DepartureLane(Integer id) {
		super(id);
	}
	
	public synchronized void use(Flight flight) throws InterruptedException {
		while(this.isOccupied()) {
			this.wait();
		}
		System.out.println("Flight number " + flight.getFlightId() + " is departing in lane number " + this.getId());
		Thread.sleep(2000);
		System.out.println("Flight number " + flight.getFlightId() + " has departed in lane number " + this.getId());
		this.setOccupied(false);
		this.notifyAll();
	}

}
