//importations
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

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
private Label lblPointA;
private Label lblPointB;
private Label lblPointC;	
private Label lblPointD;

//constructor
@SuppressWarnings("exports")
public Track(double distance, Rectangle rec1, Rectangle rec2, Pane pane, Line line, Color color, Label lblPointA,
		Label lblPointB, Label lblPointC, Label lblPointD) {
	
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

@SuppressWarnings("exports")
public Rectangle getRec1() {
	return rec1;
}

@SuppressWarnings("exports")
public void setRec1(Rectangle rec1) {
	this.rec1 = rec1;
}

@SuppressWarnings("exports")
public Rectangle getRec2() {
	return rec2;
}

@SuppressWarnings("exports")
public void setRec2(Rectangle rec2) {
	this.rec2 = rec2;
}

@SuppressWarnings("exports")
public Pane getPane() {
	return pane;
}

@SuppressWarnings("exports")
public void setPane(Pane pane) {
	this.pane = pane;
}

@SuppressWarnings("exports")
public Line getLine() {
	return line;
}

@SuppressWarnings("exports")
public void setLine(Line line) {
	this.line = line;
}

@SuppressWarnings("exports")
public Color getColor() {
	return color;
}

@SuppressWarnings("exports")
public void setColor(Color color) {
	this.color = color;
}

@SuppressWarnings("exports")
public Label getLblPointA() {
	return lblPointA;
}

@SuppressWarnings("exports")
public void setLblPointA(Label lblPointA) {
	this.lblPointA = lblPointA;
}

@SuppressWarnings("exports")
public Label getLblPointB() {
	return lblPointB;
}

@SuppressWarnings("exports")
public void setLblPointB(Label lblPointB) {
	this.lblPointB = lblPointB;
}

@SuppressWarnings("exports")
public Label getLblPointC() {
	return lblPointC;
}

@SuppressWarnings("exports")
public void setLblPointC(Label lblPointC) {
	this.lblPointC = lblPointC;
}

@SuppressWarnings("exports")
public Label getLblPointD() {
	return lblPointD;
}

@SuppressWarnings("exports")
public void setLblPointD(Label lblPointD) {
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
	
}
