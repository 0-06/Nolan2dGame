package Main;


/**
 * Write a description of class GamePanel here.
 *
 * @author Nolan Peterson
 * @version 2/12/2023
 */
import java.awt.Dimension;
import javax.swing.JPanel;

import objects1.SuperObject;
import character.player;
import tile.TileManager;
import tile.collisionCheck;

import java.awt.Color; // allows me to add colour
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable
{
   // settup for your screen/game. Could become an import from a settings file.
   final int baseTileSize = 16; 
   // The characters will be 16x16 'Tiles', can be changed later using scale
   final int scale = 4;
   public final int realTileSize = baseTileSize * scale; // Real size is base * scale,
   public final int maxScreenCollum = 16;
   public final int maxScreenRow=12; //16:12 is 4:3 Aspect ratio. Probably will change
   public final int screenWidth = realTileSize * maxScreenCollum; 
  public final int screenHeight = realTileSize * maxScreenRow; //screen width and height will be the amount of pixels.
  
//World Settings
public final int maxWorldCol = 50;
public final int maxWorldRow = 50;
public final int maxWorldWidth = realTileSize * maxWorldCol;
public final int maxWorldHeight = realTileSize * maxWorldRow;
  KeyInput keyI = new KeyInput(); 
   Thread gameThread;

   // Collision Check

   public collisionCheck collisionCheck = new collisionCheck(this);
  


   public player player = new player(this,keyI); // imports character + key input
   public TileManager tileM = new TileManager(this);
   
   // Setting the player's default position
  public SuperObject obj[] = new SuperObject[10]; // Can display up to 10 objects at the same time.
public AssetPlacer aPlacer = new AssetPlacer(this);
// FPS LOCKER
int framesPerSecond=60;
public GamePanel () {
    this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    this.setBackground(Color.black);
    this.addKeyListener(keyI);  // Listens for the KeyInput
    this.setFocusable(true); // The game can be 'focused' in windows

}
public void setupGame(){
    aPlacer.setObject();
    
}
public void startGame() { // calls the 'run' method to start.
 gameThread = new Thread(this);
 gameThread.start();
    
}
public void run() { // the loop in which the game runs
while(gameThread != null){
    //System.out.println("Game Loop is running.");
    // This can be used to broadcast character position, and draw the screen.
    double drawInterval = 1000000000/framesPerSecond; //60 FPS
    double nextDrawTime = System.nanoTime() + drawInterval;


update();
repaint(); // will redraw game on every loop.


try {
    double remainingTime = nextDrawTime - System.nanoTime();
    remainingTime=remainingTime/1000000;
    
    if (remainingTime <0) {
remainingTime=0;
    }
    Thread.sleep((long)remainingTime);
nextDrawTime += drawInterval;
} catch (InterruptedException e) {
    // Try and catch statement auto generated by VSC
    e.printStackTrace();
}
}
}
public void update() {
player.update();
}
public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    tileM.draw(g2);
  
    for (int i=0; i<obj.length; i++){
        if (obj[i] != null){ 
            obj[i].draw(g2,this);
            System.out.println("Drawing object: " + obj[i].name);
        }
        
    }
      player.draw(g2);
    g2.dispose();
}
}


