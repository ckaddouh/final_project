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




public class InstructionScreen extends BorderPane {

    private MainApp mainApp;

    public InstructionScreen(MainApp app) {
        super();

        this.mainApp = app;

        Text text = new Text();
        text.setText("\nInstructions"); 
        text.setFill(Color.DODGERBLUE);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 35));

        setTop(text);
        setAlignment(text, Pos.CENTER);

        Button changeScreenBack = new Button("Back");
        changeScreenBack.setOnAction(e -> handleButtonBack());
        

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

        Text inst = new Text("          Welcome to Pictionary!\nThe game is simple: one player draws,\n           and the other guesses.\n   You are given a certain amount of\n    time to get as many as you can.\n         Go to settings to change\n  the number of rounds and length.\n           To begin, press play!");
        inst.setFont(Font.font("verdana", FontPosture.REGULAR, 25));
        setAlignment(inst, Pos.CENTER);
        setCenter(inst);

        setBackground( new Background( new BackgroundFill(Color.LIGHTCYAN, CornerRadii.EMPTY, Insets.EMPTY)));

    }

    private void handleButtonBack(){
        mainApp.showWelcomeScreen();
    }
    
    private void handleButtonPlay() {
        WordScreen.setNumOfRounds(Integer.parseInt(SettingsScreen.numOfRounds.getText()));
        mainApp.showWordScreen();
    }
}
