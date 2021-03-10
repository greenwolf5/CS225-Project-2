package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.stage.Stage;

public class GameGui extends Application {

    private static StartScene startScene = new StartScene();
    private static RaceScene raceScene = new RaceScene();
    private static EndScene endScene = new EndScene();
    private static Stage window;

    @Override
    public void start(Stage stage){

        window = stage;
        window.setTitle("e-Racers");
        window.setResizable(false);
        window.setScene(startScene.scene());
        window.show();

    }

    public static void consume(Event event){

        if(event.getSource() == startScene.getBtnStartRace())
        {
            raceScene.setCar1();
            raceScene.setCar2();
            raceScene.setCar3();
            window.setScene(raceScene.scene());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
