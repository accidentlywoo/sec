package step2.treeset;

import java.util.Comparator;
import java.util.TreeSet;

class MyCompare implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2)*(-1);
	}
}
public class ComparatorTest2{
	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<String>(new MyCompare());
		treeSet.add("ȫ�浿");
		treeSet.add("�谭��");
		treeSet.add("�̼���");
		
		for(String str : treeSet) {
			System.out.println(str);
		}
	}
}
