import java.util.ArrayList;
import java.util.List;

import com.my.dao.OrderDAO;
import com.my.exception.AddException;
import com.my.vo.Customer;
import com.my.vo.OrderInfo;
import com.my.vo.OrderLine;
import com.my.vo.Product;

public class TransacrionTest {
	public static void main(String[] args) {
		OrderDAO dao = new OrderDAO();
		
		OrderInfo orderInfo = new OrderInfo();
		Customer order_c = new Customer();
		String id = "id2";
		order_c.setId(id);
		orderInfo.setOrder_c(order_c);
		List<OrderLine> lines = new ArrayList<OrderLine>();
		Product order_p = new Product();
		OrderLine line = new OrderLine();
		order_p.setProd_no("C0001");
		line.setOrder_p(order_p);
		line.setOrder_quantity(1);
		lines.add(line);
		orderInfo.setLines(lines);
		try {
			dao.insert(orderInfo);
		} catch (AddException e) {
			e.printStackTrace();
		}
	}
}
