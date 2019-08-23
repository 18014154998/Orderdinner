package Service.impl;

import java.util.ArrayList;
import java.util.List;

import DAO.MenuDAO;
import DAO.impl.MenuDaoImpl;
import Entry.Menu;
import Service.MenuService;
import Utils.DatabaseUntils;

/** 
* @author 刘平远
* @version 创建时间：2019年8月20日 下午6:46:35 
* 类说明 :
*/
public class MenuServiceImpl implements MenuService {

	MenuDAO menudao=new MenuDaoImpl();
	
	//查询所有的菜单
	@Override
	public List<Menu> findAllMenu() {
		List<Menu> menus = menudao.findAllMenu();
		System.out.println("编号"+"\t"+"菜名"+"\t"+"价格"+"\t"+"余量"+"\t"+"类型"+"\t");
		for (int i = 0; i < menus.size(); i++) {
			System.out.println(menus.get(i).getmId()+"\t"+menus.get(i).getmName()+"\t"+menus.get(i).getmPrice()+"\t"+menus.get(i).getmCount()+"\t"+menus.get(i).getMtTypeName()+"\t");
		}
		return menus;
	}
	
	//查找类型菜谱
	@Override
	public List<Menu> findAMenuBytype(int typeid) {
		List<Menu> menus = menudao.findByMenuType(typeid);
		System.out.println("编号"+"\t"+"菜名"+"\t"+"价格"+"\t"+"余量"+"\t"+"类型"+"\t");
		for (int i = 0; i < menus.size(); i++) {
			System.out.println(menus.get(i).getmId()+"\t"+menus.get(i).getmName()+"\t"+menus.get(i).getmPrice()+"\t"+menus.get(i).getmCount()+"\t"+menus.get(i).getMtTypeName()+"\t");
		}
		return menus;
	}
	//按照编号查询菜谱
		@Override
		public void findMenuBymid(int mid) {
			List<Menu> menus=menudao.findByMid(mid);
			System.out.println("编号"+"\t"+"菜名"+"\t"+"价格"+"\t"+"余量"+"\t"+"类型"+"\t");
			for (int i = 0; i < menus.size(); i++) {
				System.out.println(menus.get(i).getmId()+"\t"+menus.get(i).getmName()+"\t"+menus.get(i).getmPrice()+"\t"+menus.get(i).getmCount()+"\t"+menus.get(i).getMtTypeName()+"\t");
			}
		}
	
	//添加新的菜谱
	@Override
	public boolean addnewmenu0(Menu menu) {
		int i=menudao.addMenu(menu);
		if (i>0) {
			return true;
		}else {
			return false;
		}
	}
	//删除旧的菜谱
	@Override
	public void deleteoldmenu(int mId) {
		int i=menudao.deleteMenu(mId);
		if (i>0) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
		
	}
	//更新菜谱的信息
	@Override
	public void updateMenuBymid(int mId, double price, int count) {
		int i =menudao.updateMenu(mId, price, count);
		if (i>0) {
			System.out.println("修改成功");
			findMenuBymid(mId);
		}else {
			System.out.println("修改失败");
		}
	}

	//用户点菜时时候减少的余量
	@Override
	public void updatemcount(int nums, int mid) {
		int i=menudao.updateamount(nums, mid);
		if (i>0) {
			System.out.println("菜谱总量改变了");
		}else {
			System.out.println("菜谱总量操作失败");
		}
		
	}
	



}
