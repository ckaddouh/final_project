
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.paint.Color;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;



/**
 * ScreenA is a subclass of GridPane. Since GridPane is a subclass of Pane, it
 * can be saved in a Pane variable too.
 */
public class testing extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        GridPane grid = new GridPane();

        Text text = new Text();
        text.setText("Instructions"); 
        text.setFill(Color.DARKTURQUOISE);
        text.setFont(Font.font("AvantGarde", FontWeight.BOLD, FontPosture.REGULAR, 20));
        //ScreenA is a GridPane, so it has the GridPane methods like add(...)
        //ScreenA is a GridPane, so it has the GridPane methods like add(...)
        grid.add(text, 1, 1, 2, 2);
        GridPane.setHalignment(text, HPos.CENTER);

        Button changeScreenBack = new Button("Back");
        // changeScreenBack.setOnAction(e -> handleButtonBack());
        grid.add(changeScreenBack, 2, 1);
        Button changeScreenSettings= new Button("Settings");
        // changeScreenSettings.setOnAction(e -> handleButtonSettings());
        grid.add(changeScreenSettings, 3, 3, 1, 1);


        //You would probably add more code to format this GridPane the way you'd like
        //Since screenmanager isn't finished i can't run so idk how it looks but idk 
        //if we'd need any more formatting?
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        Scene scene = new Scene(grid, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // private void handleButtonSettings(){
    //     //Call the appropriate method from the MainApp
    //     mainApp.showSettingsScreen();
    // }
    // private void handleButtonBack(){
    //     mainApp.showWelcomeScreen();
    // }
    
}
//I didn't think there was much to do so enjoy the new fonts and colors <3