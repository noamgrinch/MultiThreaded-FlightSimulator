package DataObjects;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FlightTowerImpl implements FlightTower{
	
	Queue<Lane> lanes;
	
	public FlightTowerImpl() {
		lanes = new LinkedList<Lane>();
	}
	
	public FlightTowerImpl(List<Lane> lanes) {
		this.lanes = new LinkedList<Lane>();
		for(int i=0;i<lanes.size();i++) {
			this.lanes.add(lanes.get(i));
		}
	}

	@Override
	public synchronized Lane getLane() throws InterruptedException {
		while(lanes.isEmpty()) {
			this.wait();
		}
		return lanes.poll();
	}

	@Override
	public synchronized void returnLane(Lane lane) {
		lanes.add(lane);
		this.notifyAll();
	}

}
