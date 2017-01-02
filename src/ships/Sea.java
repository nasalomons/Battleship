package ships;

import battlefield.Coordinates;
import battlefield.Battlefield;

/* The Sea class is a mutable class that implements Ship. It is the default space on a Battlefield. */
public class Sea implements Ship {

	private Coordinates location;
	private boolean hitStatus;
	
	public Sea(Coordinates coordinates) {
		this.location = coordinates;
		this.hitStatus = false;
	}
	
	/* The method returns the location of the Sea object as a Coordinates<Integer, Integer>. */
	public Coordinates getCoordinates() {
		return location;
	}

	/* This method returns false if the object is not hit and true if it was */
	public boolean isHit() {
		return hitStatus;
	}

	/* Sets hitStatus to true. */
	public void beHit() {
		hitStatus = true;
	}
	
	/* The toString method of the Sea class that returns a String. It will return a String that looks like
	 * [X] if the Sea's hitStatus is true and a String that looks like [~] if it's false. */
	public String toString() {
		if(hitStatus) {
			return "[X]";
		} else {
			return "[~]";
		}
	}

	public void beSunk() {
		this.beHit();
	}

	@Override
	public Ship getOtherPart() {
		throw new RuntimeException("No otherPart of Sea");
	}
}
