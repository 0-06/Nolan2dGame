package Main;


/**
 * Write a description of class GamePanel here.
 *
 * @author Nolan Peterson
 * @version 2/9/2023
 */
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Color; // allows me to add colour
public class GamePanel extends JPanel
{
   // settup for your screen/game. Could become an import from a settings file.
   final int baseTileSize = 16; 
   // The characters will be 16x16 'Tiles', can be changed later using scale
   final int scale = 2;
   final int realTileSize = baseTileSize * scale; // Real size is base * scale,
   final int maxScreenCollum = 16;
   final int maxScreenRow=12; //16:12 is 4:3 Aspect ratio. Probably will change
   final int screenWidth = realTileSize * maxScreenCollum; 
   final int screenHeight = realTileSize * maxScreenRow; //screen width and height will be the amount of pixels.
  
  
   Thread gameThread;
   

public GamePanel () {
    this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    this.setBackground(Color.black);
}
public void startGame() { // calls the 'run' method to start.
 gameThread = new Thread();
 gameThread.start();
    
}
public void run() { // the loop in which the game runs

}
}

