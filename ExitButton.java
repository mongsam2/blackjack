import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ExitButton extends JButton implements ActionListener{
	private GameModel m;
	public ExitButton(GameModel m) {
		super("exit");
		this.m = m;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		m.exit();
		
	}

}
