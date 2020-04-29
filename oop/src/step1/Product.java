package step1;
/**
 *  ��ü �𵨸� ���� 
 *	1. ��ǰ ��ü ����(Ư¡, �ൿ ���)
 * 	2. Ŭ����ȭ
 * 		(Ư¡ - �ν��Ͻ� ����, �ൿ/��� - �޼���)
 * 			- ��ǰ��ȣ, ��ǰ��, ����
 *	3. ��ü ���� �� ���
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
		// this() ȣ���� ������ �޼ҵ� �� ù��° �ٿ��� �ۼ� �Ǿ��Ѵ�.
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
