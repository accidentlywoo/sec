package step1;
class Child{
	int iv;

	@Override
	public String toString() {
		return "Child객체의 정보값은 "+this.iv+"입니다.";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + iv;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Child other = (Child) obj;
		if (iv != other.iv)
			return false;
		return true;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if(obj instanceof Child) {
//			return this.iv == ((Child)obj).iv;
//		}
//		return false;
//	}
//  Overloading하면 우선순위가 높아진다. But Overriding 효과를 볼 수 없다.!!!!
//	public boolean equals(Child obj) {
//		return this.iv == obj.iv;
//	}
}
public class ObjectTest {
	
	public static void test(Object object1, Object object2) {
		System.out.println("=======test()=========");
		System.out.println(object1.equals(object2));
		System.out.println("=========fin===========");
	}
	
	public static void main(String[] args) {
		Object o1, o2;
		o1 = new Object();
		o2 = new Object();
		
		//hashCode() 객체의 int형 해쉬코드값(객체 정보)을 반환
		System.out.println("o1 : "+o1.hashCode());
		System.out.println("o2 : "+o2.hashCode());
		
		//toString() : 객체정보(클래스이름@16진수해시코드) 문자열을 반환한
		System.out.println("o1 : "+o1.toString());
		System.out.println("o2 : "+o2.toString());
		
		// Object에서 equals()는 '=='과 같다.
		System.out.println("equals"+o1.equals(o2));
		
		String s1, s2;
		
		s1 = new String("우여니");
		s2 = new String("우여니");
		
		System.out.println("String equals : " + (s1 == s2));
		System.out.println("s1 String hashCode : " + s1.hashCode());
		// String의 재정의된 메서드
		System.out.println("s2 String hashCode : " + s2.hashCode());
		
		System.out.println("s1 String toString : " + s1.toString());
		System.out.println("s2 String toString : " + s2.toString());
		
		System.out.println(s1.equals(s2));
		
		StringBuffer sb1, sb2;
		
		sb1 = new StringBuffer("우여니");
		sb2 = new StringBuffer("우여니");
		
		System.out.println("sb1 String hashCode : " + sb1.hashCode());
		System.out.println("sb2 String hashCode : " + sb2.hashCode());
		
		System.out.println(sb1.equals(sb2));
		System.out.println(sb1.toString().equals(sb2.toString()));
		
		Child c1, c2;
		c1 = new Child();
		c1.iv = 5;
		c2 = new Child();
		c2.iv = 5;
		
		System.out.println(c1.toString());
		System.out.println("custom equals : "+c1.equals(c2));
		
		test(new Object(), new Object());
		test(s1, s2);
		test(c1, c2);
		
	}
}
