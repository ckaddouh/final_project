import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ResultsScreen extends GridPane {

    private MainApp mainApp;

    public ResultsScreen(MainApp app) {
        super();

        this.mainApp = app;

        DrawingScreen.rounds--;

        Button next = new Button("Next");

        if (WordScreen.rounds <= 0) 
            add(next, 2, 3);

        next.setOnAction(e -> {
            if (WordScreen.rounds <= 0) 
                handleFinalScreen();
        });
        
        Text text = new Text("Results!");
        text.setFill(Color.DARKTURQUOISE);
        text.setFont(Font.font("AvantGarde", FontWeight.BOLD, FontPosture.REGULAR, 20));
        add(text, 1, 1, 2, 2);
        GridPane.setHalignment(text, HPos.CENTER);

        Button changeScreenButton = new Button("Back");
        changeScreenButton.setOnAction(e -> {
            WordScreen.useWords();
            handleButton();
        });
        add(changeScreenButton, 3, 3, 1, 1);
        
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(10));

        
    }
    private void handleButton(){
        mainApp.showWordScreen();
    }

    private void handleFinalScreen() {
        mainApp.showFinalScreen();
    }

}