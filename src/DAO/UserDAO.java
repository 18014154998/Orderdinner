package DAO;

import java.util.List;

import Entry.User;

/** 
* @author 刘平远
* @version 创建时间：2019年8月20日 上午10:49:05 
* 类说明 : 用户注册，查询用户信息。
*/
public interface UserDAO {
	
	//用户注册
	public int  addUser(User user);
	
	//查询用户,即用户登陆
	public List<User> findAllUsers();
	
	public List<User> findAllUsers2();
	
	//按照电话号码或者用户名查询
	public List<User> findUserByNameorPhone(String uName,String uPhone);
	
}
