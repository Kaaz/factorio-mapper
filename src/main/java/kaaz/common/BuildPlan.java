package kaaz.common;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BuildPlan {
    private List<Buildable> entities;
    private double minX, maxX, minY, maxY;
    private static int margin = 4;

    public BuildPlan() {
        entities = new ArrayList<Buildable>();
        minX = 0;
        maxX = 0;
        minY = 0;
        maxY = 0;
    }

    public void addEntity(Buildable b) {
        minX = Math.min(minX, b.x);
        maxX = Math.max(maxX, b.x);
        minY = Math.min(minY, b.y);
        maxY = Math.max(maxY, b.y);
        entities.add(b);
    }
    public Color[][] toMinimap(){
        double offsetX = maxX - minX;
        double offsetY = maxY - minY;
        Color[][] m = createColorMap(margin + (int) offsetY, margin + (int) offsetX);
        int startX = (int) (offsetX - maxX)+margin/2;
        int startY = (int) (offsetY - maxY)+margin/2;
        for (Buildable entity : entities) {
            int x = entity.entity.getWidth() % 2 == 0 ? -entity.entity.getWidth() / 2 : -(entity.entity.getWidth() - 1) / 2;
            int xEnd = x + entity.entity.getWidth() - 1;
            int y = (entity.entity.getHeight()) % 2 == 0 ? -entity.entity.getHeight() / 2 : -(entity.entity.getHeight() - 1) / 2;
            int yEnd = x + entity.entity.getHeight() - 1;
            for (int i = x; i <= xEnd; i++) {
                for (int j = y; j <= yEnd; j++) {
                    m[startY + (int) entity.y + j][startX + (int) entity.x + i] = entity.entity.getColor();
                }
            }
        }
        return m;
    }
    public String toString() {
        double offsetX = maxX - minX;
        double offsetY = maxY - minY;
        char[][] m = createMap(margin + (int) offsetY, margin + (int) offsetX);
        int startX = (int) (offsetX - maxX)+margin/2;
        int startY = (int) (offsetY - maxY)+margin/2;
        for (Buildable entity : entities) {
            int x = entity.entity.getWidth() % 2 == 0 ? -entity.entity.getWidth() / 2 : -(entity.entity.getWidth() - 1) / 2;
            int xEnd = x + entity.entity.getWidth() - 1;
            int y = (entity.entity.getHeight()) % 2 == 0 ? -entity.entity.getHeight() / 2 : -(entity.entity.getHeight() - 1) / 2;
            int yEnd = x + entity.entity.getHeight() - 1;
            for (int i = x; i <= xEnd; i++) {
                for (int j = y; j <= yEnd; j++) {
                    m[startY + (int) entity.y + j][startX + (int) entity.x + i] = entity.entity.getMapIndicator();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m.length; i++) {
            char[] chars = m[i];
            for (char aChar : chars) {
                sb.append(aChar);
            }
            sb.append("\n");
        }
        return String.format("X %02.2f - %02.2f (difference: %02.2f)\n" +
                "Y %02.2f - %02.2f (difference: %02.2f)", minX, maxX, offsetX, minY, maxY, offsetY) + "\n\n" + sb.toString();
    }

    private char[][] createMap(int x, int y) {
        char[][] c = new char[x][y];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = ' ';
            }
        }
        return c;
    }
    private Color[][] createColorMap(int x, int y) {
        Color[][] c = new Color[x][y];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = Color.WHITE;
            }
        }
        return c;
    }
}
