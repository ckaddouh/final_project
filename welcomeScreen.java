import java.io.FileNotFoundException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * ScreenA is a subclass of GridPane. Since GridPane is a subclass of Pane, it
 * can be saved in a Pane variable too.
 */
public class WelcomeScreen extends BorderPane {

    private MainApp mainApp;
    public static String file_name;

    public WelcomeScreen(MainApp app) {
        super();
        // the super() calls the constructor of GridPane.
        // It's not necessary because it's automatically called,
        // but if we wanted certain parameters, we can add them.

        // Save the parameter app so we can access
        // methods from the mainApp for changing the screen.
        this.mainApp = app;

        Label label = new Label();
        label.setText(" Welcome to Pictionary! ");
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 48));
        label.setStyle("text-decoration: underline overline; -fx-background-color: dodgerblue");

        // ScreenA is a GridPane, so it has the GridPane methods like add(...)
        setCenter(label);
        setAlignment(label, Pos.CENTER);
        setBackground( new Background( new BackgroundFill(Color.LIGHTCYAN, CornerRadii.EMPTY, Insets.EMPTY)));


        label.setAlignment(Pos.CENTER);
        GridPane.setValignment(label, VPos.CENTER);

        
        Button changeScreenButton = new Button("Instructions");
        changeScreenButton.setOnAction(e -> handleButton());
        changeScreenButton.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.7), 5, 0.0, 0, 1)");
        changeScreenButton.setStyle("-fx-font: 22 fantasy; -fx-background-color: #0072ab, linear-gradient(#2a5880 0%, #1f2429 20%, #191d22 100%), linear-gradient(#007be0, #3275c7), radial-gradient(center 50% 0%, radius 100%, #64a5f5, #9ddbfa)");
        
        
        Button play = new Button("Start");
        play.setOnAction(e -> handleButtonStart());
        play.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.7), 5, 0.0, 0, 1)");
        play.setStyle("-fx-font: 22 fantasy; -fx-background-color: #0072ab, linear-gradient(#2a5880 0%, #1f2429 20%, #191d22 100%), linear-gradient(#007be0, #3275c7), radial-gradient(center 50% 0%, radius 100%, #64a5f5, #9ddbfa)");


        Button settingsBT = new Button("Settings");
        settingsBT.setOnAction(e -> handleButtonSettings());
        settingsBT.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.7), 5, 0.0, 0, 1)");
        settingsBT.setStyle("-fx-font: 22 fantasy; -fx-background-color: #0072ab, linear-gradient(#2a5880 0%, #1f2429 20%, #191d22 100%), linear-gradient(#007be0, #3275c7), radial-gradient(center 50% 0%, radius 100%, #64a5f5, #9ddbfa)");
        

        GridPane bottom = new GridPane();
        bottom.addRow(0, changeScreenButton, play, settingsBT);

        bottom.setHgap(20);
        bottom.setVgap(10);
        bottom.setPadding(new Insets(10));

        setAlignment(bottom, Pos.CENTER);
        setBottom(bottom);
        bottom.setBackground( new Background( new BackgroundFill(Color.LIGHTCYAN, CornerRadii.EMPTY, Insets.EMPTY)));

        //You would probably add more code to format this GridPane the way you'd like
    }

    private void handleButton(){
        //Call the appropriate method from the MainApp
        mainApp.showInstructionScreen();
    }
    
    public void handleButtonStart(){
        WordScreen.setNumOfRounds(Integer.parseInt(SettingsScreen.numOfRounds.getText()));
        mainApp.showWordScreen();
    }

    public void handleButtonSettings() {
        mainApp.showSettingsScreen();
    }
}