package DAO;

import java.util.List;

import Entry.Menu;

/** 
* @author 刘平远
* @version 创建时间：2019年8月20日 下午4:44:10 
* 类说明 :
*/
public interface MenuDAO {
		
	//查找所有的菜谱
	public List<Menu> findAllMenu();
	
	//按照种类查找菜谱
	public List<Menu> findByMenuType(int type);
	
	//用户点菜时时候减少的余量
	public int updateamount(int nums,int mid);
	
	//按照id查找菜谱
	public List<Menu> findByMid(int mid);
	
	//增加新的菜谱
	public int addMenu(Menu menu);
	
	//删除现在的菜谱
	public int deleteMenu(int mId);
	
	//修改现有的菜谱
	public int  updateMenu(int mId, double price ,int count);
	
}
