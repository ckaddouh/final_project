import java.io.FileNotFoundException;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class WordScreen extends BorderPane {

    private MainApp mainApp;

    public static String file_name;
    public static Label difficulty;
    public static Label rounds;
    public static Label time;

    public static Words list;
    public static String word;
    public static Label wordLbl;

    public WordScreen(MainApp app) {
        super(); 
        this.mainApp = app;
        
        Label wordLbl = new Label();
        setTop(wordLbl);
        setAlignment(wordLbl, Pos.CENTER);

        GridPane pane = new GridPane();
        
        time = new Label("You have " + time + " seconds");
        
        pane.addRow(0, rounds);
        pane.addRow(1, time);

        Label ready = new Label("Ready?");
        Button play = new Button("Let's Go!");

        pane.addRow(2, ready, play);

        play.setOnAction(e -> handleButton());
        
        setCenter(pane);
        setAlignment(pane, Pos.CENTER);
    }

        private void handleButton() {
            mainApp.showDrawingScreen();
        }
        
        public static void setFileName(String fileName) throws FileNotFoundException {
            file_name = fileName;
            list = new Words("words/" + file_name + ".txt");
            useWords();
        }
        
        public static void setTimerLength(int timerLength) {
            time.setText("" + timerLength);
        }
    
        public static void setNumOfRounds(int numOfRounds) {
            rounds.setText("" + numOfRounds);
        }
        
       
        public static void useWords(){
            word = list.getRandomWord();
            wordLbl.setText("Your word is... " + word + "!");
            list.remove(word);
        }
}

// Interesting: https://www.youtube.com/watch?v=AUpytdHcwUg 