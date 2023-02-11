package character;


/**
 * The class where I will keep the player character
 *
 * @Nolan Peterson
 * @2/11/2023
 */
import Main.GamePanel;
import Main.KeyInput;
import java.io.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class player extends character
{
    GamePanel gp; 
    KeyInput keyI; 
    

    public player(GamePanel gp, KeyInput keyI) {

        this.gp = gp;
        this.keyI = keyI;
        setDefaultValue();
        getPlayerImage();
    }
    public void setDefaultValue(){
x=100;
y=100;
speed=8;
direction="up";
    }
    public void getPlayerImage () {
        System.out.println("Get Player Image Running");
        try{
            System.out.println("image loading");
stillUp = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/StillAshUp.png"));
stillDown = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/StillAshDown.png"));
stillLeft = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/StillAshLeft.png"));
stillRight = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/StillAshRight.png"));
down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/DownAsh1.png"));
down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/DownAsh2.png"));
down3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/DownAsh3.png"));
down4 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/DownAsh4.png"));
left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/LeftAsh1.png"));
left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/LeftAsh2.png"));
left3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/LeftAsh3.png"));
left4 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/LeftAsh4.png"));
right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/RightAsh1.png"));
right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/RightAsh2.png"));
right3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/RightAsh3.png"));
right4 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/RightAsh4.png"));
up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("res/player/UpAsh1.png"));
up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/UpAsh2.png"));
up3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/UpAsh3.png"));
up4 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/UpAsh4.png"));
System.out.println("image loading done");

        }
        catch(IOException e){
            e.printStackTrace (); 
        }
    }
    public void update(){
        if (keyI.wKeyDown == true){
            y -=speed;
            direction = "up";
            System.out.println("going up");
        }
        if (keyI.sKeyDown==true){
            y +=speed;
            direction = "down";
        }
        if (keyI.aKeyDown==true){
            x-=speed;
            direction = "left";
        }
        if (keyI.dKeyDown==true){
            x+=speed;
            direction = "right";
        }
    }
    public void draw(Graphics2D g2){
      //  //g2.setColor(Color.white);
      ///  g2.fillRect(x,y,gp.realTileSize,gp.realTileSize);
      BufferedImage image = null;

      switch(direction) {
        case "up":
        image=up1;
        break;
        case "down":
        image=down1;
        break;
        case "left":
        image=left1;
        break;
        case "right":
        image=right1;

    break;

      }
      g2.drawImage(image, x, y, gp.realTileSize, gp.realTileSize, null);
        g2.dispose();
    }
}
