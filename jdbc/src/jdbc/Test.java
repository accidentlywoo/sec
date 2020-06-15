package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * java -cp bin;JDBC드라이버압축파일명 Test
 * 위와 같이 실행하려면
 * 프로젝트 -> buildpath로 jdbc드라이버 압축파일 추가
 */
public class Test {
	public static void main(String[] args) {
		// 1. JDBC 드라이버 로드
		String className = "oracle.jdbc.driver.OracleDriver";
		String url, user, password;
		url = "jdbc:oracle:thin:@192.168.0.107:1521:xe";
		user = "test";
		password = "test";
		ResultSet rs = null;
		// 2. 데이터 베이스 연결
		try (Connection con = DriverManager.getConnection(url, user, password)){
			Class.forName(className);
			System.out.println("JDBC 드라이버 로드 성공");
			
			 // Connection타입의 변수 반환
			System.out.println("DB와 연결 성공");
			String selectSQL = "SELECT "
					+ "prod_no, "
					+ "prod_price, "
					+ "info.order_no,"
					+ "order_dt, "
					+ "order_id, "
					+ "order_quantity 주문수량 "
			+	"FROM order_info info "
			+ "JOIN order_line line ON (info.order_no = line.order_no) "
			+ "JOIN product p ON(p.prod_no = line.order_prod_no) "
			+ "WHERE order_id = ?";
			
			try ( PreparedStatement pstmt = con.prepareStatement(selectSQL)){
				String id = "id1";
				pstmt.setString(1, id);
				//3. SQL구문 송신, 수신
				rs = pstmt.executeQuery();
				while(rs.next()) {
					String no = rs.getString("prod_no"); // getString(1)
					int price = rs.getInt("prod_price"); // getInt(2)
					int quantity = rs.getInt("주문수량"); // Alias 사용시 알리아스 사용
					String dt = rs.getString("order_dt");
					int order_no = rs.getInt("order_no");
					System.out.println(no +" : " + price + " : " + quantity + " : "+dt+ " : " + order_no );
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		 * // 1. JDBC 드라이버 로드
		String className = "oracle.jdbc.driver.OracleDriver";
		Connection con = null;
		
		try {
			Class.forName(className);
			System.out.println("JDBC 드라이버 로드 성공");
			
			 // Connection타입의 변수 반환
			  * String url, user, password;
			url = "jdbc:oracle:thin:@192.168.0.107:1521:xe";
			user = "test";
			password = "test";
			// 2. 데이터 베이스 연결
		    con= DriverManager.getConnection(url, user, password);
			System.out.println("DB와 연결 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(con != null){
				try{
					con.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		 */
	}
}
