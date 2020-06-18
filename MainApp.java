// The main screen manager that creates and controls other screens

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

// Create a class that extends Application
public class MainApp extends Application {

    static Stage primaryStage;
    public static Stage stage2;

    // Define all of the screens as Pane variables
    Pane welcomeScreen;
    Pane instructionScreen;
    Pane drawingScreen;
    Pane settingsScreen;
    Pane resultsScreen;
    Pane finalScreen;
    Pane wordScreen;
    Pane reminder;

    public static Scene scene2;

    @Override
    public void start(Stage stage) throws Exception {
        // Create 2 stages, one for the main game, and one for the timer
        primaryStage = stage;

        stage2 = new Stage();
        stage2.setX(1100);
        stage2.setY(150);

        // Create the second scene for the timer and set its properties
        Scene scene2 = new Scene(new TimerScreen(this), 200, 200);
        stage2.setTitle("Pictionary");
        stage2.setScene(scene2);

        // Define each of the Pane variables to a new screen passing it the mainApp
        welcomeScreen = new WelcomeScreen(this);
        instructionScreen = new InstructionScreen(this);
        drawingScreen = new DrawingScreen(this);
        settingsScreen = new SettingsScreen(this);
        resultsScreen = new ResultsScreen(this);
        finalScreen = new FinalScreen(this);
        wordScreen = new WordScreen(this);
        reminder = new Reminder(this);
 
        // Make sure the users cannot resize the windows
        primaryStage.setResizable(false);
        stage2.setResizable(false);
        
        // Set the primary screen to the WelcomeScreen and determine its properties
        Scene scene = new Scene(welcomeScreen, 900, 500);
        primaryStage.setTitle("Pictionary!");
        primaryStage.setScene(scene);
        primaryStage.show();  

    }

    // Define a method that sets the root of the scene to welcomeScreen
    public void showWelcomeScreen(){
        Scene scene = primaryStage.getScene();
        // setStageSize(800, 500);
        scene.setRoot(welcomeScreen);

    }

    // Define a method that sets the root of the scene to instructionScreen
    public void showInstructionScreen(){
        Scene scene = primaryStage.getScene();
        // setStageSize(415, 250);
        scene.setRoot(instructionScreen);
    }

    // Define a method that sets the root of the scene to settingsScreen
    public void showSettingsScreen(){
        Scene scene = primaryStage.getScene();
        // setStageSize(800, 400);
        scene.setRoot(settingsScreen);
    }

    // Define a method that shows the drawingScreen and timerScreen in the second stage
    public void showDrawingScreen(){
        Scene scene = primaryStage.getScene();
        primaryStage.setX(100);
        primaryStage.setY(100);
        
        scene2 = new Scene(new TimerScreen(this), 400, 400);
        stage2.setScene(scene2);
        stage2.show();

        // Start the actual timer
        new Reminder(this);

        scene.setRoot(drawingScreen);
    }

    // Define a method that sets the root of the scene to resultsScreen
    public void showResultsScreen(){

        Scene scene = primaryStage.getScene();

        primaryStage.setX(350);
        primaryStage.setY(100);

        // Depending on if the other player guessed correctly, change the text and image of the resultsScreen
        if (DrawingScreen.isCorrect){
            ResultsScreen.text.setText("CORRECT! \n The word was " + WordScreen.word);
            ResultsScreen.imageView.setImage(new Image("image/good.gif"));
        }
        else {
            ResultsScreen.text.setText("Out of time... \n The word was " + WordScreen.word);
            ResultsScreen.imageView.setImage(new Image("image/crying.gif"));
        }

        scene.setRoot(resultsScreen);
    }

    // Define a method that sets the root of the scene to finalScreen
    public void showFinalScreen(){
        Scene scene = primaryStage.getScene();
        scene.setRoot(finalScreen);
    }

    // Define a method that sets the root of the scene to wordScreen
    public void showWordScreen(){
        Scene scene = primaryStage.getScene();        
        primaryStage.setX(350);
        primaryStage.setY(100);

        // Create a try-catch for passing the file name
        try {
            WordScreen.setFileName(SettingsScreen.comboBox.getValue());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Set the length of the timer based on the settingsScreen values
        WordScreen.setTimerLength(Integer.parseInt(SettingsScreen.timerLength.getText()));

        scene.setRoot(wordScreen);
    }

    // Define a function to set the stage size
    public static void setStageSize(double width, double height){
        primaryStage.setWidth(width);
        primaryStage.setHeight(height);
    }

    // Define a method that actually runs the program
    public static void main(String[] args){
        launch(args);
    }
}