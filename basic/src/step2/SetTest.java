package step2;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("�̼���");
		set.add("������");
		set.add("�谭��");
		set.add("�̼���");
		
		System.out.println(set);
		Iterator<String> ir = set.iterator();
		while(ir.hasNext()) {
			System.out.println(ir.next());
		}
	}
}
