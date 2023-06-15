
package Main;
import objects1.Key;
// THis is the class which will allow me to place objects.
//Nolan Peterson, 6/06/2023
public class AssetPlacer{
    GamePanel gp;
    public AssetPlacer(GamePanel gp){
        this.gp=gp;

    }
    public void setObject(){
        gp.obj[0] = new Key();
        gp.obj[0].worldX =500;
        gp.obj[0].worldY = 110;
        System.out.println();
         System.out.println();
        System.out.println("Key object created: " + gp.obj[0]);
    }
}
