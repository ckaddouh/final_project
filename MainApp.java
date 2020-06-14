import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainApp extends Application {

    static Stage primaryStage;
    public static Stage stage2;
    // static Stage secondaryStage;

    Pane welcomeScreen;
    Pane instructionScreen;
    Pane drawingScreen;
    Pane settingsScreen;
    Pane resultsScreen;
    Pane finalScreen;
    Pane wordScreen;
    Pane reminder;
    // Pane timerScreen;

    public static Scene scene2;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        stage2 = new Stage();

        Scene scene2 = new Scene(new TimerScreen(this), 400, 400);
        stage2.setTitle("Pictionary");
        stage2.setScene(scene2);
    

        welcomeScreen = new WelcomeScreen(this);
        instructionScreen = new InstructionScreen(this);
        drawingScreen = new DrawingScreen(this);
        settingsScreen = new SettingsScreen(this);
        resultsScreen = new ResultsScreen(this);
        finalScreen = new FinalScreen(this);
        wordScreen = new WordScreen(this);
        // timerScreen = new TimerScreen(this);
        reminder = new Reminder(this);
        // timeScreen = new TimeScreen(this);

        primaryStage.setResizable(false);
        stage2.setResizable(false);

        // scene2 = new Scene(new TimerScreen(this), 400, 400);
        // scene2 = new Scene(reminder, 400, 400);
        // stage2.setScene(scene2);
        // stage2.setTitle("Pictionary!");
        
        Scene scene = new Scene(welcomeScreen, 900, 500);
        primaryStage.setTitle("Pictionary!");
        primaryStage.setScene(scene);
        primaryStage.show();  

    }

    public void showWelcomeScreen(){
        Scene scene = primaryStage.getScene();
        // setStageSize(800, 500);
        scene.setRoot(welcomeScreen);
    }

    public void showInstructionScreen(){
        Scene scene = primaryStage.getScene();
        // setStageSize(415, 250);
        scene.setRoot(instructionScreen);
    }

    public void showSettingsScreen(){
        Scene scene = primaryStage.getScene();
        // setStageSize(800, 400);
        scene.setRoot(settingsScreen);
    }

    public void showDrawingScreen(){
        Scene scene = primaryStage.getScene();

        DrawingScreen.setNumOfRounds(Integer.parseInt(SettingsScreen.numOfRounds.getText()));
        DrawingScreen.setTimerLength(Integer.parseInt(SettingsScreen.timerLength.getText()));
        
        scene2 = new Scene(new TimerScreen(this), 400, 400);
        stage2.setScene(scene2);
        stage2.show();

        // try {
        //     DrawingScreen.setFileName(SettingsScreen.comboBox.getValue());
        // } catch (FileNotFoundException e) {
        //     e.printStackTrace();
        // }
        
        // secondaryStage.show();

        new Reminder(this);
        // System.out.println(WordScreen.sec);
    
        // setStageSize(900, 500);
        scene.setRoot(drawingScreen);
    }

    public void showResultsScreen(){

        Scene scene = primaryStage.getScene();

        if (DrawingScreen.isCorrect)
            ResultsScreen.text.setText("CORRECT! \n The word was " + WordScreen.word);
        else
            ResultsScreen.text.setText("Out of time... \n The word was " + WordScreen.word);

        // stage2.close();

        // setStageSize(400, 400);
        scene.setRoot(resultsScreen);
        Reminder.timer.cancel();
    }

    public void showFinalScreen(){
        Scene scene = primaryStage.getScene();
        // setStageSize(400, 400);
        scene.setRoot(finalScreen);
    }

    // public void showTimeScreen(){
    //     Scene scene = primaryStage.getScene();
    //     setStageSize(400, 400);
    //     scene.setRoot(timeScreen);
    // }

    public void showWordScreen(){
        Scene scene = primaryStage.getScene();

        try {
            WordScreen.setFileName(SettingsScreen.comboBox.getValue());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        WordScreen.setTimerLength(Integer.parseInt(SettingsScreen.timerLength.getText()));

        // setStageSize(600, 400);
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