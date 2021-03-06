// A screen which displays a final message for the users until they exit

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// Create a class that extends BorderPane
public class FinalScreen extends BorderPane {

    private MainApp mainApp;

    public FinalScreen(MainApp app) {
        super(); 
        this.mainApp = app;
        
        // Create a completion label and format it
        Label complete = new Label("\nGreat job!");
        complete.setTextFill(Color.DODGERBLUE);
        complete.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
        setTop(complete);
        setAlignment(complete, Pos.CENTER);

        // Create an ImageView for a gif in the center
        ImageView imageView = new ImageView();
        imageView.setImage(new Image("image/confetti.gif"));
        setCenter(imageView);

        // Create a thank you label and format it
        Label thanks = new Label("          Thanks for playing! \nWe hope you enjoyed the game! \n                      :)");
        thanks.setFont(new Font("verdana", 20));
        thanks.setTextFill(Color.DODGERBLUE);
        setBottom(thanks);
        setAlignment(thanks, Pos.CENTER);

        // Set the background
        setBackground( new Background( new BackgroundFill(Color.LIGHTCYAN, CornerRadii.EMPTY, Insets.EMPTY)));

    }
}