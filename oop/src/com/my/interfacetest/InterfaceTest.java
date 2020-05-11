package com.my.interfacetest;

interface Pet{
	void play();
}
interface Robot{
	void service();
}
class Animal{
	void move() {
		System.out.println("움직인다");
	}
}
class Dog extends Animal implements Pet{
	public void play() {
		System.out.println("공놀이를 한다");
	}
}

class Cat extends Animal implements Pet, Robot{
	@Override
	public void service() {
		System.out.println("쥐를 잡는다");
	}
	@Override
	public void play() {
		System.out.println("나무에 오른다");		
	}
}

public class InterfaceTest {
	public static void test(Animal a) {
		a.move();
	}
	public static void test(Pet p) {
		p.play();
	}
	public static void test(Robot r) {
		r.service();
	}
	public static void main(String[] args) {
		Dog d = new Dog();
		test((Animal)d);
		test((Pet)d);
		test((Robot)d);
		
		Cat c = new Cat();
		test((Animal)c);
		test((Pet)c);
		test((Robot)c);		
	}
}