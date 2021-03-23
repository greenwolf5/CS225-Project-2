//importations
import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author John E Youte
 *
 */

//variables
public class Track {
    private double distance;
    private Rectangle rec1;
    private Rectangle rec2;
    private Pane pane;
    private Line line;
    private Color color;
    private Text lblPointA;
    private Text lblPointB;
    private Text lblPointC;
    private Text lblPointD;
    private ArrayList<Line> laneHo;
    private ArrayList<Line> laneVer;

    //constructor
    public Track(double distance, Rectangle rec1, Rectangle rec2, Pane pane, Line line, Color color, Text lblPointA,
                 Text lblPointB, Text lblPointC, Text lblPointD) {

        this.distance = distance;
        this.rec1 = rec1;
        this.rec2 = rec2;
        this.pane = pane;
        this.line = line;
        this.color = color;
        this.lblPointA = lblPointA;
        this.lblPointB = lblPointB;
        this.lblPointC = lblPointC;
        this.lblPointD = lblPointD;
    }

    /**
     *
     */
//default constructor
    public Track() {
        this.distance = 0.0;
        this.rec1 = null;
        this.rec2 = null;
        this.pane = null;
        this.line = null;
        this.color = null;
        this.lblPointA = null;
        this.lblPointB = null;
        this.lblPointC = null;
        this.lblPointD = null;
    }

    //getters and setters
    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    
    public Rectangle getRec1() {
        return rec1;
    }

    
    public void setRec1(Rectangle rec1) {
        this.rec1 = rec1;
    }

    @SuppressWarnings("exports")
    public Rectangle getRec2() {
        return rec2;
    }

   
    public void setRec2(Rectangle rec2) {
        this.rec2 = rec2;
    }

    
    public Pane getPane() {
        return pane;
    }

    
    public void setPane(Pane pane) {
        this.pane = pane;
    }

    
    public Line getLine() {
        return line;
    }

    
    public void setLine(Line line) {
        this.line = line;
    }

   
    public Color getColor() {
        return color;
    }

    
    public void setColor(Color color) {
        this.color = color;
    }

    
    public Text getLblPointA() {
        return lblPointA;
    }

    
    public void setLblPointA(Text lblPointA) {
        this.lblPointA = lblPointA;
    }

    
    public Text getLblPointB() {
        return lblPointB;
    }

    
    public void setLblPointB(Text lblPointB) {
        this.lblPointB = lblPointB;
    }

   
    public Text getLblPointC() {
        return lblPointC;
    }

  
    public void setLblPointC(Text lblPointC) {
        this.lblPointC = lblPointC;
    }

    
    public Text getLblPointD() {
        return lblPointD;
    }

    
    public void setLblPointD(Text lblPointD) {
        this.lblPointD = lblPointD;
    }

    //toString method
    @Override
    public String toString() {
        return "Track [distance=" + distance + ", rec1=" + rec1 + ", rec2=" + rec2 + ", pane=" + pane + ", line=" + line
                + ", color=" + color + ", lblPointA=" + lblPointA + ", lblPointB=" + lblPointB + ", lblPointC=" + lblPointC
                + ", lblPointD=" + lblPointD + "]";
    }

    //equal method
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Track other = (Track) obj;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        if (Double.doubleToLongBits(distance) != Double.doubleToLongBits(other.distance))
            return false;
        if (lblPointA == null) {
            if (other.lblPointA != null)
                return false;
        } else if (!lblPointA.equals(other.lblPointA))
            return false;
        if (lblPointB == null) {
            if (other.lblPointB != null)
                return false;
        } else if (!lblPointB.equals(other.lblPointB))
            return false;
        if (lblPointC == null) {
            if (other.lblPointC != null)
                return false;
        } else if (!lblPointC.equals(other.lblPointC))
            return false;
        if (lblPointD == null) {
            if (other.lblPointD != null)
                return false;
        } else if (!lblPointD.equals(other.lblPointD))
            return false;
        if (line == null) {
            if (other.line != null)
                return false;
        } else if (!line.equals(other.line))
            return false;
        if (pane == null) {
            if (other.pane != null)
                return false;
        } else if (!pane.equals(other.pane))
            return false;
        if (rec1 == null) {
            if (other.rec1 != null)
                return false;
        } else if (!rec1.equals(other.rec1))
            return false;
        if (rec2 == null) {
            if (other.rec2 != null)
                return false;
        } else if (!rec2.equals(other.rec2))
            return false;
        return true;
    }

	/*
	 * This method creates the track, it basically return a pane, and that pane
	 * contain arrays of rectangles and Lines. and the method lane(), and Labels(),
	 * was initialized outside of the method Trackpainting(), because they would be
	 * too big.
	 */
    public Pane trackpainting() {
        Pane pane1 = new Pane();
        setRec1(new Rectangle(1500,950));
        setRec2(new Rectangle(700,300));
        rec1.setFill(Color.BLACK);
        rec1.setStroke(Color.RED);
        rec1.setStrokeWidth(5);
        rec2.setFill(Color.rgb(0,132,0));
        rec2.setLayoutX(430);
        rec2.setLayoutY(340);
        rec2.setStroke(Color.RED);
        rec2.setStrokeWidth(5);
        rec2.setStyle("-fx-background-color: #0e6b0e");

        pane1.getChildren().addAll(rec1,rec2);
  			for (int i = 0; i < 20; i++) {
            pane1.getChildren().addAll(lane());
        }
				for (int i = 0; i < 10; i++) {
            pane1.getChildren().addAll(lane2());
        }  pane1.getChildren().addAll(labels());
  		return pane1;
    }

	/*
	 * this method creates the horizontal lanes,which was later added inside of the
	 * pane in trackpainting(),this method creates 20 Lines by through out of a
	 * loop, and add these lines inside of an arrayList, which the method returns.
	 * and the layout x and y were incremented so the Lines could be in the right
	 * places.
	 */
    
    public ArrayList<Line> lane() {
        laneHo=new ArrayList<Line>();
        int incrementx=200; int incrementy=40;
        for (int i = 0; i < 20; i++) {
            laneHo.add(new Line());
            laneHo.get(i).setStyle("-fx-background-color: #81b214");
            laneHo.get(i).setStroke(Color.YELLOW);
            laneHo.get(i).setStrokeWidth(10);
            laneHo.get(i).setStartX(20.0);
            laneHo.get(i).setStartY(150.0);
            laneHo.get(i).setEndX(50.0);
            laneHo.get(i).setEndY(150.0);
            laneHo.get(i).setLayoutX(incrementx);
            laneHo.get(i).setLayoutY(incrementy);

            if (laneHo.size()<10) {
                incrementx +=120;
            }else if (laneHo.size()==10) {
                incrementy =650;
            }if(laneHo.size()>10){
                incrementy =650;
                incrementx -=120;
            }
        }return laneHo;
    }

    /*
	 * this method creates the vertical lanes,which was later added inside of the
	 * pane in trackpainting(),this method creates 20 Lines by through out of a
	 * loop, and add these lines inside of an arrayList, which the method returns.
	 * and the layout x and y were incremented so the Lines could be in the right
	 * places.
	 */
    public ArrayList<Line> lane2(){
        laneVer=new ArrayList<Line>();
        int incrementx=180; int incrementy=100;
        for (int i = 0; i < 10; i++) {
            laneVer.add(new Line());
            laneVer.get(i).setRotate(90);
            laneVer.get(i).setStyle("-fx-background-color: #81b214");
            laneVer.get(i).setStroke(Color.YELLOW);
            laneVer.get(i).setStrokeWidth(10);
            laneVer.get(i).setStartX(20.0);
            laneVer.get(i).setStartY(150.0);
            laneVer.get(i).setEndX(50.0);
            laneVer.get(i).setEndY(150.0);
            laneVer.get(i).setLayoutX(incrementx);
            laneVer.get(i).setLayoutY(incrementy);

            if (laneVer.size()<5) {
                incrementy +=120;
            }else if (laneVer.size()==5) {
                incrementx=1300;
            }if(laneVer.size()>5){
                incrementy -=120;
            }
        }
        return laneVer;
    }

	/*
	 * //this method creates the points and place them in corners. and all of them
	 * were added inside of an arrayList of type text. which is what the method returns.
	 */
    public ArrayList<Text> labels() {
        ArrayList<Text> labels=new ArrayList<Text>();
        lblPointA=new Text(10,50, "A");
        lblPointA.setFont(new Font("Arial", 50));
        lblPointA.setFill(Color.WHITE);
        lblPointA.setStroke(Color.RED);

        lblPointB=new Text(1460,50, "B");
        lblPointB.setFont(new Font("Arial", 50));
        lblPointB.setFill(Color.WHITE);
        lblPointB.setStroke(Color.RED);

        lblPointC=new Text(1460,940, "C");
        lblPointC.setFont(new Font("Arial", 50));
        lblPointC.setFill(Color.WHITE);
        lblPointC.setStroke(Color.RED);

        lblPointD=new Text(10,940, "D");
        lblPointD.setFont(new Font("Arial", 50));
        lblPointD.setFill(Color.WHITE);
        lblPointD.setStroke(Color.RED);

        labels.add(lblPointA);
        labels.add(lblPointB);
        labels.add(lblPointC);
        labels.add(lblPointD);

        return labels;
    }



}
