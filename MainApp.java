import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainApp extends Application {

    static Stage primaryStage;

    Pane welcomeScreen;
    Pane instructionScreen;
    Pane drawingScreen;
    Pane settingsScreen;
    Pane resultsScreen;
    Pane finalScreen;
    Pane wordScreen;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;

        welcomeScreen = new WelcomeScreen(this);
        instructionScreen = new InstructionScreen(this);
        drawingScreen = new DrawingScreen(this);
        settingsScreen = new SettingsScreen(this);
        resultsScreen = new ResultsScreen(this);
        finalScreen = new FinalScreen(this);
        wordScreen = new WordScreen(this);

        Scene scene = new Scene(welcomeScreen, 800, 500);
        primaryStage.setTitle("Welcome to Pictionary!");
        primaryStage.setScene(scene);
        primaryStage.show();  

    }

    public void showWelcomeScreen(){
        Scene scene = primaryStage.getScene();
        setStageSize(800, 500);
        scene.setRoot(welcomeScreen);
    }

    public void showInstructionScreen(){
        Scene scene = primaryStage.getScene();
        setStageSize(415, 250);
        scene.setRoot(instructionScreen);
    }

    public void showSettingsScreen(){
        Scene scene = primaryStage.getScene();
        setStageSize(800, 400);
        scene.setRoot(settingsScreen);
    }

    public void showDrawingScreen(){
        Scene scene = primaryStage.getScene();
        
        DrawingScreen.setNumOfRounds(Integer.parseInt(SettingsScreen.numOfRounds.getText()));
        DrawingScreen.setTimerLength(Integer.parseInt(SettingsScreen.timerLength.getText()));
        // try {
        //     DrawingScreen.setFileName(SettingsScreen.comboBox.getValue());
        // } catch (FileNotFoundException e) {
        //     e.printStackTrace();
        // }

        setStageSize(800, 500);
        scene.setRoot(drawingScreen);
    }

    public void showResultsScreen(){
        Scene scene = primaryStage.getScene();
        setStageSize(400, 400);
        scene.setRoot(resultsScreen);
    }

    public void showFinalScreen(){
        Scene scene = primaryStage.getScene();
        setStageSize(400, 400);
        scene.setRoot(finalScreen);
    }

    public void showWordScreen(){
        Scene scene = primaryStage.getScene();

        WordScreen.setNumOfRounds(Integer.parseInt(SettingsScreen.numOfRounds.getText()));
        WordScreen.setTimerLength(Integer.parseInt(SettingsScreen.timerLength.getText()));
        try {
            WordScreen.setFileName(SettingsScreen.comboBox.getValue());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        setStageSize(400, 400);
        scene.setRoot(wordScreen);
    }

    public static void setStageSize(double width, double height){
        primaryStage.setWidth(width);
        primaryStage.setHeight(height);
    }

    public static void main(String[] args){
        launch(args);
    }
}