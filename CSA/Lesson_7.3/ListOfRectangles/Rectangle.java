class Rectangle {
  private double length;
  private double width;

  public Rectangle(double length, double width) {
    this.length = length;
    this.width = width;
  }

  public double area() {
    return getLength() * getWidth();
  }

  public double getLength() {
    return length;
  }

  public double getWidth() {
    return width;
  }

}
