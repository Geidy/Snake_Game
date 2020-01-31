import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePlay extends JPanel {
	private int[] snakeXlength = new int[750];
	private int [] snakeYlength = new int[750];
	
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	
	private ImageIcon rigthmouth;
	private ImageIcon leftmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	
	private Timer timer;
	private int delay = 100;
	
	private ImageIcon snakeImage;
	
	private ImageIcon titleImage;
	
	public GamePlay() {
		
		
	}
	
	public void paint(Graphics g) {
		
		//drawing border for title
		g.setColor(Color.white);
		g.drawRect(24, 10, 851, 55);
		
		//draw the title image
		titleImage = new ImageIcon("Assets/Snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);
		
		//draw border for gamePlay
		g.setColor(Color.WHITE);
		g.drawRect(24, 74, 851, 577);
		
		//Draw background for the gamePlay
		g.setColor(Color.gray);
		g.fillRect(25, 75, 850, 575);  //game area_last # snake will check
		
		
		
	}
	

}
