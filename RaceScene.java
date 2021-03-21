
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

import java.util.Random;

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

//    private;
//    private;
//    private;
//    private;
//    private;
//    private;
//    private;
//    private;
//    private;
//    private;

    public RaceScene(Car car1, Car car2, Car car3){
        carOne = car1;

        carTwo = car2;
        carTwo.setRotate(90);

        carThree = car3;
        carTwo.setRotate(180);

        btnStartRace = new Button("Start");
        btnStartRace.setOnMouseClicked(this);
    }

    public Long carMovement(Car car, int startLoc){
        SequentialTransition seqT = new SequentialTransition();

        TranslateTransition breakdown = new TranslateTransition();
        breakdown.setOnFinished(event -> car.carFire());
        int breakdownFlag;

        Long time = System.currentTimeMillis();

        if(car.doBreakdownCheck()){
            int dur;
            time = 0L;
            switch (random.nextInt(4)){
                case 0:
                    breakdown.setByX(300);
                    dur = (11 - car.getSpeed()) * 500;
                    breakdown.setDuration(Duration.millis(dur));
                    breakdownFlag = 1;
                    break;
                case 1:
                    breakdown.setByY(-100);
                    dur = (11 - car.getSpeed()) * 250;
                    breakdown.setDuration(Duration.millis(dur));
                    breakdownFlag = 2;
                    break;
                case 2:
                    breakdown.setByX(-300);
                    dur = (11 - car.getSpeed()) * 500;
                    breakdown.setDuration(Duration.millis(dur));
                    breakdownFlag = 3;
                    break;
                case 3:
                    breakdown.setByY(100);
                    dur = (11 - car.getSpeed()) * 250;
                    breakdown.setDuration(Duration.millis(dur));
                    breakdownFlag = 4;
                    break;
            }
        }

        switch(startLoc){
            case 1:
                if(breakdownFlag == 1){
                    seqT.getChildren().add(breakdown);
                    seqT.play();
                    return time;
                }
                if(car.doHandlingCheck()){
                    seqT.getChildren().add(spinOut());
                    seqT.getChildren().add(translate(1, car.getSpeed()));
                }
        }


        return time;

//        while(turns < 4){
//            if(currentLoc == 1){
//                translateTransition.setByX(600);
//                translateTransition.setByY(0);
//                translateTransition.setDuration(Duration.millis(1000));
//
//                translateTransition.play();
//
//                currentLoc++;
//                turns++;
//            }
//            if(currentLoc == 2){
//                translateTransition.setByX(0);
//                translateTransition.setByY(-200);
//                translateTransition.setDuration(Duration.millis(1000));
//
//                translateTransition.play();
//
//                translateTransition.setOnFinished(event -> translateTransition.pause());
//
//                car.setRotate(car.getRotate() + 90);
//                currentLoc++;
//                turns++;
//            }
//            if(currentLoc == 3){
//                translateTransition.setByX(-600);
//                translateTransition.setByY(0);
//                translateTransition.setDuration(Duration.millis(1000));
//
//                translateTransition.play();
//
//                translateTransition.setOnFinished(event -> translateTransition.pause());
//
//                car.setRotate(car.getRotate() + 90);
//                currentLoc++;
//                turns++;
//            }
//            if(currentLoc == 4){
//                translateTransition.setByX(0);
//                translateTransition.setByY(200);
//                translateTransition.setDuration(Duration.millis(1000));
//
//                translateTransition.play();
//
//                translateTransition.setOnFinished(event -> translateTransition.pause());
//
//                car.setRotate(car.getRotate() + 90);
//                currentLoc = 1;
//                turns++;
//            }
//        }
    }

    private RotateTransition spinOut(){
        RotateTransition spinOut = new RotateTransition(Duration.millis(2000));
        spinOut.setByAngle(360);
        return spinOut;
    }

    private RotateTransition turn(){
        RotateTransition turn = new RotateTransition(Duration.millis(500));
        turn.setByAngle(90);
        return turn;
    }

    private TranslateTransition translate(int location, int speed){
        int durLong = (11 - speed) * 1000;
        int durShort = durLong / 3;
        TranslateTransition translateTransition = new TranslateTransition();
        switch (location){
            case 1:
                translateTransition.setByX(600);
                translateTransition.setDuration(Duration.millis(durLong));
                break;
            case 2:
                translateTransition.setByY(-200);
                translateTransition.setDuration(Duration.millis(durShort));
                break;
            case 3:
                translateTransition.setByX(-600);
                translateTransition.setDuration(Duration.millis(durLong));
                break;
            case 4:
                translateTransition.setByY(200);
                translateTransition.setDuration(Duration.millis(durShort));
                break;
        }
        return translateTransition;
    }

    public Scene scene(){
        AnchorPane anchorPane = new AnchorPane();

        Pane track = raceTrack.trackpainting();

        AnchorPane.setTopAnchor(track, 40.0);
        AnchorPane.setLeftAnchor(track, 40.0);

        AnchorPane.setTopAnchor(carOne, 100.0);
        AnchorPane.setLeftAnchor(carOne, 100.0);

        AnchorPane.setTopAnchor(carTwo, 100.0);
        AnchorPane.setRightAnchor(carTwo, 100.0);

        AnchorPane.setBottomAnchor(carThree, 100.0);
        AnchorPane.setRightAnchor(carThree, 100.0);

        AnchorPane.setTopAnchor(btnStartRace, 500.0);
        AnchorPane.setLeftAnchor(btnStartRace, 500.0);

        anchorPane.setBackground(new Background(new BackgroundFill(Color.rgb(0,132,0), CornerRadii.EMPTY, Insets.EMPTY)));

        anchorPane.getChildren().addAll(track, carOne, carTwo, carThree, btnStartRace);

        Scene scene = new Scene(anchorPane, 1580, 1030);
        return scene;
    }

    @Override
    public void handle(Event event){
        if(event.getSource() == btnStartRace){
            carOneTime = carMovement(carOne, 1);
            System.out.println(carOneTime);
        }
    }
}
