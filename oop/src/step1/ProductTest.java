package step1;

public class ProductTest {

	public static void main(String[] args) {
		Product p1 = new Product();
		p1.prodNo = "M001";
		p1.prodName = "������";
		p1.prodPrice = 100;
		
		Product p2 = new Product();
		p2.prodNo = "M002";
		p2.prodName = "������s20";
		p2.prodPrice = 150;
		p2.printInfo();
		
		Product p3 = new Product("M003", "������", 200);
		p3.printInfo();
		
		Product p4 = new Product("M004", "��Ű��");
		p4.printInfo();
	}
}
