import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Bidak;
import model.Dadu;
import model.Map;
import model.Roll;

public class game_Panel extends JPanel implements MouseListener,Runnable{
	
	Thread game_Thread = new Thread(this);
	JFrame parent;
	Bidak bidak[][] = new Bidak[10][10];
	Dadu dadu = new Dadu(845, 100);
	Roll roll = new Roll(860,90);
	Font font = new Font("Comic Sans", Font.BOLD, 50);
	
	int turn = 1;
	boolean move_Valid = true; // check if choosed bidak can be moved
	
	Map map[] = new Map[100];
	boolean game_Status = true;
	String text_Shown;
	String text_Over = " ";
	String text_Tips = "You can start move the ";
	String text_Tips2 = "pieces when you get 6";
	
	public game_Panel(JFrame parent) {
		// TODO Auto-generated constructor stub
		this.parent = parent;
		setFocusable(true);
		this.addMouseListener(this);
		game_Thread.start();
		init_Bidak();
		init_Map();
	}
	
	public void init_Bidak() {
		//Urutan atas,kanan,bawah,kiri
		
		//Hijau
		bidak[0][0] = new Bidak(145,65,"green.png",0);
		bidak[0][1] = new Bidak(200,105,"green.png",0);
		bidak[0][2] = new Bidak(145,145,"green.png",0);
		bidak[0][3] = new Bidak(90,105,"green.png",0);
		
		//Merah
		bidak[1][0] = new Bidak(625,65,"red.png",13);
		bidak[1][1] = new Bidak(680,105,"red.png",13);
		bidak[1][2] = new Bidak(625,145,"red.png",13);
		bidak[1][3] = new Bidak(570,105,"red.png",13);
		
		//Kuning
		bidak[2][0] = new Bidak(145,425,"yellow.png",39);
		bidak[2][1] = new Bidak(200,465,"yellow.png",39);
		bidak[2][2] = new Bidak(145,505,"yellow.png",39);
		bidak[2][3] = new Bidak(90,465,"yellow.png",39);
		
		//Biru
		bidak[3][0] = new Bidak(625,425,"blue.png",26);
		bidak[3][1] = new Bidak(680,465,"blue.png",26);
		bidak[3][2] = new Bidak(625,505,"blue.png",26);
		bidak[3][3] = new Bidak(570,465,"blue.png",26);
		
		System.out.println(bidak[3][0].move_count);
	}
	
	public void init_Map() {
		  map[0] = new Map(65, 245);
		  map[1] = new Map(120, 245);
		  map[2] = new Map(170, 245);
		  map[3] = new Map(225, 245);
		  map[4] = new Map(280, 245);
		  
		  map[5] = new Map(330, 205);
		  map[6] = new Map(330, 165);
		  map[7] = new Map(330, 125);
		  map[8] = new Map(330, 85);
		  map[9] = new Map(330, 45);
		  map[10] = new Map(330, 5);
		  map[11] = new Map(385, 5);
		  map[12] = new Map(440, 5);
		  map[13] = new Map(440, 45);
		  map[14] = new Map(440, 85);
		  map[15] = new Map(440, 125);
		  map[16] = new Map(440, 165);
		  map[17] = new Map(440, 205);
		  
		  map[18] = new Map(490, 245);
		  map[19] = new Map(545, 245);
		  map[20] = new Map(600, 245);
		  map[21] = new Map(650, 245);
		  map[22] = new Map(705, 245);
		  map[23] = new Map(760, 245);
		  map[24] = new Map(760, 285);
		  map[25] = new Map(760, 325);
		  map[26] = new Map(705, 325);
		  map[27] = new Map(650, 325);
		  map[28] = new Map(600, 325);
		  map[29] = new Map(545, 325);
		  map[30] = new Map(490, 325);
		  
		  map[31] = new Map(440, 365);
		  map[32] = new Map(440, 405);
		  map[33] = new Map(440, 445);
		  map[34] = new Map(440, 485);
		  map[35] = new Map(440, 525);
		  map[36] = new Map(440, 565);
		  map[37] = new Map(385, 565);
		  map[38] = new Map(330, 565);
		  map[39] = new Map(330, 525);
		  map[40] = new Map(330, 485);
		  map[41] = new Map(330, 445);
		  map[42] = new Map(330, 405);
		  map[43] = new Map(330, 365);
		  
		  map[44] = new Map(280, 325);
		  map[45] = new Map(225, 325);
		  map[46] = new Map(170, 325);
		  map[47] = new Map(120, 325);
		  map[48] = new Map(65, 325);
		  map[49] = new Map(10, 325);
		  map[50] = new Map(10, 285);
		  map[51] = new Map(10, 245);
		  

		  //Finish Green
		  map[52] = new Map(65, 285);
		  map[53] = new Map(120, 285);
		  map[54] = new Map(170, 285);
		  map[55] = new Map(225, 285);
		  map[56] = new Map(280, 285);
		  map[57] = new Map(330, 285);
		  
		  //Finish Red
		  map[58] = new Map(385, 45);
		  map[59] = new Map(385, 85);
		  map[60] = new Map(385, 125);
		  map[61] = new Map(385, 165);
		  map[62] = new Map(385, 205);
		  map[63] = new Map(385, 245);
		  
		  //Finish Blue
		  map[64] = new Map(705, 285);
		  map[65] = new Map(650, 285);
		  map[66] = new Map(600, 285);
		  map[67] = new Map(545, 285);
		  map[68] = new Map(490, 285);
		  map[69] = new Map(440, 285);

		  //Finish Yellow
		  map[70] = new Map(385, 525);
		  map[71] = new Map(385, 485);
		  map[72] = new Map(385, 445);
		  map[73] = new Map(385, 405);
		  map[74] = new Map(385, 365);
		  map[75] = new Map(385, 325);
		  
	}
	
	public void paint(Graphics g){
		super.paintComponent(g); //Take paint component
		render(g); // Function for testing drawing
	}
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		BufferedImage image = load_Img();
		draw_Image(image, g2d);
		draw_Bidak(g2d);
		draw_Dadu(g2d);
		draw_Status(g2d);
	}
	
	public BufferedImage load_Img(){
		BufferedImage temp_image = null;
		
		try {
			temp_image = ImageIO.read(new File("src/Asset/Game/Board.png"));
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
	
	public void draw_Bidak(Graphics2D g) {
		//Draw Bidak		
		g.drawImage(bidak[0][0].image,(int)bidak[0][0].pos_X,(int)bidak[0][0].pos_Y,null);
		g.drawImage(bidak[0][1].image,(int)bidak[0][1].pos_X,(int)bidak[0][1].pos_Y,null);
		g.drawImage(bidak[0][2].image,(int)bidak[0][2].pos_X,(int)bidak[0][2].pos_Y,null);
		g.drawImage(bidak[0][3].image,(int)bidak[0][3].pos_X,(int)bidak[0][3].pos_Y,null);
		
		g.drawImage(bidak[1][0].image,(int)bidak[1][0].pos_X,(int)bidak[1][0].pos_Y,null);
		g.drawImage(bidak[1][1].image,(int)bidak[1][1].pos_X,(int)bidak[1][1].pos_Y,null);
		g.drawImage(bidak[1][2].image,(int)bidak[1][2].pos_X,(int)bidak[1][2].pos_Y,null);
		g.drawImage(bidak[1][3].image,(int)bidak[1][3].pos_X,(int)bidak[1][3].pos_Y,null);
		
		g.drawImage(bidak[2][0].image,(int)bidak[2][0].pos_X,(int)bidak[2][0].pos_Y,null);
		g.drawImage(bidak[2][1].image,(int)bidak[2][1].pos_X,(int)bidak[2][1].pos_Y,null);
		g.drawImage(bidak[2][2].image,(int)bidak[2][2].pos_X,(int)bidak[2][2].pos_Y,null);
		g.drawImage(bidak[2][3].image,(int)bidak[2][3].pos_X,(int)bidak[2][3].pos_Y,null);
		
		g.drawImage(bidak[3][0].image,(int)bidak[3][0].pos_X,(int)bidak[3][0].pos_Y,null);
		g.drawImage(bidak[3][1].image,(int)bidak[3][1].pos_X,(int)bidak[3][1].pos_Y,null);
		g.drawImage(bidak[3][2].image,(int)bidak[3][2].pos_X,(int)bidak[3][2].pos_Y,null);
		g.drawImage(bidak[3][3].image,(int)bidak[3][3].pos_X,(int)bidak[3][3].pos_Y,null);
	}
	
	public void draw_Dadu(Graphics2D g) {
		draw_Roll(g);
		draw_Roll_Button(g);
	}
	
	void draw_Roll(Graphics2D g) {
		Integer value = roll.value;
		if(turn == 1) {
			g.setColor(Color.GREEN);
		}else if(turn == 2) {
			g.setColor(Color.RED);
		}else if(turn == 3) {
			g.setColor(Color.BLUE);
		}else {
			g.setColor(Color.YELLOW);
		}
		g.setFont(font);
		g.drawString(value.toString(), roll.x, roll.y);
	}
	
	public void draw_Roll_Button(Graphics2D g) {
		g.drawImage(dadu.image,(int)dadu.x,(int)dadu.y,null);
	}
	
	void draw_Status(Graphics2D g) {
		String turn_P = "Green ";
		text_Shown = "Turn";
		String text_Shown_Under = "";
		Font font2 = new Font("Comic Sans", Font.BOLD, 12);
		g.setFont(font2);
		
		if(game_Status == true) {
			if(turn == 1) {
				g.setColor(Color.green);
				g.drawString(turn_P, 805, 165);
				if(dadu.enabled == true) {
					text_Shown_Under = "Please roll";
				}
				else{
					text_Shown_Under = "Select your piece";
				} 
				g.setColor(Color.BLACK);
				g.drawString(text_Shown, 842, 165);
				
			}else if(turn == 2) {
				turn_P = "Red";
				g.setColor(Color.RED);
				g.drawString(turn_P, 805, 165);
				if(dadu.enabled == true) {
					text_Shown_Under = "Please roll";
				}
				else{
					text_Shown_Under = "Select your piece";
				}
				g.setColor(Color.BLACK);
				g.drawString(text_Shown, 830, 165);
				
			}else if(turn == 3) {
				turn_P = "Blue";
				g.setColor(Color.BLUE);
				g.drawString(turn_P, 805, 165);
				if(dadu.enabled == true) {
					text_Shown_Under = "Please roll";
				}
				else{
					text_Shown_Under = "Select your piece";
				}
				g.setColor(Color.BLACK);
				g.drawString(text_Shown, 833, 165);
				
			}else if(turn == 4) {
				turn_P = "Yellow";
				g.setColor(Color.YELLOW);
				g.drawString(turn_P, 805, 165);
				if(dadu.enabled == true) {
					text_Shown_Under = "Please roll";
				}
				else{
					text_Shown_Under = "Select your piece";
				}
				g.setColor(Color.BLACK);
				g.drawString(text_Shown, 845, 165);
			}
			
			g.drawString(text_Shown_Under, 805, 185);
			g.drawString(text_Tips, 805, 220);
			g.drawString(text_Tips2, 805, 240);
		}
		else {
			
			g.drawString(text_Shown, 810, 165);
		}
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(game_Status) {
			try {
				Thread.sleep(1000/120);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			this.repaint();
			
		}
	}
		
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		int choose = -1;
		move_Valid = false;
		
		System.out.println("Turn : "+turn);
		System.out.println("Move valid : "+move_Valid);
		System.out.println("X : "+ e.getX() + "\nY : " +e.getY());
		if(e.getX() > 843 && e.getX() < 907 && dadu.enabled == true) {
			if(e.getY() > 98 && e.getY() < 141) {
				roll_Dice();
			}
		}
		
		if(turn == 1 && dadu.enabled == false) {
			System.out.println("Masuk move hijau");
			x = e.getX();
			y = e.getY();
			choose = bidak_Choose_Green(x,y);
			System.out.println(choose);
			if(choose != -1) {
				move_Green(choose);
				if(move_Valid){
					dadu.enabled = true;
					turn_Counter(turn);
				}
			}
		}
		else if(turn == 2 && dadu.enabled == false) {//Red Turn
			System.out.println("Masuk move merah");
			x = e.getX();
			y = e.getY();
			choose = bidak_Choose_Red(x,y);
			System.out.println(choose);
			if(choose != -1) {
				move_Red(choose);
				if(move_Valid){
					dadu.enabled = true;
					turn_Counter(turn);
				}
			}
		}
		else if(turn == 3 && dadu.enabled == false) { //Blue Turn
			System.out.println("Masuk move biru");
			x = e.getX();
			y = e.getY();
			choose = bidak_Choose_Blue(x,y);
			System.out.println("Choose bidak : "+choose);
			if(choose != -1) {
				move_Blue(choose);
				if(move_Valid){
					dadu.enabled = true;
					turn_Counter(turn);
				}
			}
		}
		else if(turn == 4 && dadu.enabled == false) {//Yellow Turn
			System.out.println("Masuk move kuning");
			x = e.getX();
			y = e.getY();
			choose = bidak_Choose_Yellow(x,y);
			System.out.println(choose);
			if(choose != -1) {
				move_Yellow(choose);
				if(move_Valid){
					dadu.enabled = true;
					turn_Counter(turn);
				}
			}
		}
		game_Status = check_Over();
	}
	
	void roll_Dice(){
		roll.random_Dice();
		dadu.enabled = false;
		skip_Turn();
	}
	
	void skip_Turn(){
		System.out.println("Roll Value : "+roll.value);
		if(roll.value != 6 && check_Pos()){
			dadu.enabled = true;
			turn_Counter(turn);
		}
	}
	
	//check if all bidak is still in base;
	boolean check_Pos(){
		int check = 0;
		if(turn == 1){
			check = 0;
		}else if(turn == 2){
			check = 1;
		}
		else if(turn == 3){
			check = 3;
		}
		else{
			check = 2;
		}
		if(bidak[check][0].pos_X == bidak[check][0].x && bidak[check][0].pos_Y == bidak[check][0].y){
			if(bidak[check][1].pos_X == bidak[check][1].x && bidak[check][0].pos_Y == bidak[check][0].y){
				if(bidak[check][2].pos_X == bidak[check][2].x && bidak[check][0].pos_Y == bidak[check][0].y){
					if(bidak[check][3].pos_X == bidak[check][3].x && bidak[check][0].pos_Y == bidak[check][0].y){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	//Green
	//Choose bidak to move
	public int bidak_Choose_Green(int x,int y) {
		for(int i = 0 ; i < 4; i++) {
			if(x > bidak[0][i].pos_X && x < bidak[0][i].pos_X+30) {
				if(y > bidak[0][i].pos_Y && y < bidak[0][i].pos_Y+30) {
					return i;
				}
			}
		}
		return -1;
	}

	//Move green bidak
	public void move_Green(int choose) {
		if(bidak[0][choose].pos_X == bidak[0][choose].x && bidak[0][choose].pos_Y == bidak[0][choose].y) {
			if(roll.value == 6) {
				bidak[0][choose].pos_X = map[bidak[0][choose].move_count].x;
				bidak[0][choose].pos_Y = map[bidak[0][choose].move_count].y;
				move_Valid = true;
			}
			else if(roll.value != 6 && move_Valid == true){
				return;
			}
			return;
		}
		else {
				if(bidak[0][choose].move_count < 50 && bidak[0][choose].move_count + roll.value > 50) {
					bidak[0][choose].move_count++;
				}
				bidak[0][choose].move_count += roll.value;
				
				if(bidak[0][choose].move_count > 50) {
					move_Final_Green(bidak[0][choose]);
					return;
				}
				
				move_Changer(bidak[0][choose]);
				bidak[0][choose].pos_X = map[bidak[0][choose].move_count].x;
				bidak[0][choose].pos_Y = map[bidak[0][choose].move_count].y;
				move_Valid = true;
		}
	}
	//Move on final 5 tile before finish
	void move_Final_Green(Bidak bidak) {
		if(bidak.move_count > 57) {
			return;
		}else {
			bidak.pos_X = map[bidak.move_count].x;
			bidak.pos_Y = map[bidak.move_count].y;
			move_Valid = true;
		}
	}
	
	
	//Red
	public int bidak_Choose_Red(int x , int y) {
		for(int i = 0 ; i < 4; i++) {
			if(x > bidak[1][i].pos_X && x < bidak[1][i].pos_X+30) {
				if(y > bidak[1][i].pos_Y && y < bidak[1][i].pos_Y+30) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public void move_Red(int choose) {
		if(bidak[1][choose].pos_X == bidak[1][choose].x && bidak[1][choose].pos_Y == bidak[1][choose].y) {
			if(roll.value == 6) {
				bidak[1][choose].pos_X = map[bidak[1][choose].move_count].x;
				bidak[1][choose].pos_Y = map[bidak[1][choose].move_count].y;
				move_Valid = true;
			}
			else if(roll.value != 6 && move_Valid == true){
				move_Valid = false;
				return;
			}
			return;
		}
		else {
			if(bidak[1][choose].move_count < 11 && bidak[1][choose].move_count + roll.value >= 11 || bidak[1][choose].move_count > 57) {
				bidak[1][choose].move_count += roll.value;
				move_Final_Red(bidak[1][choose]);
				move_Valid = true;
				return;
			}
			bidak[1][choose].move_count += roll.value;
			move_Changer(bidak[1][choose]);
			bidak[1][choose].pos_X = map[bidak[1][choose].move_count].x;
			bidak[1][choose].pos_Y = map[bidak[1][choose].move_count].y;
			move_Valid = true;
		}
	}
	
	void move_Final_Red(Bidak bidak) {
		
		if(bidak.move_count > 63) {
			return;
		}else {
			bidak.move_count = bidak.move_count - 12 + 58;
			bidak.pos_X = map[bidak.move_count].x;
			bidak.pos_Y = map[bidak.move_count].y;
			move_Valid = true;
		}
	}
	
	
	//Blue
	public int bidak_Choose_Blue(int x , int y) {
		for(int i = 0 ; i < 4; i++) {
			if(x > bidak[3][i].pos_X && x < bidak[3][i].pos_X+30) {
				if(y > bidak[3][i].pos_Y && y < bidak[3][i].pos_Y+30) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public void move_Blue(int choose) {
		if(bidak[3][choose].pos_X == bidak[3][choose].x && bidak[3][choose].pos_Y == bidak[3][choose].y) {
			if(roll.value == 6) {
				bidak[3][choose].pos_X = map[bidak[3][choose].move_count].x;
				bidak[3][choose].pos_Y = map[bidak[3][choose].move_count].y;
				move_Valid = true;

			}else if(roll.value != 6 && move_Valid == true){
				move_Valid = false;
				return;
			}
			return;
		}
		else {
			if(bidak[3][choose].move_count < 24 && bidak[3][choose].move_count + roll.value >= 24 || bidak[3][choose].move_count > 63) {
				bidak[3][choose].move_count += roll.value;
				move_Final_Blue(bidak[3][choose]);
				move_Valid = true;
				return;
			}
			bidak[3][choose].move_count += roll.value;
			move_Changer(bidak[3][choose]);
			bidak[3][choose].pos_X = map[bidak[3][choose].move_count].x;
			bidak[3][choose].pos_Y = map[bidak[3][choose].move_count].y;
			move_Valid = true;

		}
	}
	
	void move_Final_Blue(Bidak bidak) {
		if(bidak.move_count > 69) {
			return;
		}else {
			bidak.move_count = bidak.move_count - 25 + 64;
			bidak.pos_X = map[bidak.move_count].x;
			bidak.pos_Y = map[bidak.move_count].y;
			move_Valid = true;
		}
	}
	
	
	//Yellow
	public int bidak_Choose_Yellow(int x , int y) {
		for(int i = 0 ; i < 4; i++) {
			if(x > bidak[2][i].pos_X && x < bidak[2][i].pos_X+30) {
				if(y > bidak[2][i].pos_Y && y < bidak[2][i].pos_Y+30) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public void move_Yellow(int choose) {
		if(bidak[2][choose].pos_X == bidak[2][choose].x && bidak[2][choose].pos_Y == bidak[2][choose].y) {
			if(roll.value == 6) {
				bidak[2][choose].pos_X = map[bidak[2][choose].move_count].x;
				bidak[2][choose].pos_Y = map[bidak[2][choose].move_count].y;
				move_Valid = true;
			}else if(roll.value != 6 && move_Valid == true){
				move_Valid = false;
				return;
			}
			return;
		}
		else {
			if(bidak[2][choose].move_count < 39 && bidak[2][choose].move_count + roll.value >= 39 || bidak[2][choose].move_count > 69){
				bidak[2][choose].move_count += roll.value;
				move_Final_Yellow(bidak[2][choose]);
				move_Valid = true;
				return;
			}
			bidak[2][choose].move_count += roll.value;
			move_Changer(bidak[2][choose]);
			bidak[2][choose].pos_X = map[bidak[2][choose].move_count].x;
			bidak[2][choose].pos_Y = map[bidak[2][choose].move_count].y;
			move_Valid = true;

		}
	}
	
	void move_Final_Yellow(Bidak bidak) {
		if(bidak.move_count > 75) {
			return;
		}
		else {
			bidak.move_count = bidak.move_count - 40 + 70;
			bidak.pos_X = map[bidak.move_count].x;
			bidak.pos_Y = map[bidak.move_count].y;
		}
	}
	
	
	//change turn order
	void turn_Counter(int count) {
		turn += 1;
		if(turn > 4) {
			turn = 1;
		}
	}
	
	//Change bidak position
	void move_Changer(Bidak bidak) {
		if(bidak.file_Name.equals("green.png")) {
			return;
		}
		else if(bidak.move_count > 51) {
			bidak.move_count = bidak.move_count - 52;
			System.out.println("Move_Count : "+bidak.move_count);
		}
	}
	
	//Check if one of the player already finished
	public boolean check_Over() {
		if(green_Win()) {
			text_Over = "game over Winner green";
			return false;
		}else if(red_Win()) {
			text_Over = "game over Winner red";
			return false;
		}else if(blue_Win()) {
			text_Over = "game over Winner blue";
			return false;
		}
		else if(yellow_Win()) {
			text_Over = "game over Winner yellow";
			return false;
		}
		
		return true;
	}
	//condition of each player win
	boolean green_Win() {
		if(bidak[0][0].move_count == 57) {
			if(bidak[0][1].move_count == 57) {
				if(bidak[0][2].move_count == 57) {
					if(bidak[0][3].move_count == 57) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	boolean red_Win() {
		if(bidak[1][0].move_count == 63) {
			if(bidak[1][1].move_count == 63) {
				if(bidak[1][2].move_count == 63) {
					if(bidak[1][3].move_count == 63) {
						return true;
					}
				}
			}
		}
		return false;
	}

	boolean blue_Win() {
		if(bidak[3][0].move_count == 69) {
			if(bidak[3][1].move_count == 69) {
				if(bidak[3][2].move_count == 69) {
					if(bidak[3][3].move_count == 69) {
						return true;
					}
				}
			}
		}
		return false;
	}

	boolean yellow_Win() {
		if(bidak[2][0].move_count == 75) {
			if(bidak[2][1].move_count == 75) {
				if(bidak[2][2].move_count == 75) {
					if(bidak[2][3].move_count == 75) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
