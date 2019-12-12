import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.util.Timer;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

	private int moves = 0;
	private int[] snakexlength = new int[750];
	private int[] snakeylength = new int[750];

	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;

	private ImageIcon rightmouth;
	private ImageIcon leftmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;

	private int lengthofsnake = 3;

	private Timer timer;
	private int delay = 100; // Snake speed

	private ImageIcon snakeImage;

	private ImageIcon titleImage;

	public GamePlay() {
		// Default position for snake
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		 timer = new Timer(delay, this);
		 timer.start();

	}

	public void paint(Graphics g) {

		if (moves == 0) {
			snakexlength[2] = 50;
			snakexlength[1] = 75;
			snakexlength[0] = 100;

			snakeylength[2] = 100;
			snakeylength[1] = 100;
			snakeylength[0] = 100;

		}

		// drawing border for title
		g.setColor(Color.white);
		g.drawRect(24, 10, 851, 55);

		// draw the title image
		titleImage = new ImageIcon("Assets/Snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);

		// draw border for gamePlay
		g.setColor(Color.WHITE);
		g.drawRect(24, 74, 851, 577);

		// Draw background for the gamePlay
		g.setColor(Color.gray);
		g.fillRect(25, 75, 850, 575); // game area_last # snake will check

		rightmouth = new ImageIcon("Assets/rightmouth.png");
		rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);

		for (int a = 0; a < lengthofsnake; a++) {
			if (a == 0 && right) {

				rightmouth = new ImageIcon("Assets/rightmouth.png");
				rightmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);

			}
			if (a == 0 && left) {

				leftmouth = new ImageIcon("Assets/lefthmouth.png");
				leftmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);

			}
			if (a == 0 && up) {

				upmouth = new ImageIcon("Assets/upmouth.png");
				upmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);

			}

			if (a == 0 && down) {

				downmouth = new ImageIcon("Assets/downmouth.png");
				downmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);

			}
			if (a != 0) {

				snakeImage = new ImageIcon("Assets/snakeimage.png");
				snakeImage.paintIcon(this, g, snakexlength[a], snakeylength[a]);

			}
		}

		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		timer.start();
		if(right) {			
			for(int r = lengthofsnake-1; r >= 0; r--) {
				snakeylength[r+1] = snakeylength[r];
					
			}
			
			for(int r = lengthofsnake; r >= 0; r--) {				
				if( r == 0) {
					snakexlength[r] = snakexlength[r] + 25;
				} else {
					snakexlength[r] = snakexlength[r-1];
				}
				if(snakexlength[r] > 850) {
					snakexlength[r] = 25;
				}
			}
			
			repaint();
			
		}
		if(left) {
			for(int r = lengthofsnake-1; r >= 0; r--) {
				snakeylength[r+1] = snakeylength[r];
					
			}
			
			for(int r = lengthofsnake; r >= 0; r--) {				
				if( r == 0) {
					snakexlength[r] = snakexlength[r] - 25;
				} else {
					snakexlength[r] = snakexlength[r-1];
				}
				if(snakexlength[r] < 25) {
					snakexlength[r] = 850;
				}
			}
			
			repaint();
			
			
		}
		if(up) {
			for(int r = lengthofsnake-1; r >= 0; r--) {
				snakexlength[r+1] = snakexlength[r];
					
			}
			
			for(int r = lengthofsnake; r >= 0; r--) {				
				if( r == 0) {
					snakeylength[r] = snakeylength[r] - 25;
				} else {
					snakeylength[r] = snakeylength[r-1];
				}
				if(snakeylength[r] < 75) {
					snakeylength[r] = 625;
				}
			}
			
			repaint();
			
			
		}
		if(down) {
			for(int r = lengthofsnake-1; r >= 0; r--) {
				snakexlength[r+1] = snakexlength[r];
					
			}
			
			for(int r = lengthofsnake; r >= 0; r--) {				
				if( r == 0) {
					snakeylength[r] = snakeylength[r] + 25;
				} else {
					snakeylength[r] = snakeylength[r-1];
				}
				if(snakeylength[r] > 625) {
					snakeylength[r] = 75;
				}
			}
			
			repaint();
			
			
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			moves++; // snake move from starting position
			right = true;
			if (!left) {

				right = true;
			} else {
				right = false;
				left = true;
			}

			up = false;
			down = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			moves++; // snake move from starting position
			left = true;
			if (!right) {

				left = true;
			} else {
				left = false;
				right = true;
			}

			up = false;
			down = false;
		}
		
if(e.getKeyCode() == KeyEvent.VK_UP) {
			
			moves++; // snake move from starting position
			up = true;
			if(!down) {
				
				up = true;
			}
			else {
				up = false;
				down = true;
			}
			
			right = false;
			left = false;
		}

if(e.getKeyCode() == KeyEvent.VK_DOWN) {
	
	moves++; // snake move from starting position
	down = true;
	if(!up) {
		
		down = true;
	}
	else {
		up = false;
		down = true;
	}
	
	right = false;
	left = false;
}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
