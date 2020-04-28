package step1;

public class PersonTest {

	public static void main(String[] args) {
		Person p1 = new Person();
		/*
		 * Person p1;
		 * p1 = new Person(); // °´Ã¼ »ý¼º
		 */
		p1.id = "id1";
		p1.name = "n1";
		p1.pwd = "p1";
		p1.addr = "a1";
		System.out.println("¾Þ"+p1.ang);
		System.out.println("¾ÞÅ¬"+Person.ang);
		p1.work();
		p1.display();
		
		Person p2;
		p2 = new Person();
		p2.id = "id2";
		p2.pwd = "p2";
		p2.name = "n2";
		p2.addr = "a2";
		p2.work();
		p2.display();
		
		Person p3;
		p3 = p2;
		p3.display();
		System.out.println(p2==p3);
		System.out.println(p2.equals(p3));
	}
}
