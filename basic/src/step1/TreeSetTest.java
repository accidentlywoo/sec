package step1;

import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.add("�̼���");
		treeSet.add("������");
		treeSet.add("ȫ�浿");
		
		for(String str : treeSet) {
			System.out.println(str);
			//String�� �̹� Comparable<String>�� �����ؼ� ������ �ȴ�.
		}
	}
}
