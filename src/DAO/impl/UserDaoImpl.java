package DAO.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

import DAO.UserDAO;
import Entry.User;
import Utils.DatabaseUntils;

/** 
* @author 刘平远
* @version 创建时间：2019年8月20日 上午10:58:25 
* 类说明 :
*/
public class UserDaoImpl extends DatabaseUntils implements UserDAO  {
	//添加用户
	@Override
	public int addUser(User user) {
		String sql="insert into  user (U_NAME,U_PWD,U_PHONE) VALUES ( ? , ? , ? ) ";
		Object [] object=new Object[] {user.getuName(),user.getuPwd(),user.getuPhone()};
		//判断用户名或者手机号码 是否存在
		List<User> list=findUserByNameorPhone(user.getuName(), user.getuPhone());
		if (null == list || list.size() ==0) {
			int i=super.excuteupdate(sql, object);
			return i;
		}
		else {
			System.out.println("用户名重复！");
			return 0 ;
		}
	}
	//查询所有用户信息
	@Override
	public List<User> findAllUsers() {
		List<User> list=new ArrayList<User>();
		String sql="select U_ID,u_name,U_PWD,u_phone,u_balance,u_state,u_role from user";
		Object[] objects=null;
		ResultSet rs=super.executeQuery(sql, objects);
		try {
			while(rs.next()) {
				list.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getDouble(5),
						rs.getInt(6),
						rs.getInt(7)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	//封装方法
	private List<User> dealUsers(ResultSet rs,List<User> user) {
		try {
			while(rs.next()) {
				user.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getDouble(5),
						rs.getInt(6),
						rs.getInt(7)));
				}
		} catch (Exception e) {
			e.printStackTrace();
			}
		return user;
		}
	//按照姓名或者电话查找用户信息
	@Override
	public List<User> findUserByNameorPhone(String uName, String uPhone) {
		List<User> list=new ArrayList<User>();
		String sql="select U_ID,u_name,U_PWD,u_phone,u_balance,u_state,u_role from user where u_name = ? or u_phone = ?   ";
		Object[] objects=new Object[] {uName,uPhone};
		ResultSet rs=super.executeQuery(sql, objects);
		try {
			while(rs.next()) {
				list.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getDouble(5),
						rs.getInt(6),
						rs.getInt(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<User> findAllUsers2() {
		List<User> list=new ArrayList<User>();
		String sql="select U_ID,u_name,U_PWD,u_phone,u_balance,u_state,u_role from user";
		Object[] objects=null;
		ResultSet rs=super.executeQuery(sql, objects);
		list=dealUsers(rs, list);
		return list;
	}

	

}
