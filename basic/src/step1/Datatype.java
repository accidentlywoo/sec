package step1;
class Datatype{
	public static void main(String[] args){
		byte b1; // ���� ����
		short s1, s2;
		int num;
		long large1;
		
		b1 = 1; //���� �� ����
		b1 = 2; 
		//b1 = 3.5;
	
		b1 = -128;
		//b1 = -129;
		b1 = 127;
		//b1 = 128;
		
		large1 = 1; // int ���ͷ�
		large1 = 1L; // long ���ͷ�(�빮�ڰ� �������� ����.)
		// �����ս� ���̾���.

		/*
		 * �ڵ� ����ȯ
		 * byte(1) -> short(2) -> int(4) -> long(8) -> float(4) -> double(8)
		 */

		double d; //8 ����Ʈ
		d = 12.3;

		float f; //4 ����Ʈ
		//f = 12.3; // �⺻ DoubleŸ���� ����. ������ ����
		f = 12.3F;
		f = (float)12.3; // ������ ��ȯ () : ĳ��Ʈ ������

		num = (int)f;

		System.out.println(f);

		System.out.println(num);

		System.out.println(123); // int Ÿ�� ���ͷ�

		System.out.println(123.45); // double Ÿ�� ���ͷ�

		//System.out.println(100000000000000000); // ������ ����

		System.out.println(100000000000000000L); // long Ÿ�� ���ͷ�


		// ��������ȯ : char -> int -> long -> float -> double
		char c; //2byte unicode
		c = 'A';
		c = 65;
		// ����, ������ ����, Ư������
		//c = '��';
		c = 44032;
		
		System.out.println(c);


		/*
		* UTF-8 �� ����ϸ� ����ڿ��� ASCII�ڵ常ŭ�� �޸𸮸� ����ϱ� ������ �޸� ���� ���� �� �ִ�.
		*/

		num = c;
		System.out.println(num);
		c = (char)num;
		System.out.println(c);

		c = 'A';
		System.out.println(c);
	
		c = 'A'+1;
		System.out.println(c);
		
		c = 'A'+2;
		System.out.println(c);

		System.out.println((char)('A'+3));

		boolean flag; // 1byte ����ȯ ����. (C, Python �� ����)
	
		flag = true;
		flag = false;
		//flag = 1; ������ ����

		int score; // ���� ����
		boolean study; // ���� ��������
		double avg; // ���
		char grade; // ����
	}
}