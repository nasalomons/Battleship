package battlefield;

/* The Coordinates<R, C> class is an immutable class. */
public class Coordinates {

	private int row;
	private int col;
	
	public Coordinates(int row, int col) {
		if(row<0||row>9||col<0||col>9) {
			throw new RuntimeException("Invalid coordinates: " + row + ", " + col);
		}
		this.row = row; 
		this.col = col;
	}
	
	/* Returns the first int in the pair of Coordinates. */
	public int getRow() {
		return row;
	}
	
	/* Returns the second int in the pair of Coordinates. */
	public int getCol() {
		return col;
	}
	
	public boolean equals(Object other) {
		if(this == other) {
			return true;
		}
		if(!(other instanceof Coordinates)) {
			return false;
		}
		Coordinates otherCoor = (Coordinates)other;
		return this.getRow()==otherCoor.getRow()&&this.getCol()==otherCoor.getCol();
	}
	
	/* The toString method of the Coordinates class. Returns a String of the following form: "(row, col)". */
	public String toString() {
		return "(" + row + ", " + col + ")";
	}
}
