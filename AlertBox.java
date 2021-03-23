// Justin Valas

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    public AlertBox() {
        // default constructor.
    }

    public static void showMessageDialogue(String title, String message) {

        final String FONT_TYPE = "Times New Roman";
        final double PREF_SIZE = 20.0;

        BackgroundFill backGroundFill = new BackgroundFill(Color.LIGHTSTEELBLUE, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backGroundFill);

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setTitle(title);

        Pane pane = new Pane();
        pane.setBackground(background);

        Text text = new Text(message);
        text.setFont(new Font(FONT_TYPE, PREF_SIZE));
        text.setTextAlignment(TextAlignment.CENTER);
        pane.getChildren().add(text);
        pane.getChildren().get(0).setLayoutX(20.0);
        pane.getChildren().get(0).setLayoutY(20.0);

        Scene scene = new Scene(pane, 1000, 250.0);
        stage.setScene(scene);

        stage.show();

    }
}