package DataObjects;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FlightTower {
	

	BlockingQueue<Lane> lanes;
	
	public FlightTower() {
		lanes = new LinkedBlockingQueue<Lane>();
	}
	
	public FlightTower(List<Lane> lanes) {
		this.lanes = new LinkedBlockingQueue<Lane>();
		for(int i=0;i<lanes.size();i++) {
			this.lanes.add(lanes.get(i));
		}
	}
	
	public Lane getLane() throws InterruptedException {
		return lanes.take();
	}
	
	public void returnLane(Lane lane) {
		lanes.add(lane);
	}

}
