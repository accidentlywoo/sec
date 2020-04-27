package step1;
class RockScissorsPaper{
	public static void main(String[] args){
		java.util.Scanner sc;
		sc = new java.util.Scanner(System.in);
		
		System.out.println("가위바위보 게임! 가위 : 1, 바위 : 2, 보 : 3");
		
		int u = sc.nextInt();

		double r = Math.random();
		int m = (int)(r * 3 + 1);
		
		if(u == m){
			System.out.println("무승부");
		}else if(u == 1 && m == 3){
			System.out.println("승리");			
		}else if(u == 2 && m == 1){
			System.out.println("승리");			
		}else if(u == 3 && m == 2){
			System.out.println("승리");			
		}else{
			System.out.println("패배");
		}
		// 3으로 나눈 나머지 값으로 승패를 구할 수 있다.
		/*
		if(u == m)
			System.out.println("무승부");
		else if(u == (m%3)+1)
			System.out.println("승리");					
		else
			System.out.println("패배");
		*/
	}
}