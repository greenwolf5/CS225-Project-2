
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RaceScene implements EventHandler<Event> {
    private Car carOne;
    private Car carTwo;
    private Car carThree;
    private Track raceTrack = new Track();
    private Button btnStartRace;
    private Long carOneTime = 0L;
    private Long carTwoTime = 0L;
    private Long carThreeTime = 0L;
    private Random random = new Random();
    private int breakdownFlag;

    // private;
    // private;
    // private;
    // private;
    // private;
    // private;
    // private;
    // private;
    // private;
    // private;

    public RaceScene(Car car1, Car car2, Car car3) {
        carOne = car1;

        carTwo = car2;

        carThree = car3;

        btnStartRace = new Button("Start");
        btnStartRace.setOnMouseClicked(this);
    }

    private void determineStartingLocation(Car carOne, Car carTwo, Car carThree) {
        ArrayList<Integer> locationPlaces = new ArrayList<Integer>();
        locationPlaces.add(1);// 0
        locationPlaces.add(2);// 1
        locationPlaces.add(3);// 2
        locationPlaces.add(4);// 3

        Collections.shuffle(locationPlaces);

        carOne.setLocation(locationPlaces.get(0));
        carTwo.setLocation(locationPlaces.get(1));
        carThree.setLocation(locationPlaces.get(2));
    }

    private void carPosition(Car car) {
        if (car.getLocation() == 1) {
            AnchorPane.setTopAnchor(car, 180.0);
            AnchorPane.setLeftAnchor(car, 160.0);
            car.setRotate(180);
        } else if (car.getLocation() == 2) {
            AnchorPane.setTopAnchor(car, 180.0);
            AnchorPane.setRightAnchor(car, 110.0);
            car.setRotate(-90);
        } else if (car.getLocation() == 3) {
            AnchorPane.setBottomAnchor(car, 140.0);
            AnchorPane.setRightAnchor(car, 110.0);
        } else {
            AnchorPane.setBottomAnchor(car, 140.0);
            AnchorPane.setLeftAnchor(car, 160.0);
            car.setRotate(90);
        }
    }

    public Scene scene() {
        AnchorPane anchorPane = new AnchorPane();

        Pane track = raceTrack.trackpainting();

        AnchorPane.setTopAnchor(track, 40.0);
        AnchorPane.setLeftAnchor(track, 40.0);

        determineStartingLocation(carOne, carTwo, carThree);

        carPosition(carOne);
        carPosition(carTwo);
        carPosition(carThree);

        System.out.println("Car one's location: " + carOne.getLocation() + " and carTwo's location: "
                + carTwo.getLocation() + " and carThree's location: " + carThree.getLocation());

        AnchorPane.setTopAnchor(btnStartRace, 500.0);
        AnchorPane.setLeftAnchor(btnStartRace, 500.0);

        anchorPane.setBackground(
                new Background(new BackgroundFill(Color.rgb(0, 132, 0), CornerRadii.EMPTY, Insets.EMPTY)));

        anchorPane.getChildren().addAll(track, carOne, carTwo, carThree, btnStartRace);

        Scene scene = new Scene(anchorPane, 1580, 1030);
        return scene;
    }

    @Override
    public void handle(Event event) {
        if (event.getSource() == btnStartRace) {
            btnStartRace.setVisible(false);
            carOne.carMovement(carOne.getLocation());
            carTwo.carMovement(carTwo.getLocation());
            carThree.carMovement(carThree.getLocation());
            carOneTime = carOne.getFinalTime().get();
            carTwoTime = carTwo.getFinalTime().get();
            carThreeTime = carThree.getFinalTime().get();
            System.out.println("AAAAAAAAAAA");
            System.out.println(carOneTime);
            
       
                
                Long startTime = System.currentTimeMillis();
                startTime = System.currentTimeMillis();
                while (System.currentTimeMillis() - startTime < 10000) { // empty block
                }
                System.out.println("Car one is done: " + carOne.getFinalTime().get());
            

        }
    }
}
