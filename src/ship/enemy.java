package ship;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class enemy extends JPanel{
	int y=0;
	int r=0;
	int eballvisible=1;
	bullet ebullet=new bullet(45,false);
	int soundplayed=-1;
	int xmovement=angle();
	boolean hit=true;//true if not hit
	int eballvisible2=1;//to stop bullets till certain time
	public enemy() {
			Random x= new Random();
			r=x.nextInt(610);
			while(enemies.positionofship(r)) {
				r=x.nextInt(610);
				}
			enemies.addship(this);
	}
	public void paint(Graphics g) {
		if(!disapeared()) {
			super.paint(g);
			Graphics2D g2d = (Graphics2D) g;
			Image img1 = new ImageIcon(getClass().getResource("/images/rocket.png")).getImage();
			g2d.drawImage(img1,r, y, this);
			//g2d.drawLine(r+12, y+20, r+27, y+53);
			//g2d.drawLine(r+27, y+53, r+38, y+20);
						// g2d.drawLine(x, 620, x+32, 580-32);
						// g2d.drawLine(x+64, 620, x+32, 580-32);
			move();
			if (hit) {
			if( eballvisible<=80){
				
				if(soundplayed==-1) {
					try {
						ebullet.playsoundenemy(2);
						soundplayed=0;
						//System.out.println("played");
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
				
					}
				}
				
				ebullet.setx(r+20);
				ebullet.paint(g2d);
				
				ebullet.move(9);
				ebullet.movex(xmovement);
				eballvisible++;
				//eballvisible=ebullet.getvisibleenemy(eballvisible);

			}
			else {
				//System.out.println(this.toString() +","+eballvisible);/////////////////
				soundplayed=-1;
				ebullet.sety(y+45);
				eballvisible=0;
				ebullet.setx2nd(-1);//to restart x
				//eballvisible=1;
				
			}
			}
			else {
				if(eballvisible2<=80)
					eballvisible2++;
				else {
					eballvisible2=0;
					hit=true;
					this.ebullet.notmissed=true;
					soundplayed=-1;
					ebullet.sety(y+45);
					eballvisible=0;
					ebullet.setx2nd(-1);
				}
			}
		}
	    
	}


	public void move() {
		y+=1+Shoot.speed-1;
	}
	public void setY(int y) {
		this.y=y;
	}
	public int xposition() {
		return r;
	}
	public boolean disapeared() {//ship reached end
		if (y>=700) {
			
			enemies.remove(this);
	    	return true;
	    }
		else return false;
	}
	public String toString() {
		return "enemy $, created at: "+r+", "+y;
	}
	public int angle() {
		Random j= new Random();
		return j.nextInt(8)-4;
	}
}
