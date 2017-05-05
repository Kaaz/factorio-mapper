package kaaz.common;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MapGenerator {

    public static BufferedImage drawImage(int width, int height, BuildPlan plan) {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Color[][] colors = plan.toMinimap();
        int mapW = colors.length;
        int mapH = colors[0].length;
        int tileWidth = width / mapW;
        int tileHeight = height / mapH;
        int tileSize = Math.min(tileHeight, tileWidth);
        Graphics2D g = img.createGraphics();

        for (int x = 0; x < colors.length; x++) {
            for (int y = 0; y < colors[x].length; y++) {
                if (colors[x][y] == null) {
                    continue;
                }
                g.setColor(colors[x][y]);
                g.fillRect(y * tileSize, x * tileSize, tileSize-1, tileSize-1);
            }
        }
        return img;
    }
}
