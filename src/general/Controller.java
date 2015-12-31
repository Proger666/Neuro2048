package general;

import game2048.Game2048;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import neuronet.Neuronet;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Controller implements  ControlledScreen {


    ScreensController myController;
    @FXML
    public TextField tickTimeInputField;

    @FXML
    public TextField hiddenNodesCount;

    @FXML
    public TextField popSizeField;

    @FXML
    private Button goButt;
    private Canvas canvas;

    @FXML
    void onClickGoButt(ActionEvent event) {




        //Show new screens
        myController.setScreen(Main.neuroNetScreenID);
        myController.unloadScreen(Main.mainScreenID);


        Neuronet net = new Neuronet(Integer.parseInt(hiddenNodesCount.getText()),
                Integer.parseInt(popSizeField.getText()),
                Float.parseFloat(tickTimeInputField.getText()));

        //Start NeuroNet
        net.runSimulation(prepareGame());
    }

    private Game2048 prepareGame() {
        Game2048 game2048 = new Game2048();

        JFrame game = new JFrame();
        game.setTitle("2048 Game");
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setSize(340, 400);
        game.setResizable(false);

        game.add(game2048);
        game.setLocationRelativeTo(null);
        game.setVisible(true);


        return game2048;
    }

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
}
