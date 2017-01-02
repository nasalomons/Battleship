package ships;

import battlefield.Coordinates;

public interface Ship {
	
	public Coordinates getCoordinates();
	public boolean isHit(); 
	public void beHit();
	public void beSunk();
	public Ship getOtherPart();
}
