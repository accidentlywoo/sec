package step2.treeset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;


public class PersonTreeSet {
	private TreeSet<Person> treeSet;
	
	public PersonTreeSet() {
		treeSet = new TreeSet<Person>();
	}
	public void addPerson(Person personLee) {
		treeSet.add(personLee);
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
	@Override
	public String toString() {
		return "PersonTreeSet [hashSet=" + treeSet + "]\r\n";
	}
}
