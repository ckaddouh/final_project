import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class drawing2 extends Application {

    Boolean pen = false;
    Boolean rectangle = false;
    Boolean oval = false;
    Boolean eraser = false;

    double x;
    double y;

    @Override
    public void start(Stage primaryStage){
        
        // Create a StackPane to hold the canvas and set its background to white
        StackPane pane = new StackPane();
        pane.setStyle(" -fx-background-color: #FFFFFF");

        // Create a GridPane for the words and buttons
        GridPane grid = new GridPane();

        // Create GraphicsContext for the user to draw with
        GraphicsContext gc;

        // Implement a color picker and slider for pen color and width
        ColorPicker cp = new ColorPicker();
        Slider slider = new Slider();
        Label sliderLbl = new Label("1.0");
        
        // Create a new scene
        Scene scene = new Scene(pane, 800, 500);

        // Create a canvas and bind its properties to the scene's properties
        Canvas canvas = new Canvas();
        canvas.widthProperty().bind(scene.widthProperty());
        canvas.heightProperty().bind(scene.heightProperty());

        // Create a try-catch to carry out specific actions if an error occurs
        try {
            // Define the graphics context to that of the pane and set the pen's properties
            gc = canvas.getGraphicsContext2D();
            gc.setStroke(Color.BLACK);
            gc.setLineWidth(1);

            pane.getChildren().addAll(canvas, grid);

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
            scene.setOnMousePressed(e -> {
                // If either the pen or eraser is selected, being a new path where the mouse is located
                if (pen || eraser){
                    gc.beginPath();
                    gc.moveTo(e.getX(), e.getY());
                    gc.stroke();
                }

                if (rectangle){
                    x = e.getX();
                    y = e.getY();
                }

                if (oval){
                    x = e.getX();
                    y = e.getY();
                }
            });

            // Define a set of actions to carry out when the mouse is dragged
            scene.setOnMouseDragged(e -> {
                // If the pen or eraser is selected, draw a line to the new position of the mouse
                if (pen || eraser){
                    gc.lineTo(e.getX(), e.getY());
                    gc.stroke();
                }
            });

            scene.setOnMouseReleased(e -> {
                if (rectangle){    
                    if (fill.isSelected()){
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
                   gc.beginPath();
                }

                if (oval) {
                    if (fill.isSelected()){
                        if (e.getX() > x && e.getY() > y)
                            gc.fillOval(x, y, e.getX() - x, e.getY() - y);
                        if (e.getX() > x && e.getY() < y)
                            gc.fillOval(x, e.getY(), e.getX() - x, y - e.getY());
                        if (e.getX() < x && e.getY() > y)
                            gc.fillOval(e.getX(), y, x - e.getX(), e.getY() - y);
                        if (e.getX() < x && e.getY() < y)
                            gc.fillOval(e.getX(), e.getY(), x - e.getX(), y - e.getY());
                    }
                    else{
                        if (e.getX() > x && e.getY() > y)
                            gc.strokeOval(x, y, e.getX() - x, e.getY() - y);
                        if (e.getX() > x && e.getY() < y)
                            gc.strokeOval(x, e.getY(), e.getX() - x, y - e.getY());
                        if (e.getX() < x && e.getY() > y)
                            gc.strokeOval(e.getX(), y, x - e.getX(), e.getY() - y);
                        if (e.getX() < x && e.getY() < y)
                            gc.strokeOval(e.getX(), e.getY(), x - e.getX(), y - e.getY());
                    }
                    gc.beginPath();
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

            Button rectangleBT = new Button("Rectangle");
            rectangleBT.setOnAction(e -> {
                rectangle = true;
                pen = false;
                oval = false;
                eraser = false;

                gc.setStroke(cp.getValue());
                gc.setLineWidth(slider.getValue());
            });

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

            grid.addRow(1, cp, slider, sliderLbl, penBT, fill, rectangleBT, ovalBT, eraseBT, clearBT);
            grid.setHgap(20);
            grid.setAlignment(Pos.TOP_CENTER);
            grid.setPadding(new Insets(20, 0, 0, 0));

        } catch(Exception e) {
            e.printStackTrace();
        }

        primaryStage.setTitle("Pictionary");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}