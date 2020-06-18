// A timer that controls program flow

import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.awt.Toolkit;

// Create a class that extends BorderPane
public class Reminder extends BorderPane {

    private MainApp mainApp;

    Toolkit toolkit;    
    public static Timer timer;

    static int seconds;
    public static Button changeScreen;

    public Reminder(MainApp app) {
        super();
        this.mainApp = app;

        // Set the toolkit and timer
        toolkit = Toolkit.getDefaultToolkit();

        timer = new Timer();
        timer.schedule(new RemindTask(), 0, 1*1000);
        
        // Get the starting number of seconds from the wordScreen (really settingsScreen)
        seconds = WordScreen.sec;

        // Create a button that is not displayed to handle the timer running out
        changeScreen = new Button();
        changeScreen.setOnAction(e -> {
            DrawingScreen.isCorrect = false;
            mainApp.showResultsScreen();
        });

	}

    // Create a class that extends TimerTask
    class RemindTask extends TimerTask {
        public void run() {
            // While the timer has not run out, subtract 1 from it every second
            if (seconds > 0) {
                seconds--;
            }
            
            // If the timer has run out, notify the user and fire the button which will change the screen
            else {
                toolkit.beep();
                
                changeScreen.fire();
                
                // Reset the settings of the drawing screen
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

                //Terminate the timer thread
                timer.cancel(); 
            }
        }
    }
}


