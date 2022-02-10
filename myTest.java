package day5;


import java.awt.Frame;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class myTest extends Frame{
	Button b1, b2, b3;
	public void  MyFrame() {
		setTitle("MyFrame");
		setSize(300, 200);
		setBackground(Color.orange);
		setLayout(new FlowLayout());
		b1 = new Button("red");
		b2 = new Button("green");
		b3 = new Button("blue");
		add(b1);
		add(b2);
		add(b3);
		b1.addActionListener(new ButtonEvent());
		b2.addActionListener(new ButtonEvent());
		b3.addActionListener(new ButtonEvent());
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				System.exit(0);
			}
		});
		setVisible(true);
	}
	class ButtonEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			 if(e.getSource()==b1) {
				 setBackground(Color.red);
			 }else if(e.getSource()==b2) {
				 setBackground(Color.green);
			 }else if(e.getSource()==b3) {
				 setBackground(Color.blue);
			 }			
		}		
	}
	

	public static void main(String[] args) {
		

	}

}