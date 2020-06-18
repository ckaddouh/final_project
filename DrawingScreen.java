// The main drawing screen where users draw and can press a button to see the results screen

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import java.util.Timer;

// Create a class that extends StackPane
public class DrawingScreen extends StackPane {

    // Define variables
    private MainApp mainApp;
    public static String file_name;
    public static Label lbl;
    public static Label lbl2;

    public static Boolean pen = true;
    public static Boolean rectangle = false;
    public static Boolean oval = false;
    public static Boolean eraser = false;

    public static CheckBox fill;

    double x;
    double y;

    public static Canvas canvas;
    public static GraphicsContext gc;

    public static int sec;
    public static int rounds;

    public static ColorPicker cp;
    public static Slider slider;

    public static String word;

    public static boolean isCorrect = false;

    public static Timer timer;
    public static Label timerLbl = new Label();

    private static final Integer STARTTIME = WordScreen.sec;
    protected static final Object timerSeconds = null;


    public DrawingScreen(MainApp app) {
        super();
        this.mainApp = app;


        // Create a GridPane for the words and buttons
        GridPane grid = new GridPane();
        setStyle(" -fx-background-color: #FFFFFF");

        // Implement a color picker and slider for pen color and width
        cp = new ColorPicker();
        slider = new Slider();
        Label sliderLbl = new Label("1.0");

        // Create a canvas and bind its properties to the scene's properties
        canvas = new Canvas();
        canvas.widthProperty().bind(this.widthProperty());
        canvas.heightProperty().bind(this.heightProperty());

        // Create a try-catch to carry out specific actions if an error occurs
        try {
            // Define the graphics context to that of the pane and set the pen's properties
            gc = canvas.getGraphicsContext2D();
            gc.setStroke(Color.BLACK);
            gc.setLineWidth(1);

            // Define the properties of the slider for the width of the pen
            slider.setMin(1);
            slider.setMax(5);
            slider.setShowTickLabels(true);
            slider.setShowTickMarks(true);
            slider.setValue(1);

            getChildren().addAll(canvas, grid);

            // Set the starting color picker value
            cp.setValue(Color.BLACK);
            // If the user selects another color, set that color for the pen
            cp.setOnAction(e -> {
                if (!eraser)
                    gc.setStroke(cp.getValue());
                gc.setFill(cp.getValue());
            });

            // Create a clear button that places a white rectangle over the canvas
            Button clearBT = new Button("Clear");
            clearBT.setOnAction(e -> {
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            });

            // Create a listener for when the slider is moved to update the width of the pen
            slider.valueProperty().addListener(e -> {
                double value = slider.getValue();
                String str = String.format("%.1f", value);
                sliderLbl.setText(str);

                if (eraser)
                    gc.setLineWidth(value + 5);
                else
                    gc.setLineWidth(value);

            });

            // Create a CheckBox to determine if shapes should be filled
            fill = new CheckBox("Fill");

            // Define a set of events for when the mouse is pressed
            setOnMousePressed(e -> {
                // If either the pen or eraser is selected, being a new path where the mouse is located
                if (pen || eraser) {
                    gc.beginPath();
                    gc.moveTo(e.getX(), e.getY());
                    gc.stroke();
                }
                
                // If rectangle or oval is selected, get the initial x and y coordinates of the mouse
                if (rectangle) {
                    x = e.getX();
                    y = e.getY();
                }

                if (oval) {
                    x = e.getX();
                    y = e.getY();
                }
            });

            // Define a set of actions to carry out when the mouse is dragged
            setOnMouseDragged(e -> {
                // If the pen or eraser is selected, draw a line to the new position of the mouse
                if (pen || eraser) {
                    gc.lineTo(e.getX(), e.getY());
                    gc.stroke();
                }
            });

            // Define a set of actions for rectangle and oval when mouse is released
            setOnMouseReleased(e -> {
                // If the rectangle button is selected
                if (rectangle) {
                    // If fill is selected, fill the rectangle with the value of the color picker
                    if (fill.isSelected()) {
                        if (e.getX() > x && e.getY() > y)
                            gc.fillRect(x, y, e.getX() - x, e.getY() - y);
                        if (e.getX() > x && e.getY() < y)
                            gc.fillRect(x, e.getY(), e.getX() - x, y - e.getY());
                        if (e.getX() < x && e.getY() > y)
                            gc.fillRect(e.getX(), y, x - e.getX(), e.getY() - y);
                        if (e.getX() < x && e.getY() < y)
                            gc.fillRect(e.getX(), e.getY(), x - e.getX(), y - e.getY());
                    }
                    // If fill is not selected, outline the rectangle
                    else {
                        if (e.getX() > x && e.getY() > y)
                            gc.strokeRect(x, y, e.getX() - x, e.getY() - y);
                        if (e.getX() > x && e.getY() < y)
                            gc.strokeRect(x, e.getY(), e.getX() - x, y - e.getY());
                        if (e.getX() < x && e.getY() > y)
                            gc.strokeRect(e.getX(), y, x - e.getX(), e.getY() - y);
                        if (e.getX() < x && e.getY() < y)
                            gc.strokeRect(e.getX(), e.getY(), x - e.getX(), y - e.getY());
                    }
                    gc.closePath();
                }
                // If the oval button is selected
                if (oval) {
                    // If fill is selected, create a filled in oval
                    if (fill.isSelected()) {
                        if (e.getX() > x && e.getY() > y)
                            gc.fillOval(x, y, e.getX() - x, e.getY() - y);
                        if (e.getX() > x && e.getY() < y)
                            gc.fillOval(x, e.getY(), e.getX() - x, y - e.getY());
                        if (e.getX() < x && e.getY() > y)
                            gc.fillOval(e.getX(), y, x - e.getX(), e.getY() - y);
                        if (e.getX() < x && e.getY() < y)
                            gc.fillOval(e.getX(), e.getY(), x - e.getX(), y - e.getY());
                    } 
                    // If fill is not selected, outline the oval
                    else {
                        if (e.getX() > x && e.getY() > y)
                            gc.strokeOval(x, y, e.getX() - x, e.getY() - y);
                        if (e.getX() > x && e.getY() < y)
                            gc.strokeOval(x, e.getY(), e.getX() - x, y - e.getY());
                        if (e.getX() < x && e.getY() > y)
                            gc.strokeOval(e.getX(), y, x - e.getX(), e.getY() - y);
                        if (e.getX() < x && e.getY() < y)
                            gc.strokeOval(e.getX(), e.getY(), x - e.getX(), y - e.getY());
                    }
                    gc.closePath();
                }
            });

            // Create a pen button which adjusts the boolean variables
            Button penBT = new Button("Pen");
            penBT.setOnAction(e -> {
                pen = true;
                rectangle = false;
                oval = false;
                eraser = false;

                gc.setStroke(cp.getValue());
                gc.setLineWidth(slider.getValue());
            });

            // Create a rectangle button that adjusts the boolean variables and sets the stroke and line width
            Button rectangleBT = new Button("Rectangle");
            rectangleBT.setOnAction(e -> {
                rectangle = true;
                pen = false;
                oval = false;
                eraser = false;

                gc.setStroke(cp.getValue());
                gc.setLineWidth(slider.getValue());
            });

            // Create an oval button that adjusts the boolean variables and sets the stroke and line width
            Button ovalBT = new Button("Oval");
            ovalBT.setOnAction(e -> {
                oval = true;
                pen = false;
                rectangle = false;
                eraser = false;

                gc.setStroke(cp.getValue());
                gc.setLineWidth(slider.getValue());
            });

            // Create an eraser button that sets the pen stroke to white
            Button eraseBT = new Button("Eraser");
            eraseBT.setOnAction(e -> {
                eraser = true;
                pen = false;
                rectangle = false;
                oval = false;

                gc.setStroke(Color.WHITE);
                gc.setLineWidth(10);
            });

            // Create a checkbutton for the user to press when the other players guesses correctly
            Button yesBT = new Button("GOT IT");
            yesBT.setOnAction(e -> {
                // If the button is pressed before the timer is up, change the isCorrect boolean to true and reset the drawing settings
                if (Reminder.seconds >= 0) {
                    isCorrect = true;
                    pen = true;
                    rectangle = false;
                    oval = false;
                    eraser = false;
                    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    fill.setSelected(false);
                    cp.setValue(Color.BLACK);
                    slider.setValue(1);
                    gc.setStroke(cp.getValue());
                    gc.setLineWidth(slider.getValue());

                    // Cancel the timer and close its screen
                    Reminder.timer.cancel();
                    MainApp.stage2.close();

                    
                } 
                // Otherwise, set the boolean to false (other files will handle this case)
                else {
                    isCorrect = false;
                }

                // Use a button to control the screen change
                handleButtonCorrect();
            });
            
            // Add the buttons, color picker, slider, and label to the grid
            grid.addRow(1, cp, slider, sliderLbl, penBT, fill, rectangleBT, ovalBT, eraseBT, clearBT, yesBT);
            // Set the grid's alignment
            grid.setHgap(20);
            grid.setAlignment(Pos.TOP_CENTER);
            grid.setPadding(new Insets(20, 0, 0, 0));

            // Clear the screen
            clearBT.fire();  
          
        // Catch statement
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Define methods for changing screens and clearing the canvas
    private void handleButton() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        mainApp.showResultsScreen();
    }

    public void handleButtonCorrect() {
        mainApp.showResultsScreen();
    }

    public static void clearScreen() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

}