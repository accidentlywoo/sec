package step1;
/**
 *  this ������ ���� ������� ��ü�� �ǹ��Ѵ�.
 *  �޼��忡�� ����� �� �ִ�
 *  this.�� ���� ������� ��ü�� ����
 * @author user
 *
 */
class A{
	int i;
	void m(int i) {
		this.i = i;
		// this�� �޼��忡���� ����� �����ϴ�.
	}
	A m2() {
		return this;
	}
}
public class ThisTest {
	public static void main(String[] args) {
		A a = new A();
		a.m(99);
		System.out.println(a.i); // 99
		A a2 = a.m2();
		System.out.println(a == a2);
	}
}
