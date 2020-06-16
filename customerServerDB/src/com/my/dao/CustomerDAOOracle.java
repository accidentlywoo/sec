package com.my.dao;

import java.io.IOException;
import java.net.ServerSocket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.my.control.CustomerBufferedControl;
import com.my.exception.AddException;
import com.my.exception.DuplicatedException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;
import com.my.sql.MyConnection;
import com.my.vo.Customer;

public class CustomerDAOOracle implements CustomerDAO2{

	@Override
	public Customer insert(Customer customer) throws AddException, DuplicatedException, FindException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = MyConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		}
		
		String insertSQL = 
				"INSERT INTO customer(id, pwd, name) "
				+ "VALUES (?,?,?)";
		try {
			pstmt = con.prepareStatement(insertSQL);
			pstmt.setString(1, customer.getId());
			pstmt.setString(2, customer.getPwd());
			pstmt.setString(3, customer.getName());
			pstmt.executeUpdate(); //Java는 Auto Commit
		} catch (SQLException e) {// SQLException 에만 있는 메소드가 있다.
			e.printStackTrace();
			if(e.getErrorCode() == 1) { // SQLException만 있는 getErrorCode()
				// ErrorCode = 1 -> PK중복 에러
				throw new DuplicatedException("이미 존재하는 ID입니다.");
			}
			throw new AddException(e.getMessage());
		}finally {
			MyConnection.close(pstmt, con);
		}
		return null;
	}

	@Override
	public List<Customer> selectAll() throws FindException {
		return null;
	}

	@Override
	public Customer selectById(String id) throws FindException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = MyConnection.getConnection();
		}catch (ClassNotFoundException | SQLException e) {
			throw new FindException(e.getMessage());
		}
		
		String selectByIdSQL =
				"select * from customer\r\n" + 
				"where id = ?";
		try {
			pstmt = con.prepareStatement(selectByIdSQL);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) { // BOF 상태 Begin of File 
				Customer customer = new Customer();
				customer.setId(id);
				customer.setPwd(rs.getString("pwd"));
				customer.setName("name");
				return customer;
			}
			throw new FindException("selectById : 찾을 수 없는 아이디 입니다.");
		} catch (SQLException e) {
			throw new FindException("selectById : "+e.getMessage());
		}finally {
			MyConnection.close(rs, pstmt, con);
		}
	}

	@Override
	public List<Customer> selectByName(String word) throws FindException {
		return null;
	}

	@Override
	public void update(Customer customer) throws ModifyException, FindException {
		
	}

	@Override
	public void delete(String id) throws RemoveException, FindException {
		
	}
	public static void main(String[] args) throws FindException, IOException {
		CustomerDAOOracle control = null;
		control = new CustomerDAOOracle();
		System.out.println(control.selectById("id1").toString());
		
		Customer customer = new Customer("id2","pwd2","name2");
		try {
			control.insert(customer);
		} catch (AddException | FindException e) {
			e.printStackTrace();
		}
	}

}
