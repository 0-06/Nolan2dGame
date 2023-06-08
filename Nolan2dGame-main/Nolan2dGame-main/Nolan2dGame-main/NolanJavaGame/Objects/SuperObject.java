package Objects;


/**
 * Where I will deal with objects (powerups, keys, etc)
 *
 * @Nolan Peterson
 * @version 6/06/2023
 */
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import Main.GamePanel;
public class SuperObject
{
    public BufferedImage image; // image of the objects
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    
     public void draw(Graphics2D g2, GamePanel gp){
        
        int screenX = worldX - gp.player.worldX+gp.player.screenX;
        int screenY = worldY - gp.player.worldY+gp.player.screenY;
        
        if(worldX+gp.realTileSize > gp.player.worldX - gp.player.screenX &&
        worldX-gp.realTileSize < gp.player.worldX + gp.player.screenX &&
        worldY+gp.realTileSize > gp.player.worldY - gp.player.screenY &&
        worldY-gp.realTileSize < gp.player.worldY + gp.player.screenY){
         System.out.println("Drawing object: " + name);
    g2.drawImage(image,screenX, screenY, gp.realTileSize, gp.realTileSize, null);
  }
     }
    }

