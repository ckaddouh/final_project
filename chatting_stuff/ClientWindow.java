package chatting_stuff;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class ClientWindow extends Application {

    private static TextField textField = new TextField();
    private static TextField display = new TextField();
    
    private Client client;

    public ClientWindow() { 
        client = new Client("localhost", 52864);
    }

    @Override
    public void start(Stage primaryStage){
        GridPane pane = new GridPane();
        Pane show = new Pane();

        show.getChildren().add(display);
        display.setEditable(false);
        display.setPrefHeight(450);
        display.setPrefWidth(800);
        display.setDisable(true);
        
        textField.setPrefWidth(650);
        textField.setPrefColumnCount(1);

        Button send = new Button("Send");
        pane.addRow(0, show);

        send.setOnAction( e -> {
            
        });

        pane.add(textField, 0, 3);
        pane.add(send, 1, 3);

        

        Scene scene = new Scene(pane, 900, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Chat Room");
        primaryStage.show();
    }

    public static void printToConsole(String message){
        textField.setText(textField.getText() + message + "\n");
    }
}