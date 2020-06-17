import java.util.List;

import com.my.dao.CustomerDAO;
import com.my.dao.CustomerDAOOracle;
import com.my.dao.PostalDAO;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.vo.Customer;
import com.my.vo.Postal;

public class HasATest {
	public static void main(String[] args) {
		//------ 우편번호 검색과 고객 가입 화면----------
		System.out.println("가입할 고객 정보 입력받기");
		String id,pwd,name;
		Postal postal = null;
		String addr;
		//키보드로 입력받을 ID,PWD,NAME
		System.out.println("ID입력하세요");
		id = "id4"; 
		System.out.println("비밀번호입력하세요");
		pwd = "p4";
		System.out.println("이름입력하세요");
		name = "n4";
		System.out.println("우편번호검색");
		System.out.println("도로명입력하세요 예)세종로 2511");
		String doro = "세종로"; //키보드로 입력받을 도로명검색어
		
		System.out.printf("%2s %5s %25s  %s  %s  %s\n", "no",  "우편번호", "건물관리번호", "도시","도로",   "건물 ");
		try {
			PostalDAO postalDAO = new PostalDAO();
			List<Postal> list = postalDAO.selectByDoro(doro);
			int i =0;
			for(Postal item : list) {
				System.out.printf("%2d %5s %25s %s %s %s\n",(i+1), item.getZipcode() ,item.getBuildingno(), item.getCity(), item.getDoro(), item.getBuilding());
				i++;
			}
				
			System.out.println("번호를 선택하세요: 예)1");
			int index = 2-1; //선택할 우편번호를 갖는 도로명 선택			
			postal = list.get(index);
		}catch(FindException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("상세주소입력하세요");
		addr = "1동102호";
		//-----------------------------------------
		System.out.println("고객 가입");
		try {
			Customer c = new Customer();
			c.setId(id);
			c.setPwd(pwd);
			c.setName(name);
			c.setPostal(postal);
			c.setAddr(addr);
			
			CustomerDAO customerDAO = new CustomerDAOOracle();
			try {
				customerDAO.insert(c);
				System.out.println("고객가입 성공");
			} catch (FindException e) {
				e.printStackTrace();
			}
			System.out.println("고객가입");
		}catch(AddException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}