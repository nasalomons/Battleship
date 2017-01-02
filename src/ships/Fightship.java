package ships;

import battlefield.Coordinates;

public class Fightship implements Ship{

	private Coordinates coordinates;
	private boolean hitStatus;
	private boolean sunkStatus;
	private Fightship otherPart;
	
	public Fightship(Coordinates startCoordinates, Coordinates endCoordinates, Fightship otherPart) {
		if((startCoordinates.getRow()-endCoordinates.getRow()==2&&startCoordinates.getCol()==endCoordinates.getCol())
				||(startCoordinates.getRow()-endCoordinates.getRow()==-2&&startCoordinates.getCol()==
				endCoordinates.getCol())||(startCoordinates.getCol()-endCoordinates.getCol()==2&&
				startCoordinates.getRow()==endCoordinates.getRow())||(startCoordinates.getCol()
				-endCoordinates.getCol()==-2&&startCoordinates.getRow()==endCoordinates.getRow())) {
			this.coordinates = startCoordinates;
			this.otherPart = otherPart;
		} else {
			throw new RuntimeException("Invalid Fightship Coordinates:" + startCoordinates + ", " + 
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
			return "[F]";
		}
	}
	
}
