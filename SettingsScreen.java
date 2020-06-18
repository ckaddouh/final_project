// A settings screen where users can edit the length of each round, the number of rounds, and the difficulty level
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

// Create a class that extends BorderPane
public class SettingsScreen extends BorderPane {

    private MainApp mainApp;
    public static ComboBox<String> comboBox = new ComboBox<>();
    public static TextField timerLength;
    public static TextField numOfRounds;
    
    public SettingsScreen(MainApp app) throws FileNotFoundException {
        super();
        this.mainApp = app;

        // Create a new GridPane and format it
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));

        // Set the background of the screen
        setBackground( new Background( new BackgroundFill(Color.LIGHTCYAN, CornerRadii.EMPTY, Insets.EMPTY)));

        // Create a title and format it at the top center
        Text title = new Text("\nSettings\n");
        title.setFill(Color.DODGERBLUE);
        title.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 35));
        title.setStyle("text-decoration: underline overline; -fx-background-color: dodgerblue");
        setTop(title);
        setAlignment(title, Pos.CENTER);

        // Create 3 buttons: play, back, and instructions
        Button changeScreenButton = new Button("Play");
        changeScreenButton.setOnAction(e -> handleButton());

        Button backBT = new Button("Back");
        backBT.setOnAction(e -> handleBackBT());

        Button instructionsBT = new Button("Instructions");
        instructionsBT.setOnAction(e -> handleInstructionsBT());

        // Format the buttons
        changeScreenButton.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.7), 5, 0.0, 0, 1)");
        changeScreenButton.setStyle("-fx-font: 22 fantasy; -fx-background-color: #0072ab, linear-gradient(#2a5880 0%, #1f2429 20%, #191d22 100%), linear-gradient(#007be0, #3275c7), radial-gradient(center 50% 0%, radius 100%, #64a5f5, #9ddbfa)");

        backBT.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.7), 5, 0.0, 0, 1)");
        backBT.setStyle("-fx-font: 22 fantasy; -fx-background-color: #0072ab, linear-gradient(#2a5880 0%, #1f2429 20%, #191d22 100%), linear-gradient(#007be0, #3275c7), radial-gradient(center 50% 0%, radius 100%, #64a5f5, #9ddbfa)");

        instructionsBT.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.7), 5, 0.0, 0, 1)");
        instructionsBT.setStyle("-fx-font: 22 fantasy; -fx-background-color: #0072ab, linear-gradient(#2a5880 0%, #1f2429 20%, #191d22 100%), linear-gradient(#007be0, #3275c7), radial-gradient(center 50% 0%, radius 100%, #64a5f5, #9ddbfa)");

        // Create a GridPane at the bottom that holds the buttons, and set its spacing
        GridPane bottom = new GridPane();
        bottom.addRow(0, changeScreenButton, backBT, instructionsBT);
        
        bottom.setHgap(10);
        bottom.setVgap(10);
        bottom.setPadding(new Insets(10));

        // Format the GridPane
        setAlignment(bottom, Pos.BOTTOM_RIGHT);
        setBottom(bottom);

        // Create a list for the 3 levels that correspond to file names
        ObservableList<String> files = FXCollections.observableArrayList("easy", "medium", "hard");
        // comboBox = new ComboBox<String>();
        comboBox.setItems(files);
        comboBox.setPromptText("Select a difficulty level");
        comboBox.setValue("easy");

        // Create 2 text fields for the number of rounds and timer length
        numOfRounds = new TextField();
        timerLength = new TextField();

        numOfRounds.setText("10");
        timerLength.setText("30");
        
        // Create labels for each method of user input
        Label rounds = new Label("Number of Rounds");
        Label length = new Label("Length of Rounds (seconds)");
        Label difficulty = new Label("Difficulty Level");

        // Set the styles of each label
        rounds.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        rounds.setStyle("color: dodgerblue");

        length.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        length.setStyle("color: dodgerblue");

        difficulty.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        difficulty.setStyle("color: dodgerblue");

        // Create a GridPane for the center and add the labels and user inputs
        GridPane center = new GridPane();
        center.addRow(0, rounds, numOfRounds);
        center.addRow(1, length, timerLength);
        center.addRow(2, difficulty, comboBox);
        center.setHgap(10);
        center.setVgap(10);
        center.setPadding(new Insets(10));
        setCenter(center);

    }

        // Define methods to handle the buttons
        private void handleButton() {
            // If play is pressed, transfer information over to wordScreen
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