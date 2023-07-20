package Main;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
// This class will contain all the overlayed info that isn't part of the game.
public class UI {
    
    GamePanel gp;
    Font arial;
    public UI(GamePanel gp){
        this.gp = gp;
    arial = (new Font ("Arial",Font.PLAIN,20));
    }


public void draw (Graphics2D g2) {
//Player's Keys
g2.setFont(arial);
g2.setColor(Color.white);
g2.drawString ("Keys: "+gp.player.hasKey, 50, 50);
g2.drawString ("Points: "+gp.player.points, 50, 75); 
g2.drawString ("X: "+gp.player.worldX, 50, 100);
g2.drawString ("Y: "+gp.player.worldY, 50, 125);
//System.out.println(gp.player.hasKey);
}

}
