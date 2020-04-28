package step1;

import java.util.Arrays;
import java.util.Scanner;

public class StringArray {
	public static void main(String[] args) {
		Scanner sc;
		sc = new Scanner(System.in);
		int maxRow = 2;
		String[][] personInfo = new String[maxRow][4];
		int row = 0;
		while(true) {
			System.out.println("���ڿ��� �Է��ϼ���.  (add : �߰� �۾�, retrieve : ��ȸ �۾�, modify : ���� �۾�, quit : ���� �۾�)) : ");
			String line = sc.nextLine().toLowerCase();
			
			if(line.equals("quit")) {
				System.out.println("�۾��� �����ϰڽ��ϴ�.");
				break;
			}else if(line.equals("add")) {
				
				System.out.println(" �߰� �۾��� �����ϼ̽��ϴ�. ");
				System.out.println("���� �����ο� : " + (row) + "��");
				
				if(row >= maxRow) {
					System.out.println("����Ұ� �� á���ϴ�. ");
					break;
				}
				
				System.out.println("���̵� : ");
				String idCheck = sc.nextLine();
				boolean flag = false;
				for(int i = 0; i < row; i++) {
					if(personInfo[i][0].equals(idCheck)) {
						flag = true;
						break;
					}
				}
				if(flag) {
					System.out.println("���̵� �ߺ��Դϴ�. �ٸ� ���̵� �Է��Ͻÿ�.");
				}else {
					personInfo[row][0] = idCheck;
					System.out.println("��й�ȣ : ");
					personInfo[row][1] = sc.nextLine();
					
					System.out.println("�̸� : ");
					personInfo[row][2] = sc.nextLine();
					
					System.out.println("�ּ� : ");
					personInfo[row][3] = sc.nextLine();
					
					System.out.println(Arrays.deepToString(personInfo));
					row++;
				}
			}else if(line.equals("retrieve")) {
				System.out.println(" ��ȸ�۾��� �����ϼ̽��ϴ�. ");
				for(int i = 0; i < row; i++) {
					String id = personInfo[i][0];
					System.out.println((i+1)+"��° ���̵� ��� : "+id);
				}
			}else if(line.equals("modify")) {
				System.out.println("�����۾��� �����ϼ̽��ϴ�.");
			}else {
				System.out.println("�׿��� �۾��� �����ϼ̽��ϴ�.");
			}
		}
	}
}
