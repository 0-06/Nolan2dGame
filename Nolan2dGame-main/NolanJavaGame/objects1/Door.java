
package objects1;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Door extends SuperObject {
    public Door (){
        name="Door";
        try{
image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/Door.png"));
System.out.println("Loaded Door"+image);
        }catch(IOException e) {
            e.printStackTrace();
        }
        collision = true;
       }

    }
