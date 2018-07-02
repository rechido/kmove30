package chap19;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Console
{   
    public Console()
    {
        makeConsole();
    }

    private void makeConsole()
    {
        JFrame console = new JFrame("ArchiveConsole");
        Container base  = console.getContentPane();
        base.setSize(400, 250);
        console.setSize(base.getSize());
        base.setLayout(new FlowLayout(FlowLayout.CENTER, 5,5));

        JTextField tf = new JTextField();
        tf.setSize(base.getWidth(), 25);
        base.add(tf);

        console.setVisible(true);
    }
    
    public static void main(String[] args) {
    	new Console();
    }
}