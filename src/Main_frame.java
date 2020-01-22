import java.awt.event.KeyEvent;
import java.util.EventListener;
import java.util.Scanner;

import javax.swing.JFrame;

public class Main_frame extends JFrame{
/*
	Basic Things :
	-Frame is only a container
	-All the drawing will happen in the panel
	all things that move happen in Jpanel
*/	
	Main_Menu main_menu = new Main_Menu(this);
	Scanner scan = new Scanner(System.in);
	
	public void init_Window(){
		 setTitle("Ludo v0.1-rev 3.1");
	     setSize(800,600);
	     setLocationRelativeTo(null);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setResizable(false);
	}

	public Main_frame() {
		// TODO Auto-generated constructor stub
		init_Window();
		this.setVisible(true);
		this.add(main_menu);
	}
	
}
