import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.my.dao.OrderDAO;
import com.my.exception.FindException;
import com.my.vo.OrderInfo;
import com.my.vo.OrderLine;
import com.my.vo.Product;

public class HasATest3 {
	public static void main(String[] args) {
		//로그인 된 상태에서 주문목록보기 화면
		String id = "id1";
		OrderDAO dao = new OrderDAO();
		try {
			List<OrderInfo> infos = dao.selectById(id);
			for(OrderInfo info: infos) {
				int order_no = info.getOrder_no();
				String order_dt = info.getOrder_dt();
//				SimpleDateFormat sdf = 
//						new SimpleDateFormat("yy-MM-dd hh:mm:ss");
				System.out.println("주문번호 :" + order_no);
				System.out.println("주문일자 :" + order_dt);
				System.out.println("--주문상세--");
				List<OrderLine> lines = info.getLines();
				System.out.printf("%4s %10s %7s %3s %6s\n", "상품번호", "상품명", "상품가격", "수량", "금액");
				for(OrderLine line: lines) {
					Product p = line.getOrder_p();
					System.out.printf("%4s ", p.getProd_no());
					System.out.printf("%10s ", p.getProd_name());
					System.out.printf("%7d ", p.getProd_price());
					System.out.printf("%3d ", line.getOrder_quantity());
					System.out.printf("%6d\n", p.getProd_price() * line.getOrder_quantity());
				}
				System.out.println("-----------");
			}
		} catch (FindException e) {
			e.printStackTrace();
		}
	}
}