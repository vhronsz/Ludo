import javax.swing.JFrame;

public class Frame extends JFrame implements Runnable{
	
	MyPannel pannel = new MyPannel();
	Thread myThread = new Thread(this);
	
	boolean movereact1 = false;
	boolean movereact2 = false;
	
	public Frame() {
		myThread.start();
		this.setTitle("Pertemuan 10 !");
		//this.setLocationRelativeTo(null);
		this.setSize(1080,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(pannel);
		this.setVisible(true);
		
	}

	@Override
	public void run() {
		
		while(true){
			
			if(pannel.rec1.x1 <= 0){
				movereact1 = true;
			}
			
			if(pannel.rec1.x1 + pannel.rec1.width >= 1080){
				movereact1 = false;
			}
			
			if(movereact1){
				pannel.rec1.x1 = pannel.rec1.x1 + 3;
			}
			
			else{
				pannel.rec1.x1 = pannel.rec1.x1 - 3;
			}
			
			if(pannel.rec2.x1 <= 0){
				movereact2 = true;
			}
			
			if(pannel.rec2.x1 + pannel.rec2.width >= 1080){
				movereact2 = false;
			}
			
			if(movereact2){
				pannel.rec2.x1 = pannel.rec2.x1 + 3;
			}
			
			else{
				pannel.rec2.x1 = pannel.rec2.x1 - 3;
			}
			
			try {
				Thread.sleep(1000/60);
			} catch (Exception e) {
				// TODO: handle exception
			}
			render();
		}
		
	}
	
	void render(){
		pannel.repaint();
	}

}
