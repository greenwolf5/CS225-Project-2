
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



public class StartScene implements EventHandler<Event> {
    private Label lblTitle = new Label();
    private Label lblCarOne = new Label();
    private Label lblCarTwo = new Label();
    private Label lblCarThree = new Label();
    private Pane carOnePane;
    private Pane carTwoPane;
    private Pane carThreePane;
    private Button update1;
    private Button update2;
    private Button update3;
    private Button btnContinue;
    private Button btnHelp;
    private Car carOne;
    private Car carTwo;
    private Car carThree;

    public StartScene(){
        lblTitle.setText("e-Racers");
        lblTitle.setFont(Font.font("Bauhaus 93", 40));
        lblTitle.setTextFill(Color.GOLD);

        lblCarOne.setText("Car 1:");
        lblCarOne.setFont(Font.font("Gill Sans MT Condensed", 30));
        lblCarOne.setTextFill(Color.GOLD);

        lblCarTwo.setText("Car 2:");
        lblCarTwo.setFont(Font.font("Gill Sans MT Condensed", 30));
        lblCarTwo.setTextFill(Color.GOLD);

        lblCarThree.setText("Car 3:");
        lblCarThree.setFont(Font.font("Gill Sans MT Condensed", 30));
        lblCarThree.setTextFill(Color.GOLD);

        update1 = new Button("UPDATE");
        update1.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        update1.setTextFill(Color.GOLD);
        update1.setOnMouseEntered(E -> update1.setBackground(new Background(new BackgroundFill
                (Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY))));
        update1.setOnMouseExited(E -> update1.setBackground(new Background(new BackgroundFill
                (Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY))));
        update1.setOnMouseClicked(this);

        update2 = new Button("UPDATE");
        update2.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        update2.setTextFill(Color.GOLD);
        update2.setOnMouseEntered(E -> update2.setBackground(new Background(new BackgroundFill
                (Color.RED, CornerRadii.EMPTY, Insets.EMPTY))));
        update2.setOnMouseExited(E -> update2.setBackground(new Background(new BackgroundFill
                (Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY))));
        update2.setOnMouseClicked(this);

        update3 = new Button("UPDATE");
        update3.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        update3.setTextFill(Color.GOLD);
        update3.setOnMouseEntered(E -> update3.setBackground(new Background(new BackgroundFill
                (Color.RED, CornerRadii.EMPTY, Insets.EMPTY))));
        update3.setOnMouseExited(E -> update3.setBackground(new Background(new BackgroundFill
                (Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY))));
        update3.setOnMouseClicked(this);

        btnContinue = new Button("CONTINUE >>");
        btnContinue.setFont(Font.font(20));
        btnContinue.setBackground(new Background(new BackgroundFill(Color.GOLD, CornerRadii.EMPTY, Insets.EMPTY)));
        btnContinue.setOnMouseEntered(E -> btnContinue.setBackground(new Background(new BackgroundFill
                (Color.RED, CornerRadii.EMPTY, Insets.EMPTY))));
        btnContinue.setOnMouseExited(E -> btnContinue.setBackground(new Background(new BackgroundFill
                (Color.GOLD, CornerRadii.EMPTY, Insets.EMPTY))));
        btnContinue.setOnMouseClicked(this);

        btnHelp = new Button("help");
        btnHelp.setFont(Font.font(20));
        btnHelp.setBackground(new Background(new BackgroundFill(Color.GOLD, CornerRadii.EMPTY, Insets.EMPTY)));
        btnHelp.setOnMouseEntered(E -> btnHelp.setBackground(new Background(new BackgroundFill
                (Color.RED, CornerRadii.EMPTY, Insets.EMPTY))));
        btnHelp.setOnMouseExited(E -> btnHelp.setBackground(new Background(new BackgroundFill
                (Color.GOLD, CornerRadii.EMPTY, Insets.EMPTY))));
        btnHelp.setOnMouseClicked(this);

        carOnePane = createCarPane(update1);
        carTwoPane = createCarPane(update2);
        carThreePane = createCarPane(update3);
    }

    public Button getBtnContinue(){
        return btnContinue;
    }

    private Pane createCarPane(Button update){
        Pane pane = new Pane();

        Label type = new Label("type: ");
        type.setFont(Font.font("Gill Sans MT Condensed", 25));
        ChoiceBox<String> typeChoices = new ChoiceBox<>();
        typeChoices.getItems().addAll("Truck", "SUV", "Sports Car");
        typeChoices.setValue("Truck");

        Label color = new Label("color: ");
        color.setFont(Font.font("Gill Sans MT Condensed", 25));
        ChoiceBox<String> colorChoices = new ChoiceBox<>();
        colorChoices.getItems().addAll("Blue", "Green", "Pink", "Red", "Yellow");
        colorChoices.setValue("Blue");

        Label tires = new Label("tires: ");
        tires.setFont(Font.font("Gill Sans MT Condensed", 25));
        ChoiceBox<String> tireChoices = new ChoiceBox<>();
        tireChoices.getItems().addAll("Off Road", "Street", "Sport");
        tireChoices.setValue("Off Road");

        Label engine = new Label("engine: ");
        engine.setFont(Font.font("Gill Sans MT Condensed", 25));
        ChoiceBox<String> engineChoices = new ChoiceBox<>();
        engineChoices.getItems().addAll("V4", "V6", "V8");
        engineChoices.setValue("V4");

        Car defaultCar = new Car();

        pane.getChildren().addAll(type, typeChoices, color, colorChoices, tires, tireChoices, engine, engineChoices,
                update, createStatTable(defaultCar), defaultCar);

        pane.getChildren().get(0).setLayoutX(20.0);
        pane.getChildren().get(0).setLayoutY(5.0);
        pane.getChildren().get(1).setLayoutX(80.0);
        pane.getChildren().get(1).setLayoutY(10.0);
        pane.getChildren().get(2).setLayoutX(20.0);
        pane.getChildren().get(2).setLayoutY(35.0);
        pane.getChildren().get(3).setLayoutX(80.0);
        pane.getChildren().get(3).setLayoutY(40.0);
        pane.getChildren().get(4).setLayoutX(20.0);
        pane.getChildren().get(4).setLayoutY(65.0);
        pane.getChildren().get(5).setLayoutX(80.0);
        pane.getChildren().get(5).setLayoutY(70.0);
        pane.getChildren().get(6).setLayoutX(20.0);
        pane.getChildren().get(6).setLayoutY(95.0);
        pane.getChildren().get(7).setLayoutX(80.0);
        pane.getChildren().get(7).setLayoutY(100.0);
        pane.getChildren().get(8).setLayoutX(120.0);
        pane.getChildren().get(8).setLayoutY(140.0);
        pane.getChildren().get(9).setLayoutX(20.0);
        pane.getChildren().get(9).setLayoutY(180.0);
        pane.getChildren().get(10).setLayoutX(100.0);
        pane.getChildren().get(10).setLayoutY(300.0);

        pane.setPadding(new Insets(10,10,0,10));
        pane.setBackground(new Background(new BackgroundFill(Color.GOLD, CornerRadii.EMPTY, Insets.EMPTY)));
        return pane;
    }

    private TilePane createStatBoxes(int value){
        TilePane tilePane = new TilePane();
        for(int i = 1; i <= 10; i++){
            Rectangle rect = new Rectangle();
            rect.setHeight(12);
            rect.setWidth(12);
            rect.setStroke(Color.RED);
            if(i <= value){
                tilePane.getChildren().add(rect);
                continue;
            }
            rect.setFill(Color.WHITE);
            tilePane.getChildren().add(rect);
        }
        tilePane.setPrefColumns(10);
        tilePane.setPadding(new Insets(10,10,0,10));
        return tilePane;
    }

    private GridPane createStatTable(Car car){

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);

        Label speed = new Label("Speed:");
        speed.setPadding(new Insets(5));
        speed.setFont(Font.font("Gill Sans MT Condensed", 20));

        Label handling = new Label("Handling:");
        handling.setPadding(new Insets(5));
        handling.setFont(Font.font("Gill Sans MT Condensed", 20));

        Label breakdownChance = new Label("Breakdown Chance:");
        breakdownChance.setPadding(new Insets(5));
        breakdownChance.setFont(Font.font("Gill Sans MT Condensed", 20));

        gridPane.add(speed, 0, 0);
        gridPane.add(createStatBoxes(car.getSpeed()), 1, 0);
        gridPane.add(handling, 0, 1);
        gridPane.add(createStatBoxes(car.getHandling()), 1, 1);
        gridPane.add(breakdownChance, 0, 2);
        gridPane.add(createStatBoxes(car.getBreakdownChance()), 1, 2);

        return gridPane;
    }

    private void updateCar(int num){
        int type = 0;
        int color = 0;
        int tires = 0;
        int engine = 0;
        String typeChoice = "";
        String colorChoice = "";
        String tireChoice = "";
        String engineChoice = "";

        switch(num){
            case 1:
                typeChoice = ((ChoiceBox<String>)carOnePane.getChildren().get(1)).getValue();
                colorChoice = ((ChoiceBox<String>)carOnePane.getChildren().get(3)).getValue();
                tireChoice = ((ChoiceBox<String>)carOnePane.getChildren().get(5)).getValue();
                engineChoice = ((ChoiceBox<String>)carOnePane.getChildren().get(7)).getValue();
                break;
            case 2:
                typeChoice = ((ChoiceBox<String>)carTwoPane.getChildren().get(1)).getValue();
                colorChoice = ((ChoiceBox<String>)carTwoPane.getChildren().get(3)).getValue();
                tireChoice = ((ChoiceBox<String>)carTwoPane.getChildren().get(5)).getValue();
                engineChoice = ((ChoiceBox<String>)carTwoPane.getChildren().get(7)).getValue();
                break;
            case 3:
                typeChoice = ((ChoiceBox<String>)carThreePane.getChildren().get(1)).getValue();
                colorChoice = ((ChoiceBox<String>)carThreePane.getChildren().get(3)).getValue();
                tireChoice = ((ChoiceBox<String>)carThreePane.getChildren().get(5)).getValue();
                engineChoice = ((ChoiceBox<String>)carThreePane.getChildren().get(7)).getValue();
                break;
        }
        switch (typeChoice) {
            case "Truck":
                type = 1;
                break;
            case "SUV":
                type = 2;
                break;
            case "Sports Car":
                type = 3;
                break;
        }
        switch (colorChoice) {
            case "Blue":
                color = 1;
                break;
            case "Green":
                color = 2;
                break;
            case "Pink":
                color = 3;
                break;
            case "Red":
                color = 4;
                break;
            case "Yellow":
                color = 5;
                break;
        }
        switch (tireChoice) {
            case "Off Road":
                tires = 1;
                break;
            case "Street":
                tires = 2;
                break;
            case "Sport":
                tires = 3;
                break;
        }
        switch (engineChoice) {
            case "V4":
                engine = 1;
                break;
            case "V6":
                engine = 2;
                break;
            case "V8":
                engine = 3;
                break;
        }
        switch (num){
            case 1:
                carOne = new Car(type,color,tires,engine);
                carOnePane.getChildren().set(10, carOne);
                carOnePane.getChildren().set(9, createStatTable(carOne));
                carOnePane.getChildren().get(9).setLayoutX(20.0);
                carOnePane.getChildren().get(9).setLayoutY(180.0);
                carOnePane.getChildren().get(10).setLayoutX(100.0);
                carOnePane.getChildren().get(10).setLayoutY(300.0);
                break;
            case 2:
                carTwo = new Car(type,color,tires,engine);
                carTwoPane.getChildren().set(10, carTwo);
                carTwoPane.getChildren().set(9, createStatTable(carTwo));
                carTwoPane.getChildren().get(9).setLayoutX(20.0);
                carTwoPane.getChildren().get(9).setLayoutY(180.0);
                carTwoPane.getChildren().get(10).setLayoutX(100.0);
                carTwoPane.getChildren().get(10).setLayoutY(300.0);
                break;
            case 3:
                carThree = new Car(type,color,tires,engine);
                carThreePane.getChildren().set(10, carThree);
                carThreePane.getChildren().set(9, createStatTable(carThree));
                carThreePane.getChildren().get(9).setLayoutX(20.0);
                carThreePane.getChildren().get(9).setLayoutY(180.0);
                carThreePane.getChildren().get(10).setLayoutX(100.0);
                carThreePane.getChildren().get(10).setLayoutY(300.0);
                break;
        }
    }

    public Scene scene(){
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        AnchorPane.setTopAnchor(lblTitle, 20.0);
        AnchorPane.setLeftAnchor(lblTitle, 420.0);

        AnchorPane.setTopAnchor(lblCarOne, 100.0);
        AnchorPane.setLeftAnchor(lblCarOne, 120.0);

        AnchorPane.setTopAnchor(lblCarTwo, 100.0);
        AnchorPane.setLeftAnchor(lblCarTwo, 470.0);

        AnchorPane.setTopAnchor(lblCarThree, 100.0);
        AnchorPane.setLeftAnchor(lblCarThree, 800.0);

        AnchorPane.setTopAnchor(carOnePane, 150.0);
        AnchorPane.setLeftAnchor(carOnePane, 10.0);

        AnchorPane.setTopAnchor(carTwoPane, 150.0);
        AnchorPane.setLeftAnchor(carTwoPane, 345.0);

        AnchorPane.setTopAnchor(carThreePane, 150.0);
        AnchorPane.setLeftAnchor(carThreePane, 680.0);

        AnchorPane.setBottomAnchor(btnContinue, 20.0);
        AnchorPane.setRightAnchor(btnContinue, 420.0);

        AnchorPane.setBottomAnchor(btnHelp, 20.0);
        AnchorPane.setRightAnchor(btnHelp, 20.0);

        anchorPane.getChildren().addAll(lblTitle, lblCarOne, lblCarTwo, lblCarThree, carOnePane, carTwoPane,
                carThreePane, btnContinue, btnHelp);

        Scene scene = new Scene(anchorPane, 1000, 600);
        return scene;
    }

    @Override
    public void handle(Event event){
        if(event.getSource() == update1){
            updateCar(1);
        }
        if(event.getSource() == update2){
            updateCar(2);
        }
        if(event.getSource() == update3){
            updateCar(3);
        }
        if(event.getSource() == btnHelp){
            AlertBox.showMessageDialogue("Help Menu", "Customize the three cars.\nClick the update " +
                    "button to see how your choices affect the car's look and stats.\nThe stats are out of ten and " +
                    "come in three categories:\n Speed\n Handling\n Breakdown Chance\nSpeed determines how fast the " +
                    "car will move through the track (Higher is better).\n Handling reduces the chance of spinning " +
                    "out slowing the car down (Higher is better).\n Breakdown chance increases the chance of " +
                    "breaking down and preventing the car from continuing (Lower is better)");
        }
        if(event.getSource() == btnContinue){
            GameGui.consume(event);
        }
    }
}
