
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.paint.Color;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

/**
 * ScreenA is a subclass of GridPane.
 * Since GridPane is a subclass of Pane, it can be saved in a Pane variable too.
 */
public class instructionScreen extends GridPane {
    
    private screenManager mainApp;

    public instructionScreen(screenManager app){
        super();
        //the super() calls the constructor of GridPane. 
        //It's not necessary because it's automatically called,
        //but if we wanted certain parameters, we can add them.

        //Save the  parameter app  so we can access 
        //methods from the mainApp for changing the screen. 
        this.mainApp = app;

        Text text = new Text();
        text.setText("Instructions"); 
        text.setFill(Color.DARKTURQUOISE);
        text.setFont(Font.font("AvantGarde", FontWeight.BOLD, FontPosture.REGULAR, 20));
        //ScreenA is a GridPane, so it has the GridPane methods like add(...)
        //ScreenA is a GridPane, so it has the GridPane methods like add(...)
        add(text, 1, 1, 2, 2);
        GridPane.setHalignment(text, HPos.CENTER);

        Button changeScreenButton = new Button("Instructions");
        changeScreenButton.setOnAction(e -> handleButton());
        add(changeScreenButton, 3 ,3, 1, 1);

        ChoiceDialog<String> text_files = new ChoiceDialog<>("easy.txt", "medium.txt", "hard.txt");
        text_files.setTitle("Level Choices");
        text_files.setHeaderText("Choose Your Level");
        text_files.setContentText("Pick a Level: ");

        
        //You would probably add more code to format this GridPane the way you'd like
        //Since screenmanager isn't finished i can't run so idk how it looks but idk 
        //if we'd need any more formatting?
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(10));
    }

    private void handleButton(){
        //Call the appropriate method from the MainApp
        mainApp.showScreenA();
    }
    
}
//I didn't think there was much to do so enjoy the new fonts and colors <3