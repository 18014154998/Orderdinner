package Service.impl;

import java.util.List;

import DAO.UserDAO;
import DAO.impl.UserDaoImpl;
import Entry.User;
import Service.UserService;

/** 
* @author 刘平远
* @version 创建时间：2019年8月20日 下午2:25:41 
* 类说明 :
*/
public class UserServiceImpl implements UserService {
	
	private UserServiceImpl() {
	}
	
	private static final  UserServiceImpl userServiceImpl=new UserServiceImpl();

	public static  UserServiceImpl getInstance() {
		return userServiceImpl;
	}
	
	UserDAO dao=new UserDaoImpl();
	
	@Override
	public boolean checkRegister(User user) {
		int i=dao.addUser(user);
		if (i>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean userLogin(User user) {
		List<User> users=dao.findAllUsers();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getuName().equals(user.getuName())&&users.get(i).getuPwd().equals(user.getuPwd())) {
				user.setuId(users.get(i).getuId());
				return true;
			}
		}
		return false;
	}

}
