import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FinalScreen extends BorderPane {

    private MainApp mainApp;

    public FinalScreen(MainApp app) {
        super(); 
        this.mainApp = app;
        
        Label complete = new Label("Great job!");
        complete.setFont(new Font("verdana", 24));
        setTop(complete);
        setAlignment(complete, Pos.CENTER);

        ImageView imageView = new ImageView();
        imageView.setImage(new Image("image/confetti.gif"));
        setCenter(imageView);

        Label thanks = new Label("          Thanks for playing! \nWe hope you enjoyed the game! :)");
        thanks.setFont(new Font("verdana", 18));
        setBottom(thanks);
        setAlignment(thanks, Pos.CENTER);

        setBackground( new Background( new BackgroundFill(Color.LIGHTCYAN, CornerRadii.EMPTY, Insets.EMPTY)));

    }
}