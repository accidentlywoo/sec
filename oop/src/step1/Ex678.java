package step1;

class Employee{
	//TODO
	String no;
	String name;
	String department;
	long salary;
	double commitionPct;
	
	double calcSalary() {
		return (salary + salary*0.03);
	}
	
	void printInfo() {
		System.out.println("예상결과 : 사번-"+ no+", 이름-"+name
				+", 부서-"+department+", 급여-"+salary+", 수당-"+commitionPct+", 실급여-"+calcSalary());
	}

	public Employee(String no, String name, long salary) {
		super();
		this.no = no;
		this.name = name;
		this.salary = salary;
	}
	
	

	public Employee(String no, String name, String department, long salary, double commitionPct) {
		super();
		this.no = no;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.commitionPct = commitionPct;
	}

	public Employee() {
	}
	
}
/**
 * TODO영역 외는 수정하지 않습니다.
 * TODO영역만  완성하세요
 * @author 오문정
 */
public class Ex678 {
	public static void main(String[] args) {
		System.out.println("6. 다음은 사원관리에 필요한 사원객체를 생성하려고 한다");
		System.out.println("아래 작업이 정상처리되도록 Employee클래스를 구현하시오");
		Employee e61 = new Employee(); //사원객체생성
		e61.no="202061"; //사원객체의 사번을 202061로 설정
		e61.name = "오문정"; //사원객체의 이름을 오문정으로 설정
		e61.department = "총무부"; //사원객체의 부서를 총무부로 설정
		e61.salary = 1000; //사원객체의 기본급여를 1000으로 설정
		e61.commitionPct = 0.03; //사원객체의 수당률을 기본급여의 0.03배(3%)로 설정한다 

		System.out.println("[출력 결과]");
		System.out.println("사원의 실급여는 기본급여 + 기본급여*수당률이다");
		System.out.println("예상결과 : 사원의 실급여는 1030");
		System.out.println("실행결과");
		double totalSalary = e61.calcSalary(); 
		System.out.println("사원의 실급여는 " + totalSalary); //
		
		System.out.println("[출력 결과]");
		System.out.println("예상결과 : 사번-202061, 이름-오문정, 부서-총무부, 급여-1000, 수당-0.03, 실급여-1030");
		System.out.println("실행결과");
		e61.printInfo(); 
		System.out.println("---------------------------------");

				
		System.out.println("7. 다음은 사원관리에 필요한 사원객체를 생성하려고 한다");
		//사원객체의 사번을 202062로,이름을 홍길동으로, 부서를 영업부로,기본급여를 1000으로,수당을 기본급여의 0.1배(10%)로 설정한다
		Employee e62 = new Employee("202062", "홍길동", "영업부", 1000, 0.1); //사원객체생성

		//사원객체의 사번을 202063로,이름을 나자바로, 기본급여를 1000으로 설정한다. 부서와 수당은 결정되지 않았다.
		Employee e63 = new Employee("202063", "나자바", 1000); 
		System.out.println("---------------------------------");
		
		
		
		System.out.println("8. 다음은 최대 10명의 사원이 저장될 수 있는 배열을 생성하고 e61,e62,e63사원을 저장하려고 한다");
		
		Employee[] eArr = null; //배열선언
		int totalCnt = 0; //사원이 배열에 저장될때마다 1씩증가한다
		
		//TODO e61사원, e62사원, e63사원을 배열에 저장하시오
		
		System.out.println("[출력 결과]");
		System.out.println("예상결과 ");
		System.out.println("사번-202061, 이름-오문정, 부서-총무부, 급여-1000, 수당-0.03, 실급여-1030");
		System.out.println("사번-202062, 이름-홍길동, 부서-영업부, 급여-1000, 수당-0.1,  실급여-1100");
		System.out.println("사번-202063, 이름-나자바, 부서-부서없음, 급여-1000, 수당-0.0 , 실급여-1000");
		
		System.out.println("실행결과");	
		for(int i=0; i<totalCnt; i++) {
			eArr[i].printInfo();
		}
		System.out.println("---------------------------------");
		
	}
}
