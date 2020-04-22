class First{
	public static void main(String[] argss){
		m1();
		System.out.print("Welcome");
		System.out.println("First App");
		m2(10, 20);
		m3(10, 20, 30);
	}

	public static void m1(){
		System.out.println("Welcome m1");
	}

	public static void m2(int a, int b){
		System.out.println( a+b );
	}

	public static void m3(int a, int b, int c){
		System.out.println((a+b+c)/3);
	}
}