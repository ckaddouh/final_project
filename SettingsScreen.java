import java.io.FileNotFoundException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
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

        Text title = new Text("Settings");
        title.setFill(Color.DARKTURQUOISE);
        title.setFont(Font.font("AvantGarde", FontWeight.BOLD, FontPosture.REGULAR, 20));
        setTop(title);

        setAlignment(title, Pos.CENTER);

        Button changeScreenButton = new Button("Play");
        changeScreenButton.setOnAction(e -> handleButton());

        Button backBT = new Button("Back");
        backBT.setOnAction(e -> handleBackBT());

        Button instructionsBT = new Button("Instructions");
        instructionsBT.setOnAction(e -> handleInstructionsBT());

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