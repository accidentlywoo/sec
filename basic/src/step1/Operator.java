package step1;
class Operator{
	public static void main(String[] args){
		System.out.println("¦������ ���� ���ڸ� �Է��ϼ���");
		int a;
		//a = 100;

		java.util.Scanner sc;
		sc = new java.util.Scanner(System.in);

		a = sc.nextInt();

		// a�������� ¦���̸� true�� ���
		//	     Ȧ���̸� false�� ���
		int b = a%2;
		System.out.println(b == 0 ? "¦" : "Ȧ");

		// ������ �ڵ�����ȯ	
		short s1, s2, s3;
		s1 = 5;
		s2 = 8;
		s3 = (short)(s1 + s2);

		System.out.println(s3);

		byte c;
		c = 127;
		c++;
		System.out.println(c);

		// ������ ������
		int num = 6;
		//System.out.println(num/0); ArithmeticException
		System.out.println(num / 3.5);

		System.out.println("��ձ��� ������ �Է��Ͻÿ�");

		System.out.println("��� �Է��Ͻÿ� : ");
		int korean = sc.nextInt();

		System.out.println("���и� �Է��Ͻÿ� : ");
		int methmatics = sc.nextInt();

		System.out.println("��� �Է��Ͻÿ� : ");
		int english = sc.nextInt();
		float avg = (korean + methmatics + english )/3F;

		System.out.println("����� " + avg +"�� �Դϴ�.");
		System.out.println(((int)(avg*10))/10F);
	}
}