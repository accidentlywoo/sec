package step2.comparable;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparableExample {
	public static void main(String[] args) {
		TreeSet<Person> treeSet = new TreeSet<Person>();
		
		treeSet.add(new Person("È«±æµ¿", 45));
		treeSet.add(new Person("±èÀÚ¹Ù", 25));
		treeSet.add(new Person("Çæ·¡À×", 31));
		
		Iterator<Person> iterator = treeSet.iterator();
		while(iterator.hasNext()) {
			Person person = iterator.next();
			System.out.println(person.getName() + " : " + person.getAge());
		}
	}
}
