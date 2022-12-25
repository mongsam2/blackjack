import javax.swing.JOptionPane;

public class GameModel {
	private HumanPlayer player;
	private ComputerPlayer dealer;
	private String message = "";
	private CardDeck cd;
	public GameModel(HumanPlayer p, ComputerPlayer d, CardDeck cd) {
		player = p;
		dealer = d;
		this.cd = cd;
	}
	
	public String get_message() {
		return message;
	}
	
	public String get_money() {
		return "money: " + String.valueOf(player.my_money);
	}
	
	public String get_betmoney() {
		return "betting: " + String.valueOf(dealer.my_money);
	}
	
	public String get_playerinfo() {
		return player.showCards();
	}
	
	public String get_dealerinfo() {
		return dealer.showCards();
	}
	
	public void betting() {
		if (player.is_bet) {
			if (player.my_money == 0) {
				message = "No money, haha";
				player.is_bet = false;
			}
			else {
				int amount = 0;
				try {	
					String bet = JOptionPane.showInputDialog("How much do you want to bet?");
					
					amount = Integer.parseInt(bet);
					
					if (amount <= player.my_money && amount > 0) {
						player.my_money = player.my_money - amount;
						dealer.my_money = dealer.my_money + amount;
						player.is_bet = false;
						player.is_hit = true;
						dealer.is_hit = true;
					}
					else
						throw new NumberFormatException();
					message = "Betting " + dealer.my_money;
				}
				catch (NumberFormatException ee) {
					message = "Please check if you typed it correctly";
				}
			}
		}
	}
	
	public void hit() {
		if (cd.moreCards()) {
			
			if (dealer.my_money > 0) {
				player.is_stop = true;
				if (player.is_hit) {
					Card newcard = cd.newCard();
					player.receiveCard(newcard);
					player.updatescore();
					if (player.card_count == player.max_cards) {
						player.is_hit = false;
					}
				}
				if (dealer.is_hit) {
					Card newcard2 = cd.newCard();
					dealer.receiveCard(newcard2);
					dealer.updatescore();
					if (dealer.card_count == dealer.max_cards || dealer.score > 17) {
						dealer.is_hit = false;
					}
				}
			}
			else {
				message = "first, click betting button";
			}
		}		
	}
	
	public void stop() {
		if (player.is_stop&&Lucky()) {
			player.is_bet = true;
			player.is_stop = false;
			if ((dealer.score > player.score)) {
				dealer.is_win = true;
			}
			if (player.score > dealer.score) {
				player.is_win = true;
			}
			
			if ((dealer.score > 21 && player.score <= 21) || (player.score <= 21 && player.is_win && !dealer.is_win)) {
				message = player.score + " : " + dealer.score + "        you Win!!";
				if (player.score == 21) {
					message = player.score + " : " + dealer.score + "        You Win!! !BLACK JACK!";
					player.my_money += dealer.my_money * 3;
				}
				else {
					player.my_money += dealer.my_money * 2;
					dealer.my_money = 0;
					message = player.score + " : " + dealer.score + "        you Win!!";
				}
			}
			else if ((player.score > 21 && dealer.score <= 21) || (dealer.score <= 21 && dealer.is_win && !player.is_win)) {
				message = player.score + " : " + dealer.score + "        you Loose...";
				dealer.my_money = 0;
			}
			else {
				message = player.score + " : " + dealer.score + "        No winner...";
				player.my_money += dealer.my_money;
				dealer.my_money = 0;
			}
			if (player.my_money == 0) {
				message += "No money... GoodBye~";
			}
			message = message + "        " + dealer.showBlank();		
		}
		else
			message = "click hit button";
	}
	
	public void choose_lucky() {
		try {	
			String answer = JOptionPane.showInputDialog("What is your lucky number? (exit: q)");
			if (answer.equals("q"))
				System.exit(0);
			int luck = Integer.parseInt(answer);
			if (luck > 0 && luck < 14) {
				JOptionPane.showMessageDialog(null, "Your lucky number is "+luck);
				System.out.println("your lucky number is "+luck);
				System.out.println("Game Start!!");
				System.out.println("Card 11, 12, 13: get 10 points");
				player.lucky_number = luck;
			}
			else {
				JOptionPane.showMessageDialog(null, "input number 1~13");
				
				System.out.println("input number 1~13");
				choose_lucky();
			}
			}
			
		
		catch (NumberFormatException ee) {
			JOptionPane.showMessageDialog(null, "please input your lucky number... v.v");
			
			System.out.println("please input your lucky number... v.v");
			choose_lucky();
		}
		catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "input lucky number, please\\nbye~");
			
			System.out.println("input lucky number, please\nbye~");
			System.exit(0);
		}
	}
	
	public boolean lucky_change(Card c) {
		boolean result = false;
		try {
			String answer = JOptionPane.showInputDialog("Are you change "+c.suitOf()+" "+c.countOf()+"(Y / N)");
			if (answer.equals("Y")) {
				result = true;
			}
			else if (answer.equals("N")) {
			}
			else
				throw new NullPointerException();
		}
		catch (NullPointerException e) {
			lucky_change(c);
		}
		return result;
	}
	
	public boolean Lucky() {
		for (int i=0; i<player.my_hand.length; i++) {
			if (player.my_hand[i] == null)
				continue;
			int hand_number = player.my_hand[i].countOf();
			if (hand_number == player.lucky_number && lucky_change(player.my_hand[i])) {
				player.my_hand[i] = cd.newCard();
			}
		}
		player.updatescore();
		return true;
	}
	
	public void reset() {
		player.reset_hand();
		dealer.reset_hand();
		cd = new CardDeck();
		player.is_win = false;
		dealer.is_win = false;
		dealer.resetBlank();
	}
	
	public void exit() {
		JOptionPane.showMessageDialog(null, "======== BLACK JACK ========\nyour initial money: 10000\nyour fianl money: "+player.my_money);
		
		
		System.out.println("======== BLACK JACK ========");
		System.out.println("Your initial money: 10000");
		System.out.println("Your final money: "+ player.my_money);
		if (player.my_money > 100000)
			JOptionPane.showMessageDialog(null, "GOD OF BLACK JACK");
		else if(player.my_money < 10000)
			JOptionPane.showMessageDialog(null, "Are you serious?");
		System.out.println("============================");
		System.exit(0);
	}
}
