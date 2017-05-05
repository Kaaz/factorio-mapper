package kaaz.factorio;

import java.awt.*;

public enum Entities {
    SOLAR_PANEL("solar-panel", 's',3,3,new Color(0x84B1FF)),
    SMALL_LAMP("small-lamp", '*',1,1,new Color(0x82FF35)),
    ACCUMULATOR("accumulator", 'A',2,2,new Color(0x291CFF)),
    ELECTRIC_POLE_MEDIUM("medium-electric-pole", 'x',1,1,new Color(0xF7FFB0)),
    SUBSTATION("substation", 'X',2,2,new Color(0xF2FF1F)),
    ROBOPORT("roboport", 'R',4,4,new Color(0x2E2E2E)),

    UNKNOWN("unknown", '?',1,1,new Color(0xFFFFFF));

    private final String name;
    private final char mapIndicator;
    private final int width;
    private final int height;
    private Color color;

    Entities(String name, char mapIndicator,int width, int height,Color color) {

        this.name = name;
        this.mapIndicator = mapIndicator;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public static Entities fromCode(String name) {
        for (Entities e : values()) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return UNKNOWN;
    }

    public char getMapIndicator() {
        return mapIndicator;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Color getColor() {
        return color;
    }
}
