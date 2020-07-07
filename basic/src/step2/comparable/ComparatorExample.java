package step2.comparable;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparatorExample {
	public static void main(String[] args) {
//		TreeSet<Fruit> treeSet = new TreeSet<Fruit>();
//		treeSet.add(new Fruit("µþ±â", 10000));
		// Runtime Error ¹ß»ý
		TreeSet<Fruit> treeSet = new TreeSet<Fruit>(new DescendingComparator());
		treeSet.add(new Fruit("µþ±â", 10000));
		treeSet.add(new Fruit("¼ö¹Ú", 3000));
		treeSet.add(new Fruit("Æ÷µµ", 6000));
		Iterator<Fruit> iterator = treeSet.iterator();
		while(iterator.hasNext()) {
			Fruit fruit = iterator.next();
			System.out.println(fruit.name + " : " + fruit.price);
		}
	}
}
