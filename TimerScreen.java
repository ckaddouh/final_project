import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class TimerScreen extends BorderPane {

    private MainApp mainApp;
    private final Integer startTime = WordScreen.sec;
    private Integer seconds = startTime;
    private Label label;

    public TimerScreen (MainApp app) {
        super();
        this.mainApp = app;
    
        label = new Label();
        label.setTextFill(Color.ORANGE);
        label.setFont(Font.font(20));
        HBox layout= new HBox(5);
        layout.getChildren().add(label);

        setCenter(layout);
        doTime();

        // setScene(new Scene(layout, 300, 70, Color.BLACK));
        // setTitle("Countdown Timer");
        // show();

    }

    private void doTime() {
        Timeline time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);

            if(time!=null) {
                time.stop();
            } 
        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
                seconds--;
                label.setText("Countdown: " + seconds.toString());
                    if(seconds<=0) {
                        time.stop();
                    }
            }

        });

        time.getKeyFrames().add(frame);
        time.playFromStart();

    }

    // public static void main(String[] args) {
    //     launch(args);
    // }
}