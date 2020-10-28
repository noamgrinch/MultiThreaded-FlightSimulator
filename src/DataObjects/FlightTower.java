package DataObjects;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FlightTower {
	
	Queue<Lane> lanes;
	
	public FlightTower() {
		lanes = new LinkedList<Lane>();
	}
	
	public FlightTower(List<Lane> lanes) {
		this.lanes = new LinkedList<Lane>();
		for(int i=0;i<lanes.size();i++) {
			this.lanes.add(lanes.get(i));
		}
	}
	
	public synchronized Lane getLane() throws InterruptedException {
		while(lanes.isEmpty()) {
			this.wait();
		}
		return lanes.poll();
	}
	
	public synchronized void returnLane(Lane lane) {
		lanes.add(lane);
		this.notifyAll();
	}

}
