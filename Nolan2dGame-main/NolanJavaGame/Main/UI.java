package Main;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.image.BufferedImage;
import objects1.Key;

// This class will contain all the overlayed info that isn't part of the game.
public class UI {
    public boolean gameFinished = false;
    GamePanel gp;
    Font arial;
   public BufferedImage uiKey;
    public UI(GamePanel gp){
        this.gp = gp;
    arial = (new Font ("Arial",Font.PLAIN,20));
    Key Key = new Key();
    uiKey=Key.image;
    }


public void draw (Graphics2D g2) {
//Player's Keys
if (gameFinished==true){
int x = gp.screenWidth/2;
int y = gp.screenHeight/2;
String winText;
String winTextLength;
}
else{
g2.setFont(arial);
g2.setColor(Color.white);
g2.drawImage(uiKey, 40,10, gp.realTileSize, gp.realTileSize, null);
g2.drawString ("x "+gp.player.hasKey, 100, 50);
g2.drawString ("Points: "+gp.player.points, 50, 75); 
g2.drawString ("X: "+gp.player.worldX, 50, 100);
g2.drawString ("Y: "+gp.player.worldY, 50, 125);
//System.out.println(gp.player.hasKey);
}

}

}
