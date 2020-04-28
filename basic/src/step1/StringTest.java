package step1;

public class StringTest {

	public static void main(String[] args) {
		String s1;
	
		String s2;

		s1 = new String("�쿩��");
		s2 = new String("�쿩��");
		
		System.out.println("s1 compare with operator s2 : "+s1 == s2);
		System.out.println(s1.length());
		System.out.println("s1 compare with equals s2 : "+s1.equals(s2));
		
		String s3, s4;
		s3 = "�쿩��";
		s4 = "�쿩��";
		
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));
		
		String s5 = "�л�";
		s1 = s1 + s5;
		System.out.println(s1);
		System.out.println(s1.toString());
		
		s1 = s2;
		
		System.out.println(s1.toString());
		
		s1 = null;
		System.out.println(s1);
		// System.out.println(s1.length()); Null Point Exception
		
	}
}
