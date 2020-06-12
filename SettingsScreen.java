import java.io.FileNotFoundException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class SettingsScreen extends BorderPane {

    private MainApp mainApp;
    public static ComboBox<String> comboBox = new ComboBox<>();
    public static TextField timerLength;
    public static TextField numOfRounds;
    
    public SettingsScreen(MainApp app) throws FileNotFoundException {
        super();
        this.mainApp = app;

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));

        setBackground( new Background( new BackgroundFill(Color.LIGHTCYAN, CornerRadii.EMPTY, Insets.EMPTY)));


        Text title = new Text("Settings");
        title.setFill(Color.DODGERBLUE);
        title.setFont(Font.font("AvantGarde", FontWeight.BOLD, FontPosture.REGULAR, 20));
        setTop(title);

        title.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 35));
        title.setStyle("text-decoration: underline overline; -fx-background-color: dodgerblue");


        setAlignment(title, Pos.CENTER);

        Button changeScreenButton = new Button("Play");
        changeScreenButton.setOnAction(e -> handleButton());

        Button backBT = new Button("Back");
        backBT.setOnAction(e -> handleBackBT());

        Button instructionsBT = new Button("Instructions");
        instructionsBT.setOnAction(e -> handleInstructionsBT());

        changeScreenButton.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.7), 5, 0.0, 0, 1)");
        changeScreenButton.setStyle("-fx-font: 22 fantasy; -fx-background-color: #0072ab, linear-gradient(#2a5880 0%, #1f2429 20%, #191d22 100%), linear-gradient(#007be0, #3275c7), radial-gradient(center 50% 0%, radius 100%, #64a5f5, #9ddbfa)");

        backBT.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.7), 5, 0.0, 0, 1)");
        backBT.setStyle("-fx-font: 22 fantasy; -fx-background-color: #0072ab, linear-gradient(#2a5880 0%, #1f2429 20%, #191d22 100%), linear-gradient(#007be0, #3275c7), radial-gradient(center 50% 0%, radius 100%, #64a5f5, #9ddbfa)");

        instructionsBT.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.7), 5, 0.0, 0, 1)");
        instructionsBT.setStyle("-fx-font: 22 fantasy; -fx-background-color: #0072ab, linear-gradient(#2a5880 0%, #1f2429 20%, #191d22 100%), linear-gradient(#007be0, #3275c7), radial-gradient(center 50% 0%, radius 100%, #64a5f5, #9ddbfa)");


        GridPane bottom = new GridPane();
        bottom.addRow(0, changeScreenButton, backBT, instructionsBT);
        
        bottom.setHgap(10);
        bottom.setVgap(10);
        bottom.setPadding(new Insets(10));

        setAlignment(bottom, Pos.BOTTOM_RIGHT);
        setBottom(bottom);

        ObservableList<String> files = FXCollections.observableArrayList("easy", "medium", "hard");
        // comboBox = new ComboBox<String>();
        comboBox.setItems(files);
        comboBox.setPromptText("Select a difficulty level");
        comboBox.setValue("easy");

        numOfRounds = new TextField();
        timerLength = new TextField();

        numOfRounds.setText("10");
        timerLength.setText("30");
        

        Label rounds = new Label("Number of Rounds");
        Label length = new Label("Length of Rounds (seconds)");
        Label difficulty = new Label("Difficulty Level");

        rounds.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        rounds.setStyle("color: dodgerblue");

        length.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        length.setStyle("color: dodgerblue");

        difficulty.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        difficulty.setStyle("color: dodgerblue");


        GridPane center = new GridPane();
        center.addRow(0, rounds, numOfRounds);
        center.addRow(1, length, timerLength);
        center.addRow(2, difficulty, comboBox);
        center.setHgap(10);
        center.setVgap(10);
        center.setPadding(new Insets(10));
        setCenter(center);

        // comboBox.setOnAction(e -> {
        //     try {
        //         WordScreen.setFileName(comboBox.getValue());
        //     } catch (FileNotFoundException e1) {
        //         e1.printStackTrace();
        //     }
        // });
    }

        private void handleButton() {
            //Call the appropriate method from the MainApp
            WordScreen.setNumOfRounds(Integer.parseInt(SettingsScreen.numOfRounds.getText()));
            mainApp.showWordScreen();
        }

        private void handleBackBT(){
            mainApp.showWelcomeScreen();
        }

        private void handleInstructionsBT(){
            mainApp.showInstructionScreen();
        }
            
}