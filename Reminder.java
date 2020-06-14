import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.awt.Toolkit;

/**
 * Simple demo that uses java.util.Timer to schedule a task 
 * to execute once 5 seconds have passed.
 */

public class Reminder extends BorderPane {
    private MainApp mainApp;

    Toolkit toolkit;    
    public static Timer timer;

    static int seconds;
    public static Button changeScreen;

    public Reminder(MainApp app) {
        super();
        this.mainApp = app;

        toolkit = Toolkit.getDefaultToolkit();

        timer = new Timer();
        timer.schedule(new RemindTask(), 0, 1*1000);
        
        seconds = WordScreen.sec;
        
        
        // label.textProperty().bind(secs.textProperty());
        // DrawingScreen.timerLbl.textProperty().bind(secs.textProperty());
        // show.setOnAction(e -> {
        //     // DrawingScreen.setTimerLength(seconds);
        //     DrawingScreen.setTimerLength(seconds);
        //     // ResultsScreen.text.setText("Hmmm");

        // });

        changeScreen = new Button();
        changeScreen.setOnAction(e -> {
            DrawingScreen.isCorrect = false;
            // MainApp.stage2.close();

            mainApp.showResultsScreen();
        });

	}

    class RemindTask extends TimerTask {
        public void run() {
            if (seconds > 0) {
                // show.fire();
                System.out.println("" + seconds);
                // label.setText(String.valueOf(seconds));
                seconds--;
            }
            
            else {
                toolkit.beep();
                changeScreen.fire();

                // DrawingScreen.timerLbl.setText("Time's up!");
                // DrawingScreen.info.setText("Time's up!");
                timer.cancel(); //Terminate the timer thread
                // System.exit();
            }
        }
    }
}


// Using the timer: https://www.iitk.ac.in/esc101/05Aug/tutorial/essential/threads/timer.html 