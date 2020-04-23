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
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("1, ");
		for(int i = 0; i < cnt; i++) {
			int current = b + b2;
			System.out.print(current + ", ");
			b = b2;
			b2 = current;
		}
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("종료하려면 'q'를 입력하세여...");
			String s = sc.nextLine();
			if(s.equals("q"))
				break; 
		}
		// -> break 문을 사용하면 퍼포먼스가 안좋다.....?
		// 좋은 코드는 무엇일까?
		
		System.out.println("----------------");
		String s;
		do {
			System.out.print("입력하세요. [종료하려면 q를 입력하세요] : ");
			s = sc.nextLine();
			System.out.println("사용자가 입력한 값 : " + s);
		}while(!s.equals("q"));
		
		// do - while 구문은 무조건 한건이상 출력이 된다.
		
	}
}
