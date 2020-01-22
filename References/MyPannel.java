import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class MyPannel extends JPanel{
	
	Rectangle rec1 = new Rectangle(100,300,200,200);
	Rectangle rec2 = new Rectangle(400,200,200,200);
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g.setColor(Color.cyan);
		g.fillRect(rec1.x1, rec1.y1, rec1.width, rec1.height);
		g.setColor(Color.BLUE);
		g.fillRect(rec2.x1, rec2.y1, rec2.width, rec2.height);
		if(collision()){
			g2d.drawString("Collision", 350, 100);
		}
	}
	
	public MyPannel() {
		
	}
	
	public boolean collision(){
		if (rec1.x1 < rec2.x1+rec2.width && rec1.width+rec1.x1 > rec2.x1 &&
				rec1.y1 < rec2.height + rec2.y1 && rec1.height + rec1.y1 > rec2.y1){
			System.out.println("Collison");
			return true;
		}
		
		else{
			return false;
		}
	}

}
