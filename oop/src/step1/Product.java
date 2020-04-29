package step1;
/**
 *  객체 모델링 절차 
 *	1. 상품 객체 설계(특징, 행동 기능)
 * 	2. 클래스화
 * 		(특징 - 인스턴스 변수, 행동/기능 - 메서드)
 * 			- 상품번호, 상품명, 가격
 *	3. 객체 생성 및 사용
 */
public class Product {
	String prodNo;
	String prodName;
	
	int prodPrice;
	
	public void printInfo() {
		System.out.println(prodNo+" : "+prodName +" : "+ prodPrice);
	}
	
	public Product() {}
	
	public Product(String prodNo) {
		this(prodNo, "M001" , 1000);
		// this() 호출은 생성자 메소드 맨 첫번째 줄에서 작성 되야한다.
	}
	
	public Product(String prodNo, String prodName) {
		this(prodNo, prodName, 1000);
	}
	
	public Product(String prodNo, String prodName, int prodPrice) {
		this.prodNo = prodNo;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
	}
}
