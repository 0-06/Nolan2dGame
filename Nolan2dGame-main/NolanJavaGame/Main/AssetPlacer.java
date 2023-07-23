
package NolanJavaGame.Main;
import objects1.Key;
import objects1.Door;
import objects1.Chest;
// THis is the class which will allow me to place objects.
//Nolan Peterson, 6/06/2023
public class AssetPlacer{
    GamePanel gp;
    public AssetPlacer(GamePanel gp){
        this.gp=gp;

    }
    public void setObject(){
        gp.obj[0] = new Key();
        gp.obj[0].worldX =550;
        gp.obj[0].worldY = 110;
        System.out.println();
         System.out.println();
        System.out.println("Key object created: " + gp.obj[0]);
        gp.obj[1] = new Door();
        gp.obj[1].worldX = 38 *gp.realTileSize;
        gp.obj[1].worldY = 10 * gp.realTileSize;
        gp.obj[2] = new Chest();
        gp.obj[2].worldX = 38 * gp.realTileSize;
            gp.obj[2].worldY = 6 * gp.realTileSize;

            gp.obj[3]=new Key();
            gp.obj[3].worldX = 42*gp.realTileSize;
            gp.obj[3].worldY = 3*gp.realTileSize;

            gp.obj[4]=new Key();
            gp.obj[4].worldX = 766;
            gp.obj[4].worldY = 1283;

            gp.obj[5] = new Chest();
        gp.obj[5].worldX = 59;
            gp.obj[5].worldY = 1724 ;

              gp.obj[6] = new Chest();
        gp.obj[6].worldX = 2628;
            gp.obj[6].worldY = 2753 ;
              gp.obj[7] = new Key();
        gp.obj[7].worldX = 2481;
            gp.obj[7].worldY = 2739 ;
    }
}
