import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Menu_text;

public class Main_Menu extends JPanel implements KeyListener,Runnable{
	
	JFrame parent;
	Font font = new Font("Comic Sans", Font.PLAIN, 30);
	int keyCount = 0; // Buat mastiin apakah sudah pernah input atau belum
	boolean menu_Status = true;
	boolean change_Scene = false;
	
	
	int position = 0;
	
	Menu_text title_Menu = new Menu_text("Ludo", -500, 120, 10, 10);
	int threshold_Title = 360;
	
	int threshold_Menu = 330;
	Menu_text[] array_Text = new Menu_text[2];
	Menu_text play_Text = new Menu_text("Play", -500, 200, 10, 10);
	Menu_text exit_Text = new Menu_text("Exit", -500, 280, 10, 10);
	
	Thread main_Thread = new Thread(this);
	public Main_Menu(JFrame parent){
		this.parent = parent;
		addKeyListener(this);
		setFocusable(true);
		main_Thread.start();
	}
	
	//Used to draw (render) things on the screen
	public void paint(Graphics g){
		super.paintComponent(g); //Take paint component
		render(g); // Function for testing drawing
	}
				
	private void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;	
		
		BufferedImage image = load_Img();
		draw_Image(image,g2d);
		title_String(g2d);
		menu_String(g2d);	
	}
	
	public BufferedImage load_Img(){
		BufferedImage temp_image = null;
		
		try {
			temp_image = ImageIO.read(new File("src/Asset/Main_menu/temp_img_menu.jpg"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Load Failed");
			return null;
		}
		
		return temp_image;
	}

	public void draw_Image(BufferedImage image, Graphics2D g){
		g.drawImage(image, 0, 0,null);
	}

	public void title_String(Graphics2D g){
		//Use to set the string before draw the font
		g.setFont(font);
		g.setColor(Color.WHITE);

		//Render he string
		g.drawString(title_Menu.text, title_Menu.coord_X,title_Menu.coord_Y);
	}
	
	public void menu_String(Graphics2D g){
		draw_Play_Text(g);
		draw_Exit_Text(g);
	}
	
	public void draw_Play_Text(Graphics2D g){
		g.setFont(font);
		
		// Ganti warna font kalo dipilih
		if(play_Text.isActive() == true){
			g.setColor(Color.YELLOW);
		}else{
			g.setColor(Color.WHITE);
		}
		
		g.drawString(play_Text.text,play_Text.coord_X,play_Text.coord_Y);
	}
	
	public void draw_Exit_Text(Graphics2D g){
		g.setFont(font);
		
		if(exit_Text.isActive() == true){
			g.setColor(Color.YELLOW);
		}else{
			g.setColor(Color.WHITE);
		}
		
		g.drawString(exit_Text.text,exit_Text.coord_X,exit_Text.coord_Y);
	}
	
	//Event Listener (Thread and keylistener)
	@Override
	public void run() {
		// TODO Auto-generated method stub		
		while(menu_Status){
			try {
				Thread.sleep(1000/120);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			text_Mover();
			main_Menu_Controller();//Used to control change in main menu
			this.repaint();
		}
	}

	public void text_Mover(){
		title_Menu.move_Horizontal(threshold_Title);
		
		if(check_Title_CoordX()){
			play_Text.move_Horizontal(threshold_Menu);
			exit_Text.move_Horizontal(threshold_Menu);
		}
	}
	
	public boolean check_Title_CoordX(){
		if(title_Menu.coord_X >= threshold_Title){
			return true;
		}
		return false;
	}
	
	//Pengatur semua hal di main menu , HARUSNYA 
	public void main_Menu_Controller(){
		change_Active_text();
	}
	
	//Buat ganti menu mana yng kepilih
	public void change_Active_text(){	
		//Sebelum text muncul semua
		if(play_Text.coord_X >= threshold_Menu && exit_Text.coord_X >= threshold_Menu && keyCount == 0){
			position = 1;
			keyCount++;
		}
		//2 ini buat liat yang mana menu kepilih
		if(position == 1){
			play_Text.setActive(true);
			exit_Text.setActive(false);
		}
		else if(position == 2){
			exit_Text.setActive(true);
			play_Text.setActive(false);
		}
	}
	
	//Key Listener
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		System.out.println(keyCode);
		position_Changer(keyCode);//buat ganti position (nentuin menu yang kepilih)
		change_Scene(keyCode);//Buat ganti scene sesuai pilihan (play/exit)
	}

	public void position_Changer(int keyCode){
		position_Adjust(keyCode);
		if(position > 2){
			position = 1;
		}else if(position < 1){
			position = 2;
		}
	}
	
	public void position_Adjust(int keyCode){
		if(keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP){
			position++;
		}
		else if(keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN){
			position--;
		}
	}
	
	public void change_Scene(int keyCode){
		if(keyCode == 10 && play_Text.isActive()){
			Game_frame game = new Game_frame();
			menu_Status = false;
			parent.dispose();
		}
		else if(keyCode == 10 && exit_Text.isActive()){
			parent.dispose();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
