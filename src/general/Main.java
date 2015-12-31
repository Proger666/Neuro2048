package general;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.stage.Stage;

import java.awt.event.ActionListener;



public class Main extends Application {


    public static String mainScreenID = "mainScreen";
    public static String mainScreenFile = "/general/MainForm.fxml";
    public static String neuroNetScreenID = "NeuroNetScreen";
    public static String neuroNetScreenFile = "/general/NeuroNetForm.fxml";
    @Override
    public void start(Stage primaryStage) throws Exception{


        ScreensController mainController = new ScreensController();
        mainController.loadScreen(Main.mainScreenID, Main.mainScreenFile);
        mainController.loadScreen(Main.neuroNetScreenID, Main.neuroNetScreenFile);

        mainController.setScreen(Main.mainScreenID);

        Group root = new Group();
        root.getChildren().addAll(mainController);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }


}
