package DataObjects;

public abstract class Lane {
	
	private Integer id;
	private boolean occupied;
	
	public Lane(Integer id) {
		this.id=id;
	}
	
	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return this.id;
	}
	
	public synchronized void setOccupied(boolean bool) {
		this.occupied=bool;
	}
	
	public synchronized boolean isOccupied() {
		return this.occupied;
	}
	
}
