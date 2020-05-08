package com.my.abstracttest;
abstract class Shape{
	private double area;
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	abstract void calcArea();
	public void printInfo() {
		System.out.println("면적은 "+area+"입니다.");
	}
}

class Circle extends Shape{
	double radius;
	final double pi = 3.14;
	
	void calcArea() {
		setArea(Math.pow(radius, 2)*pi);
	}
	
	double getRadius() {
		return radius;
	}
	
	public void printInfo() {
		calcArea();
		System.out.print("반지름이  : "+ getRadius()+" 인 원의");
		super.printInfo();
	}
	
	public Circle(double radius) {
		this.radius = radius;
	}
}

class Rectangle extends Shape{
	double width;
	double height;
	double getWidth() {
		return width;
	}
	double getHeight() {
		return height;
	}
	public void setWidth(double width) {
		this.width = width;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public Rectangle(double width) {
		this(width, width);
	}

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	void calcArea() {
		setArea(width*height);
	}
	public void printInfo() {
		calcArea();
		System.out.print("가로 : "+width+" 세로 : "+height +"인 직각사각형의 ");
		super.printInfo();
	}
}

class Triangle extends Shape{
	double width; // 밑변
	double height; // 높이
	
	public Triangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	void calcArea() {
		setArea((width*height)/2.0D);
	}
	public void printInfo() {
		calcArea();
		System.out.print("가로 : "+width+" 세로 : "+height +"인 삼각형의 ");
		super.printInfo();
	}
}

public class ShapeTest {

	public static void main(String[] args) {
		Circle c;
		c = new Circle(5); 
		c.printInfo();
		
		Rectangle r = new Rectangle(3, 4);
		
		r.printInfo();
		
		Rectangle sq = new Rectangle(3);
		
		sq.printInfo();

		Triangle t = new Triangle(5, 5);
		t.printInfo();
		
		// Abstract Array 만들어보자!
		Shape[] shapes = new Shape[4];
		shapes[0] = c;
		shapes[1] = r;
		shapes[2] = sq;
		shapes[3] = t;
		for(Shape s : shapes) {
			s.printInfo();
			// s.getRadius
			// s.getWidth
			//s.getHeight
		}
	}
}
