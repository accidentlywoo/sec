package step1;
/**
 *  this 예약어는 현재 사용중인 객체를 의미한다.
 *  메서드에서 사용할 수 있다
 *  this.은 현재 사용중인 객체를 참조
 * @author user
 *
 */
class A{
	int i;
	void m(int i) {
		this.i = i;
		// this는 메서드에서만 사용이 가능하다.
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
