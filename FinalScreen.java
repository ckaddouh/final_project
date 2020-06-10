import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class FinalScreen extends BorderPane {

    private MainApp mainApp;

    public FinalScreen(MainApp app) {
        super(); 
        this.mainApp = app;
        
        Label complete = new Label("Great job!");
        setTop(complete);
        setAlignment(complete, Pos.CENTER);
    }
}