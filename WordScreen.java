import java.io.FileNotFoundException;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class WordScreen extends BorderPane {

    private MainApp mainApp;
    public static String file_name;
    public static Label label;
    public static words list;


    public WordScreen(MainApp app) throws FileNotFoundException {
        super();

        this.mainApp = app;

        label.setTextFill(Color.DODGERBLUE);
        label.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 48));
        // ScreenA is a GridPane, so it has the GridPane methods like add(...)
        setCenter(label);
        setAlignment(label, Pos.CENTER);

        label.setAlignment(Pos.CENTER);
        GridPane.setValignment(label, VPos.CENTER);

        
        
        setPadding(new Insets(10));

    }
    public static void setFileName(String fileName) throws FileNotFoundException {
        file_name = fileName;
        list = new words("words/" + file_name + ".txt");
        useWords();
    }

    public static void useWords(){
        String word = list.getRandomWord();
        label.setText(word);
        list.remove(word);
    }

}