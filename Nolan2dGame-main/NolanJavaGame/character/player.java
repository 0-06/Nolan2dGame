package character;


/**
 * The class where I will keep the player character
 *
 * @Nolan Peterson
 * @2/12/2023
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
speed=4;
direction="up";
    }
    public void getPlayerImage () {
        System.out.println("Get Player Image Running");
        try{
            System.out.println("image loading");
            stillUp = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/StillAshUp.png"));
            stillDown = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/StillAshDown.png"));
            stillLeft = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/StillAshLeft.png"));
            stillRight = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/StillAshRight.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/DownAsh1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/DownAsh2.png"));
            down3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/DownAsh3.png"));
            down4 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/DownAsh4.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/LeftAsh1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/LeftAsh2.png"));
            left3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/LeftAsh3.png"));
            left4 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/LeftAsh4.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/RightAsh1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/RightAsh2.png"));
            right3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/RightAsh3.png"));
            right4 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/RightAsh4.png"));
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/UpAsh1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/UpAsh2.png"));
            up3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/UpAsh3.png"));
           
            up4 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/UpAsh4.png"));           
System.out.println("image loading done");

        }
        catch(IOException e){
            e.printStackTrace (); 
        }
    }
    public void update(){
        if (keyI.aKeyDown == true ||keyI.sKeyDown == true | keyI.dKeyDown == true || keyI.wKeyDown == true){
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
        animationCount++;
        if(animationCount > 6){
            if(animationNum==1){
                animationNum=2;
            }
            else if (animationNum==2){
                animationNum=3;
            }
            else if (animationNum==3){
                animationNum=4;
            }
            else if (animationNum==4){
                animationNum=1;
            }
            animationCount=0;
        }
    }
    else if (direction =="up"){
        direction ="upStill";
    }

    else if (direction =="down"){
        direction ="downStill";
    }
    else if (direction =="left"){
        direction ="leftStill";
    } 
    else if (direction =="right"){
        direction ="rightStill";
    }


    
    }
    public void draw(Graphics2D g2){
      //  //g2.setColor(Color.white);
      ///  g2.fillRect(x,y,gp.realTileSize,gp.realTileSize);
      BufferedImage image = null;

      switch(direction) {
        case "up":
        if (animationNum==1){

        image=up1;
        }
        if (animationNum==2){
            image=up2;
        }
        if (animationNum==3){
            image=up3;
        }
        if (animationNum==4){
            image=up4;
        }
        break;
        case "down":
        if (animationNum==1){
            image=down1;
        }
        if (animationNum==2){
            image=down2;
        }
        if (animationNum==3){
            image=down3;
        }
        if (animationNum==4){
            image=down4;
        }
        
        break;
        case "left":
        if (animationNum==1){
            image=left1;
        }
        if (animationNum==2){
            image=left2;
        }
        if (animationNum==3){
            image=left3;
        }
        if (animationNum==4){
            image=left4;
        }
        
        break;
        case "right":
        if (animationNum==1){
            image=right1;
        }
        if (animationNum==2){
            image=right2;
        }
        if (animationNum==3){
            image=right3;
        }if (animationNum==4){
            image=right4;
        }
break;
        case "upStill":
        image=stillUp;   
    break;
    case "downStill":
    image=stillDown;
    break;
    case "leftStill":
    image=stillLeft;
    break;
    case "rightStill":
    image=stillRight;
    break;


      }
      g2.drawImage(image, x, y, gp.realTileSize, gp.realTileSize, null);
        g2.dispose();
    }
}