import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Car extends Rectangle {//I am extending shape since I think this'll be necessary to paste the picture on the GUI, and to translate it.
    private Image image;
    private int tire;
    private int engine;
    private int type;
    private int color;
    private int speed = 0;
    private int handling = 0;
    private int breakdownChance = 0;

    //add the rectangle constructor for size and adding the picture

    public Car(){
        image = new Image("");
        tire = 0;
        engine = 0;
        type = 0;
        color = 0;
    }

    public Car(int tire, int engine, int type, int color, int xSize, int ySize){
        super(xSize,ySize);
        
        this.tire = tire;
        setTiresEffect(tire);

        this.engine = engine;
        setEngineEffect(engine);

        this.type = type;
        this.color = color;
        image = setCarPicture(type, color);
    }


    public Image setCarPicture(int type, int color){
        if(type == 1){
            speed +=1;
            handling +=1;
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
            speed +=4;
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

    public boolean doBreakdownCheck(){// 0,1,2,3,(4,5,6) (,7,8,9,10)
        Boolean breakdown = false;
        int x;
        Random randomGen = new Random();
        if(breakdownChance <= 3){ //if breakdown chance is 3 it will NEVER Breakdown.
            breakdown = false;
        }
        else if(breakdownChance <= 6){
            x = randomGen.nextInt(3);//0-2, three chances, 2 to pass. one to fail (placeholder values)
            if(x == 0){
                breakdown = true;
            }
        }
        else{
            x = randomGen.nextInt(2);//0-1 two chances, one to pass, one to fail (placeholder values)
            if(x == 0){
                breakdown = true;
            }
        }
        return breakdown;
    }

    public boolean doHandlingCheck(){// 0,1,2,3,(4,5,6) (,7,8,9,10)
        Boolean handleFailure = false;
        int x;
        Random randomGen = new Random();
        if(handling <= 3){ //if breakdown chance is 3. it will NEVER Breakdown.
            handleFailure = false;
        }
        else if(handling <=6){
            x = randomGen.nextInt(3);//0-2, three chances, 2 to pass. one to fail (placeholder values)
            if(x == 0){
                handleFailure = true;
            }
        }
        else{
            x = randomGen.nextInt(2);//0-1 two chances, one to pass, one to fail (placeholder values)
            if(x == 0){
                handleFailure = true;
            }
        }
        return handleFailure;
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
    public int getSpeed() {
        return speed;
    }
    public int getHandling() {
        return handling;
    }
    public int getBreakdownChance() {
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
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setHandling(int handling) {
        this.handling = handling;
    }
    public void setBreakdownChance(int breakdownChance) {
        this.breakdownChance = breakdownChance;
    }

    @Override
    public String toString() {
        String s = ("image is: " + getImage() + " and the tire type is: " + getTire() + " and the engine type is: " + getEngine() + " and the color type is: " + getColor() +
        " and the speed is: " + getSpeed() + " and the handling is " + getHandling() + " and the breakdown chance is: " + getBreakdownChance() );
        return s;
    }
}