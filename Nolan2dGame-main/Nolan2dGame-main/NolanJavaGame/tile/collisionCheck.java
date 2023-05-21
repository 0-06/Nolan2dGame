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
        characterTopRow=(characterTopY - character.speed)/gp.realTileSize; // This will predict where the player will be after they move - or what tile they are trying to step into
        tileNum1 = gp.tileM.mapTileNumber[characterLeftCol][characterTopRow]; 
        tileNum2 = gp.tileM.mapTileNumber[characterRightCol][characterTopRow];
        if (gp.tileM.tile[tileNum1].collision==true || gp.tileM.tile[tileNum2].collision == true){ // If the tile the player is going into is solid, collision is true.

            character.collisionIsOn = true;
        }
        
        break;
        case "down":
        characterBottomRow=(characterBottomY - character.speed)/gp.realTileSize; // This will predict where the player will be after they move - or what tile they are trying to step into
        tileNum1 = gp.tileM.mapTileNumber[characterLeftCol][characterBottomRow];
        tileNum2 = gp.tileM.mapTileNumber[characterRightCol][characterBottomRow];
        if (gp.tileM.tile[tileNum1].collision==true || gp.tileM.tile[tileNum2].collision == true){ // If the tile the player is going into is solid, collision is true.
            
            character.collisionIsOn = true;
        }
        break;
        case "left":
        characterLeftCol=(characterLeftX + character.speed)/gp.realTileSize; // This will predict where the player will be after they move - or what tile they are trying to step into
        tileNum1 = gp.tileM.mapTileNumber[characterLeftCol][characterTopRow]; 
        tileNum2 = gp.tileM.mapTileNumber[characterLeftCol][characterBottomRow];
        if (gp.tileM.tile[tileNum1].collision==true || gp.tileM.tile[tileNum2].collision == true){ // If the tile the player is going into is solid, collision is true.
            
            character.collisionIsOn = true;
        }
        break;
        case "right":
        characterRightCol=(characterLeftX + character.speed)/gp.realTileSize; // This will predict where the player will be after they move - or what tile they are trying to step into
        tileNum1 = gp.tileM.mapTileNumber[characterRightCol][characterTopRow];
        tileNum2 = gp.tileM.mapTileNumber[characterRightCol][characterBottomRow];
        if (gp.tileM.tile[tileNum1].collision==true || gp.tileM.tile[tileNum2].collision == true){ // If the tile the player is going into is solid, collision is true.
            
            character.collisionIsOn = true;
        }
        break;
    }
}

    }



