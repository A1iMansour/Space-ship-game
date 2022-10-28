package ship;

import java.awt.Image;

import javax.swing.ImageIcon;

public class collision {
	
	
	public boolean tc(double slope, int tbase,int th, int tx,int ty,int cy, int cx,int crad) {//isosceles triangle circle collision
		boolean c=false;
		if(cx>=tx && cx<=tx+tbase) {
			//System.out.println("bulletx: "+cx+"bullety: "+cy +"planex"+tx + "width "+tbase+"ty"+ty);
			if(cy>=slope*(cx-tx)+ty-th) {
				//System.out.println("wwbulletx: "+cx+"bullety: "+cy +"planex"+tx+ "width "+tbase);
				c=true;
			}
		}
		
		
		return c;
	}
	
	public static void main(String[]args) {
		Image img2 = new ImageIcon(("C:\\Users\\alima\\Desktop\\ece 435l\\v1\\src\\images\\b.png")).getImage();
		System.out.println(img2.getHeight(null));
	}
}
