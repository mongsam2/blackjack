import javax.swing.JOptionPane;

public class CardGame {

	public static void main(String[] args) {
		
		CardDeck cd = new CardDeck();
		HumanPlayer p = new HumanPlayer(5, 10000);
		ComputerPlayer d = new ComputerPlayer(5, 0);
		GameModel m = new GameModel(p, d, cd);
	    	GameFrame f = new GameFrame(m, p, d, cd);
	    
	}
}
