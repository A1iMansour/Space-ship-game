package e;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;      
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
public class Shoot extends JPanel {
static int x=350;
static int ballvisible=0;
static int ballx=x;
static boolean shot=false;
int ballloc=610;
static int start=0;
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		//Image img1 = Toolkit.getDefaultToolkit().getImage("ww.gif");
	    //g2d.drawImage(img1,0, 0, this);
		g2d.fillRect(0,0,700,700);
		g2d.setColor(Color.white);
		if (start!=0){
			g2d.fillRect(x,650,60,20);
			g2d.fillRect(x+20,640,20,10);
		
			g2d.setColor(Color.blue);
			if( ballvisible>0){
				if(shot)
					ballx=x;
				g2d.drawOval(ballx+20, ballloc, 20, 20);
				ballloc-=3;
				shot=false;
			}
		}
		else{
			g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			g2d.drawString("press space to shoot", 250, 50);
			g2d.drawString("press left arrow to move left", 250, 100);
			g2d.drawString("press right arrow to move right", 250, 150);
			g2d.setFont(new Font("TimesRoman", Font.PLAIN, 40));
			g2d.setColor(Color.blue);
			g2d.drawString("press enter to start the game", 100, 300);
		}
	}
	
	public static void moveleft(){
		
		x-=10;
	}
	public static void moveright(){
		
		x+=10;
	}
	public  void shoot(){
		ballvisible=1;
		if(ballloc==610)
		shot=true;
	}
	public  void start(){
		start=1;
	}

	
	public static void main (String[]args) throws InterruptedException {
		JFrame frame = new JFrame("Battle ");
		frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);

		Shoot s=new Shoot();
		
		frame.add(s);
		frame.addKeyListener(new key(s));
		while(true){
			
        	frame.setVisible(true);

			s.repaint();
			Thread.sleep(10);
			if (s.ballloc<=0){
				s.ballloc=610;
				s.ballvisible=0;
				
			}
			if (x<0){
				x=0;
			}
			if (x>625){
				x=625;
			}
		}
	}
}
