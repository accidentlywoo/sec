class Condition{
	public static void main(String[] args){
		int num = 3;
		if(num % 2 == 0){
			System.out.println("¦���Դϴ�.");	
		}
		if(num > 0){
			System.out.println("����Դϴ�.");
		}else if(num < 0){
			System.out.println("�����Դϴ�.");			
		}else{
			System.out.println("0�Դϴ�.");
		}

		java.util.Calendar now;
		now = java.util.Calendar.getInstance();

		int ampm = now.get(java.util.Calendar.AM_PM);
		int hour = now.get(java.util.Calendar.HOUR);
		int m = now.get(java.util.Calendar.MINUTE);
		int s = now.get(java.util.Calendar.SECOND);
		
		if(ampm == 1){
			System.out.print("����");
		}else{
			System.out.print("����");
		}

		System.out.println(" ����ð� : " + hour + " �� : "+ m + " �� : "+ s + " ��");

		// Ű����� �⵵�� �Է¹����ÿ�.
		int year;

		/*
		* �⵵�� 12�� ���������� 0����
		* ����, ��, ��, ����, ��, ��, ȣ��, �k, ��, ��, ��, ��
		*/
		java.util.Scanner sc;
		sc = new java.util.Scanner(System.in);

		year = sc.nextInt();
		int mod = year % 12;
		
		if(mod == 0){
			System.out.println("������");
		}else if(mod == 1){
			System.out.println("��");
		}
	}
}