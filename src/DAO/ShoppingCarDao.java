package DAO;

import java.util.List;

import Entry.Menu;
import Entry.ShoppingCar;

/** 
* @author 刘平远
* @version 创建时间：2019年8月21日 上午10:04:57 
* 类说明 :
*/
public interface ShoppingCarDao {
	
	//添加菜
	public int insert(ShoppingCar car);
	
	//修改菜的数量，包括 删除修改为0就是删除
	public int update(ShoppingCar car);

	//打印出我自己的菜单
	public List<ShoppingCar> findmymenu(int uid);

	public int set11(int getuId);

	////显示历史信息
	public List<ShoppingCar> showhostryinfo(int getuId);

	
}
