package com.my.dao;

import java.sql.Connection;
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
			if(con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
					e.printStackTrace();
				}
			}
			throw new AddException(e.getMessage());
		}finally {
			MyConnection.close(con);
		}
		
	}
	public void insertInfo(Connection connection, OrderInfo info) throws AddException{
		Connection con = null;
		//주문기본정보 추가
	}
	public void insertLines(Connection connection, List<OrderLine> lines) throws AddException{
		Connection con = null;
		//주문상세정보들 추가
	}
}
