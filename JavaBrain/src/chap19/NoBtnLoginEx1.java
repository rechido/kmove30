package chap19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class NoBtnLoginEx1 implements ActionListener {
	JFrame frame = new JFrame();
	

	public NoBtnLoginEx1(JFrame frame) {
		super();
		this.frame = frame;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispose();

	}

}
