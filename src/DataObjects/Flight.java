package DataObjects;

public class Flight extends Thread{

	private int id;
	private LandingLane landingLane;
	private DepartureLane departureLane;
	private boolean departed = false;
	private boolean landed = false;
	
	public Flight(int id,LandingLane landingLane,DepartureLane departureLane) {
		this.departureLane=departureLane;
		this.landingLane=landingLane;
		this.id=id;
	}
	
	public int getFlightId() {
		return this.id;
	}

	@Override
	public void run() {
		try {
			this.departureLane.use(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Flight number " + this.id + " is now cruising...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.landingLane.use(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
