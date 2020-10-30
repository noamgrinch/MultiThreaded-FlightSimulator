package DataObjects;

public interface FlightTower {
		
	public Lane getLane() throws InterruptedException;
	public void returnLane(Lane lane);

}
