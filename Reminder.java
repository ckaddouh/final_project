import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.control.Button;
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
    public static boolean printStuff;
    public static Button show;
    public static Button changeScreen;

    public Reminder(MainApp mainApp) {
        super();

        toolkit = Toolkit.getDefaultToolkit();

        timer = new Timer();
        timer.schedule(new RemindTask(), 0, 1*1000);
        
        seconds = WordScreen.sec;
        
        show = new Button();
        show.setOnAction(e -> {
            // DrawingScreen.setTimerLength(seconds);
            DrawingScreen.info.setText(String.format("%d", seconds));
        });

        changeScreen = new Button();
        changeScreen.setOnAction(e -> {
            DrawingScreen.isCorrect = false;
            mainApp.showResultsScreen();
        });

	}

    class RemindTask extends TimerTask {
        public void run() {
            if (seconds > 0) {
                show.fire();
                System.out.println("" + seconds);
                seconds--;
            }
            
            else {
                toolkit.beep();
                changeScreen.fire();
                System.out.println("Time's up!");
                // DrawingScreen.info.setText("Time's up!");
                timer.cancel(); //Terminate the timer thread
                // System.exit();
            }
        }
    }
}


// Using the timer: https://www.iitk.ac.in/esc101/05Aug/tutorial/essential/threads/timer.html 