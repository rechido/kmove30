package messenger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class NoBtn_Login implements ActionListener {
	JFrame frame;
	

	public NoBtn_Login(JFrame frame) {
		super();
		this.frame = frame;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispose();

	}

}
