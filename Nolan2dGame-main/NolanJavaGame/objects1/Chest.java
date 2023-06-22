package objects1;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Chest extends SuperObject {
    public Chest (){
        name="Chest";
        try{
image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/Chest.png"));
System.out.println("Loaded Chest"+image);
        }catch(IOException e) {
            e.printStackTrace();
        }
       }

    }
