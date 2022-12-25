import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameFrame extends JFrame{
	
	private GameModel m;
	private JLabel bet = new JLabel("Betting: ");
	private JLabel money = new JLabel("money: ");
	private JLabel dealerinfo = new JLabel("dealer's card");
	private JLabel playerinfo = new JLabel("your card");
	private JLabel message = new JLabel("Now you have 10000");
	private String change_message;
	
	public GameFrame(GameModel m, HumanPlayer p, ComputerPlayer d, CardDeck cd) {
		
		
		this.m = m;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		JPanel moneys = new JPanel(new BorderLayout());
		JPanel hands = new JPanel(new BorderLayout());
		JPanel messages = new JPanel(new BorderLayout());
		JPanel buttons = new JPanel(new FlowLayout());
		moneys.add(bet, BorderLayout.NORTH);
		moneys.add(money, BorderLayout.SOUTH);
		hands.add(dealerinfo, BorderLayout.NORTH);
		hands.add(playerinfo, BorderLayout.SOUTH);
		buttons.add(new BettingButton(this, m));
		buttons.add(new HitButton(this, m));
		buttons.add(new StopButton(this, m));
		buttons.add(new ExitButton(m));
		messages.add(buttons, BorderLayout.SOUTH);
		messages.add(message, BorderLayout.NORTH);
		m.choose_lucky();
		cp.add(moneys, BorderLayout.NORTH);
		cp.add(hands);
		cp.add(messages, BorderLayout.SOUTH);
		setTitle("BLACK JACK");
		setSize(600, 200);
		setVisible(true);
		
	}
	public void set_message(String s) {
		change_message = s;
	}
	
	public void update() {
		playerinfo.setText(m.get_playerinfo());
		dealerinfo.setText(m.get_dealerinfo());
		bet.setText(m.get_betmoney());
		money.setText(m.get_money());
		message.setText(change_message);
	}
}
