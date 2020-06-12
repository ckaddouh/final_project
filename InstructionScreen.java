import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;



/**
 * ScreenA is a subclass of GridPane. Since GridPane is a subclass of Pane, it
 * can be saved in a Pane variable too.
 */
public class InstructionScreen extends BorderPane {

    private MainApp mainApp;

    public InstructionScreen(MainApp app) {
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

        setTop(text);
        setAlignment(text, Pos.CENTER);

        Button changeScreenBack = new Button("Back");
        changeScreenBack.setOnAction(e -> handleButtonBack());
        
        // Button changeScreenSettings= new Button("Settings");
        // changeScreenSettings.setOnAction(e -> handleButtonSettings());

        Button changeScreenPlay = new Button("Play");
        changeScreenPlay.setOnAction(e -> handleButtonPlay());

        changeScreenBack.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.7), 5, 0.0, 0, 1)");
        changeScreenBack.setStyle("-fx-font: 22 fantasy; -fx-background-color: #0072ab, linear-gradient(#2a5880 0%, #1f2429 20%, #191d22 100%), linear-gradient(#007be0, #3275c7), radial-gradient(center 50% 0%, radius 100%, #64a5f5, #9ddbfa)");


        changeScreenPlay.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.7), 5, 0.0, 0, 1)");
        changeScreenPlay.setStyle("-fx-font: 22 fantasy; -fx-background-color: #0072ab, linear-gradient(#2a5880 0%, #1f2429 20%, #191d22 100%), linear-gradient(#007be0, #3275c7), radial-gradient(center 50% 0%, radius 100%, #64a5f5, #9ddbfa)");


        GridPane bottom = new GridPane();
        bottom.addRow(0, changeScreenBack, changeScreenPlay);

        bottom.setHgap(10);
        bottom.setVgap(10);
        bottom.setPadding(new Insets(10));

        setAlignment(bottom, Pos.BOTTOM_RIGHT);
        setBottom(bottom);

        Text inst = new Text("                              Welcome to Pictionary!\nThe game is simple: one player draws, and the other guesses.\n                       You are given a certain amount of\n                        time to get as many as you can \n                               To begin, press play!");
        inst.setFont(Font.font("AvantGarde", FontPosture.REGULAR, 14));
        setAlignment(inst, Pos.CENTER);
        setCenter(inst);

        setBackground( new Background( new BackgroundFill(Color.LIGHTCYAN, CornerRadii.EMPTY, Insets.EMPTY)));


        //You would probably add more code to format this GridPane the way you'd like
        //Since screenmanager isn't finished i can't run so idk how it looks but idk 
        //if we'd need any more formatting?
        
    }

    // private void handleButtonSettings(){
    //     //Call the appropriate method from the MainApp
    //     mainApp.showSettingsScreen();
    // }
    
    private void handleButtonBack(){
        mainApp.showWelcomeScreen();
    }
    
    private void handleButtonPlay() {
        WordScreen.setNumOfRounds(Integer.parseInt(SettingsScreen.numOfRounds.getText()));
        mainApp.showWordScreen();
    }
}
//I didn't think there was much to do so enjoy the new fonts and colors <3