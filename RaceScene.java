
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Collections;

public class RaceScene implements EventHandler<Event> {
    private Car carOne;
    private Car carTwo;
    private Car carThree;
    private Track raceTrack = new Track();
    private Button btnStartRace;
    private Button btnEndRace;
    private Long carOneTime = 0L;
    private Long carTwoTime = 0L;
    private Long carThreeTime = 0L;
    private Text txtWarning;

    public RaceScene(Car car1, Car car2, Car car3) {
        carOne = car1;

        carTwo = car2;

        carThree = car3;

        txtWarning = new Text("Wait for all cars to finish moving");
        txtWarning.setFont(Font.font(30));
        txtWarning.setFill(Color.WHITE);
        txtWarning.setVisible(false);

        btnStartRace = new Button("Start");
        btnStartRace.setFont(Font.font(40));
        btnStartRace.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        btnStartRace.setOnMouseEntered(E -> btnStartRace.setBackground(new Background(new BackgroundFill
                (Color.DODGERBLUE, CornerRadii.EMPTY, Insets.EMPTY))));
        btnStartRace.setOnMouseExited(E -> btnStartRace.setBackground(new Background(new BackgroundFill
                (Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY))));
        btnStartRace.setOnMouseClicked(this);

        btnEndRace = new Button("Finish");
        btnEndRace.setVisible(false);
        btnEndRace.setFont(Font.font(40));
        btnEndRace.setTextFill(Color.WHITE);
        btnEndRace.setBackground(new Background(new BackgroundFill(Color.CRIMSON, CornerRadii.EMPTY, Insets.EMPTY)));
        btnEndRace.setOnMouseEntered(E -> btnEndRace.setBackground(new Background(new BackgroundFill
                (Color.DARKRED, CornerRadii.EMPTY, Insets.EMPTY))));
        btnEndRace.setOnMouseExited(E -> btnEndRace.setBackground(new Background(new BackgroundFill
                (Color.CRIMSON, CornerRadii.EMPTY, Insets.EMPTY))));
        btnEndRace.setOnMouseClicked(this);
    }

    public Car getCarOne(){
        return carOne;
    }

    public Car getCarTwo(){
        return carTwo;
    }

    public Car getCarThree(){
        return carThree;
    }

    public Long getCarOneTime(){
        return carOneTime;
    }

    public Long getCarTwoTime(){
        return carTwoTime;
    }

    public Long getCarThreeTime(){
        return carThreeTime;
    }

    public Button getBtnEndRace(){
        return btnEndRace;
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

        AnchorPane.setTopAnchor(btnStartRace, 480.0);
        AnchorPane.setLeftAnchor(btnStartRace, 740.0);

        AnchorPane.setTopAnchor(btnEndRace, 480.0);
        AnchorPane.setLeftAnchor(btnEndRace, 730.0);

        AnchorPane.setTopAnchor(txtWarning, 600.0);
        AnchorPane.setLeftAnchor(txtWarning, 610.0);

        anchorPane.setBackground(
                new Background(new BackgroundFill(Color.rgb(0, 132, 0),
                        CornerRadii.EMPTY, Insets.EMPTY)));

        anchorPane.getChildren().addAll(track, carOne, carTwo, carThree, btnStartRace, btnEndRace, txtWarning);

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

            btnEndRace.setVisible(true);
        }
        if (event.getSource() == btnEndRace) {
            if(carOne.getFinalTime().get() == null || carTwo.getFinalTime().get() == null ||
                    carThree.getFinalTime().get() == null){
                txtWarning.setVisible(true);
            }
            else{
                carOneTime = carOne.getFinalTime().get();
                carTwoTime = carOne.getFinalTime().get();
                carThreeTime = carOne.getFinalTime().get();

                GameGui.consume(event);
            }
        }
    }
}