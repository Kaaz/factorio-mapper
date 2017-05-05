package kaaz.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import kaaz.gui.core.MyController;

import java.io.InputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GuiApplication extends Application {

    private final ScheduledExecutorService planpool;
    private Stage stage;

    public GuiApplication() {
        planpool = Executors.newScheduledThreadPool(1);
    }

    public void start(final Stage primaryStage) throws Exception {
        stage = primaryStage;
        primaryStage.show();
        loadScreen();
        planpool.schedule(() -> Platform.runLater(this::mainScreen), 3, TimeUnit.SECONDS);
        primaryStage.setOnCloseRequest(t -> {
            Platform.exit();
            System.exit(0);
        });
    }

    public void loadScreen() {
        try {
            MyController controller = (MyController) replaceSceneContent("/view/load.fxml");
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mainScreen() {
        try {
            MyController controller = (MyController) replaceSceneContent("/view/main.fxml");
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = getClass().getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(getClass().getResource(fxml));
        AnchorPane page;
        try {
            page = loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, 1280, 800);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }
}