package step2;

import java.util.Iterator;
import java.util.TreeSet;

import step1.Person;

public class MemberHashSet {
	private TreeSet<Person> treeSet;
	
	public MemberHashSet() {
		treeSet = new TreeSet<Person>();
	}
	public void addPerson(Person person) {
		treeSet.add(person);
	}
	public boolean removePerson(String person_name) {
		Iterator<Person> ir = treeSet.iterator();
		while (ir.hasNext()) {
			Person person = ir.next();
			if(person.getName() == person_name) {
				treeSet.remove(person);
				return true;
			}
		}
		System.out.println(person_name + "가 존재하지 않습니다.");
		return false;
	}
	public void showAllPerson() {
		for(Person person : treeSet) {
			System.out.println(person);
		}
	}
}
