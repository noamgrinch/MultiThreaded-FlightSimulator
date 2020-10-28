package DataObjects;

import java.util.List;

public class Airport {
	
	private List<DepartureLane> departureLane;
	private List<LandingLane> ladningLanes;
	
	public Airport(List<DepartureLane> departureLane,List<LandingLane> ladningLanes) {
		this.departureLane=departureLane;
		this.ladningLanes=ladningLanes;
	}
	
	public List<DepartureLane> getDepartureLanes() {
		return this.departureLane;
	}
	
	public List<LandingLane> getLandingLanes() {
		return this.ladningLanes;
	}

}
