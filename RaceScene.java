
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

public class RaceScene implements EventHandler<Event> {
    private Car carOne = new Car();
    private Car carTwo = new Car();
    private Car carThree = new Car();
    private Track raceTrack = new Track();
    private Button btnStartRace = new Button("Start");
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
//    private;

    public RaceScene(Car car1, Car car2, Car car3){
        carOne = car1;
        carTwo = car2;
        carThree = car3;
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
            System.out.println("hey");
//            carOne.setRotate(carOne.getRotate() + 90);
        }
    }
}
