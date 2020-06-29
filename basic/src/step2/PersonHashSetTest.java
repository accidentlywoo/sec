package step2;

import step1.Person;

public class PersonHashSetTest {
	public static void main(String[] args) {
		MemberHashSet manager = new MemberHashSet();
		Person personLee = new Person(1,"Lee", 3);
		Person personKim = new Person(2, "Kim", 7);
		Person personPark = new Person(3, "Park", 8);
		Person personLim = new Person(4, "Lim", 2);
		
		manager.addPerson(personLee);
		manager.addPerson(personKim);
		manager.addPerson(personPark);
		manager.addPerson(personLim);
		
		manager.showAllPerson();
		
		System.out.println("---------------");
		manager.removePerson("Lee");
		manager.showAllPerson();
		
		System.out.println("---------------");
		Person personLim2 = new Person(4, "Lim", 5);
		manager.addPerson(personLim2);
		manager.showAllPerson();
		//중복값을 이름별로 관리하고 싶다면, equals와 hashcode를 작성하자
		
	}
}
