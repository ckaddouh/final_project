import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.io.FileNotFoundException;
import java.util.Optional;

import javax.swing.event.ChangeListener;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * ScreenA is a subclass of GridPane. Since GridPane is a subclass of Pane, it
 * can be saved in a Pane variable too.
 */
public class WelcomeScreen extends GridPane {

    private MainApp mainApp;
    public static String file_name;
    public final ComboBox<String> comboBox;

    public WelcomeScreen(MainApp app) {
        super();
        // the super() calls the constructor of GridPane.
        // It's not necessary because it's automatically called,
        // but if we wanted certain parameters, we can add them.

        // Save the parameter app so we can access
        // methods from the mainApp for changing the screen.
        this.mainApp = app;

        Label label = new Label();
        label.setText("Welcome to Pictionary!");
        label.setTextFill(Color.DODGERBLUE);
        label.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        // ScreenA is a GridPane, so it has the GridPane methods like add(...)
        add(label, 0, 0);
        label.setAlignment(Pos.CENTER);
        GridPane.setValignment(label, VPos.CENTER);

        Button changeScreenButton = new Button("Instructions");
        changeScreenButton.setOnAction(e -> handleButton());
        add(changeScreenButton, 0, 1);

        ObservableList<String> files = FXCollections.observableArrayList("easy", "medium", "hard");
        comboBox = new ComboBox<String>();
        comboBox.setItems(files);
        comboBox.setPromptText("Select a difficulty level");

        add(comboBox, 2, 1);

        Label tester = new Label("testing");
        add(tester, 3, 3);

        comboBox.setOnAction(e -> {
            tester.setText(comboBox.getValue());
            try {
                DrawingScreen.setFileName(comboBox.getValue());
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        });
        
        Button play = new Button("Play");
        play.setOnAction(e -> handleButtonStart());
        add(play, 2, 2);

        //You would probably add more code to format this GridPane the way you'd like
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(10));
    }

    private void handleButton(){
        //Call the appropriate method from the MainApp
        mainApp.showInstructionScreen();
    }

    public void handleButton2(){
        mainApp.showSettingsScreen();
    }
    
    public void handleButtonStart(){
        mainApp.showDrawingScreen();
    }
}