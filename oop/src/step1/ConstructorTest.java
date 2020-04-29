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
		System.out.println("�������� : "+ getRadius()+"�� ���� ���̴�" + radiusArea);
	}
	
	public Circle(double radius) {
		this.radius = radius;
	}
}

class Rectangle{
	double width;
	double height;
	void printInfo() {
		System.out.println("���δ� : " + width + "���δ� : " +height);
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

}

public class ConstructorTest {

	public static void main(String[] args) {
		Circle c;
		c = new Circle(5); // �������� 5�� �� ��ü
		c.printInfo();
		
		Rectangle r = new Rectangle(3, 4);
		
		r.printInfo();
		
		Rectangle sq = new Rectangle(3);
		
		sq.printInfo();

	}
}
