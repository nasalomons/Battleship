package battlefield;

import ships.*;

public class Battlefield {
	
	private final int MAX_ROWS = 10;
	private final int MAX_COLS = 10;
	
	private Ship[][] pOneField;
	private Ship[][] pTwoField;
	
	private Tugboat pOneTugboat;
	private Tugboat pTwoTugboat;
	
	public Battlefield() {
		pOneField = new Ship[MAX_ROWS][MAX_COLS];
		pTwoField = new Ship[MAX_ROWS][MAX_COLS];
		for(int i = 0; i<MAX_ROWS; i++) {
			for(int j = 0; j<MAX_COLS; j++) {
				Coordinates coordinates = new Coordinates(i, j);
				setSea(1, coordinates);
				setSea(2, coordinates);
			}
		}
	}
	
	public void setSea(int player, Coordinates coordinates) {
		if(player == 1) {
			pOneField[coordinates.getRow()][coordinates.getCol()] = new Sea(coordinates);
		} else if(player == 2) {
			pTwoField[coordinates.getRow()][coordinates.getCol()] = new Sea(coordinates);
		} else {
			throw new RuntimeException("Invalid player: " + player);
		}
	}
	
	public void setTugboat(int player, Coordinates start, Coordinates end) {
		if(!(getShip(player, start) instanceof Sea)) {
			throw new RuntimeException("Boat already at start: " + start);
		} else if(!(getShip(player, end) instanceof Sea)) {
			throw new RuntimeException("Boat already at end: " + end);
		}
		Tugboat tugTwo = new Tugboat(start, end, null);
		Tugboat tugOne = new Tugboat(start, end, tugTwo);
		if(player == 1) {
			pOneField[start.getRow()][start.getCol()] = tugOne;
			pOneField[end.getRow()][end.getCol()] = tugOne.getOtherPart();
		} else if(player == 2) {
			pTwoField[start.getRow()][start.getCol()] = tugOne;
			pTwoField[end.getRow()][end.getCol()] = tugOne.getOtherPart();
		} else {
			throw new RuntimeException("Invalid player: " + player);
		}
	}
	
	public void setFightship(int player, Coordinates start, Coordinates end) {
		if(!(player==1||player==2)) {
			throw new RuntimeException("Invalid player: " + player);
		}
		Fightship prev = null;
		if(start.getRow()==end.getRow()) {
			for(int i = start.getCol(); i<=end.getCol(); i++) {
				if(!(getShip(player, new Coordinates(start.getRow(), i)) instanceof Sea)) {
					throw new RuntimeException("Boat already at position: " + new Coordinates(start.getRow(), i));
				}
			}
			for(int i = start.getCol(); i<=end.getCol(); i++) {
				if(player == 1) {
					Fightship curr = new Fightship(start, end, prev);
					pOneField[start.getRow()][i] = curr;
					prev = curr;
				} else {
					Fightship curr = new Fightship(start, end, prev);
					pTwoField[start.getRow()][i] = curr;
					prev = curr;
				}
			}
		} else if(start.getCol()==end.getCol()) {
			for(int i = start.getRow(); i<=end.getRow(); i++) {
				if(!(getShip(player, new Coordinates(i, start.getCol())) instanceof Sea)) {
					throw new RuntimeException("Boat already at start: " + start);
				}
			}
			for(int i = start.getRow(); i<=end.getRow(); i++) {
				if(player == 1) {
					Fightship curr = new Fightship(start, end, prev);
					pOneField[i][start.getCol()] = curr;
					prev = curr;
				} else {
					Fightship curr = new Fightship(start, end, prev);
					pTwoField[i][start.getCol()] = curr;
					prev = curr;
				}
			}
		} else {
			throw new RuntimeException("Illegal Fightship Coordinates"); 
			
		}
	}
	
	public void setSubmarine(int player, Coordinates start, Coordinates end) {
		if(!(player==1||player==2)) {
			throw new RuntimeException("Invalid player: " + player);
		}
		Submarine prev = null;
		if(start.getRow()==end.getRow()) {
			for(int i = start.getCol(); i<=end.getCol(); i++) {
				if(!(getShip(player, new Coordinates(start.getRow(), i)) instanceof Sea)) {
					throw new RuntimeException("Boat already at position: " + new Coordinates(start.getRow(), i));
				}
			}
			for(int i = start.getCol(); i<=end.getCol(); i++) {
				if(player == 1) {
					Submarine curr = new Submarine(start, end, prev);
					pOneField[start.getRow()][i] = curr;
					prev = curr;
				} else {
					Submarine curr = new Submarine(start, end, prev);
					pTwoField[start.getRow()][i] = curr;
					prev = curr;
				}
			}
		} else if(start.getCol()==end.getCol()) {
			for(int i = start.getRow(); i<=end.getRow(); i++) {
				if(!(getShip(player, new Coordinates(i, start.getCol())) instanceof Sea)) {
					throw new RuntimeException("Boat already at start: " + start);
				}
			}
			for(int i = start.getRow(); i<=end.getRow(); i++) {
				if(player == 1) {
					Submarine curr = new Submarine(start, end, prev);
					pOneField[i][start.getCol()] = curr;
					prev = curr;
				} else {
					Submarine curr = new Submarine(start, end, prev);
					pTwoField[i][start.getCol()] = curr;
					prev = curr;
				}
			}
		} else {
			throw new RuntimeException("Illegal Submarine Coordinates"); 
			
		}
	}
	
	
	public void setAircraftCarrier(int player, Coordinates start, Coordinates end) {
		if(!(player==1||player==2)) {
			throw new RuntimeException("Invalid player: " + player);
		}
		AircraftCarrier prev = null;
		if(start.getRow()==end.getRow()) {
			for(int i = start.getCol(); i<=end.getCol(); i++) {
				if(!(getShip(player, new Coordinates(start.getRow(), i)) instanceof Sea)) {
					throw new RuntimeException("Boat already at position: " + new Coordinates(start.getRow(), i));
				}
			}
			for(int i = start.getCol(); i<=end.getCol(); i++) {
				if(player == 1) {
					AircraftCarrier curr = new AircraftCarrier(start, end, prev);
					pOneField[start.getRow()][i] = curr;
					prev = curr;
				} else {
					AircraftCarrier curr = new AircraftCarrier(start, end, prev);
					pTwoField[start.getRow()][i] = curr;
					prev = curr;
				}
			}
		} else if(start.getCol()==end.getCol()) {
			for(int i = start.getRow(); i<=end.getRow(); i++) {
				if(!(getShip(player, new Coordinates(i, start.getCol())) instanceof Sea)) {
					throw new RuntimeException("Boat already at start: " + start);
				}
			}
			for(int i = start.getRow(); i<=end.getRow(); i++) {
				if(player == 1) {
					AircraftCarrier curr = new AircraftCarrier(start, end, prev);
					pOneField[i][start.getCol()] = curr;
					prev = curr;
				} else {
					AircraftCarrier curr = new AircraftCarrier(start, end, prev);
					pTwoField[i][start.getCol()] = curr;
					prev = curr;
				}
			}
		} else {
			throw new RuntimeException("Illegal AircraftCarrier Coordinates"); 
			
		}
	}
	
	public Ship[][] getPlayerOneField() {
		return pOneField;
	}
	
	public Ship[][] getPlayerTwoField() {
		return pTwoField;
	}
	
	public Ship getShip(int player, Coordinates coordinates) {
		if(player==1) {
			return pOneField[coordinates.getRow()][coordinates.getCol()];
		} else if(player==2) {
			return pTwoField[coordinates.getRow()][coordinates.getCol()];
		} else {
			throw new RuntimeException("Invalid player: " + player);
		}
	}
	
	public int numberHit(Ship ship, int count) {
		int counter = count;
		if(ship.getOtherPart()==null) {
			if(ship.isHit()) {
				counter++;
				return counter;
			} else {
				return counter;
			}
		}
		if(ship.isHit()) {
			counter++;
			return numberHit(ship.getOtherPart(), counter);
		} else {
			return counter;
		}
	}
	
	public void sinkShip(int player, Coordinates start) {
		Ship ship = getShip(player, start);
		switch(numberHit(ship, 0)) {
			case 2:
				if(ship instanceof Tugboat) {
					ship.beSunk();
					ship.getOtherPart().beSunk();
				}
				break;
			case 3:
				if(ship instanceof Fightship) {
					Ship curr = ship;
					while(curr.getOtherPart()!=null) {
						curr.beSunk();
						curr = curr.getOtherPart();
					}
					curr.beSunk();
				}
				break;
			case 4:
				if(ship instanceof Submarine) {
					Ship curr = ship;
					while(curr.getOtherPart()!=null) {
						curr.beSunk();
						curr = curr.getOtherPart();
					}
					curr.beSunk();
				}
				break;
			case 5:
				if(ship instanceof AircraftCarrier) {
					Ship curr = ship;
					while(curr.getOtherPart()!=null) {
						curr.beSunk();
						curr = curr.getOtherPart();
					}
					curr.beSunk();
					break;
				}
			default:
				return;
		}
	}
	
	
	public String toString() {
		String result = "Player One Board: \n";
		for(int i = 0; i<MAX_COLS; i++) {
			result += "[" + i + "]";
		}
		result+="\n";
		char rowLetterOne = 'A';
		for(int i = 0; i<MAX_ROWS; i++) {
			result+= "[" + rowLetterOne++ + "]";
			for(int j = 0; j<MAX_COLS; j++) {
				result+= getShip(1, new Coordinates(i, j));
			}
			result+="\n";
		}
		result+="\n\n";
		result += "Player Two Board: \n";
		for(int i = 0; i<MAX_COLS; i++) {
			result += "[" + i + "]";
		}
		result+="\n";
		char rowLetterTwo = 'A';
		for(int i = 0; i<MAX_ROWS; i++) {
			result+= "[" + rowLetterTwo++ + "]";
			for(int j = 0; j<MAX_COLS; j++) {
				result+= getShip(2, new Coordinates(i, j));
			}
			result+="\n";
		}
		return result;
	}
	
}
