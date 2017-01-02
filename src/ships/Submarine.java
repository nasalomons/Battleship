package ships;

import battlefield.Coordinates;

public class Submarine implements Ship{
	private Coordinates coordinates;
	private boolean hitStatus;
	private boolean sunkStatus;
	private Submarine otherPart;
	
	public Submarine(Coordinates startCoordinates, Coordinates endCoordinates, Submarine otherPart) {
		if((startCoordinates.getRow()-endCoordinates.getRow()==3&&startCoordinates.getCol()==endCoordinates.getCol())
				||(startCoordinates.getRow()-endCoordinates.getRow()==-3&&startCoordinates.getCol()==
				endCoordinates.getCol())||(startCoordinates.getCol()-endCoordinates.getCol()==3&&
				startCoordinates.getRow()==endCoordinates.getRow())||(startCoordinates.getCol()
				-endCoordinates.getCol()==-3&&startCoordinates.getRow()==endCoordinates.getRow())) {
			this.coordinates = startCoordinates;
			this.otherPart = otherPart;
		} else {
			throw new RuntimeException("Invalid Submarine Coordinates:" + startCoordinates + ", " + 
					endCoordinates);
		}
	}
	
	public Coordinates getCoordinates() {
		return coordinates;
	}
	
	public boolean isHit() {
		return hitStatus;
	}

	public void beHit() {
		hitStatus = true;
	}

	public void beSunk() {
		sunkStatus = true;
	}

	public Ship getOtherPart() {
		return otherPart;
	}

	public String toString() {
		if(sunkStatus) {
			return "[s]";
		} else if(hitStatus) {
			return "[h]";
		} else {
			return "[S]";
		}
	}
}
