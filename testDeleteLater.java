import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class testDeleteLater extends Application {
 
    @Override
    public void start(final Stage primaryStage) {
 
        Button button = new Button();
        button.setText("Open a New Window");
 
        button.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
 
                Label secondLabel = new Label("I'm a Label on new Window");
 
                StackPane secondaryLayout = new StackPane();
                secondaryLayout.getChildren().add(secondLabel);
 
                Scene secondScene = new Scene(secondaryLayout, 230, 100);
 
                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Second Stage");
                newWindow.setScene(secondScene);
 
                // Set position of second window, related to primary window.
                newWindow.setX(primaryStage.getX() + 200);
                newWindow.setY(primaryStage.getY() + 100);
 
                newWindow.show();
            }
        });
 
        StackPane root = new StackPane();
        root.getChildren().add(button);
 
        Scene scene = new Scene(root, 450, 250);
 
        primaryStage.setTitle("JavaFX Open a new Window (o7planning.org)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
 
}