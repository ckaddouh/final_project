import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.image.*;
import javafx.scene.image.ImageView;


public class ResultsScreen extends GridPane {

    private MainApp mainApp;
    public static Text text;
    
    public static ImageView imageView;

    public ResultsScreen(MainApp app) {
        super();

        this.mainApp = app;

        setBackground(new Background(new BackgroundFill(Color.LIGHTCYAN, CornerRadii.EMPTY, Insets.EMPTY)));
        imageView = new ImageView();

        add(imageView, 5, 3);

        Button next = new Button("Next");
        Button changeScreenButton = new Button("Back");

        next.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.7), 5, 0.0, 0, 1)");
        next.setStyle("-fx-font: 22 fantasy; -fx-background-color: #0072ab, linear-gradient(#2a5880 0%, #1f2429 20%, #191d22 100%), linear-gradient(#007be0, #3275c7), radial-gradient(center 50% 0%, radius 100%, #64a5f5, #9ddbfa)");
        
        changeScreenButton.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.7), 5, 0.0, 0, 1)");
        changeScreenButton.setStyle("-fx-font: 22 fantasy; -fx-background-color: #0072ab, linear-gradient(#2a5880 0%, #1f2429 20%, #191d22 100%), linear-gradient(#007be0, #3275c7), radial-gradient(center 50% 0%, radius 100%, #64a5f5, #9ddbfa)");


        setBackground( new BackgroundFill(Color.LIGHTCYAN, CornerRadii.EMPTY, Insets.EMPTY));

        add(next, 2, 3);

        next.setOnAction(e -> {
            if (WordScreen.getNumOfRounds() <= 1) {
                handleFinalScreen();
                DrawingScreen.isCorrect = false;
            }
        
        });


        // changeScreenButton.disarm();
    
        
        text = new Text();

        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        add(text, 1, 1, 2, 2);
        GridPane.setHalignment(text, HPos.CENTER);

        changeScreenButton.setOnAction(e -> {
            if ((WordScreen.rounds - 1) > 0){
                WordScreen.useWords();
                handleButton();
            }
        });

        add(changeScreenButton, 3, 3);
        
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(10));
        
    }

    private void setBackground(BackgroundFill backgroundFill) {
    }

    private void handleButton() {
        WordScreen.setNumOfRounds(WordScreen.rounds - 1);
        mainApp.showWordScreen();
    }

    private void handleFinalScreen() {
        mainApp.showFinalScreen();
    }
    

}