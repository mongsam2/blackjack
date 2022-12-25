import javax.swing.*;
import java.awt.event.*;
public class HitButton extends JButton implements ActionListener{
	//private HumanPlayer player;
	//private ComputerPlayer dealer;
	// CardDeck cd;
	private GameFrame f;
	private GameModel m;
	public HitButton(GameFrame f, GameModel m) {
		super("Hit");
		//player = p;
		//dealer = d;
		this.f = f;
		this.m = m;
		//cd = new CardDeck();
		addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		m.hit();

		f.set_message(m.get_message());
		f.update();
	}
	
}
