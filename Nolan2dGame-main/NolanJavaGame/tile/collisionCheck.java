package tile;
import Main.GamePanel;
import character.character;

/**
 * The Class where I establish things for collision 
 * 
 * 
 *
 * @Nolan Peterson
 * @22/05/2023
 */
public class collisionCheck{
 GamePanel gp;

public collisionCheck(GamePanel gp) {
    this.gp=gp;
}
public void  checkTile(character character){
    int characterLeftX= character.worldX + character.playerBox.x;
    int characterRightX= character.worldX + character.playerBox.x + character.playerBox.width;
    int characterTopY= character.worldY + character.playerBox.y;
    int characterBottomY= character.worldY + character.playerBox.y + character.playerBox.height;

    int characterLeftCol = characterLeftX/gp.realTileSize;
    int characterRightCol = characterRightX/gp.realTileSize;
    int characterTopRow = characterTopY/gp.realTileSize;
    int characterBottomRow = characterBottomY/gp.realTileSize;

    int tileNum1, tileNum2;

    switch(character.direction){
        case "up":
        characterTopRow=(int)Math.floor((double)(characterTopY - character.speed)/gp.realTileSize); 
        characterTopRow=(characterTopY - character.speed)/gp.realTileSize; 
        tileNum1 = gp.tileM.mapTileNumber[characterLeftCol][characterTopRow]; 
        tileNum2 = gp.tileM.mapTileNumber[characterRightCol][characterTopRow];
        if (gp.tileM.tile[tileNum1].collision==true || gp.tileM.tile[tileNum2].collision == true){ 
            character.collisionIsOn = true;
        }
        break;
        case "down":
        characterBottomRow=(int)Math.floor((double)(characterBottomY + character.speed)/gp.realTileSize); 
        characterBottomRow=(characterBottomY + character.speed)/gp.realTileSize; 
        tileNum1 = gp.tileM.mapTileNumber[characterLeftCol][characterBottomRow];
        tileNum2 = gp.tileM.mapTileNumber[characterRightCol][characterBottomRow];
        if (gp.tileM.tile[tileNum1].collision==true || gp.tileM.tile[tileNum2].collision == true){ 
            character.collisionIsOn = true;
            
        }
        break;
        case "left":
        characterLeftCol=(int)Math.floor((double)(characterLeftX - character.speed)/gp.realTileSize); 
        characterLeftCol=(characterLeftX - character.speed)/gp.realTileSize; 
        tileNum1 = gp.tileM.mapTileNumber[characterLeftCol][characterTopRow]; 
        tileNum2 = gp.tileM.mapTileNumber[characterLeftCol][characterBottomRow];
        if (gp.tileM.tile[tileNum1].collision==true || gp.tileM.tile[tileNum2].collision == true){ 
            character.collisionIsOn = true;
        }
        break;
        case "right":
        characterRightCol=(int)Math.floor((double)(characterRightX + character.speed)/gp.realTileSize); 
        characterRightCol=(characterRightX + character.speed)/gp.realTileSize; 
        tileNum1 = gp.tileM.mapTileNumber[characterRightCol][characterTopRow];
        tileNum2 = gp.tileM.mapTileNumber[characterRightCol][characterBottomRow];
        if (gp.tileM.tile[tileNum1].collision==true || gp.tileM.tile[tileNum2].collision == true){ 
            character.collisionIsOn = true;
        }
        break;
    }
    
}
    public int checkObject(character character, boolean player){
        int index = 999;
        for(int i=0; i<gp.obj.length; i++) { 
if (gp.obj[i] !=null){
    // Get player's position for collision
   character.playerBox.x = character.worldX + character.playerBox.x;
    character.playerBox.y = character.worldY + character.playerBox.y;
    //get the object's solid position
    if (gp.obj[1] != null) { //  null check
        gp.obj[i].playerBox.x = gp.obj[i].worldX + gp.obj[1].playerBox.x;
        gp.obj[i].playerBox.y = gp.obj[i].worldY + gp.obj[1].playerBox.y;
    }
    switch(character.direction){
       
       
       // Simulates players location AFTER it has moved, will it be on a collision object?
        case "up": 
character.playerBox.y -= character.speed;
    if(character.playerBox.intersects(gp.obj[i].playerBox)) {
            System.out.println("colliding");
            if(gp.obj[i].collision == true){
                character.collisionIsOn=true;
            }
            if(player==true){
                index = i; // Potential NPC's cannot pick up objects
            }
    }
        break;
          case "down":
          character.playerBox.y+= character.speed;
          if(character.playerBox.intersects(gp.obj[i].playerBox)) {
            System.out.println("colliding");
            if(gp.obj[i].collision == true){
                character.collisionIsOn=true;
            }
            if(player==true){
                index = i; // Potential NPC's cannot pick up objects
            }
          }
        break;
          case "left":
          character.playerBox.x-= character.speed;
            if(character.playerBox.intersects(gp.obj[i].playerBox)) {
            System.out.println("colliding");
            if(gp.obj[i].collision == true){
                character.collisionIsOn=true;
            }
            if(player==true){
                index = i; // Potential NPC's cannot pick up objects
            }
            }
        break;
          case "right":
          character.playerBox.x+= character.speed;
            if(character.playerBox.intersects(gp.obj[i].playerBox)) {
            System.out.println("colliding");
            if(gp.obj[i].collision == true){
                character.collisionIsOn=true;
            }
            if(player==true){
                index = i; // Potential NPC's cannot pick up objects
            }
            
        break;
            }

    }
    character.playerBox.x = character.playerBoxDefaultX;
 character.playerBox.y = character.playerBoxDefaultY;
 gp.obj[i].playerBox.x = gp.obj[i].playerBoxDefaultX;
  gp.obj[i].playerBox.y = gp.obj[i].playerBoxDefaultY;
    
}
        }
        return index;

    }
}

    



