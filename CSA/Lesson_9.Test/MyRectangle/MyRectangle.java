import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.awt.geom.AffineTransform;

/**
 * Primary java class: MyRectangle
 *
 * <pre>
 * Author:  Aaron Dill
 * Date:    05/10/2024
 * Course:  Computer Science I AP
 * Period:  3rd
 * </pre>
 *
 * Summary of file:
 *
 */
public class MyRectangle extends Rectangle {
  private String color = "black";
  private String borderColor;
  private boolean border;

  public MyRectangle() {
    super(1, 1);
  }

  public MyRectangle(int x, int y, int width, int height, String color, String borderColor, boolean hasBorder) {
    super(x, y, width, height);
    this.color = color;
    this.border = hasBorder;
    if (this.border) this.borderColor = borderColor;
  }

  public MyRectangle(int x, int y, int width, int height, String color) {
    super(x, y, width, height);
    this.color = color;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getBorderColor() {
    return borderColor == null ? "none" : borderColor;
  }

  public void setBorderColor(String borderColor) {
    this.border = true;
    this.borderColor = borderColor;
  }

  public boolean hasBorder() {
    return border;
  }

  public void setBorder(boolean hasBorder) {
    this.border = hasBorder;
  }

  // Rotate clockwise the rectangle the number of degrees stored in the parameter degrees using the upper left corner (x,y) as an anchor. Precondition - degrees will always be 90, 180 or 270. If not, no action is taken.
  public void rotate(int degrees) {
    if (degrees != 90 && degrees != 180 && degrees != 270) return;
    AffineTransform tfx = new AffineTransform();
    tfx.rotate(Math.toRadians(degrees), this.x, this.y);
    Rectangle bounds = tfx.createTransformedShape(this).getBounds();
    this.x = bounds.x;
    this.y = bounds.y;
    this.width = bounds.width;
    this.height = bounds.height;
  }

  public int area() {
    return this.width * this.height;
  }

  public int perimeter() {
    return 2 * (this.width + this.height);
  }

  @Override
  public Object clone() {
    return super.clone();
  }

  public MyRectangle copy() {
    return (MyRectangle) this.clone();
  }

  // Returns a String representation of the location, dimensions and colors of this rectangle. If there is no border, the border color is not printed.
  @Override
  public String toString() {
    List<String> list = new ArrayList<>();
    list.add("x = " + this.x);
    list.add("y = " + this.y);
    list.add("width = " + this.width);
    list.add("height = " + this.height);
    list.add("color = " + this.color);
    if (this.border) list.add("borderColor = " + this.borderColor);
    return String.join(" ", list);
  }

}
