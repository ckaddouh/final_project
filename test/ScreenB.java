import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

/**
 * ScreenA is a subclass of FlowPane.
 * Since FlowPane is a subclass of Pane, it can be saved in a Pane variable too.
 */
public class ScreenB extends FlowPane {
    private MainApp mainApp;

    public ScreenB(MainApp app){
        super();
        //the super() calls the constructor of GridPane. 
        //It's not necessary because it's automatically called,
        //but if we wanted certain parameters, we can add them.

        //Save the  parameter app  so we can access 
        //methods from the mainApp for changing the screen. 
        this.mainApp = app;

        Label hello = new Label("Hola! This is Screen B");
        //ScreenB is a FlowPane, so it has the FlowPane methods like getChildren() ..
        getChildren().add(hello);

        Button changeScreenButton = new Button("Change to Screen A");
        changeScreenButton.setOnAction(e -> handleButton());
        getChildren().add(changeScreenButton);

        //These don't do anything, but show that the state of this 
        //screen is NOT preserved because in the MainApp, we recreate ScreenB
        //every time we show it.
        getChildren().add(new CheckBox("We"));
        getChildren().add(new CheckBox("Are"));
        getChildren().add(new CheckBox("Forgotten"));

        //You would probably add more code to format this FlowPane the way you'd like
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(10));
    }

    private void handleButton(){
        //Call the appropriate method from the MainApp
        mainApp.showScreenA();
    }
}