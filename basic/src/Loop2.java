import java.util.Scanner;

public class Loop2 {
	public static void main(String[] args) {
		int cnt = 5;
		for(int i = 0; i < cnt; i++) 
			System.out.println("h1");
		
		
		for(int i =0; i <cnt;i++ )
			System.out.println(i);
		
		for(int i =0; i <cnt;)
			System.out.println(i++);
		
		for(int i = 0 ; i < cnt; i++) 
			System.out.println(1+2*i);
		
		int b = 0;
		int b2 = 1;
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		System.out.print("1, ");
		for(int i = 0; i < cnt; i++) {
			int current = b + b2;
			System.out.print(current + ", ");
			b = b2;
			b2 = current;
		}
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("�����Ϸ��� 'q'�� �Է��ϼ���...");
			String s = sc.nextLine();
			if(s.equals("q"))
				break; 
		}
		// -> break ���� ����ϸ� �����ս��� ������.....?
		// ���� �ڵ�� �����ϱ�?
		
		System.out.println("----------------");
		String s;
		do {
			System.out.print("�Է��ϼ���. [�����Ϸ��� q�� �Է��ϼ���] : ");
			s = sc.nextLine();
			System.out.println("����ڰ� �Է��� �� : " + s);
		}while(!s.equals("q"));
		
		// do - while ������ ������ �Ѱ��̻� ����� �ȴ�.
		
	}
}
