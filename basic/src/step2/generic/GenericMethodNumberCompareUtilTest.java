package step2.generic;

public class GenericMethodNumberCompareUtilTest {
	public static void main(String[] args) {
//		String str = GenericMethodNumberCompareUtil.compare("a", "b");
		int result1 = GenericMethodNumberCompareUtil.compare(10, 20);
		System.out.println(result1);
		
		int result2 = GenericMethodNumberCompareUtil.compare(4.5, 3);
		System.out.println(result2);
	}
}
