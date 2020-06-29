package step1;

import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.add("이순신");
		treeSet.add("감강찬");
		treeSet.add("홍길동");
		
		for(String str : treeSet) {
			System.out.println(str);
			//String이 이미 Comparable<String>을 구현해서 정렬이 된다.
		}
	}
}
