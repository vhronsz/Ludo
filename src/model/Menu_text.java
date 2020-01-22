package model;

public class Menu_text {
	
	public float coord_X;
	public float coord_Y;
	public float velo_X;
	public float velo_Y;
	public String text;
	private boolean active;
	
	public void move_Horizontal(float threshold){
		if(coord_X < threshold){
			coord_X += velo_X;
		}
	}
	
	public Menu_text(String text,float coord_X,float coord_Y,float velo_X,float velo_Y) {
		// TODO Auto-generated constructor stub
		this.text = text;
		this.coord_X = coord_X;
		this.coord_Y = coord_Y;
		this.velo_X = velo_X;
		this.velo_Y = velo_Y;
		this.active = false;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
