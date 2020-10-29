package DataObjects;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FlightTower {
	
	private Lock lock;
	Queue<Lane> lanes;
	private Condition emptyLanes; // Putting the thread to sleep if the condition is met.
	
	public FlightTower() {
		lock = new ReentrantLock();
		lanes = new LinkedList<Lane>();
		emptyLanes = lock.newCondition();
	}
	
	public FlightTower(List<Lane> lanes) {
		lock = new ReentrantLock();
		emptyLanes = lock.newCondition();
		this.lanes = new LinkedList<Lane>();
		for(int i=0;i<lanes.size();i++) {
			this.lanes.add(lanes.get(i));
		}
	}
	
	public Lane getLane() throws InterruptedException {
		Lane result = null;
		lock.lock();
		try {
			while(lanes.isEmpty()) {
				emptyLanes.await();
			}
			result = lanes.poll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void returnLane(Lane lane) {
		try {
			lanes.add(lane);
		}
		finally {
			lock.unlock();
		}
	}

}
