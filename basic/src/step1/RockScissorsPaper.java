package step1;
class RockScissorsPaper{
	public static void main(String[] args){
		java.util.Scanner sc;
		sc = new java.util.Scanner(System.in);
		
		System.out.println("���������� ����! ���� : 1, ���� : 2, �� : 3");
		
		int u = sc.nextInt();

		double r = Math.random();
		int m = (int)(r * 3 + 1);
		
		if(u == m){
			System.out.println("���º�");
		}else if(u == 1 && m == 3){
			System.out.println("�¸�");			
		}else if(u == 2 && m == 1){
			System.out.println("�¸�");			
		}else if(u == 3 && m == 2){
			System.out.println("�¸�");			
		}else{
			System.out.println("�й�");
		}
		// 3���� ���� ������ ������ ���и� ���� �� �ִ�.
		/*
		if(u == m)
			System.out.println("���º�");
		else if(u == (m%3)+1)
			System.out.println("�¸�");					
		else
			System.out.println("�й�");
		*/
	}
}