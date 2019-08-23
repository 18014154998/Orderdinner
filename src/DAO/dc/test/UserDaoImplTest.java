package DAO.dc.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import DAO.UserDAO;
import DAO.impl.UserDaoImpl;
import Entry.User;

/** 
* @author 刘平远
* @version 创建时间：2019年8月20日 下午2:16:13 
* 类说明 :
*/
class UserDaoImplTest {

	@Test
	void testFindAllUsers2() {
		UserDAO dao=new UserDaoImpl();
		System.out.println(123);
		List<User> list=dao.findAllUsers2();
		System.out.println(list);
		
	}

}
