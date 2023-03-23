package tile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
        mapTileNumber = new int[gp.maxScreenCollum][gp.maxScreenRow];
        getTileImage();
        loadMap("/maps/map0.txt");
    }

    public void getTileImage() {
        try {
            tile[0] = new tile();
            tile[0].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/grass.png"));

            tile[1] = new tile();
            tile[1].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/wall.png"));

            tile[2] = new tile();
            tile[2].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/water.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String mapPath) {
        try {
            InputStream is = getClass().getResourceAsStream("mapPath");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            for (int row = 0; row < gp.maxScreenRow; row++) {
                String line = br.readLine();
                String[] characters = line.split("");

                for (int col = 0; col < gp.maxScreenCollum; col++) {
                    char currentChar = characters[col].charAt(0);
                    int tileNum;

                    switch (currentChar) {
                        case 'W':
                            tileNum = 1;
                            break;
                        case 'L':
                            tileNum = 2;
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
        for (int col = 0; col < gp.maxScreenCollum; col++) {
            for (int row = 0; row < gp.maxScreenRow; row++) {
                int currentTile = mapTileNumber[col][row];
                g2.drawImage(tile[currentTile].image, col * gp.realTileSize, row * gp.realTileSize, gp.realTileSize, gp.realTileSize, null);
            }
        }
    }
}
