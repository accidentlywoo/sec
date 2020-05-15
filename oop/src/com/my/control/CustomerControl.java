package com.my.control;

import java.util.List;

import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;
import com.my.service.CustomerService2;
import com.my.share.CustomerShare;
import com.my.view.FailView;
import com.my.view.SuccessView;
import com.my.vo.Customer;

public class CustomerControl {

	private CustomerService2 customerService;
	private SuccessView successView;
	private FailView failView;
	
	public CustomerControl() {
		this.customerService = new CustomerService2();
		this.successView = new SuccessView();
		this.failView = new FailView();
	}
	
	public void addControl(Customer customer) {
		try {
			customerService.add(customer);
			successView.addCustomerView("가입 "); // 가입 성공
		} catch (AddException e) {
			failView.addCustimerView("가입 "); // 가입 실패
		}
	}
	public void findAllControl() {
		try {
			List<Customer> result = customerService.findAll();
			successView.addCustomerView(result+"전체 검색 ");
		} catch (FindException e) {
			failView.addCustimerView("전체 검색 ");
		}
	}
	public void findByIdControll(String id) {
		try {
			Customer result = customerService.findById(id);
			successView.addCustomerView(result + "아이디로 찾기");
		} catch (FindException e) {
			failView.addCustimerView("아이디로 찾기");
		}
	}
	
	public void loginControl(String id, String pwd) {
		try {
			Customer result = customerService.findById(id);
			if(result.getPwd().equals(pwd)) {
				successView.addCustomerView(id+"로그인 성공");
				CustomerShare.loginedCustomer = result;
			}else {
				failView.addCustimerView("로그인 실패");
			}
		} catch (FindException e) {
			failView.addCustimerView("로그인 실패");
		}
	}
	public void modifyControll(Customer customer) {
		try {
			customerService.modify(customer);
			successView.addCustomerView(customer+"의 정보가 수정됬습니다.");
		} catch (ModifyException e) {
			e.printStackTrace();
		}
	}
	public void remove(Customer customer) {
		try {
			customerService.remove(customer);
			successView.addCustomerView(customer+"의 정보가 삭제됬습니다.");
		} catch (RemoveException e) {
			failView.addCustimerView(customer+"의 정보삭제에 실패했습니다.");
		}
	}
}
