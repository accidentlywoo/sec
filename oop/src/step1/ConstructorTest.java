package step1;

class Circle {
	double radius;
	final double pi = 3.14;
	double radiusArea;
	
	void calcArea() {
		radiusArea = (radius*radius)*pi;
	}
	
	double getRadius() {
		return radius;
	}
	
	void printInfo() {
		calcArea();
		System.out.println("반지름이 : "+ getRadius()+"인 원의 넓이는" + radiusArea);
	}
	
	public Circle(double radius) {
		this.radius = radius;
	}
}

class Rectangle{
	double width;
	double height;
	void printInfo() {
		System.out.println("가로는 : " + width + "세로는 : " +height);
	}
	
	double getWidth() {
		return width;
	}
	double getHeight() {
		return height;
	}
	
	public Rectangle(double width) {
		this(width, width);
	}

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Rectangle rectangle = (Rectangle) o;
		return Double.compare(rectangle.width, width) == 0 &&
				Double.compare(rectangle.height, height) == 0;
	}

}

public class ConstructorTest {

	public static void main(String[] args) {
		Circle c;
		c = new Circle(5); // 반지름이 5인 원 객체
		c.printInfo();
		
		Rectangle r = new Rectangle(3, 4);
		
		r.printInfo();
		
		Rectangle sq = new Rectangle(3);
		
		sq.printInfo();

	}
}
