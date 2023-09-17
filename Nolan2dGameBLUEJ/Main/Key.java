package Main;


 
import java.io.IOException;
import javax.imageio.ImageIO;
public class Key extends SuperObject {
    public Key (){
        name="Key";
        try{
image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("res/objects/key.png"));
System.out.println("Loaded Key"+image);
        }catch(IOException e) {
            e.printStackTrace();
        }
      
       }

    }

