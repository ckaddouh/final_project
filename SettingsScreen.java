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

public class SettingsScreen extends GridPane {

    private MainApp mainApp;
    public static ComboBox<String> comboBox = new ComboBox<>();
    
    public SettingsScreen(MainApp app) throws FileNotFoundException {
        super();
        this.mainApp = app;

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));

        Text title = new Text("Settings");
        title.setFill(Color.DARKTURQUOISE);
        title.setFont(Font.font("AvantGarde", FontWeight.BOLD, FontPosture.REGULAR, 20));
        add(title, 0 , 2);

        Button changeScreenButton = new Button("Play");
        changeScreenButton.setOnAction(e -> handleButton());

        Button backBT = new Button("Back");
        backBT.setOnAction(e -> handleBackBT());

        Button instructionsBT = new Button("Instructions");
        instructionsBT.setOnAction(e -> handleInstructionsBT());

        addRow(2, changeScreenButton, backBT, instructionsBT);
        // GridPane bottom = new GridPane();
        // bottom.addRow(0, changeScreenButton, backBT, instructionsBT);

        setHgap(10);
        setVgap(10);
        setPadding(new Insets(10));

        // setAlignment(bottom, Pos.BOTTOM_RIGHT);
        // setBottom(bottom);

        ObservableList<String> files = FXCollections.observableArrayList("easy", "medium", "hard");
        // comboBox = new ComboBox<String>();
        comboBox.setItems(files);
        comboBox.setPromptText("Select a difficulty level");
        comboBox.setValue("easy");
        TextField numOfRounds = new TextField();
        numOfRounds.setOnAction(e -> {
            DrawingScreen.setNumOfRounds(Integer.parseInt(numOfRounds.getText()));
        });

        TextField timerLength = new TextField();
        timerLength.setOnAction(e -> {
            DrawingScreen.setTimerLength(Integer.parseInt(timerLength.getText()));
        });

        GridPane center = new GridPane();
        center.addRow(0, numOfRounds, timerLength);

        Label tester = new Label("Showing");

        addRow(1, tester, center, comboBox);


        comboBox.setOnAction(e -> {
            tester.setText(comboBox.getValue());
            try {
                DrawingScreen.setFileName(tester.getText());
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        });


    }

        private void handleButton() {
            //Call the appropriate method from the MainApp

            mainApp.showDrawingScreen();
        }

        private void handleBackBT(){
            mainApp.showWelcomeScreen();
        }

        private void handleInstructionsBT(){
            mainApp.showInstructionScreen();
        }
            
}