import com.my.dao.CustomerDAO;
import com.my.dao.CustomerDAOOracle;
import com.my.exception.FindException;
import com.my.vo.Customer;
import com.my.vo.Postal;

public class HasATest2 {
	public static void main(String[] args) {
		//로그인 된 상태에서 고객 내정보보기 화면
		String id = "id5";
		System.out.println("내 정보보기");
		CustomerDAO dao = new CustomerDAOOracle();
		try {
			Customer c = dao.selectById(id);
			System.out.println("비밀번호:" + c.getPwd());
			System.out.println("이름:" + c.getName());
			Postal postal = c.getPostal();
			System.out.println("우편번호:" + postal.getZipcode());
			System.out.println("기본주소:" + postal.getCity()+" "+ postal.getDoro() + " " + postal.getBuilding());
			System.out.println("상세주소:" + c.getAddr());
		} catch (FindException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}