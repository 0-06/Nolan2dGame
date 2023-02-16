package tile;

import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import Main.GamePanel;

/**
 * The Manager for my world tiles
 *
 * @author Nolan Peterson
 * @version 17/02/2023
 */
public class TileManager
{
    GamePanel gp;
tile[] tile; 
   
public TileManager(GamePanel gp){
    this.gp =gp;

    tile= new tile[10];
getTileImage();

}
public void getTileImage() {
try {
    tile [0] = new tile();
    tile [0].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/grass.png"));

    tile [1] = new tile();
    tile [1].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/wall.png"));
    
    tile [2] = new tile();
    tile [2].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/water.png"));
} catch(IOException e){
    e.printStackTrace();
}

}



public void draw(Graphics2D g2) { 
    for (int x=0; x<gp.screenWidth; x=x+32){
        for (int y=0; y<gp.screenHeight; y=y+32) {

    g2.drawImage(tile [0].image, x, y, gp.realTileSize, gp.realTileSize, null);
    
}
}
}
}



