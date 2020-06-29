package step2.treeset;

import java.util.HashSet;
import java.util.Iterator;


public class PersonTreeSet {
	private HashSet<Person> hashSet;
	
	public PersonTreeSet() {
		hashSet = new HashSet<Person>();
	}
	public void addPerson(Person personLee) {
		hashSet.add(personLee);
	}
	public boolean removePerson(String person_name) {
		Iterator<Person> ir = hashSet.iterator();
		while (ir.hasNext()) {
			Person person = ir.next();
			if(person.getName() == person_name) {
				hashSet.remove(person);
				return true;
			}
		}
		System.out.println(person_name + "가 존재하지 않습니다.");
		return false;
	}
	public void showAllPerson() {
		for(Person person : hashSet) {
			System.out.println(person);
		}
	}
	@Override
	public String toString() {
		return "PersonTreeSet [hashSet=" + hashSet + "]\r\n";
	}
}
