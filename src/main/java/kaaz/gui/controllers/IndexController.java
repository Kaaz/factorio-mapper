package kaaz.gui.controllers;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import kaaz.common.BuildPlan;
import kaaz.common.MapGenerator;
import kaaz.gui.core.MyController;
import kaaz.transform.Transformer;

import java.net.URL;
import java.util.ResourceBundle;

public class IndexController extends MyController {

    public Button btn_import;
    public Button btn_save_img;
    public TextField input_blueprint;
    public ImageView blueprint_image;

    public void initialize(URL location, ResourceBundle resources) {
        btn_import.setOnMouseClicked(event -> {
            System.out.println("CLICKY CLICKY");
            String input = input_blueprint.getText();
            System.out.println(input);
            BuildPlan buildPlan = Transformer.fromGameBluePrint(input);
            if(buildPlan == null){
                System.out.println("invalid blueprint");
                return;
            }
            WritableImage image = SwingFXUtils.toFXImage(MapGenerator.drawImage((int)blueprint_image.getFitWidth(),(int)blueprint_image.getFitHeight(),buildPlan), null);
            blueprint_image.setImage(image);

        });
    }
}
