package kaaz.common;

import kaaz.factorio.Entities;

public class Buildable {
    public Entities entity;
    public double x;
    public double y;

    public Buildable(Entities entity, Double x, Double y) {

        this.entity = entity;
        this.x = x;
        this.y = y;
    }
}
