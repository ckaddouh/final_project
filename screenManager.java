import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * MainApp that demonstrates the standard approach to multiple screens:
 * changing the root (usually some kind of Pane) of the Scene.
 * 
 * Using multiple objects to represent screens helps keep functionality separate. 
 */
public class screenManager extends Application {


    Stage primaryStage;
    //Save screenA so you don't have to build it every time
    Pane screenA;

    //NOTE: You could save screenB too, if you wanted to keep changes between switches
    //Pane screenB;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        //Save for later access.
        primaryStage = stage;

        //Create screenA for the Scene
        //We also  save screenA so you don't have to recreate it 
        screenA = new welcomeScreen(this);
        //Note that we are passing a reference to this MainApp so 
        //screenA can access the methods for showing other screens;


        //NOTE: You could create and save screenB too, if you wanted to keep changes between switches
        //screenB = new ScreenB(this);

        //Creates a Scene with screenA as the "root".
        Scene scene = new Scene(screenA, 300, 200);
        //Put the scene in the Stage (aka window)
        primaryStage.setTitle("Multi-screen Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Standard approach of changing the screen - change the root of the Scene.
     * 
     * This approach uses the saved screenA - any previous changes to screenA will 
     * be seen.
     */
    public void showScreenA(){
        //This is the scene we set before.
        Scene scene = primaryStage.getScene();

        //Change the "root" to be screenA, which we've never changed;
        scene.setRoot(screenA);
        //Note that when we change the root, if the old root
    }


    /**
     * Same approach as the above - change the root of the scene.
     * 
     * The difference here is that we are creating screenB every time
     * we set the screen. 
     * 
     * This might be what you want - (say, starting a level from scratch)
     * 
     * However, we could easily have also saved screenB. 
     * See the 3 commented lines with NOTE above them
     * 
     */
    public void showScreenB(){
        //This is the scene we set before.
        Scene scene = primaryStage.getScene();

        //Change the "root" to be a *new* screenA, which we've never changed;
        scene.setRoot(new instructionScreen(this));

        //NOTE: You could save screenB too, if you wanted to keep changes between switches
        //scene.setRoot(screenB);
    }

    public static void main(String[] args) {
        launch(args);
    }
}