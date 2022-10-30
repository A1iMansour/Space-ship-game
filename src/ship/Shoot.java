package ship;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;      
import javax.swing.JPanel;
import java.awt.Image;

import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
public class Shoot extends JPanel {
static int x=350;
static int playerballvisible=0;
static int playerballvisible2=0;
//static int ballx=x;
static boolean shot=false;

static int start=0;
static bullet playerbullet= new bullet(590,true);
static bullet playerbullet2= new bullet(590,true);
static music j= new music();
static int backgroundindex1=-577;
static int backgroundindex2=-1854;//-1277
static int slower=0;

//user
static int speed=1;
static int blood=97;//for blood
static int freq=300;
static int paused=0;
static int shift=0;//speed or frequency
static int shoot=0;
static int hit=0;

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.white);
	
	  if (start==1){//game started
		  if (blood<=0) {
			  start=3;
		  }
		  else {
			Image imgs1 = new ImageIcon(getClass().getResource("/images/back.png")).getImage();
		    g2d.drawImage(imgs1,0,backgroundindex1, this);
		    g2d.drawImage(imgs1,0,backgroundindex2, this);
		    backgroundindex2=backindex(backgroundindex2);
		    backgroundindex1=backindex(backgroundindex1);
			enemies.enemiesgenerator(g2d);
			Image img2 = new ImageIcon(getClass().getResource("/images/plane.png")).getImage();
			 g2d.drawImage(img2,x, 580, this);
			// g2d.drawLine(x, 580, x+64, 580);
			// g2d.drawLine(x, 620, x+32, 580-32);
			// g2d.drawLine(x+64, 620, x+32, 580-32);
			g2d.setColor(Color.blue);
			
			if( playerballvisible>0){
				try {
					playerbullet.playsound(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				
					
					
				}
				playerbullet.setx(x+30);
				playerbullet.paint(g2d);
				
				playerbullet.move(-8-speed);////////////
				playerballvisible=playerbullet.getvisible();

			}
			if( playerballvisible2>0){
			
				try {
					playerbullet2.playsound(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				
					
					
				}
				playerbullet2.setx(x+30);
				playerbullet2.paint(g2d);
				
				playerbullet2.move(-9);///////////////
				playerballvisible2=playerbullet2.getvisible();

			}
			panel(g2d);
		  }
			
		}
		else if(start==0){//lunching game
			Image img1 = new ImageIcon(getClass().getResource("/images/back1.png")).getImage();
		    g2d.drawImage(img1,0,0, this);
			g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			g2d.drawString("press space to shoot",300, 200);
			g2d.drawString("press left arrow to move left", 270, 250);
			g2d.drawString("press right arrow to move right", 260, 300);
			g2d.setFont(new Font("TimesRoman", Font.PLAIN, 40));
			g2d.setColor(Color.yellow);
			g2d.drawString("press enter to start the game", 150, 400);
		}
		else if(start==2) {//for pause
			Image imgs1 = new ImageIcon(getClass().getResource("/images/back.png")).getImage();
		    g2d.drawImage(imgs1,0,backgroundindex1, this);
		    g2d.drawImage(imgs1,0,backgroundindex2, this);
		    Image img2 = new ImageIcon(getClass().getResource("/images/plane.png")).getImage();
			 g2d.drawImage(img2,x, 580, this);
			 panel(g2d);
			 g2d.setColor(Color.gray);
			 g2d.fillRect(240, 270, 270, 60);
			 g2d.setColor(Color.orange);
			 g2d.setFont(new Font("TimesRoman", Font.PLAIN, 40));
			 g2d.drawString("Game Paused", 250, 310);
		}
		else if(start==3) {//for gameover
			paused=1;
			Image imgs1 = new ImageIcon(getClass().getResource("/images/back.png")).getImage();
		    g2d.drawImage(imgs1,0,backgroundindex1, this);
		    g2d.drawImage(imgs1,0,backgroundindex2, this);
		    Image img2 = new ImageIcon(getClass().getResource("/images/plane.png")).getImage();
			 g2d.drawImage(img2,x, 580, this);
			 panel(g2d);
			 g2d.setColor(Color.gray);
			 g2d.fillRect(240, 270, 270, 60);
			 g2d.setColor(Color.red);
			 g2d.setFont(new Font("TimesRoman", Font.PLAIN, 40));
			 g2d.drawString("Game Over", 250, 310);
		}
		
	}
	
	
	
	public static void moveleft(){
		
		x-=15+speed;
	}
	public static void moveright(){
		
		x+=15+speed;
	}
	public  void shoot(){
		if(playerballvisible==0) {
			shoot++;
			playerballvisible=1;
		}
		else if(playerballvisible2==0) {
			shoot++;
			playerballvisible2=1;
		}
		/*if(ballloc==610)//to start bullet from ship position
		shot=true;*/
	}
	public  void start(){
		start=1;
	}
	public  void restart(){
		paused=0;
		blood=97;
		start=1;
		enemies.ship.clear();
		shoot=0;
		hit=0;
		enemies.numberofships=0;
	}
	public  void pause(){
		if (start==1) {
			start=2;
			paused=1;
		}
		else if(start==2) {
			start=1;
			paused=0;
		}
		//else;
	}
	public  void freqo(int kiwi){
			freq=(9-kiwi)*45+40;
	}
	
	public void speedo(int ananas) {
		speed=ananas;
	}
	public void s_or_f() {
		if(shift==0)
			shift=1;
		else
			shift=0;
	}
	
	
	
	
	public static void main (String[]args) throws InterruptedException {
		j.setFile(0);
		j.play();
		j.loop();
		JFrame frame = new JFrame("Battle ");
		frame.setSize(850, 700);
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
	public int backindex(int x) {//to move background
		
		if (x>=700) {
			
				return -1854;
			
		}
		
		else {
			if (slower<=1) {
				slower++;
				return x;
				
			}
			else {
				slower=0;
				return x+1;
			}
		}
	}
	public void panel(Graphics2D g2d) {//for right panel
		g2d.setColor(Color.black);
		g2d.fillRect(690, 0, 150, 700);//background for panel

		g2d.setFont(new Font("Helvetica", Font.PLAIN, 20));
		g2d.setColor(Color.green);
		g2d.drawString("PLayer", 715, 100);//player's name
		g2d.setFont(new Font("Helvetica", Font.PLAIN, 13));
		g2d.drawString("Shoots: "+shoot, 715, 140);//player's level
		g2d.drawString("Hits: "+hit, 715, 170);//player's score
		g2d.drawString("Life ", 715, 230);
		if(shoot==0)
			g2d.drawString("Score: "+(hit/1), 715, 200);
		else
			g2d.drawString("Score: "+(Math.round((0.0+hit)/shoot*100))+" %", 715, 200);
		g2d.drawRect(715, 240, 100, 10);//for player's blood
		g2d.setColor(Color.red);
		g2d.fillRect(717, 242, blood, 7);//varies w.r.t blood
		

		g2d.setColor(Color.white);
		g2d.drawString("Click \"shift\" to switch", 715, 420);
		g2d.drawString("b/w freq & speed", 715, 440);
		g2d.setColor(Color.white);
		g2d.fillRect(717, 475, 60, 20);
		g2d.fillRect(717, 535, 60, 20);
		g2d.setColor(Color.orange);
		g2d.setFont(new Font("Helvetica", Font.PLAIN, 14));
		g2d.drawString(-((freq-40)/45-9)+"", 740, 490);
		g2d.drawString(speed+"", 740, 550);
		g2d.setFont(new Font("Helvetica", Font.PLAIN, 13));
		g2d.drawRect(700, 511, 10, 10);
		g2d.drawRect(700, 451, 10, 10);
		g2d.drawString("Speed:(1-9)", 715, 520);
		g2d.drawString("Click \"P\" to pause", 715, 580);
		g2d.drawString("Click \"R\" to restart", 715, 620);
		g2d.drawString("Frequency:(1-9)", 715, 460);//above 9 set to 9, less than 0 set t0 0
		g2d.drawString("Options ", 715, 400);
		g2d.setColor(Color.green);
		if(shift==1)
			g2d.fillRect(702, 513, 7, 7);
		else if(shift==0)
			g2d.fillRect(702, 453, 7, 7);
	
	}
}

