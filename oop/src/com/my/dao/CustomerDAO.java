package com.my.dao;

import com.my.exception.AddException;
import com.my.exception.DuplicatedException;
import com.my.exception.FindException;
import com.my.vo.Customer;

public interface CustomerDAO {
	/**
	 * 저장소에 고객정보를 추가한다.
	 * @param customer 고객 정보
	 * @throws AddException 고객정보 추가 시 오류 발생
	 * @throws 고객 ID 중복 오류 발생
	 */
	public void insert(Customer customer) throws AddException, DuplicatedException;
	/**
	 * 고객 전체를 반환한다.
	 * @return
	 * @throws FindException 고객이 한명도 없을 때 오류 발생
	 * 										처리 오류 발생
	 */
	public Customer[] selectAll() throws FindException;
	/**
	 * 아이디에 해당하는 고객을 반환한다.
	 * @param id 아이디
	 * @return 고객
	 * @throws FindException 아이디에 해당하는 고객이 없을 때 오류 발생, 처리오류 발생
	 */
	public Customer selectById(String id) throws FindException;
	/**
	 * 모든 회원의 이름에 해당 요소를 찾는다.
	 * @param i 요소값
	 * @return Customer[]
	 * @throws FindException 아이디에 해당하는 고객이 없을 때 오류 발생, 처리오류 발생
	 */
	public Customer[] selectByName(String c) throws FindException;
}
