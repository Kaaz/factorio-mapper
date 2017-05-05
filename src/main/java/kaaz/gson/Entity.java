package kaaz.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entity {

    @SerializedName("entity_number")
    @Expose
    private Integer entityNumber;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("position")
    @Expose
    private Position position;

    public Integer getEntityNumber() {
        return entityNumber;
    }

    public void setEntityNumber(Integer entityNumber) {
        this.entityNumber = entityNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "\nEntity{" +
                "#=" + entityNumber +
                ", N='" + name + '\'' +
                ", POS=" + position +
                '}';
    }
}
