import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

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


        changeScreen = new Button();
        changeScreen.setOnAction(e -> {
            DrawingScreen.isCorrect = false;

            mainApp.showResultsScreen();
        });

	}

    class RemindTask extends TimerTask {
        public void run() {
            if (seconds > 0) {

                seconds--;
            }
            
            else {

                toolkit.beep();
                
                changeScreen.fire();
                
                DrawingScreen.clearScreen();
                DrawingScreen.pen = true;
                DrawingScreen.rectangle = false;
                DrawingScreen.oval = false;
                DrawingScreen.eraser = false;
                DrawingScreen.fill.setSelected(false);
                DrawingScreen.cp.setValue(Color.BLACK);
                DrawingScreen.slider.setValue(1);
                DrawingScreen.gc.setStroke(DrawingScreen.cp.getValue());
                DrawingScreen.gc.setLineWidth(DrawingScreen.slider.getValue());

                timer.cancel(); //Terminate the timer thread

            }
        }
    }
}


