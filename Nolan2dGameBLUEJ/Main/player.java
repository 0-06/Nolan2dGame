package Main;

 


/**
 * The class where I will keep the player character
 *
 * @Nolan Peterson
 * @5/12/2023
 */
import Main.GamePanel;
import Main.KeyInput;
import java.io.*;
import java.awt.Graphics2D;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class player extends character
{
    GamePanel gp; 
    KeyInput keyI; 
    
public  int screenX;
public  int screenY;
public int chestsLeft = 3;
public int hasKey = 0; // how many keys the player currently has

    public player(GamePanel gp, KeyInput keyI) {

        this.gp = gp;
        this.keyI = keyI;

        screenX = gp.screenWidth/2 - (gp.realTileSize/2);
        screenY = gp.screenHeight/2 - (gp.realTileSize/2);
        playerBox=new Rectangle(16,16,gp.realTileSize-32,gp.realTileSize-32);

        playerBox.x = 8;
        playerBox.y=16;
        playerBoxDefaultX = playerBox.x;
        playerBoxDefaultY= playerBox.y;
        playerBox.width = 32;
        playerBox.height = 32;

        setDefaultValue();
        getPlayerImage();
    }
    public void setDefaultValue(){
worldX=500;
worldY=100;
speed=7;
direction="up";
    }
    public void getPlayerImage () {
        System.out.println("Get Player Image Running");
        try{
            System.out.println("image loading");
            stillUp = ImageIO.read(getClass().getClassLoader().getResourceAsStream("res/player/StillAshUp.png"));
            stillDown = ImageIO.read(getClass().getClassLoader().getResourceAsStream("res/player/StillAshDown.png"));
            stillLeft = ImageIO.read(getClass().getClassLoader().getResourceAsStream("res/player/StillAshLeft.png"));
            stillRight = ImageIO.read(getClass().getClassLoader().getResourceAsStream("res/player/StillAshRight.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("res/player/DownAsh1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("res/player/DownAsh2.png"));
            down3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("res/player/DownAsh3.png"));
            down4 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("res/player/DownAsh4.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("res/player/LeftAsh1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("res/player/LeftAsh2.png"));
            left3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("res/player/LeftAsh3.png"));
            left4 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("res/player/LeftAsh4.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("res/player/RightAsh1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("res/player/RightAsh2.png"));
            right3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("res/player/RightAsh3.png"));
            right4 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("res/player/RightAsh4.png"));
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("res/player/UpAsh1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("res/player/UpAsh2.png"));
            up3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("res/player/UpAsh3.png"));
           
            up4 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("res/player/UpAsh4.png"));           
System.out.println("image loading done");

        }
        catch(IOException e){
            e.printStackTrace (); 
        }
    }
    public void update(){
        if (keyI.aKeyDown == true ||keyI.sKeyDown == true | keyI.dKeyDown == true || keyI.wKeyDown == true){
        if (keyI.wKeyDown == true){
            
            direction = "up";

    
           // System.out.println("going up");
        }
        else if (keyI.sKeyDown==true){
      
            direction = "down";
        }
        else if (keyI.aKeyDown==true){
          
            direction = "left";
        }
        else if (keyI.dKeyDown==true){
           
            direction = "right";
        }
        animationCount++;
        if(animationCount > 5){
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

// Checking tile collision
collisionIsOn = false; 
gp.collisionCheck.checkTile(this);

// Check Object Collision
int objIndex = gp.collisionCheck.checkObject(this, true);
pickUpObject(objIndex);
//if collision is false, player can move
if (collisionIsOn == false){
    switch (direction) {
        case "up":
        worldY -=speed;
        break;
        case "down":
        worldY +=speed;
        break;
        case "left":
        worldX-=speed;
        break;
        case "right":
        worldX+=speed;
        break;
    }
}
    
    }

    public void pickUpObject(int i){ // method for picking up objects
        if (i !=999){
String objectName = gp.obj[i].name;
switch (objectName) { // When touching objects, what happens?
    case "Key":
    
      System.out.println("Touching Key");
    hasKey++; 
    System.out.println("added Key, you now have "+hasKey);
    gp.obj[i]=null; // add to number of keys, delete key from screen

    break;
    case "Door": // If you have a key, delete door and remove one key 
     System.out.println("Touching Door");
     if ( hasKey >0 ) {
       gp.obj[i] = null;
        hasKey--;
        System.out.println("removed Key, you now have "+hasKey);
     }
     break;
       
    
     // 20/07/2023: Bug where opening door stops any other object interaction. FIXED issue was collision check relied on obj[1] not being null.
     
    case "Chest": 
     System.out.println("Touching Chest");
     if ( hasKey >0 ) {
       gp.obj[i] = null;
        hasKey--;
        chestsLeft = chestsLeft-1;
        //System.out.println ("you got 1000 Points! you now have "+points);
       // System.out.println("removed Key, you now have "+hasKey);
     }
     if ( chestsLeft <=0){
       gp.ui.gameFinished = true;
       break;
     }
     break;
     default: 
     break;
//
//break;
}
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
        //w System.out.println("Drawing player: at " +worldX + "Y"+ worldY );
      g2.drawImage(image, screenX, screenY, gp.realTileSize, gp.realTileSize, null);
        g2.dispose();
        
    }
}
