import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class drawing extends Application {
    
    Boolean pen = false;
    Boolean rectangle = false;
    Boolean eraser = false;

    @Override
    public void start(Stage primaryStage){

        StackPane pane = new StackPane();
        GridPane grid = new GridPane();
        pane.setStyle(" -fx-background-color: #FFFFFF");

        GraphicsContext gc;
        ColorPicker cp = new ColorPicker();
        Slider slider = new Slider();
        Label label = new Label("1.0");

        Scene scene = new Scene(pane, 800, 500);
        Canvas canvas = new Canvas();
        canvas.widthProperty().bind(scene.widthProperty());
        canvas.heightProperty().bind(scene.heightProperty());


        try {
            gc = canvas.getGraphicsContext2D();
            gc.setStroke(Color.BLACK);
            gc.setLineWidth(1);
                 
            cp.setValue(Color.BLACK);
            cp.setOnAction(e -> {
                gc.setStroke(cp.getValue());
            });

            scene.setOnMousePressed(e -> {
                if (pen || eraser){
                    gc.beginPath();
                    gc.lineTo(e.getX(), e.getY());
                    gc.stroke();
                }
            });

            scene.setOnMouseDragged(e1 -> {
                    if (pen || eraser){
                        gc.lineTo(e1.getSceneX(), e1.getSceneY());
                        gc.stroke();
                    }
                
            });

            slider.setMin(1);
            slider.setMax(5);
            slider.setShowTickLabels(true);
            slider.setShowTickMarks(true);

            slider.valueProperty().addListener(e -> {
                double value = slider.getValue();
                String str = String.format("%.1f", value);
                label.setText(str);
                gc.setLineWidth(value);
            });


            pane.getChildren().addAll(canvas, grid);

            Button penBT = new Button("Pen");
            penBT.setOnAction( e -> {
                pen = true;
                    rectangle = false;
                    eraser = false;

                if (pen){    
                    gc.beginPath();
                    gc.setStroke(cp.getValue());
                    gc.setLineWidth(slider.getValue());
                    
                    gc.closePath();
                }
                
            });

            Button drawRectangleBT = new Button("Rectangle");

            drawRectangleBT.setOnAction ( e0 -> {
                gc.setLineWidth(slider.getValue());

                rectangle = true;
                pen = false;
                eraser = false;

                scene.setOnMousePressed(e -> {
                    if (rectangle){
                        double x = e.getX();
                        double y = e.getY();
    
                        gc.setFill(Color.WHITE);
    
                        scene.setOnMouseReleased( e2 -> {
                            if (rectangle){
                                gc.setStroke(cp.getValue());
                                if (e2.getX() > x && e2.getY() > y)
                                    gc.strokeRect(x, y, e2.getX() - x, e2.getY() - y);
                                if (e2.getX() > x && e2.getY() < y) 
                                    gc.strokeRect(x, e2.getY(), e2.getX() - x, y - e2.getY());
                                if (e2.getX() < x && e2.getY() > y)
                                    gc.strokeRect(e2.getX(), y, x - e2.getX(), e2.getY() - y);
                                if (e2.getX() < x && e2.getY() < y)
                                    gc.strokeRect(e2.getX(), e2.getY(), x - e2.getX(), y - e2.getY());   
                            }
                                   
                                         
                        });
                        
                    }
                    
                });

            });
            


            // ObservableList<String> erasers = FXCollections.observableArrayList ("Eraser", "Select Erase");
            

            Button eraseBT = new Button("Eraser");
            eraseBT.setOnAction(e -> {
                eraser = true;
                rectangle = false;
                pen = false;

                if (eraser){
                    gc.setStroke(Color.WHITE);
                    gc.setLineWidth(10);
                }

            });

            Button clearBT = new Button("Clear");
            clearBT.setOnAction(e -> {
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            });


            // Button selectEraseBT = new Button("Select Erase");
            // selectEraseBT.setOnAction ( e0 -> {
            //     gc.setLineWidth(slider.getValue());
            //     selectErase = true;
            //     pen = false;
            //     eraser = false;
            //     rectangle = false;

            //     scene.setOnMousePressed(e -> {
            //         if (selectErase){
            //             double x = e.getX();
            //             double y = e.getY();
    
            //             gc.setStroke(Color.WHITE);
            //             gc.setFill(Color.WHITE);
                    

            //         scene.setOnMouseReleased( e2 -> {
            //             gc.setStroke(cp.getValue());
            //             if (e2.getX() > x && e2.getY() > y)
            //                 gc.strokeRect(x, y, e2.getX() - x, e2.getY() - y);
            //             if (e2.getX() > x && e2.getY() < y) 
            //                 gc.strokeRect(x, e2.getY(), e2.getX() - x, y - e2.getY());
            //             if (e2.getX() < x && e2.getY() > y)
            //                 gc.strokeRect(e2.getX(), y, x - e2.getX(), e2.getY() - y);
            //             if (e2.getX() < x && e2.getY() < y)
            //                 gc.strokeRect(e2.getX(), e2.getY(), x - e2.getX(), y - e2.getY());      
                                    
            //         });
            //     }
            //     });
            // });

            grid.addRow(0, cp, slider, label, penBT, drawRectangleBT, eraseBT, clearBT);
            grid.setHgap(20);
            grid.setAlignment(Pos.TOP_CENTER);
            grid.setPadding(new Insets(20, 0, 0, 0));

            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }

        primaryStage.setTitle("Pictionary");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

// https://examples.javacodegeeks.com/desktop-java/javafx/javafx-canvas-example/
// Great examples