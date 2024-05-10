import java.awt.Rectangle;

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
    super();
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
    switch (degrees) {
      case 90 -> {
      }
      case 180 -> {
      }
      case 270 -> {
      }
    }
  }

  public int area() {
    return this.width * this.height;
  }

  public int perimeter() {
    return 2 * (this.width + this.height);
  }

}
