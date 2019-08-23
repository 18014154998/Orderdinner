package DAO.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.MenuDAO;
import Entry.Menu;
import Utils.DatabaseUntils;

/** 
* @author 刘平远
* @version 创建时间：2019年8月20日 下午4:51:48 
* 类说明 :
*/
public class MenuDaoImpl extends DatabaseUntils implements MenuDAO {

	//查找所有的菜谱
	@Override
	public List<Menu> findAllMenu() {
		String sql="select m_id, m_t_type, m_name, m_t_type_name, m_price, m_count  from menu where m_count > 0  "; 
		List<Menu> menus=new ArrayList<Menu>();
		ResultSet rs=super.executeQuery(sql, null);
		try {
			while(rs.next()) {
				menus.add(new Menu(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6)));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return menus;
	}
	
	//按照种类查找菜谱
	@Override
	public List<Menu> findByMenuType(int type) {
		String sql=" select m_id, m_t_type, m_name, m_t_type_name, m_price, m_count  from menu where  m_count > 0  and m_t_type = ?  ";
		List<Menu> menus=new ArrayList<Menu>();
		Object [] obj=new Object[] {type};
		ResultSet rs=super.executeQuery(sql, obj);
		try {
			while(rs.next()) {
				menus.add(new Menu(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6)));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return menus;
	}
	
	//按照id查找菜谱
	@Override
	public List<Menu> findByMid(int mid) {
			String sql=" select m_id, m_t_type, m_name, m_t_type_name, m_price, m_count  from menu  where m_id = ?  ";
			List<Menu> menus=new ArrayList<Menu>();
			Object [] obj=new Object[] {mid};
			ResultSet rs=super.executeQuery(sql, obj);
			try {
				while(rs.next()) {
					menus.add(new Menu(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6)));
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			return menus;
		}
			
	
	//增加新的菜谱
	@Override
	public int addMenu(Menu m) {
		String sql="insert into menu (m_t_type, m_name, m_t_type_name, m_price, m_count ) values ( ?,? ,? ,? ,? )  ";
		Object [] o=new Object[] {m.getMtType(),m.getmName(),m.getMtTypeName(),m.getmPrice(),m.getmCount()};
		//判断是否重复，不判断了 
		int i=super.excuteupdate(sql, o);
		return i;
	}
	
	//删除现在的菜谱
	@Override
	public int deleteMenu(int mId) {
		String sql=" delete from menu  where m_id = ?  ";
		Object[] o=new Object[] {mId};
		int i=super.excuteupdate(sql, o);
		if (i>0) {
			return 1;
		}else {
			
			return 0;
		}
	}
	
	//修改现有的菜谱
	@Override
	public int updateMenu(int mId, double price ,int count) {
		String sql=" update menu  set m_price = ? , m_count = ?   where m_id = ?  ";
		Object[] o=new Object[]{price,count,mId};
		int i=super.excuteupdate(sql, o);
		if (i>0) {
			return 1;
		}else {
			
			return 0;
		}
	}

	//用户点菜时时候减少的余量
	@Override
	public int updateamount(int nums, int mid) {
		String sql=" update menu  set m_count = m_count - ? where  m_id = ?   ";
		Object [] objects=new Object[] {nums,mid};
		int i= super.excuteupdate(sql, objects);
		return i;
	}
	
		
}
