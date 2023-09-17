package Main;

 
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.image.BufferedImage;
import Main.Key;

// This class will contain all the overlayed info that isn't part of the game.
public class UI {
    public boolean gameFinished = false;
    GamePanel gp;
    Font arial,arialBold;
   public BufferedImage uiKey;
    public UI(GamePanel gp){
        this.gp = gp;
    arial = (new Font ("Arial",Font.PLAIN,20));
    arialBold = (new Font("ArialBold",Font.BOLD,50));
    Key Key = new Key();
uiKey=Key.image;
    }


public void draw (Graphics2D g2) {
    

//Player's Keys
if (gameFinished==true){

    g2.setFont(arialBold);
g2.setColor(Color.white);

String winText;
int winTextLength;
winText = "You Have Found the Treasure!";
winTextLength = (int)g2.getFontMetrics().getStringBounds(winText, g2).getWidth();

int x = gp.screenWidth/2 -winTextLength/2;
int y = gp.screenHeight/2 - (gp.realTileSize*3);
g2.drawString(winText,x,y);
gp.gameThread = null; // Stops the game
}
else{
g2.setFont(arial);
g2.setColor(Color.white);
g2.drawImage(uiKey, 40,10, gp.realTileSize, gp.realTileSize, null);
g2.drawString ("x "+gp.player.hasKey, 100, 50);
g2.drawString ("Chests Left: "+gp.player.chestsLeft, 50, 75); 
g2.drawString ("X: "+gp.player.worldX, 50, 100);
g2.drawString ("Y: "+gp.player.worldY, 50, 125);
//System.out.println(gp.player.hasKey);

}

}

}
