import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.my.sql.MyConnection;

public class DateTest {
	public static void main(String[] args) {
		Connection con = null; // DB연결
		PreparedStatement pstmt = null; // SQL 구문 송신
		ResultSet rs = null; // 결과 수신용 API
		try {
			con = MyConnection.getConnection();
			String sql = 
					"SELECT "
					+ "dt"
					+ ", TO_CHAR(dt, 'YYMMDD HH24:MI:SS') dt1"
					+ ", sdt "
					+ ", ts "
				+ "FROM datest ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getDate("dt"));
				Date dt = rs.getDate("dt");
				System.out.println("Data dt : "+dt);
				SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd  hh:mm:ss");
				Timestamp ts = rs.getTimestamp("ts");
				
				System.out.println("sdf : "+sdf.format(dt)); // 시분초 정보가 정확하지 않다.
				System.out.println(rs.getString("dt1"));
				System.out.println(rs.getString("sdt"));
				System.out.println("timestamp : "+ ts); // 시분초 정보가 정확하지 않다.
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			MyConnection.close(rs, pstmt, con);
		}
	}
}
