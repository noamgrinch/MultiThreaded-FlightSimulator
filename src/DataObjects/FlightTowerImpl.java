package DataObjects;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FlightTowerImpl implements FlightTower{
	
	BlockingQueue<Lane> lanes;
	
	public FlightTowerImpl() {
		lanes = new LinkedBlockingQueue<Lane>();
	}
	
	public FlightTowerImpl(List<Lane> lanes) {
		this.lanes = new LinkedBlockingQueue<Lane>();
		for(int i=0;i<lanes.size();i++) {
			this.lanes.add(lanes.get(i));
		}
	}

	@Override
	public Lane getLane() throws InterruptedException {
		return lanes.take();
	}

	@Override
	public void returnLane(Lane lane) {
		lanes.add(lane);	
	}

}
