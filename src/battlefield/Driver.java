package battlefield;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Driver extends JPanel{
	
	private final int GAME_IN_PROGRESS = 0;
	private final int PLAYER_ONE_WINS = 1;
	private final int PLAY_TWO_WINS = 2;
	
	private int gameStatus;
	private Battlefield battlefield;
	
	public Driver() {
		gameStatus = GAME_IN_PROGRESS;
		battlefield = new Battlefield();
	}
	
	public static void playGame() {
		
	}
	
	public static void main(String[] args) {
		
		
		
	}

}
