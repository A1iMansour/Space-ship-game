package ship;

import java.awt.event.*;

public class key implements KeyListener{ 

Shoot s;

public key(Shoot s){
    this.s=s;
}

    public void keyPressed(KeyEvent e) { 
    	if(Shoot.paused==0) {
    		if(e.getKeyCode() == KeyEvent.VK_RIGHT) 
    			Shoot.moveright();    
    		else if(e.getKeyCode() == KeyEvent.VK_LEFT) 
    			Shoot.moveleft(); 
    		
    		else if(e.getKeyCode() == KeyEvent.VK_SHIFT)
    			s.s_or_f();

    		else if(e.getKeyCode() == KeyEvent.VK_SPACE)
    			s.shoot();
    		else if(e.getKeyCode() == KeyEvent.VK_ENTER)
    			s.start();
    		
    		else if(e.getKeyCode() == KeyEvent.VK_1) {
    			if(Shoot.shift==0)
    				s.freqo(1);
    			else
    				s.speedo(1);
    		}
    		else if(e.getKeyCode() == KeyEvent.VK_2) {
       			if(Shoot.shift==0)
    				s.freqo(2);
    			else
    				s.speedo(2);
			}
    		else if(e.getKeyCode() == KeyEvent.VK_3) {
       			if(Shoot.shift==0)
    			s.freqo(3);
			else
				s.speedo(3);
		}
    		else if(e.getKeyCode() == KeyEvent.VK_4) {
       			if(Shoot.shift==0)
    			s.freqo(4);
			else
				s.speedo(4);
		}
    		else if(e.getKeyCode() == KeyEvent.VK_5) {
       			if(Shoot.shift==0)
    			s.freqo(5);
			else
				s.speedo(5);
		}
    		else if(e.getKeyCode() == KeyEvent.VK_6) {
       			if(Shoot.shift==0)
    			s.freqo(6);
			else
				s.speedo(6);
		}
    		else if(e.getKeyCode() == KeyEvent.VK_7) {
       			if(Shoot.shift==0)
    			s.freqo(7);
			else
				s.speedo(7);
		}
    		else if(e.getKeyCode() == KeyEvent.VK_8) {
       			if(Shoot.shift==0)
    			s.freqo(8);
			else
				s.speedo(8);
		}
    		else if(e.getKeyCode() == KeyEvent.VK_9) {
    			if(Shoot.shift==0)
    			s.freqo(9);
			else
				s.speedo(9);
		}
    	    else if(e.getKeyCode() == KeyEvent.VK_P)
                s.pause();
    	}
        else if(e.getKeyCode() == KeyEvent.VK_P)
            s.pause();
             
    }
    
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
    
    }
    
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
    
    }
}
