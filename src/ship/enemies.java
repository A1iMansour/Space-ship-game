package ship;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class enemies  {
static ArrayList <Integer>positions= new ArrayList<Integer>();
static ArrayList <enemy>ship= new ArrayList<enemy>();
static int numberofships=0;
static int wait;
	public static boolean positionofship(int x) {//inorder not for two ships get created on same positon
		if(positions.contains(x))
			return true;
		else
			return false;
	}
	public static void addship(enemy e) {
		ship.add(e);
		positions.add(e.xposition());
		numberofships++;
	}
	public static void remove(enemy e) {
		//System.out.println("removed: "+e);/////////
		ship.remove(positions.indexOf(e.xposition()));
		positions.remove(positions.indexOf(e.xposition()));
		numberofships--;
	}
	public static void enemiesgenerator(Graphics g) {
		if(wait>Shoot.freq-Shoot.speed*4) {
			//System.out.println(numberofships);//////////
			enemy s=new enemy();
			wait=0;
			
		}
		else {//
			wait++;
		}
		for(int i=0;i<ship.size();i++) {//edit i accorfing to remove
			ship.get(i).paint(g);
			try{////////////////////////(sl,tbase,int th, int tx,int ty,int cy, int cx,int crad)
				if(((new collision()).tc(1,29,33,Shoot.x+3,620,ship.get(i).ebullet.y+25,ship.get(i).ebullet.x,7)==true)||(new collision()).tc(-1,29,33,Shoot.x+32+3,620,ship.get(i).ebullet.y+25,ship.get(i).ebullet.x,7)==true) {
					ship.get(i).hit=false;
					if(ship.get(i).ebullet.notmissed)
						Shoot.blood-=1;
					ship.get(i).ebullet.notmissed=false;
				}
			}
			catch(Exception e){
				// TODO Auto-generated catch block
			}
			 //System.out.println( (new collision()).tc(1,64,38,Shoot.x,580,ship.get(i).ebullet.y+25,ship.get(i).ebullet.x,3)+","+ship.get(i));
		}

	}
}