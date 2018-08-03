/**
 * 2018. 5. 23. Dev. by D. A. Lee
 */
package chap19;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class WindowExample1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello Java Program");		
		
		//frame.setLocation(500, 400); // 프레임 위치 조정
		frame.setPreferredSize(new Dimension(300, 200)); // 프레임 크기 조정		
		
		Container contentPane = frame.getContentPane();
		
		ImageIcon image1 = new ImageIcon("D:\\Da Eun Lee\\BrainJava\\KakaoTalk_20180501_110735388.jpg");
		JLabel label = new JLabel("こんにちは", image1, SwingConstants.CENTER);
		contentPane.add(label);
		frame.pack();
		frame.setVisible(true);		
		frame.setLocationRelativeTo(null); // 프레임 정중앙 배치 // 코드 마지막에 안 넣으면 제대로 위치 안잡힘
				

	}

}
