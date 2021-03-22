//Shane Callahan
import java.io.FileInputStream;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Car extends Rectangle {//I am extending shape since I think this'll be necessary to paste the picture on the GUI, and to translate it.
    private Image image;
    private int tire;
    private int engine;
    private int type;
    private int color; // 1 = blue, 2 = green, 3 = pink, 4 = red, 5 = yellow
    private int speed = 0;
    private int handling = 0;
    private int breakdownChance = 0;
    public static final int X_SIZE = 200;
    public static final int Y_SIZE = 100;
    private int breakdownFlag;
    private int location; //1 = A, 2 = B, 3 = C, 4 = D
    private AtomicReference<Long> finalTime = new AtomicReference<>();
    private double time;

    public Car(){
        super(X_SIZE,Y_SIZE);
        tire = 1;
        engine = 1;
        type = 1;
        color = 1;
        this.setFill(new ImagePattern(setCarPicture(1, 1)));
        finalTime = new AtomicReference<>(0L);
        location = 1;
    }

    public Car(int type, int color, int tire, int engine){//Justin changed the order of my paramaters >:O i'm just playin'
        super(X_SIZE,Y_SIZE);


        this.tire = tire;
        setTiresEffect(tire);

        this.engine = engine;
        setEngineEffect(engine);

        this.type = type;
        this.color = color;
        image = setCarPicture(type, color);
        this.setFill(new ImagePattern(image));
    }


    public Image setCarPicture(int type, int color){//Takes the car type and car color to assign the car with a picture
        if(type == 1){
            speed +=1;
            handling +=7;
            if(color == 1){
                try {
                    FileInputStream inputstream = new FileInputStream("project_car_images\\truck\\blue.png"); 
                    image = new Image(inputstream);
                } catch (Exception e) {
                    System.out.println(e + " error loading blue truck");
                }
            }
            else if(color == 2){
                image = new Image("https://github.com/greenwolf5/CS225-Project-3/blob/main/project%20car%20images/truck/green.png?raw=true");
            }
            else if(color == 3){
                image = new Image("https://github.com/greenwolf5/CS225-Project-3/blob/main/project%20car%20images/truck/pink.png?raw=true");
            }
            else if(color == 4){
                image = new Image("https://github.com/greenwolf5/CS225-Project-3/blob/main/project%20car%20images/truck/red.png?raw=true");
            }
            else if(color == 5){
                image = new Image("https://github.com/greenwolf5/CS225-Project-3/blob/main/project%20car%20images/truck/yellow.png?raw=true");
            }
        }
        else if(type == 2){
            speed +=2;
            handling +=2;
            breakdownChance +=2;
            if(color == 1){
                image = new Image("https://github.com/greenwolf5/CS225-Project-3/blob/main/project%20car%20images/Jeep/blue.png?raw=true");
            }
            else if(color == 2){
                image = new Image("https://github.com/greenwolf5/CS225-Project-3/blob/main/project%20car%20images/Jeep/green.png?raw=true");
            }
            else if(color == 3){
                image = new Image("https://github.com/greenwolf5/CS225-Project-3/blob/main/project%20car%20images/Jeep/pink.png?raw=true");
            }
            else if(color == 4){
                image = new Image("https://github.com/greenwolf5/CS225-Project-3/blob/main/project%20car%20images/Jeep/red.png?raw=true");
            }
            else if(color == 5){
                image = new Image("https://github.com/greenwolf5/CS225-Project-3/blob/main/project%20car%20images/Jeep/yellow.png?raw=true");
            }
        }
        else if(type ==3){
            speed +=4;
            handling +=1;
            breakdownChance +=3;
            if(color == 1){
                image = new Image("https://github.com/greenwolf5/CS225-Project-3/blob/main/project%20car%20images/sports%20car/blue.png?raw=true");//PLACE HOLDER PICTURES
            }
            else if(color == 2){
                image = new Image("https://github.com/greenwolf5/CS225-Project-3/blob/main/project%20car%20images/sports%20car/green.png?raw=true");
            }
            else if(color == 3){
                image = new Image("https://github.com/greenwolf5/CS225-Project-3/blob/main/project%20car%20images/sports%20car/pink.png?raw=true");
            }
            else if(color == 4){
                image = new Image("https://github.com/greenwolf5/CS225-Project-3/blob/main/project%20car%20images/sports%20car/red.png?raw=true");
            }
            else if(color == 5){
                image = new Image("https://github.com/greenwolf5/CS225-Project-3/blob/main/project%20car%20images/sports%20car/yellow.png?raw=true");
            }
        }
        return image;
    }

    public void carFire(){ //Used when car breaks down, gets fire version 
        switch (type) {
            case 1:
                this.setFill(new ImagePattern(new Image("https://github.com/greenwolf5/CS225-Project-3/blob/main/project%20car%20images/truck/truck_fire.png?raw=true")));
                break;
            case 2:
                this.setFill(new ImagePattern(new Image("https://github.com/greenwolf5/CS225-Project-3/blob/main/project%20car%20images/Jeep/jeep_fire.png?raw=true")));
                break;
            case 3:
                this.setFill(new ImagePattern(new Image("https://github.com/greenwolf5/CS225-Project-3/blob/main/project%20car%20images/sports%20car/sport_fire.png?raw=true")));
                break;
        }
    }

    public void setTiresEffect(int tire){ //Each tire has a different speed and handling stat, this establishes that for the car
        if(tire ==1){
            speed +=1;
            handling +=3;
        }
        else if(tire ==2){
            speed +=2;
            handling +=2;
        }
        else if(tire == 3){
            speed +=3;
            handling +=1;
        }
    }

    public void setEngineEffect(int engine){ //Each engine has a different speed and breakdownchance stat, this establishes that for the car
        if(engine == 1){
            speed +=1;
        }
        if(engine ==2){
            speed +=2;
            breakdownChance +=2;
        }
        if(engine == 3){
            speed +=3;
            breakdownChance +=3;
        }
    }

    public boolean doBreakdownCheck(){ //checks if breakdownchance passes, if so, returns true
        Boolean breakdown = false;
        int carChance = (breakdownChance*10);
        Random randomGen = new Random();
        int breakChance = (randomGen.nextInt(100)+1);

        if(carChance > breakChance){
            breakdown = true;
        }
        return breakdown;
    }

    public boolean doHandlingCheck(){ //checks if handling check passes if so, returns true
        Boolean handleFailure = false;
        int carChance = (handling*10);
        Random randomGen = new Random();
        int handleChance = (randomGen.nextInt(100)+1);
        if(carChance < handleChance){
            handleFailure = true;
        }
        return handleFailure;
    }


    public void carMovement(int startLoc){ //Car movement method.
        int location = startLoc;
        SequentialTransition seqT = new SequentialTransition(this);//seqT is a sequence of animation for the car.
        Random random = new Random();
        TranslateTransition breakdown = new TranslateTransition();
        breakdown.setOnFinished(event -> this.carFire()); //When the car breaks down, after it finishes  it will call carFire()
        int turns = 0;

        final Long time = System.currentTimeMillis();

        seqT.setOnFinished(event -> finalTime.set(System.currentTimeMillis() - time)); //When the seqT finishes, set finalTime to the time it took for the car to finish racing.

        if(this.doBreakdownCheck()){
            int dur;
            switch (random.nextInt(4)){//breakdown check, each case is a different time when it'll break down, case 0 is the start, case 3 is right before it ends.
                case 0:
                    breakdown.setByX(300);
                    dur = (11 - this.getSpeed()) * 500;
                    breakdown.setDuration(Duration.millis(dur));
                    breakdownFlag = 1;
                    break;
                case 1:
                    breakdown.setByY(100);
                    dur = (11 - this.getSpeed()) * 250;
                    breakdown.setDuration(Duration.millis(dur));
                    breakdownFlag = 2;
                    break;
                case 2:
                    breakdown.setByX(-300);
                    dur = (11 - this.getSpeed()) * 500;
                    breakdown.setDuration(Duration.millis(dur));
                    breakdownFlag = 3;
                    break;
                case 3:
                    breakdown.setByY(-100);
                    dur = (11 - this.getSpeed()) * 250;
                    breakdown.setDuration(Duration.millis(dur));
                    breakdownFlag = 4;
                    break;
            }
        }

        while(turns < 4){
            if(location == breakdownFlag){
                seqT.getChildren().add(breakdown);
                seqT.setOnFinished(event -> finalTime.set(9999999L));//always the "slowest"
                seqT.play();
                return;//justin says this goes here lol
            }
            if(this.doHandlingCheck()){
                seqT.getChildren().add(spinOut());
            }
            seqT.getChildren().addAll(translate(location, this.getSpeed()),this.turn());

            turns++;

            location++;
            if(location == 5){
                location = 1;
            }
        }
        seqT.play();
    }

    private RotateTransition spinOut(){ //Spinout method
        RotateTransition spinOut = new RotateTransition(Duration.millis(2000));
        spinOut.setByAngle(360);
        return spinOut;
    }

    private RotateTransition turn(){ //Turning method
        RotateTransition turn = new RotateTransition(Duration.millis(500));
        turn.setByAngle(90);
        return turn;
    }

    private TranslateTransition translate(int location, int speed){//The bulk of getting the car to move.
        int durLong = (11 - speed) * 1000;
        double durShort = durLong / 1.8;
        TranslateTransition translateTransition = new TranslateTransition();
        switch (location){
            case 1:
                translateTransition.setByX(1120);
                translateTransition.setDuration(Duration.millis(durLong));
                break;
            case 2:
                translateTransition.setByY(610);
                translateTransition.setDuration(Duration.millis(durShort));
                break;
            case 3:
                translateTransition.setByX(-1120);
                translateTransition.setDuration(Duration.millis(durLong));
                break;
            case 4:
                translateTransition.setByY(-610);
                translateTransition.setDuration(Duration.millis(durShort));
                break;
        }
        return translateTransition;
    }


    public String getTireString(){//To get the String verson of the number, 1 = Off Road, 2 = Street, 3 = Sport.
        String s = "";
        switch (getTire()) {
            case 1:
                s = "Off Road";
                break;
            case 2:
                s = "Street";
                break;
            case 3:
                s = "Sport";
                break;
        }
        return s;
    }

    public String getEngineString(){//To get the string version of the number, 1 = V4, 2 = V6, 3 = V8
        String s = "";
        switch (getEngine()) {
            case 1:
                s = "V4";
                break;
            case 2:
                s = "V6";
                break;
            case 3:
                s = "V8";
                break;
        }
        return s;
    }

    public String getTypeString(){//To get the string version of the number, 1 = truck, 2 = SUV, 3 = Sports Car
        String s = "";
        switch (getType()) {
            case 1:
                s = "Truck";
                break;
            case 2:
                s = "SUV";
                break;
            case 3:
                s = "Sports Car";
                break;
        }
        return s;
    }
    public String getColorString(){//To get the string version of the number, 1 = Blue, 2 = Green, 3 = Pink, 4 = Red, 5 = Yellow
        String s = "";
        switch (getColor()) {
            case 1:
                s = "Blue";
                break;
            case 2:
                s = "Green";
                break;
            case 3:
                s = "Pink";
                break;
            case 4:
                s = "Red";
                break;
            case 5:
                s = "Yellow";
                break;
        }
        return s;
    }

    public String getLocationString(){//To get the string version of the number, 1 = A, 2 = B, 3 = C, 4 = D
        String s = "";
        switch (getLocation()) {
            case 1:
                s = "A";
                break;
            case 2:
                s = "B";
                break;
            case 3:
                s = "C";
                break;
            case 4:
                s = "D";
                break;
        }
        return s;
    }

    public String getPathString(){//To get the path of the car, if the starting is 1, the path is A-B-C-D, if 2, B-C-D-A etc.
        String s = "";
        switch (getLocation()) {
            case 1:
                s = "A-B-C-D";
                break;
            case 2:
                s = "B-C-D-A";
                break;
            case 3:
                s = "C-D-A-B";
                break;
            case 4:
                s = "D-A-B-C";
                break;
        }
        return s;
    }

    //getters and setters

    public Image getImage() {
        return image;
    }
    public int getTire() {
        return tire;
    }
    public int getEngine() {
        return engine;
    }
    public int getType() {
        return type;
    }
    public int getColor() {
        return color;
    }
    public int getSpeed() {
        return speed;
    }
    public int getHandling() {
        return handling;
    }
    public int getBreakdownChance() {
        return breakdownChance;
    }
    public int getLocation() {
        return location;
    }
    public AtomicReference<Long> getFinalTime() {
        return finalTime;
    }
    public double getTime() { //special one, uses finalTime to get Time, truncating the time to 2 numbers after . to prevent only one car to win, when a tie 
        double time = this.getFinalTime().get().doubleValue() / 1000;
        String s = String.format("%.2f", time);
        time = Double.parseDouble(s);
        return time;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setTire(int tire) {
        this.tire = tire;
    }
    public void setEngine(int engine) {
        this.engine = engine;
    }
    public void setType(int type) {
        this.type = type;
    }
    public void setColor(int color) {
        this.color = color;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setHandling(int handling) {
        this.handling = handling;
    }
    public void setBreakdownChance(int breakdownChance) {
        this.breakdownChance = breakdownChance;
    }
    public void setLocation(int location) {
        this.location = location;
    }
    public void setFinalTime(AtomicReference<Long> finalTime) {
        this.finalTime = finalTime;
    }
    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        String s = ("image is: " + getImage() + " and the tire type is: " + getTire() + " and the engine type is: " + getEngine() + " and the color type is: " +"and the type is " + getType()
        + getColor() + " and the speed is: " + getSpeed() + " and the handling is " + getHandling() + " and the breakdown chance is: " + getBreakdownChance() + " and the location is: "
         + getLocation() + " and the final time is: " + getFinalTime() + " and the time is: " + getTime());
        return s;
    }
}