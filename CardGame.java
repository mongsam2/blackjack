import javax.swing.JOptionPane;

public class CardGame {

	public static void main(String[] args) {
		
		CardDeck cd = new CardDeck();
		HumanPlayer p = new HumanPlayer(5, 10000);
		ComputerPlayer d = new ComputerPlayer(5, 0);
		GameModel m = new GameModel(p, d, cd);
	    GameFrame f = new GameFrame(m, p, d, cd);
	    
		/*boolean p1_wants_card = true;
	    boolean p2_wants_card = true;
		int p1_score = 0;
		int p2_score = 0;
		while (!p1_loose && !p2_loose)
			{
			int total = 0;              
			System.out.println("your money: " + p1.get_money());
			System.out.println("dealer's money: " + p2.get_money());
			int mybet = p1.bet();
			int dealerbet = p2.bet();
			total = mybet + dealerbet;
			while (p1_wants_card && p2_wants_card) {
			
				Card c;
				if (p1_wants_card && (p1_wants_card = p1.wantsACard())) {
					c = cd.newCard(); 
					p1.receiveCard(c);
					int count = c.countOf();
					System.out.println("Player 1 gets " + c.suitOf() + ":" + count);
					p1_score = p1_score + count;
				}
				else {
					p1_wants_card = false;
				}
				if (p2_wants_card && (p2_wants_card = p2.wantsACard())) {
					p2_wants_card = p2.wantsACard();
					c = cd.newCard();
					p2.receiveCard(c);
					int count = c.countOf();
					System.out.println("Player 2 gets " + c.suitOf() +  ":" + count);
					p2_score = p2_score + count;
				}
				else {
					p2_wants_card = false;
				}
				if (p1_score > 21 || p2_score > 21)
					break;
				
				
				
			
			}
			if ((p2_score > 21) ||  (p1_score <= 21 && p1_score > p2_score)) {
				p1.victory(total);
			}
			else if ((p1_score > 21) ||  (p2_score <= 21 && p2_score > p1_score)) {
				p2.victory(total);
			}
			else {
				System.out.println("No Winner...");
			}
			
			if (p1.get_money() < 0) {
				p1_loose = true;
			}
			if (p2.get_money() < 0) {
				p2_loose = true;
			}
			
			String response = JOptionPane.showInputDialog
	                  ("Continue? (Y or N)?");
			if (response.equals("N"))
				break; // while문 탈출 안됨
			
	}
		if (p1_loose) {
			if (p2_loose) {
				System.out.println("haha, no winner...");
			}
			else {System.out.println("You are looser");}
		}
		else {
			System.out.println("You are Winner");
		}*/
		
	
	}

}