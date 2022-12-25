import javax.swing.*;
import javax.swing.*;
import java.awt.event.*;
public class StopButton extends JButton implements ActionListener {

	private GameFrame f;
	private GameModel m;
	
	public StopButton(GameFrame f, GameModel m) {
		super("Stop");
		this.m = m;
		this.f = f;
		addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		m.stop();
		f.set_message(m.get_message());
		f.update();
		m.reset();
		
	}

}
