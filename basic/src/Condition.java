class Condition{
	public static void main(String[] args){
		int num = 3;
		if(num % 2 == 0){
			System.out.println("짝수입니다.");	
		}
		if(num > 0){
			System.out.println("양수입니다.");
		}else if(num < 0){
			System.out.println("음수입니다.");			
		}else{
			System.out.println("0입니다.");
		}

		java.util.Calendar now;
		now = java.util.Calendar.getInstance();

		int ampm = now.get(java.util.Calendar.AM_PM);
		int hour = now.get(java.util.Calendar.HOUR);
		int m = now.get(java.util.Calendar.MINUTE);
		int s = now.get(java.util.Calendar.SECOND);
		
		if(ampm == 1){
			System.out.print("오후");
		}else{
			System.out.print("오전");
		}

		System.out.println(" 현재시간 : " + hour + " 시 : "+ m + " 분 : "+ s + " 초");

		// 키보드로 년도를 입력받으시오.
		int year;

		/*
		* 년도를 12로 나눈나머지 0부터
		* 원숭, 닭, 개, 돼지, 쥐, 소, 호랭, 퇶, 용, 뱀, 말, 양
		*/
		java.util.Scanner sc;
		sc = new java.util.Scanner(System.in);

		year = sc.nextInt();
		int mod = year % 12;
		
		if(mod == 0){
			System.out.println("원숭이");
		}else if(mod == 1){
			System.out.println("닭");
		}
	}
}