import java.io.FileNotFoundException;
import java.util.Optional;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class SettingsScreen extends GridPane {

    private MainApp mainApp;
    
    public SettingsScreen(MainApp app) throws FileNotFoundException {
        super();
        this.mainApp = app;

        Text title = new Text("Settings");
        title.setFill(Color.DARKTURQUOISE);
        title.setFont(Font.font("AvantGarde", FontWeight.BOLD, FontPosture.REGULAR, 20));
        add(title, 1, 1, 2, 2);
        GridPane.setHalignment(title, HPos.CENTER);

        

        Button changeScreenButton = new Button("Start");
        changeScreenButton.setOnAction(e -> handleButton());
        add(changeScreenButton, 3, 3, 1, 1);

        setHgap(10);
        setVgap(10);
        setPadding(new Insets(10));
    }

        private void handleButton(){
            //Call the appropriate method from the MainApp
            mainApp.showDrawingScreen();
        }
            
}