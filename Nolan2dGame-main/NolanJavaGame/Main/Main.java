package NolanJavaGame.Main;


/**
 * The Main Class for my Java Project
 *
 * @Nolan Peterson
 * @version (2/10/2023)
 */
import javax.swing.JFrame;
public class Main
{
    public static void main(String[] args) { //sets up window frame so you can see the game.
     JFrame window = new JFrame(); 
     window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // allows the window to close properly
     window.setResizable(false); // the window cannot be resized, which could throw aspect ratio and proportions off.
     window.setTitle("Nolan's Awesome game");
     
     GamePanel gamePanel = new GamePanel (); //binds main class and gamepanel together
     window.add(gamePanel);
     window.pack();
     
    window.setLocationRelativeTo(null); // takes the window to the middle, can be moved
    window.setVisible(true); // window is forced to be visible
    gamePanel.setupGame();
    gamePanel.startGame();
    }
    }

