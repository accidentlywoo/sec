package step2.generic;

public class GenericMethodNumberCompareUtil {
	public static <T extends Number> int compare(T t1, T t2) {
		double v1 = t1.doubleValue(); // Number�� doubleValue() �޼ҵ� ���
		double v2 = t2.doubleValue(); // Number�� doubleValue() �޼ҵ� ���
		return Double.compare(v1, v2);
	}
}
