// Team effort
import javafx.application.Application;
import javafx.event.Event;
import javafx.stage.Stage;

public class GameGui extends Application {

    private static StartScene startScene = new StartScene();
    private static RaceScene raceScene;
    private static EndScene endScene;
    private static Stage window;

    @Override
    public void start(Stage stage){

        window = stage;
        window.setTitle("e-Racers");
        window.setResizable(false);
        window.setScene(startScene.scene());

        window.show();

    }

    // The consume method consumes the button clicks from both the end scene and race scene that result in a scene
    // transition. Also it passes the car objects from one scene to another using getters.
    public static void consume(Event event){
        if(event.getSource() == startScene.getBtnContinue())
        {
            raceScene = new RaceScene(startScene.getCarOne(), startScene.getCarTwo(), startScene.getCarThree());
            window.setScene(raceScene.scene());
        }
        if(event.getSource() == raceScene.getBtnEndRace()){
            endScene = new EndScene(raceScene.getCarOne(), raceScene.getCarTwo(), raceScene.getCarThree());
            window.setScene(endScene.scene());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
