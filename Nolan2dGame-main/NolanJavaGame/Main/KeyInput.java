package Main;


import java.awt.event.KeyEvent;
/**
 * This Class will handle key input for my game.
 *
 * @Nolan Peterson
 * @02/10/2023
 */
import java.awt.event.KeyListener;
public class KeyInput implements KeyListener
{
    public boolean wKeyDown, aKeyDown, sKeyDown, dKeyDown; 

    @Override
    public void keyPressed(KeyEvent e) {
        // When the key is released...
        int code =e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            wKeyDown=true;
                    }
                    if (code == KeyEvent.VK_A) {
                        aKeyDown=true;
                    }
                    if (code == KeyEvent.VK_S) {
                        sKeyDown=true;
                    }
                    if (code == KeyEvent.VK_D) {
                        dKeyDown=true;
                    }
    }

    @Override
    public void keyReleased(KeyEvent e) { 
        // When the key is released...
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
wKeyDown=false;
        }
        if (code == KeyEvent.VK_A) {
            aKeyDown=false;
        }
        if (code == KeyEvent.VK_S) {
            sKeyDown=false;
        }
        if (code == KeyEvent.VK_D) {
            dKeyDown=false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // When the key is typed..
        
    }

   
    
}
