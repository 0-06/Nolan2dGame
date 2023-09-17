package Main;

 


/**
 * Where I will deal with objects (powerups, keys, etc)
 *
 * @Nolan Peterson
 * @version 6/06/2023
 */
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import Main.GamePanel;
import java.awt.Rectangle;
public class SuperObject
{
    public BufferedImage image; // image of the objects
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public boolean isActive = true;
    public Rectangle playerBox = new Rectangle(0,0,48,48);
    public int playerBoxDefaultX = 0;
    public int playerBoxDefaultY = 0;
    public void draw(Graphics2D g2, GamePanel gp){
    int screenX = worldX - gp.player.worldX+gp.player.screenX;
    int screenY = worldY - gp.player.worldY+gp.player.screenY;
    
    if(screenX+gp.realTileSize > 0 &&
    screenX-gp.realTileSize < gp.screenWidth &&
    screenY+gp.realTileSize > 0 &&
    screenY-gp.realTileSize < gp.screenHeight){
       g2.drawImage(image, screenX, screenY, gp.realTileSize, gp.realTileSize, null);

   //    System.out.println("Drawing object: " + name + " at screen coordinates: (" + screenX + ", " + screenY + ")");

  
  
    }
}

    


    }

  
     
    

