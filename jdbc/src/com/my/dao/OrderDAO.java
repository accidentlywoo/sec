package com.my.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.my.exception.AddException;
import com.my.sql.MyConnection;
import com.my.vo.OrderInfo;
import com.my.vo.OrderLine;

public class OrderDAO {
	public void insert(OrderInfo info) throws AddException{ //Transaction
		Connection con = null;
		try {
			con = MyConnection.getConnection();
			con.setAutoCommit(false); // Default true -> 자동커밋 해재
			insertInfo(con, info);
			insertLines(con, info.getLines());
			con.commit();
		} catch (Exception e) { //무슨 문제발생하든
			e.printStackTrace();
			if(con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			throw new AddException(e.getMessage());
		}finally {
			MyConnection.close(con);
		}
		
	}
	private void insertInfo(Connection connection, OrderInfo info) throws AddException{
		//주문기본정보 추가
		PreparedStatement pstmt = null;
		String insertInfoSQL =
				"INSERT INTO order_info(order_no, order_id, order_dt) "
				+ "VALUES(order_seq.NEXTVAL, ?, SYSDATE)";
		try {
			pstmt = connection.prepareStatement(insertInfoSQL);
			pstmt.setString(1, info.getOrder_c().getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AddException();
		}finally {
			//MyConnection.close(connection); -> insertLines에서도 connection을 사용해야 하기 때문에 커넥션을 close하면 안된다.
			MyConnection.close(pstmt, null);
		}
	}
	private void insertLines(Connection connection, List<OrderLine> lines) throws AddException{
		//주문상세정보들 추가
		PreparedStatement pstmt = null;
		String insertLineSQL =
				"INSERT INTO order_line(order_no, order_prod_no, order_quantity) " //값이오는 위치에만 ?:바인드변수 사용가능
				+ "VALUES(order_seq.CURRVAL, ?, ?)";
		try {
			pstmt = connection.prepareStatement(insertLineSQL); 
			// SQL문을 준비한다 ->DB에 구문을 작성해 둔다. 실행 시 필요값('?':바인드변수)만 보낸다
			// -> 반복문에서 성능이 더 좋다.
			// Statement는 구문을 보낼때마다, 매번 DB에 SQL구문을 보냄.
			for(OrderLine item : lines) {
				pstmt.setString(1, item.getOrder_p().getProd_no());
				pstmt.setInt(2, item.getOrder_quantity());
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		}finally {
			//MyConnection.close(connection); -> insertLines에서도 connection을 사용해야 하기 때문에 커넥션을 close하면 안된다.
			MyConnection.close(pstmt, null);
		}
	}
}
