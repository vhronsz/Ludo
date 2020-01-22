package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


public class Bidak {
	
	public float x;
	public float y;
	
	public float pos_X;
	public float pos_Y;
	
	public int width = 35;
	public int height = 35;
	public String file_Name;
	public BufferedImage image;
	
	public boolean reverse;
	public boolean horizontal;
	public int move_count;
	
	public Bidak(int x,int y,String file,int count) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.pos_X = x;
		this.pos_Y = y;
		this.file_Name = file;
		image = load_Image();
		this.move_count = count;
	}
	
	public BufferedImage load_Image() {
		BufferedImage temp_image = null;
		
		try {
			temp_image = ImageIO.read(new File("src/Asset/Game/"+this.file_Name));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Load Failed");
			return null;
		}
		return temp_image;
	}
	
	public void move_Horizontal(float x) {
		this.x = x;
	}
	
	public void move_Vertical(float y) {
		this.y = y;
	}
	
	public void start_Moving(float x,float y) {
		this.x = x;
		this.y = y;
	}
	
}
