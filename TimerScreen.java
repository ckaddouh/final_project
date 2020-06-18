// A countdown timer that is displayed in another window

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

// Create a class that extends BorderPane
public class TimerScreen extends BorderPane {

    private MainApp mainApp;
    private final Integer startTime = WordScreen.sec;
    private Integer seconds = startTime;
    private Label label;

    public TimerScreen (MainApp app) {
        super();
        this.mainApp = app;

        // Set the background of the screen
        setBackground( new Background( new BackgroundFill(Color.LIGHTCYAN, CornerRadii.EMPTY, Insets.EMPTY)));

        // Create a label for the timer to display and format it
        label = new Label();
        label.setTextFill(Color.DODGERBLUE);
        label.setFont(Font.font(20));

        // Create an HBox to add the label to
        HBox layout= new HBox(5);
        layout.getChildren().add(label);

        // Set the HBox to the center
        setCenter(layout);

        // Run the timer
        doTime();
    }

    private void doTime() {
        // Create a Timeline animation that stops when time is up
        Timeline time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);

            if(time != null) {
                time.stop();
            } 
        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
                // Subtract from the seconds every second and change the label
                seconds--;
                label.setText("Countdown: " + seconds.toString());
                label.setFont(new Font("Courier", 40));
                setCenter(label);
                setAlignment(label, Pos.CENTER);
                
                // Create an ImageView for a timer gif
                ImageView imageView = new ImageView();
                imageView.setImage(new Image("image/timer2.gif"));
                setBottom(imageView);
                setAlignment(imageView, Pos.CENTER);
                // Once the timer is up, stop it
                    if(seconds<=0) {
                        time.stop();
                    }
            }

        });

        // Run the animation
        time.getKeyFrames().add(frame);
        time.playFromStart();

    }

}