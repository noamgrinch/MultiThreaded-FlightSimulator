package DataObjects;

public class LandingLane extends Lane{
	
	public LandingLane(Integer id) {
		super(id);
	}
	
	public synchronized void use(Flight flight) throws InterruptedException {
		while(this.isOccupied()) {
			this.wait();
		}
		System.out.println("Flight number " + flight.getFlightId() + " is landing in lane number " + this.getId());
		Thread.sleep(2000);
		System.out.println("Flight number " + flight.getFlightId() + " has landed in lane number " + this.getId());
		this.setOccupied(false);
		this.notifyAll();
	}

}
