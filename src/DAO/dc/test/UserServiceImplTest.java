package DAO.dc.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import DAO.impl.UserDaoImpl;
import Entry.User;
import Service.impl.UserServiceImpl;

/** 
* @author 刘平远
* @version 创建时间：2019年8月20日 下午2:44:36 
* 类说明 :
*/
class UserServiceImplTest {

	@Test
	void test() {
		UserServiceImpl impl=UserServiceImpl.getInstance();
		User user=new User("li1", "123415", "1565614");
		System.out.println(impl.checkRegister(user));
		
	}

}
