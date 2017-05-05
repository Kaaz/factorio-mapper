package kaaz.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Blueprint {

    @SerializedName("icons")
    @Expose
    private List<Icon> icons = null;
    @SerializedName("entities")
    @Expose
    private List<Entity> entities = null;
    @SerializedName("tiles")
    @Expose
    private List<Tile> tiles = null;
    @SerializedName("item")
    @Expose
    private String item;
    @SerializedName("version")
    @Expose
    private Long version;

    public List<Icon> getIcons() {
        return icons;
    }

    public void setIcons(List<Icon> icons) {
        this.icons = icons;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Blueprint{" +
                "\nicons=" + icons +
                "\n, entities=" + entities +
                "\n, tiles=" + tiles +
                "\n, item='" + item + '\'' +
                "\n, version=" + version +
                "\n}";
    }
}
