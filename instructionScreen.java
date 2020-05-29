
import javafx.scene.control.Button;

import javafx.scene.paint.Color;

import javafx.scene.text.Font; 
import javafx.scene.text.FontPosture; 
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Text;

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
        text.setFill(Color.DODGERBLUE);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        //ScreenA is a GridPane, so it has the GridPane methods like add(...)
        //ScreenA is a GridPane, so it has the GridPane methods like add(...)
        add(text, 0, 0);

        Button changeScreenButton = new Button("Instructions");
        changeScreenButton.setOnAction(e -> handleButton());
        add(changeScreenButton, 0,1);

        
        //You would probably add more code to format this GridPane the way you'd like
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(10));
    }

    private void handleButton(){
        //Call the appropriate method from the MainApp
        mainApp.showScreenA();
    }
    
}