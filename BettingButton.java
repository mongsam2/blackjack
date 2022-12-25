import javax.swing.*;
import java.awt.event.*;
public class BettingButton extends JButton implements ActionListener{
	
	private GameFrame f;
	private GameModel m;
	public BettingButton(GameFrame f, GameModel m) {
		super("Betting");
		this.f = f;
		this.m = m;
		addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e) {
		m.betting();

		f.set_message(m.get_message());
		f.update();
	}
}
