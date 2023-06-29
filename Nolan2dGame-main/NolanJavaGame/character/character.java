package character;


import java.awt.Rectangle;

/**
 * The class where I will keep character variables such as enemies
 * 
 * Credit for Character Sprite goes to 'elouai.com'
 *
 * @Nolan Peterson
 * @2/12/2023
 */

import java.awt.image.BufferedImage;



public class character
{
    
    public int worldX, worldY;
    public int speed;
    public BufferedImage stillUp, stillDown, stillLeft, stillRight, up1, up2, up3, up4, down1, down2, down3, down4, right1, right2, right3, right4, left1, left2, left3, left4;
    public String direction;
public int animationCount =0;
public int animationNum = 1;
public Rectangle playerBox;
public boolean collisionIsOn=false;

   public int playerBoxDefaultX, playerBoxDefaultY;
        }
    

