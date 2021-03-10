package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;


public class StartScene implements EventHandler<ActionEvent> {
    Label lblTitle = new Label();
    Label lblCarOne = new Label();
    Label lblCarTwo = new Label();
    Label lblCarThree = new Label();
    Pane carOnePane = new Pane();
    Pane carTwoPane = new Pane();
    Pane carThreePane = new Pane();

    public StartScene(){
        lblTitle.setText("e-Racers");

        lblCarOne.setText("Car 1:");

        lblCarTwo.setText("Car 2:");

        lblCarThree.setText("Car 3:");

    }

    private Pane createCarPane(){
        Pane pane = new Pane();

    }
}
