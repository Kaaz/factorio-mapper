package kaaz.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tile {

    @SerializedName("position")
    @Expose
    private Position position;
    @SerializedName("name")
    @Expose
    private String name;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
