import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class drawing extends Application {
    @Override
    public void start(Stage primaryStage){

        StackPane pane = new StackPane();
        GridPane grid = new GridPane();

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
                gc.beginPath();
                gc.lineTo(e.getX(), e.getY());
                gc.stroke();
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

            scene.setOnMouseDragged(e -> {
                gc.lineTo(e.getSceneX(), e.getSceneY());
                gc.stroke();
            });

            pane.getChildren().addAll(canvas, grid);

            grid.addRow(0, cp, slider, label);
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