// A screen that displays a word, length of the round, and the number of rounds remaining 

import java.io.FileNotFoundException;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

// Create a class that extends BorderPane
public class WordScreen extends BorderPane {

    private MainApp mainApp;

    public static String file_name;
    public static Label difficulty = new Label("difficulty");
    public static Label roundsLbl = new Label("rounds");
    public static Label time = new Label("time");

    public static Words list;
    public static String word;
    public static Label wordLbl = new Label();

    public static int rounds;
    public static int sec;

    public WordScreen(MainApp app) {
        super(); 
        this.mainApp = app;

        // Set the background of the screen
        setBackground( new Background( new BackgroundFill(Color.LIGHTCYAN, CornerRadii.EMPTY, Insets.EMPTY)));
        
        // Format the word label and place it at the top center of the screen
        wordLbl.setTextFill(Color.DODGERBLUE);
        wordLbl.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 36));
        setTop(wordLbl);
        setAlignment(wordLbl, Pos.CENTER);

        // Create a GridPane
        GridPane pane = new GridPane();

        // Add filler labels
        Label filler = new Label();
        pane.addRow(1, filler, roundsLbl);
        Label filler2 = new Label();
        pane.addRow(2, filler2);
        Label filler3 = new Label();
        pane.addRow(3, filler3, time);
        setAlignment(time, Pos.CENTER);
        Label filler4 = new Label();
        pane.addRow(4, filler4);

        // Create a label and button to play
        Label ready = new Label("\tReady?\n");
        ready.setFont(Font.font("verdana", 20));
        Button play = new Button("Let's Go!");
        play.setOnAction(e -> handleButton());

        // Format the button
        play.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.7), 5, 0.0, 0, 1)");
        play.setStyle("-fx-font: 32 fantasy; -fx-background-color: #0072ab, linear-gradient(#2a5880 0%, #1f2429 20%, #191d22 100%), linear-gradient(#007be0, #3275c7), radial-gradient(center 50% 0%, radius 100%, #64a5f5, #9ddbfa)");

        // Create more fillers
        Label filler5 = new Label();
        pane.addRow(5, filler5, ready);
        setAlignment(ready, Pos.CENTER);
        Label filler6 = new Label();
        pane.addRow(6, filler6, play);
        setAlignment(play, Pos.CENTER);
        
        // Place the GridPane in the center
        setCenter(pane);
        setAlignment(pane, Pos.CENTER);

        // Create a new GridPane for the bottom with the button
        GridPane bottom = new GridPane();
        bottom.addRow(0, play);

        // Set the spacing of the GridPane
        bottom.setHgap(10);
        bottom.setVgap(10);
        bottom.setPadding(new Insets(10));

        setAlignment(bottom, Pos.BOTTOM_RIGHT);
        setBottom(bottom);

        
    }

        // Define a set of methods to handle the buttons and variables
        private void handleButton() {
            mainApp.showDrawingScreen();

        }
        
        // To set the file name variable, take the difficulty and format it into a file name
        public static void setFileName(String fileName) throws FileNotFoundException {
            file_name = fileName;
            // Create a list object of type Words
            list = new Words("words/" + file_name + ".txt");
            // Run useWords()
            useWords();
        }
        
        // To set the timer length, take the integer from settingsScreen and update the label
        public static void setTimerLength(int timerLength) {
            sec = timerLength;
            time.setText(String.format("\tYou have %d seconds", sec));
            time.setFont(Font.font("verdana", 20));
        }
    
        // To set the number of rounds, get the info from settingsScreen and format the label
        public static void setNumOfRounds(int numOfRounds) {
            rounds = numOfRounds;
            
            roundsLbl.setText(String.format("\n\tThere are %d rounds remaining", rounds));
            roundsLbl.setFont(Font.font("verdana", 20));
        }

        // User words takes the list object and gets a random word, displays it, and removes it from the list
        public static void useWords(){
            word = list.getRandomWord();
            wordLbl.setText("\nYour word is.... " + word + "!");
            list.remove(word);
        }

        // Create a getter for the number of rounds
        public static int getNumOfRounds(){
            return rounds;
        }
}

