public class MyRectangleTest {

	public static void main(String[] args) {
		MyRectangle mr1 = new MyRectangle(0,0,4,2,"blue","red",true);
		MyRectangle mr2 = new MyRectangle(5,5,10,3,"green");
		MyRectangle mr3 = new MyRectangle();
		mr3.setColor("pink");
		mr3.setBorder(true);
		mr3.setBorderColor("orange");
		MyRectangle mr4 = mr2.copy();
		mr4.setBorder(true);
		mr4.setBorderColor("black");
		mr4.rotate(180);
		if(!mr2.hasBorder())
			{
			mr2.setBorder(true);
			mr2.setBorderColor("purple");
			}
		mr3.setBorderColor(mr1.getBorderColor());
		mr1.setBorder(false);
		System.out.println(mr1 + " " + "area = " + mr1.area() + " perimeter = " + mr1.perimeter());
		System.out.println(mr2 + " " + "area = " + mr2.area() + " perimeter = " + mr2.perimeter());
		System.out.println(mr3 + " " + "area = " + mr3.area() + " perimeter = " + mr3.perimeter());
		System.out.println(mr4 + " " + "area = " + mr4.area() + " perimeter = " + mr4.perimeter());
	}
}
