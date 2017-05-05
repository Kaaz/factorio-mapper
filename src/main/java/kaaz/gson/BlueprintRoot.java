package kaaz.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BlueprintRoot {

    @SerializedName("blueprint")
    @Expose
    private Blueprint blueprint;

    public Blueprint getBlueprint() {
        return blueprint;
    }

    public void setBlueprint(Blueprint blueprint) {
        this.blueprint = blueprint;
    }

    @Override
    public String toString() {
        return "BlueprintRoot{" +
                "blueprint=" + blueprint +
                '}';
    }
}