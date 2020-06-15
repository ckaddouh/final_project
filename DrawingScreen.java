import java.beans.EventHandler;
import java.io.FileNotFoundException;
import java.time.Duration;

import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
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
import java.util.TimerTask;

public class DrawingScreen extends StackPane {

    private MainApp mainApp;
    public static String file_name;
    public static Label lbl;
    public static Label lbl2;

    Boolean pen = true;
    Boolean rectangle = false;
    Boolean oval = false;
    Boolean eraser = false;
    double x;
    double y;

    Canvas canvas;
    GraphicsContext gc;

    public static int sec;
    public static int rounds;

    public static Label info2;

    public static String word;

    public static boolean isCorrect = false;

    public static Timer timer;
    public static Label timerLbl = new Label();

    private static final Integer STARTTIME = WordScreen.sec;
    protected static final Object timerSeconds = null;
    private Timeline timeline;
    private Integer timeSeconds = STARTTIME;

    public DrawingScreen(MainApp app) {
        super();
        this.mainApp = app;

        setStyle(" -fx-background-color: #FFFFFF");

        // Create a GridPane for the words and buttons
        GridPane grid = new GridPane();

        // Create GraphicsContext for the user to draw with

        // Implement a color picker and slider for pen color and width
        ColorPicker cp = new ColorPicker();
        Slider slider = new Slider();
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

            getChildren().addAll(canvas, grid);

            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

            // Set the starting color picker value
            cp.setValue(Color.BLACK);
            // If the user selects another color, set that color for the pen
            cp.setOnAction(e -> {
                if (!eraser)
                    gc.setStroke(cp.getValue());
                gc.setFill(cp.getValue());
            });

            // Define the properties of the slider for the width of the pen
            slider.setMin(1);
            slider.setMax(5);
            slider.setShowTickLabels(true);
            slider.setShowTickMarks(true);

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
            CheckBox fill = new CheckBox("Fill");

            // Define a set of events for when the mouse is pressed
            setOnMousePressed(e -> {
                // If either the pen or eraser is selected, being a new path where the mouse is
                // located
                if (pen || eraser) {
                    gc.beginPath();
                    gc.moveTo(e.getX(), e.getY());
                    gc.stroke();
                }

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
                // If the pen or eraser is selected, draw a line to the new position of the
                // mouse
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

                if (oval) {
                    if (fill.isSelected()) {
                        if (e.getX() > x && e.getY() > y)
                            gc.fillOval(x, y, e.getX() - x, e.getY() - y);
                        if (e.getX() > x && e.getY() < y)
                            gc.fillOval(x, e.getY(), e.getX() - x, y - e.getY());
                        if (e.getX() < x && e.getY() > y)
                            gc.fillOval(e.getX(), y, x - e.getX(), e.getY() - y);
                        if (e.getX() < x && e.getY() < y)
                            gc.fillOval(e.getX(), e.getY(), x - e.getX(), y - e.getY());
                    } else {
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

            // Create a rectangle button that adjusts the boolean variables and sets the
            // stroke and line width
            Button rectangleBT = new Button("Rectangle");
            rectangleBT.setOnAction(e -> {
                rectangle = true;
                pen = false;
                oval = false;
                eraser = false;

                gc.setStroke(cp.getValue());
                gc.setLineWidth(slider.getValue());
            });

            // Create an oval button that adjusts the boolean variables and sets the stroke
            // and line width
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

            // Create a clear button that places a white rectangle over the canvas
            Button clearBT = new Button("Clear");
            clearBT.setOnAction(e -> {
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            });

            // Label wordlbl = new Label(list.getRandomWord());
            // grid.addRow(0, wordlbl);

            Button yesBT = new Button("GOT IT");
            yesBT.setOnAction(e -> {
                if (Reminder.seconds > 0) {
                    isCorrect = true;
                    Reminder.timer.cancel();
                    MainApp.stage2.close();
                    
                } else {
                    isCorrect = false;
                }
                handleButtonCorrect();
            });

            lbl = new Label();
            lbl.setText(file_name);
            lbl2 = new Label();
            grid.addRow(0, lbl, lbl2);
            // Add the buttons, color picker, slider, and label to the grid
            grid.addRow(1, cp, slider, sliderLbl, penBT, fill, rectangleBT, ovalBT, eraseBT, clearBT, yesBT);
            // Set the grid's alignment
            grid.setHgap(20);
            grid.setAlignment(Pos.TOP_CENTER);
            grid.setPadding(new Insets(20, 0, 0, 0));

            // info = new Label("Nothing");
            info2 = new Label("Info 2");

            Button seeWord = new Button("See Word");
            seeWord.setOnAction(e -> handleSeeWord());

            timerLbl = new Label("Showing");
            Button changeScreenButton = new Button("See Results");
            changeScreenButton.setOnAction(e -> handleButton());
            grid.addRow(2, timerLbl);
            grid.addRow(3, info2);
            grid.addRow(4);
            grid.addRow(5, changeScreenButton);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Button button = new Button();
        button.fire();

        // button.setOnAction(e -> {
        // if (timeline != null) {
        // timeline.stop();
        // }
        // timeSeconds = STARTTIME;

        // timerLbl.setText(timeSeconds.toString());
        // timeline = new Timeline();
        // timeline.setCycleCount(Timeline.INDEFINITE);
        // timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new
        // EventHandler(){
        // public void handle(ActionEvent event){
        // timeSeconds--;
        // timerLbl.setText(timerSeconds.toString());
        // if(timeSeconds <= 0){
        // timeline.stop();
        // }
        // }
        // }));
        // timeline.playFromStart();

        // });
        // }

    //     int i = 0;
    //     Timer timer2 = new Timer();

    //     timer.setDelay(1000);

    //     for (int i = WordScreen.sec; i >= 0; i--) {
    //         timerLbl.setText(i + "");
    //         try {
    //             Thread.sleep(1000);
    //         } catch (InterruptedException e) {
    //             // TODO Auto-generated catch block
    //             e.printStackTrace();
    //         }
    // }






    }

    // public static void Remainder(int seconds){
    //     timer = new Timer();
    //     timer.schedule(new RemindTask(), seconds*1000);
    // }

    // class RemindTask extends TimerTask {
    //     public void run() {
    //         timerLbl.setText("Time is up!");
    //         mainApp.showResults();
    //     }
    // }

    private void handleButton() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        mainApp.showResultsScreen();
    }

    public void handleSeeWord() {
        mainApp.showWordScreen();
    }

    public void handleButtonCorrect() {
        mainApp.showResultsScreen();
    }

    // public static void setFileName(String fileName) throws FileNotFoundException {
    //     file_name = fileName;
    //     lbl.setText(file_name);
    //     list = new Words("words/" + file_name + ".txt");
    //     useWords();
    // }
    
    public static void setTimerLength(Integer timerLength) {
        timerLbl.setText(Integer.toString(timerLength) + " seconds each");
    }

    public static void setNumOfRounds(int numOfRounds) {
        rounds = numOfRounds;
        info2.setText(String.format("There are %d rounds", rounds));
    }

    
    // public static void useWords(){
    //     word = list.getRandomWord();
    //     lbl2.setText(word);
    //     list.remove(word);
    // }


}