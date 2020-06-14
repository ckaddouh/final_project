import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
<<<<<<< HEAD
=======
import javafx.scene.layout.BorderPane;
>>>>>>> 6ea45953e40307ef7117697aa07d30825cdde9da
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

<<<<<<< HEAD
public class TimerScreen extends Application {

    private final Integer startTime = 10;
    private Integer seconds = startTime;
    private Label label;

    @Override
    public void start (Stage windows) throws Exception {


=======
public class TimerScreen extends BorderPane {

    private MainApp mainApp;
    private final Integer startTime = WordScreen.sec;
    private Integer seconds = startTime;
    private Label label;

    public TimerScreen (MainApp app) {
        super();
        this.mainApp = app;
    
>>>>>>> 6ea45953e40307ef7117697aa07d30825cdde9da
        label = new Label();
        label.setTextFill(Color.ORANGE);
        label.setFont(Font.font(20));
        HBox layout= new HBox(5);
        layout.getChildren().add(label);
<<<<<<< HEAD
        doTime();

        windows.setScene(new Scene(layout, 300, 70, Color.BLACK));
        windows.setTitle("Countdown Timer");
        windows.show();
=======

        setCenter(layout);
        doTime();

        // setScene(new Scene(layout, 300, 70, Color.BLACK));
        // setTitle("Countdown Timer");
        // show();
>>>>>>> 6ea45953e40307ef7117697aa07d30825cdde9da

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

<<<<<<< HEAD
    public static void main(String[] args) {
        launch(args);
    }

=======
    // public static void main(String[] args) {
    //     launch(args);
    // }
>>>>>>> 6ea45953e40307ef7117697aa07d30825cdde9da
}