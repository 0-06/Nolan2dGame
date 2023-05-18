package tile;
import Main.GamePanel;
import character.character;


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
}
}

