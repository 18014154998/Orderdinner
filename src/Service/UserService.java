package Service;

import Entry.User;

/** 
* @author 刘平远
* @version 创建时间：2019年8月20日 下午2:23:06 
* 类说明 :
*/
public interface UserService {
	
	//进行用户注册
	public boolean checkRegister(User user);
	
	//用户登陆
	public boolean userLogin(User user); 
		
	
	
}
