import javax.swing.JFrame;

public class Game_frame extends JFrame{
	
	game_Panel game = new game_Panel(this);
	public Game_frame() {
		// TODO Auto-generated constructor stub
		init_Window();
	    this.add(game);
		this.setVisible(true);
	}
	
	public void init_Window(){
		 setTitle("Ludo v0.1-rev 3.1");
	     setSize(950,637);
	     setLocationRelativeTo(null);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setResizable(false);
	}

}
