package Service;

import java.util.List;

import Entry.Menu;

/** 
* @author 刘平远
* @version 创建时间：2019年8月20日 下午6:19:10 
* 类说明 :
*/
public interface MenuService {
	
	//查看所有菜单
	public List<Menu> findAllMenu();
	
	//按照类型查看菜单
	public List<Menu> findAMenuBytype(int typeid);
	
	//按照编号查询菜谱
	public void findMenuBymid(int mid);
	
	//添加新的菜谱
	public boolean addnewmenu0(Menu m);
	
	//删除旧的菜谱
	public void deleteoldmenu(int mId);	
	
	//更新菜谱
	public void  updateMenuBymid(int mId, double price ,int count);
	
	//用户点菜时时候减少的余量
	public void updatemcount(int nums,int mid);
	
}
