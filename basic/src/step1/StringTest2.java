package step1;

import java.util.Scanner;

public class StringTest2 {

	public static void main(String[] args) {
		String pStr ="ABCDCBA"; //�Ӹ���� ���ڿ� �� �ڷ� �д� ������ �Ȱ���. �丶�� ABBA
		System.out.println(pStr.charAt(2));
		int size = pStr.length();
		System.out.println(size);
		// 1) ���ڿ��� �߰���ġ ���
		int midPoint = size/2; // �ݺ����� ���ǿ��� ������ ����ϸ� �ݺ�ȿ���� ���� �ʴ�.
		// 2) ù��° ���� pStr.charArt(0) ���� ������ ����
		boolean flag = true;
		for(int i = 0; i < midPoint; i ++) {
			if(pStr.charAt(i) != pStr.charAt(size-(i+1))) {
				flag = false;
			}
		}
		if(flag)
			System.out.println("�Ӹ���� ���ڿ��Դϴ�.");
		else
			System.out.println("�Ӹ���� ���ڿ��� �ƴմϴ�.");
		
		Scanner sc;
		sc = new Scanner(System.in);
		
//		while(true) {
//			System.out.println("���ڿ��� �Է��ϼ���.  (add : �߰� �۾�, retrieve : ��ȸ �۾�, modify : ���� �۾�, quit : ���� �۾�)) : ");
//			String line = sc.nextLine();
//			
//			if(line.equalsIgnoreCase("quit")) {
//				System.out.println("�۾��� �����ϰڽ��ϴ�.");
//				break;
//			}else if(line.equalsIgnoreCase("add")) {
//				System.out.println(" �߰� �۾��� �����ϼ̽��ϴ�. ");
//				System.out.println("���̵� : ");
//				String id = sc.nextLine();
//				
//				System.out.println("��й�ȣ : ");
//				String pwd = sc.nextLine();
//				
//				System.out.println("�̸� : ");
//				String name = sc.nextLine();
//				
//				System.out.println("�ּ� : ");
//				String address = sc.nextLine();
//				
//				System.out.println(id +", "+ pwd +", "+ name +", "+ address);
//			}else if(line.equalsIgnoreCase("retrieve")) {
//				System.out.println(" ��ȸ�۾��� �����ϼ̽��ϴ�. ");
//			}else if(line.equalsIgnoreCase("modify")) {
//				System.out.println("�����۾��� �����ϼ̽��ϴ�.");
//			}else {
//				System.out.println("�׿��� �۾��� �����ϼ̽��ϴ�.");
//			}
//		}
		while(true) {
			System.out.println("���ڿ��� �Է��ϼ���.  (add : �߰� �۾�, retrieve : ��ȸ �۾�, modify : ���� �۾�, quit : ���� �۾�)) : ");
			String line = sc.nextLine().toLowerCase();
			
			if(line.equals("quit")) {
				System.out.println("�۾��� �����ϰڽ��ϴ�.");
				break;
			}else if(line.equals("add")) {
				System.out.println(" �߰� �۾��� �����ϼ̽��ϴ�. ");
				System.out.println("���̵� : ");
				String id = sc.nextLine();
				
				System.out.println("��й�ȣ : ");
				String pwd = sc.nextLine();
				
				System.out.println("�̸� : ");
				String name = sc.nextLine();
				
				System.out.println("�ּ� : ");
				String address = sc.nextLine();
				
				System.out.println(id +", "+ pwd +", "+ name +", "+ address);
			}else if(line.equals("retrieve")) {
				System.out.println(" ��ȸ�۾��� �����ϼ̽��ϴ�. ");
			}else if(line.equals("modify")) {
				System.out.println("�����۾��� �����ϼ̽��ϴ�.");
			}else {
				System.out.println("�׿��� �۾��� �����ϼ̽��ϴ�.");
			}
		}
	}
}
