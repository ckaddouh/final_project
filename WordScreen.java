import java.io.FileNotFoundException;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

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
        
        wordLbl.setTextFill(Color.DODGERBLUE);
        wordLbl.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 36));
        setTop(wordLbl);
        setAlignment(wordLbl, Pos.CENTER);

        GridPane pane = new GridPane();
        
        // roundsLbl = new Label();
        // time = new Label();
        
        
        Label filler = new Label();
        pane.addRow(1, filler, roundsLbl);
        Label filler2 = new Label();
        pane.addRow(2, filler2);
        Label filler3 = new Label();
        pane.addRow(3, filler3, time);
        setAlignment(time, Pos.CENTER);

        Label filler4 = new Label();
        pane.addRow(4, filler4);
        Label ready = new Label("Ready?");
        ready.setFont(Font.font("verdana", 20));
        Button play = new Button("Let's Go!");

        Label filler5 = new Label();
        pane.addRow(5, filler5, ready);
        setAlignment(ready, Pos.CENTER);
        Label filler6 = new Label();
        pane.addRow(6, filler6, play);
        setAlignment(play, Pos.CENTER);

        play.setOnAction(e -> handleButton());
        
        setCenter(pane);
        setAlignment(pane, Pos.CENTER);
        
    }

        private void handleButton() {
            mainApp.showDrawingScreen();
            new Reminder(sec);
            System.out.println("Task scheduled.");
        }
        
        public static void setFileName(String fileName) throws FileNotFoundException {
            file_name = fileName;
            list = new Words("words/" + file_name + ".txt");
            useWords();
        }
        
        public static void setTimerLength(int timerLength) {
            sec = timerLength;
            time.setText(String.format("You have %d seconds", sec));
            time.setFont(Font.font("verdana", 20));
        }
    
        public static void setNumOfRounds(int numOfRounds) {
            rounds = numOfRounds;
            
            roundsLbl.setText(String.format("There are %d rounds remaining", rounds));
            roundsLbl.setFont(Font.font("verdana", 20));

        }

        public static void useWords(){
            word = list.getRandomWord();
            wordLbl.setText("" + word);
            list.remove(word);
        }

        public static int getNumOfRounds(){
            return rounds;
        }
}

// Interesting: https://www.youtube.com/watch?v=AUpytdHcwUg 