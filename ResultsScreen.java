// Display the results of each round depending on if the user guessed correctly or not

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

// Create a class that extends GridPane
public class ResultsScreen extends GridPane {

    private MainApp mainApp;
    public static Text text;
    
    public static ImageView imageView;

    public ResultsScreen(MainApp app) {
        super();

        this.mainApp = app;

        // Set the background of the screen and create an ImageView
        setBackground(new Background(new BackgroundFill(Color.LIGHTCYAN, CornerRadii.EMPTY, Insets.EMPTY)));
        imageView = new ImageView();

        add(imageView, 5, 3);

        // Create two buttons and format them
        Button next = new Button("Finish");
        Button changeScreenButton = new Button("Next");

        next.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.7), 5, 0.0, 0, 1)");
        next.setStyle("-fx-font: 22 fantasy; -fx-background-color: #0072ab, linear-gradient(#2a5880 0%, #1f2429 20%, #191d22 100%), linear-gradient(#007be0, #3275c7), radial-gradient(center 50% 0%, radius 100%, #64a5f5, #9ddbfa)");
        
        changeScreenButton.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.7), 5, 0.0, 0, 1)");
        changeScreenButton.setStyle("-fx-font: 22 fantasy; -fx-background-color: #0072ab, linear-gradient(#2a5880 0%, #1f2429 20%, #191d22 100%), linear-gradient(#007be0, #3275c7), radial-gradient(center 50% 0%, radius 100%, #64a5f5, #9ddbfa)");

        add(next, 2, 3);

        // Only activate the next button if the number of rounds remaining is less than or equal to 1
        next.setOnAction(e -> {
            if (WordScreen.getNumOfRounds() <= 1) {
                handleFinalScreen();
                DrawingScreen.isCorrect = false;
            }
        
        });
    
        // Create a new text box for if the user guessed the word or not that is edited from other classes
        text = new Text();

        // Format it
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        add(text, 1, 1, 2, 2);
        GridPane.setHalignment(text, HPos.CENTER);

        // Set the actions for the back button to only work if there are still rounds remaining
        changeScreenButton.setOnAction(e -> {
            if ((WordScreen.rounds - 1) > 0){
                // Set a new word and change the screen to wordScreen
                WordScreen.useWords();
                handleButton();
            }
        });

        add(changeScreenButton, 3, 3);
        
        // Format the GridPane
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(10));
        
    }

    // Define methods to handle each button

    private void handleButton() {
        // Decrement the number of rounds once the user guesses or time is up
        WordScreen.setNumOfRounds(WordScreen.rounds - 1);
        mainApp.showWordScreen();
    }

    private void handleFinalScreen() {
        mainApp.showFinalScreen();
    }
    

}