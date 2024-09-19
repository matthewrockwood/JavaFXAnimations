package com.example.mazeproject;

import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    public ImageView carImage;
    @FXML
    public Button animation2;
    @FXML
    private Button RobotAnimation;
    @FXML
    private ImageView robot1;
    private TranslateTransition[] translate = new TranslateTransition[13];
    private TranslateTransition[] translateCar = new TranslateTransition[7];
    private RotateTransition[] rotateCar = new RotateTransition[7];


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i =0; i<13 ;i++){
        translate[i] = new TranslateTransition(Duration.seconds(1),robot1);
            switch (i) {
                case 0:
                    translate[i].setByX(30);
                    break;
                case 1:
                    translate[i].setByY(-90);
                    break;
                case 2:
                    translate[i].setByX(190);
                    break;
                case 3:
                    translate[i].setByY(-55);
                    break;
                case 4:
                    translate[i].setByX(50);
                    break;
                case 5:
                    translate[i].setByY(190);
                    break;
                case 6:
                    translate[i].setByX(40);
                    break;
                case 7:
                    translate[i].setByY(-90);
                    break;
                case 8:
                    translate[i].setByX(100);
                    break;
                case 9:
                    translate[i].setByY(-90);
                    break;
                case 10:
                    translate[i].setByX(40);
                    break;
                case 11:
                    translate[i].setByY(110);
                    break;
                case 12:
                    translate[i].setByX(150);
                    break;
            }

        }
        for (int i = 0; i < 7; i++) {
            translateCar[i] = new TranslateTransition(Duration.seconds(1), carImage);
            rotateCar[i] = new RotateTransition(Duration.seconds(1), carImage);
            //rotateCar[i].setInterpolator(javafx.animation.Interpolator.LINEAR);

            switch (i) {
                case 0:
                    rotateCar[i].setByAngle(90);
                    translateCar[i].setByY(300);

                    break;
                case 1:
                    rotateCar[i].setByAngle(-90);
                    translateCar[i].setByX(170);

                    break;
                case 2:
                    translateCar[i].setByY(-160);
                    rotateCar[i].setByAngle(-90);
                    break;
                case 3:
                    translateCar[i].setByX(140);
                    rotateCar[i].setByAngle(90);
                    break;
                case 4:
                    translateCar[i].setByY(-140);
                    rotateCar[i].setByAngle(-90);
                    break;
                case 5:
                    translateCar[i].setByX(120);
                    rotateCar[i].setByAngle(90);
                    break;
                case 6:
                    translateCar[i].setByY(290);
                    rotateCar[i].setByAngle(90);
                    break;
            }
        }



    }
    public void moveCarRight() {
        carImage.setX(carImage.getX() + 5);
        carImage.setRotate(0);
    }

    public void moveCarLeft() {
        carImage.setX(carImage.getX() - 5);
        carImage.setRotate(180);
    }

    public void moveCarUp() {
        carImage.setY(carImage.getY() - 5);
        carImage.setRotate(-90);
    }

    public void moveCarDown() {
        carImage.setY(carImage.getY() + 5);
        carImage.setRotate(90);
    }
    public void moveRobotRight(){
        robot1.setX(robot1.getX()+5);
    }
    public void moveRobotLeft(){
        robot1.setX(robot1.getX()-5);
    }
    public void moveRobotUp(){
        robot1.setY(robot1.getY()-5);
    }
    public void moveRobotDown(){
        robot1.setY(robot1.getY()+5);
    }
    public void setRobotAnimation(ActionEvent event) {
        robot1.setX(0);
        robot1.setY(0);
        SequentialTransition sequentialTransition = new SequentialTransition(translate);

        sequentialTransition.play();


        System.out.println("Playing Animation");
    }

    public void carAnimation(ActionEvent event) {
        SequentialTransition sequentialTransition2 = new SequentialTransition();
        for (int i = 0; i < 7; i++) {
            sequentialTransition2.getChildren().addAll(rotateCar[i],translateCar[i]);

        }
        sequentialTransition2.play();
    }
}