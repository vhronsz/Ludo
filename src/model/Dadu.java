package model;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Dadu {
	public float x;
	public float y;
	public BufferedImage image;
	public boolean enabled;
	public Dadu(float x, float y) {
		super();
		this.x = x;
		this.y = y;
		this.image = load_Image();
		enabled = true;
	}
	
	public BufferedImage load_Image() {
		BufferedImage temp_image = null;
		
		try {
			temp_image = ImageIO.read(new File("src/Asset/Game/Roll.png"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Load Failed");
			return null;
		}
		return temp_image;
	}
	
}
