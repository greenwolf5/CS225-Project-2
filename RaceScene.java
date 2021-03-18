
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
    private Car carOne;
    private Car carTwo;
    private Car carThree;
    private;
    private;
    private;
    private;
    private;
    private;
    private;
    private;
    private;
    private;
    private;

    public RaceScene(Car car1, Car car2, Car car3){
        carOne = car1;
        carTwo = car2;
        carThree = car3;
    }


4
    public Scene scene(){

    }

    @Override
    public void handle(Event event){
//        if(event.getSource() == update1){
//            updateCar(1);
//        }
    }
}