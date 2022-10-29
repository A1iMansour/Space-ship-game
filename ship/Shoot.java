package ship;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;      
import javax.swing.JPanel;
import java.awt.Image;

import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
public class Shoot extends JPanel {
static int x=350;
static int playerballvisible=0;
//static int ballx=x;
static boolean shot=false;

static int start=0;
bullet playerbullet= new bullet(590,true);
static music j= new music();

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		Image img1 = new ImageIcon(getClass().getResource("/images/ww.gif")).getImage();
	    g2d.drawImage(img1,0, 0, this);
		g2d.setColor(Color.white);
		
		if (start!=0){
			enemies.enemiesgenerator(g2d);
			Image img2 = new ImageIcon(getClass().getResource("/images/plane.png")).getImage();
			 g2d.drawImage(img2,x, 600, this);
			g2d.setColor(Color.blue);
			
			if( playerballvisible>0){
				try {
					playerbullet.playsound(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				
				}
				playerbullet.setx(x+30);
				playerbullet.paint(g2d);
				
				playerbullet.move(-9);
				playerballvisible=playerbullet.getvisible();

			}
			
		}
		else{
			g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			g2d.drawString("press space to shoot", 250, 50);
			g2d.drawString("press left arrow to move left", 250, 100);
			g2d.drawString("press right arrow to move right", 250, 150);
			g2d.setFont(new Font("TimesRoman", Font.PLAIN, 40));
			g2d.setColor(Color.yellow);
			g2d.drawString("press enter to start the game", 100, 300);
		}
	}
	
	public static void moveleft(){
		
		x-=20;
	}
	public static void moveright(){
		
		x+=20;
	}
	public  void shoot(){
		playerballvisible=1;
		/*if(ballloc==610)//to start bullet from ship position
		shot=true;*/
	}
	public  void start(){
		start=1;
	}

	
	public static void main (String[]args) throws InterruptedException {
		j.setFile(0);
		j.play();
		j.loop();
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
			
			if (x<0){
				x=0;
			}
			if (x>625){
				x=625;
			}
		}
	}
}

