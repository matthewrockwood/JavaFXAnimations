package com.example.mazeproject;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
        HelloController controller = fxmlLoader.getController();
        AnchorPane pane = (AnchorPane) root.lookup("#maze2");
        //Button newButton = new Button("Click Me");
        //newButton.setLayoutX(200);                    This is just messing around, its not important
       // pane.getChildren().add(newButton);
        Scene scene = new Scene(root);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

                switch(keyEvent.getCode()){
                    case W:
                        controller.moveRobotUp();
                        break;
                    case S:
                        controller.moveRobotDown();
                        break;
                    case A:
                        controller.moveRobotLeft();
                        break;
                    case D:
                        controller.moveRobotRight();
                        break;
                    case Y:
                        controller.moveCarUp();
                        break;
                    case H:
                        controller.moveCarDown();
                        break;
                    case G:
                        controller.moveCarLeft();
                        break;
                    case J:
                        controller.moveCarRight();
                        break;



                }

            }
        });


        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}