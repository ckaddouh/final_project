import java.io.FileNotFoundException;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ResultsScreen extends BorderPane {

    private MainApp mainApp;

    public ResultsScreen(MainApp app) throws FileNotFoundException {
        super();

        this.mainApp = app;

        Text text = new Text("Results!");
        text.setFill(Color.DARKTURQUOISE);
        text.setFont(Font.font("AvantGarde", FontWeight.BOLD, FontPosture.REGULAR, 20));
        setTop(text);
        setAlignment(text, Pos.CENTER);
        
        Button changeScreenButton = new Button("Back");
        changeScreenButton.setOnAction(e -> {
            DrawingScreen.useWords();
            handleButton();
        });
        
        setBottom(changeScreenButton);
        
        // setHgap(10);
        // setVgap(10);
        // setPadding(new Insets(10));

        
    }
    private void handleButton(){
        mainApp.showDrawingScreen();
    }
}