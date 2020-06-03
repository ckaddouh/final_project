import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainApp extends Application {

    Stage primaryStage;

    Pane welcomeScreen;
    Pane instructionScreen;
    Pane settingsScreen;
    Pane drawingScreen;
    Pane resultsScreen;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;

        welcomeScreen = new WelcomeScreen(this);
        instructionScreen = new InstructionScreen(this);
        settingsScreen = new SettingsScreen(this);
        drawingScreen = new DrawingScreen(this);
        resultsScreen = new ResultsScreen(this);
        
        Scene scene = new Scene(welcomeScreen, 500, 800);
        primaryStage.setTitle("Welcome to Pictionary!");
        primaryStage.setScene(scene);
        primaryStage.show();  
    }

    public void showWelcomeScreen(){
        Scene scene = primaryStage.getScene();
        scene.setRoot(welcomeScreen);
    }

    public void showInstructionScreen(){
        Scene scene = primaryStage.getScene();
        scene.setRoot(instructionScreen);
    }

    public void showSettingsScreen(){
        Scene scene = primaryStage.getScene();
        scene.setRoot(settingsScreen);
    }

    public void showDrawingScreen(){
        Scene scene = primaryStage.getScene();
        scene.setRoot(drawingScreen);
    }

    public void showResultsScreen(){
        Scene scene = primaryStage.getScene();
        scene.setRoot(resultsScreen);
    }

    public static void main(String[] args){
        launch(args);
    }
}