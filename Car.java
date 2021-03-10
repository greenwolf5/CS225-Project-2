import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public class Car extends Shape {//I am extending shape since I think this'll be necessary to paste the picture on the GUI, and to translate it.
    private Image image;
    private int tire;
    private int engine;
    private int type;
    private int color;
    private int speed = 0;
    private int handling = 0;
    private int breakdownChance = 0;

       //add the rectangle constructor for size and adding the picture
    //Method in car class: check for breakdown chance
    //Method for handling check.

    public Car(){
        image = new Image("");
        tire = 0;
        engine = 0;
        type = 0;
        color = 0;
    }

    public Car(int tire, int engine, int type, int color){
        this.type = type;
        this.color = color;
        image = setCarPicture(type, color);
        this.tire = tire;
        setTiresEffect(tire);
        this.engine = engine;
        setEngineEffect(engine);
    }


    public Image setCarPicture(int type, int color){
        if(type == 1){
            speed +=1;
            handling +=1;
            breakdownChance +=1;
            if(color == 1){
                image = new Image("https://www.pinclipart.com/picdir/middle/568-5688686_cars-top-view-png-car-top-down-view.png");//PLACE HOLDER PICTURES
            }
            else if(color == 2){
                image = new Image("https://www.pinclipart.com/picdir/middle/568-5688686_cars-top-view-png-car-top-down-view.png");
            }
            else if(color == 3){
                image = new Image("https://www.pinclipart.com/picdir/middle/568-5688686_cars-top-view-png-car-top-down-view.png");
            }
            else if(color == 4){
                image = new Image("https://www.pinclipart.com/picdir/middle/568-5688686_cars-top-view-png-car-top-down-view.png");
            }
            else if(color == 5){
                image = new Image("https://www.pinclipart.com/picdir/middle/568-5688686_cars-top-view-png-car-top-down-view.png");
            }
        }
        else if(type == 2){
            speed +=2;
            handling +=2;
            breakdownChance +=2;
            if(color == 1){
                image = new Image("https://www.pinclipart.com/picdir/middle/568-5688686_cars-top-view-png-car-top-down-view.png");//PLACE HOLDER PICTURES
            }
            else if(color == 2){
                image = new Image("https://www.pinclipart.com/picdir/middle/568-5688686_cars-top-view-png-car-top-down-view.png");
            }
            else if(color == 3){
                image = new Image("https://www.pinclipart.com/picdir/middle/568-5688686_cars-top-view-png-car-top-down-view.png");
            }
            else if(color == 4){
                image = new Image("https://www.pinclipart.com/picdir/middle/568-5688686_cars-top-view-png-car-top-down-view.png");
            }
            else if(color == 5){
                image = new Image("https://www.pinclipart.com/picdir/middle/568-5688686_cars-top-view-png-car-top-down-view.png");
            }
        }
        else if(type ==3){
            speed +=3;
            handling +=3;
            breakdownChance +=3;
            if(color == 1){
                image = new Image("https://www.pinclipart.com/picdir/middle/568-5688686_cars-top-view-png-car-top-down-view.png");//PLACE HOLDER PICTURES
            }
            else if(color == 2){
                image = new Image("https://www.pinclipart.com/picdir/middle/568-5688686_cars-top-view-png-car-top-down-view.png");
            }
            else if(color == 3){
                image = new Image("https://www.pinclipart.com/picdir/middle/568-5688686_cars-top-view-png-car-top-down-view.png");
            }
            else if(color == 4){
                image = new Image("https://www.pinclipart.com/picdir/middle/568-5688686_cars-top-view-png-car-top-down-view.png");
            }
            else if(color == 5){
                image = new Image("https://www.pinclipart.com/picdir/middle/568-5688686_cars-top-view-png-car-top-down-view.png");
            }
        }
        return image;
    }

    public void setTiresEffect(int tire){
        if(tire ==1){
            speed +=1;
            handling +=1;
        }
        else if(tire ==2){
            speed +=2;
            handling +=2;
        }
        else if(tire == 3){
            speed +=3;
            handling +=3;
        }
    }

    public void setEngineEffect(int engine){
        if(engine == 1){
            speed +=1;
            breakdownChance +=1;
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
    public int getSpeedVariable() {
        return speed;
    }
    public int getHandlingVariable() {
        return handling;
    }
    public int getBreakdownChanceVariable() {
        return breakdownChance;
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
    public void setSpeedVariable(int speedVariable) {
        this.speed = speedVariable;
    }
    public void setHandlingVariable(int handlingVariable) {
        this.handling = handlingVariable;
    }
    public void setBreakdownChanceVariable(int breakdownChanceVariable) {
        this.breakdownChance = breakdownChanceVariable;
    }
}