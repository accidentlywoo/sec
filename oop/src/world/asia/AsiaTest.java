package world.asia;

//같은 패키지 클래스끼리 import하지 않는다..
public class AsiaTest {
	public static void main(String[] args) {
		Korea k;
		k = new Korea();
		k.population = 0;
		k.capital = "평양";
		//k.language = "일본어";
		
		k.setLanguage("일본어");
		System.out.println(k.getLanguage());
		k.setLanguage("한국어");
		System.out.println(k.getLanguage());
		/*
		 * 캡슐화
		 * 	은닉된 정보에 접근할 수 있는 기능을 제공한다.
		 * 설정 (set) / 얻기 (get)
		 */
	}
}
