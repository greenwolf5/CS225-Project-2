//Shane Callahan
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

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
    public static final int Y_SIZE = 200;

    //add the rectangle constructor for size and adding the picture

    public Car(){
        super(X_SIZE,Y_SIZE);
        tire = 1;
        engine = 1;
        type = 1;
        color = 1;
        this.setFill(new ImagePattern(setCarPicture(1, 1)));
    }

    public Car(int tire, int engine, int type, int color){
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


    public Image setCarPicture(int type, int color){
        if(type == 1){
            speed +=1;
            handling +=1;
            if(color == 1){
                image = new Image("https://github.com/greenwolf5/CS225-Project-3/blob/main/project%20car%20images/truck/blue.png?raw=true");
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
            handling +=3;
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
        "and the type is " + getType() + " and the speed is: " + getSpeed() + " and the handling is " + getHandling() + " and the breakdown chance is: " + getBreakdownChance() );
        return s;
    }
}