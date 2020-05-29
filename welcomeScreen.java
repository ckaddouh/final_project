import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage; 
import javafx.scene.text.Font; 
import javafx.scene.text.FontPosture; 
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Text; 
import javafx.scene.text.TextAlignment;
         
public class welcomeScreen extends Application { 
   @Override 
   public void start(Stage primaryStage) {       
      //Creating a Text object 
      StackPane root = new StackPane();
      Text text = new Text();
      text.setFill(Color.DODGERBLUE);
      text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
      
      //Setting the text to be added. 
      text.setText("Welcome to Pictionary!"); 
       
      //setting the position of the text 
      text.setTextAlignment(TextAlignment.CENTER);
      root.getChildren().add(text);
      //Creating a scene object 
      Scene scene = new Scene(root, 400, 400);  
    
      primaryStage.setScene(scene);
      primaryStage.show();
   }      
} 