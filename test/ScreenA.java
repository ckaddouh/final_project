import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * ScreenA is a subclass of GridPane.
 * Since GridPane is a subclass of Pane, it can be saved in a Pane variable too.
 */
public class ScreenA extends GridPane {
    
    private ScreenManager mainApp;

    public ScreenA(ScreenManager app){
        super();
        //the super() calls the constructor of GridPane. 
        //It's not necessary because it's automatically called,
        //but if we wanted certain parameters, we can add them.

        //Save the  parameter app  so we can access 
        //methods from the mainApp for changing the screen. 
        this.mainApp = app;

        Label hello = new Label("Hi! This is Screen A");
        //ScreenA is a GridPane, so it has the GridPane methods like add(...)
        add(hello, 0,0);

        Button changeScreenButton = new Button("Change to Screen B");
        changeScreenButton.setOnAction(e -> handleButton());
        add(changeScreenButton, 0,1);

        //These don't do anything, but show that the state of this 
        //screen is preserved because in the MainApp, we only create ScreenA
        //once, and show the same one every time.
        add(new CheckBox("We"), 1, 0);
        add(new CheckBox("Are"), 1, 1);
        add(new CheckBox("Remembered"), 1, 2);
        
        //You would probably add more code to format this GridPane the way you'd like
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(10));
    }

    private void handleButton(){
        //Call the appropriate method from the MainApp
        mainApp.showScreenB();
    }
    
}