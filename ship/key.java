package ship;

import java.awt.event.*;

public class key implements KeyListener{ 

Shoot s;

public key(Shoot s){
    this.s=s;
}

    public void keyPressed(KeyEvent e) { 
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            Shoot.moveright();    
        
        else if(e.getKeyCode() == KeyEvent.VK_LEFT)
            Shoot.moveleft();

        else if(e.getKeyCode() == KeyEvent.VK_SPACE)
            s.shoot();
        else if(e.getKeyCode() == KeyEvent.VK_ENTER)
            s.start();
             
    }
    
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
    
    }
    
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
    
    }
}
