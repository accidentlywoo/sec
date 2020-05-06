package world;
// 이클립스가 package.을 논리적으로 상위 패키지라고 생각한다.
// 일반적으로 따로 만들어야 한다고 생각해야 한다.
// 패키지 설계시 차근차근 만드는 것이 좋다.

import world.asia.Korea;
import world.euro.France;

public class CountryTest {
	public static void main(String[] args) {
//		world.euro.France f;
//		f = new world.euro.France();
		
		France f;
		f = new France();
		
		Korea k;
		k = new Korea();
		k.population = 0;
		k.setCapital("평양");
		k.setLanguage("일본어");
		
		System.out.println(k.getCapital() +" : "+ k.getLanguage());
		
		/*
		 * k.capital = "평양"; k.language = "일본어";
		 * 
		 * 객체지향 프로그래밍.
		 *  목적 - 클래스 재사용성을 높이자.
		 *  
		 *  document : /** */
		 /*
		  * 접근제어 : public, package(default), private
		  * public - 누구나 접근 가능.
		  * package(default) - 동일 패키지에서 접근가능.
		  * private - 자기 클래스에서 접근 가능.  
		 *  
		 */
	}
}
