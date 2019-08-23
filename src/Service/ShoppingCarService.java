package Service;
/** 
* @author 刘平远
* @version 创建时间：2019年8月21日 上午10:16:56 
* 类说明 :
*/
public interface ShoppingCarService {

	//添加菜
	public void addmenu(int uid);
	
	//修改菜
	public boolean changemenu(int uid);
	
	//打印出我已经点的菜单
	public void showmymenu( int uid);

	public void set1(int getuId);
	//显示历史信息
	public void showhostry(int getuId);
}
