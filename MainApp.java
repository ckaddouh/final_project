import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainApp extends Application {

    static Stage primaryStage;
    public static Stage stage2;

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
        primaryStage = stage;

        stage2 = new Stage();
        stage2.setX(1100);
        stage2.setY(150);

        Scene scene2 = new Scene(new TimerScreen(this), 200, 200);
        stage2.setTitle("Pictionary");
        stage2.setScene(scene2);

 
        welcomeScreen = new WelcomeScreen(this);
        instructionScreen = new InstructionScreen(this);
        drawingScreen = new DrawingScreen(this);
        settingsScreen = new SettingsScreen(this);
        resultsScreen = new ResultsScreen(this);
        finalScreen = new FinalScreen(this);
        wordScreen = new WordScreen(this);
        reminder = new Reminder(this);
 


        primaryStage.setResizable(false);
        stage2.setResizable(false);


        
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
        primaryStage.setX(100);
        primaryStage.setY(100);
        
        scene2 = new Scene(new TimerScreen(this), 400, 400);
        stage2.setScene(scene2);
        stage2.show();


        new Reminder(this);

        scene.setRoot(drawingScreen);
    }

    public void showResultsScreen(){

        Scene scene = primaryStage.getScene();

        primaryStage.setX(350);
        primaryStage.setY(100);

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

    public void showFinalScreen(){
        Scene scene = primaryStage.getScene();
        scene.setRoot(finalScreen);
    }

 

    public void showWordScreen(){
        Scene scene = primaryStage.getScene();        
        primaryStage.setX(350);
        primaryStage.setY(100);

        try {
            WordScreen.setFileName(SettingsScreen.comboBox.getValue());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        WordScreen.setTimerLength(Integer.parseInt(SettingsScreen.timerLength.getText()));


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