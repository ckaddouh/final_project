// An instruction screen from which users can go back to the Welcome or play

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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

// Create a class that extends Border Pane
public class InstructionScreen extends BorderPane {

    private MainApp mainApp;

    public InstructionScreen(MainApp app) {
        super();
        this.mainApp = app;

        // Create a title and format it
        Text text = new Text();
        text.setText("\nInstructions"); 
        text.setFill(Color.DODGERBLUE);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 35));
        // Place the title at the top center of the screen
        setTop(text);
        setAlignment(text, Pos.CENTER);

        // Create 2 buttons: back and play
        Button changeScreenBack = new Button("Back");
        changeScreenBack.setOnAction(e -> handleButtonBack());
        
        Button changeScreenPlay = new Button("Play");
        changeScreenPlay.setOnAction(e -> handleButtonPlay());

        // Set the styles of the buttons
        changeScreenBack.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.7), 5, 0.0, 0, 1)");
        changeScreenBack.setStyle("-fx-font: 22 fantasy; -fx-background-color: #0072ab, linear-gradient(#2a5880 0%, #1f2429 20%, #191d22 100%), linear-gradient(#007be0, #3275c7), radial-gradient(center 50% 0%, radius 100%, #64a5f5, #9ddbfa)");

        changeScreenPlay.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.7), 5, 0.0, 0, 1)");
        changeScreenPlay.setStyle("-fx-font: 22 fantasy; -fx-background-color: #0072ab, linear-gradient(#2a5880 0%, #1f2429 20%, #191d22 100%), linear-gradient(#007be0, #3275c7), radial-gradient(center 50% 0%, radius 100%, #64a5f5, #9ddbfa)");

        // Make the bottom of the BorderPane a GridPane of the buttons
        GridPane bottom = new GridPane();
        bottom.addRow(0, changeScreenBack, changeScreenPlay);

        // Set the sapcing and position of the GridPane
        bottom.setHgap(10);
        bottom.setVgap(10);
        bottom.setPadding(new Insets(10));

        setAlignment(bottom, Pos.BOTTOM_RIGHT);
        setBottom(bottom);

        // Create text for the actual instructions in the center
        Text inst = new Text("          Welcome to Pictionary!\nThe game is simple: one player draws,\n           and the other guesses.\n   You are given a certain amount of\n    time to get as many as you can.\n         Go to settings to change\n  the number of rounds and length.\n           To begin, press play!");
        // Format the text
        inst.setFont(Font.font("verdana", FontPosture.REGULAR, 25));
        setAlignment(inst, Pos.CENTER);
        setCenter(inst);

        // Set the background color of the screen
        setBackground( new Background( new BackgroundFill(Color.LIGHTCYAN, CornerRadii.EMPTY, Insets.EMPTY)));

    }

    // Define methods to handle screen changes for each button

    private void handleButtonBack(){
        mainApp.showWelcomeScreen();
    }
    
    private void handleButtonPlay() {
        WordScreen.setNumOfRounds(Integer.parseInt(SettingsScreen.numOfRounds.getText()));
        mainApp.showWordScreen();
    }
}
