package tile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import Main.GamePanel;

public class TileManager {
    GamePanel gp;
    tile[] tile;
    int mapTileNumber[][];

    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new tile[10];
        mapTileNumber = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/maps/map0.txt");
    }

    public void getTileImage() {
        try {
            tile[0] = new tile();
            tile[0].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/grass.png"));
    System.out.println("loaded grass");
    
            tile[1] = new tile();
            tile[1].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/dirt.png"));
            System.out.println("loaded dirt");
            tile[2] = new tile();
            tile[2].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/water.png"));
            System.out.println("loaded water");
            tile[2].collision=true; 
            tile[3] = new tile();
            tile[3].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/sand.png"));
            System.out.println("loaded sand");
            tile[4] = new tile();
            URL url = getClass().getClassLoader().getResource("tiles/tree.png");
if (url != null) {
    System.out.println("Found tree.png at " + url.getPath());
} else { // I got chat GPT to write this, as debug code, and for some reason it allowed the tree to load?
    System.out.println("tree.png not found");
}
            tile[4].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/tree.png"));
            System.out.println("loaded tree");
            tile[4].collision=true; 
            tile[5] = new tile();
            tile[5].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/wall.png"));
            System.out.println("loaded wall");
            tile[5].collision=true; 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    

    public void loadMap(String mapPath) {
        try {
            InputStream is = getClass().getResourceAsStream(mapPath);

            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            for (int row = 0; row < gp.maxWorldRow; row++) {
                String line = br.readLine();
                String[] characters = line.split("");

                for (int col = 0; col < gp.maxWorldCol; col++) {
                    char currentChar = characters[col].charAt(0);
                    int tileNum;

                    switch (currentChar) {
                        case 'D':
                            tileNum = 1;
                            break;
                        case 'W':
                            tileNum = 2;
                            break;
                            case 'S':
                            tileNum = 3;
                            break;
                            case 'T':
                            tileNum = 4;
                            break;
                            case 'B':
                            tileNum=5;
                            break;
                        default:
                            tileNum = 0;
                            break;
                    }

                    mapTileNumber[col][row] = tileNum;
                }
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        
        
     //   for (int worldCol = 0; worldCol < gp.maxWorldCol; worldCol++) {
       //     for (int worldRow = 0; worldRow < gp.maxWorldRow; worldRow++) {
         //       int currentTile = mapTileNumber[worldCol][worldRow];
           //     g2.drawImage(tile[currentTile].image, worldCol * gp.realTileSize, worldRow * gp.realTileSize, gp.realTileSize, gp.realTileSize, null);
           // }
       // }
        int worldCol=0;
        int worldRow=0;
        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){
int worldX = worldCol * gp.realTileSize;
int worldY = worldRow*gp.realTileSize;
int screenX = worldX - gp.player.worldX+gp.player.screenX;
int screenY = worldY - gp.player.worldY+gp.player.screenY;

int currentTile = mapTileNumber[worldCol][worldRow];
g2.drawImage(tile[currentTile].image, screenX, screenY, gp.realTileSize, gp.realTileSize, null);
worldCol++;
if (worldCol == gp.maxWorldCol) {
    worldCol = 0;
    worldRow++;
}
        }
    }
}
