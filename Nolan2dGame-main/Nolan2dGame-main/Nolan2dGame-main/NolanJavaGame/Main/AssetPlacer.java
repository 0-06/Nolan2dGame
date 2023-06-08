
package Main;
import Objects.Key;
// THis is the class which will allow me to place objects.
//Nolan Peterson, 6/06/2023
public class AssetPlacer{
    GamePanel gp;
    public AssetPlacer(GamePanel gp){
        this.gp=gp;

    }
    public void setObject(){
        gp.obj[0] = new Key();
        gp.obj[0].worldX = gp.player.worldX + gp.realTileSize;
        gp.obj[0].worldY = gp.player.worldY;
        System.out.println("Key object created: " + gp.obj[0]);
    }
}
