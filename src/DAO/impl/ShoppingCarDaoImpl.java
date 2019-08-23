package DAO.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.ShoppingCarDao;
import Entry.Menu;
import Entry.ShoppingCar;
import Utils.DatabaseUntils;

/** 
* @author 刘平远
* @version 创建时间：2019年8月21日 上午10:15:13 
* 类说明 :
*/
public class ShoppingCarDaoImpl extends DatabaseUntils implements ShoppingCarDao {

	//添加一个菜单
	@Override
	public int insert(ShoppingCar car) {
		String getmnanesql=" select m_name,m_price from menu where  m_id =  ? ";
		Object[] o=new Object[] { car.getmId()};
		ResultSet rs1=super.executeQuery(getmnanesql, o);
			try {
				if (rs1.next()) {
				car.setmName(rs1.getString("m_name"));
				car.setmPrice(rs1.getDouble("m_price"));
				car.setMtotal();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		String sql=" insert into shoppingcar ( u_id,m_id,m_name,m_price,m_count,m_sales  )  values ( ?,?,?,?,?,?  ) ";
		Object[] object=new Object[] {car.getuId(),car.getmId(),car.getmName(),car.getmPrice(),car.getMcount(),car.getMtotal()};
		int i = super.excuteupdate(sql, object);
		if (i>0) {
			return 1;
		}else {
			return 0;
		}
	}
	//更新我的菜单
	@Override
	public int update(ShoppingCar car) { //先获取到之前的值，在进行修改
		
		//car.getmcount()得到的修改后的值，  现在需要获取修改之前的值，   这二个做对比 判断是加还是减。
		//获取修改前的值。 
		String sql1=" select m_count from  shoppingcar  where  u_id = ? and m_id = ? and state = 0   ";
		Object [] o1= new Object[] {car.getuId(),car.getmId()};
		ResultSet rs=super.executeQuery(sql1, o1);
		int oldmcount=0;
		try {
			if(rs.next()){
				oldmcount=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//  对比 判断是加还是减 
		//用数据库的函数写呢？当初发update的时候，自动更新数据sales？？？
		String sql=" update shoppingcar  set m_count = ? ,  m_sales = m_count * m_price    where  u_id = ? and m_id = ? and state = 0   ";
		Object [] o= new Object[] {car.getMcount(),car.getuId(),car.getmId()};
		int i =super.excuteupdate(sql, o);
	
		
		
		if( car.getMcount() > oldmcount  ){
			//更新菜单表语句要减去差值
			String sql2=" update menu set m_count = m_count - ?   where  m_id = ?    ";
			int cha=car.getMcount()-oldmcount;
			Object [] o2= new Object[] {cha,car.getmId()};	
			super.excuteupdate(sql2, o2);
			System.out.println(" 该订单信息已经更新，被添加的菜谱被减去了了 ");
		}else if (0< car.getMcount() &&car.getMcount() < oldmcount ){
			//更新订单，加上插值
			String sql2=" update menu set m_count = m_count + ?   where  m_id = ?    ";
			int cha=oldmcount-car.getMcount();
			Object [] o2= new Object[] {cha,car.getmId()};	
			super.excuteupdate(sql2, o2);
			System.out.println(" 该订单信息已经更新，被删除的菜谱被加上了 ");
		}else if(car.getMcount()<=0){
			
			String sql2=" update menu set m_count = m_count + ?   where  m_id = ?    ";
			int cha=oldmcount-car.getMcount();
			Object [] o2= new Object[] {cha,car.getmId()};	
			super.excuteupdate(sql2, o2);
			System.out.println(" 该订单信息已经更新，被删除的菜谱被加上了 ");
			
			//删除本订单
			String sql3=" delete shoppingcar  where   u_id = ? and m_id = ? and state = 0  ";
			Object [] o3= new Object[] {car.getuId(),car.getmId()};
			super.excuteupdate(sql3, o3);
			System.out.println(" 改订单已经删除 ");
			
			
		}
	
		
		return i;
		  
		 
		
		
	}
	
	//打印出我自己的菜单
	@Override
	public List<ShoppingCar> findmymenu(int uid) {
		List<ShoppingCar> cars=new ArrayList<ShoppingCar>();
		String sql=" select m_id, m_name,m_price,m_count,m_sales from shoppingcar where u_id = ? and state = 0  and m_count > 0 ";
		Object[] o=new Object[] {uid};
		ResultSet rs=super.executeQuery(sql, o);
		try {
			while (rs.next()) {
				cars.add(new ShoppingCar(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getDouble(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			super.colseconnection();
		}
		return cars;
	}
	@Override
	public int set11(int getuId) {
		String sql= " update shoppingcar set state = 1  where  u_id = ?  ";
		Object[] o=new Object[] {getuId};
		int i =super.excuteupdate(sql, o);
		return i;
	}
	
	@Override
	public List<ShoppingCar> showhostryinfo(int getuId) {
		List<ShoppingCar> cars=new ArrayList<ShoppingCar>();
		String sql=" select m_id, m_name,m_price,sum(m_count),sum(m_sales)  from shoppingcar  where u_id = ? group by  m_id, m_name   ";
		Object[] object=new Object[] {getuId};
		ResultSet rs=super.executeQuery(sql, object);
		try {
			while (rs.next()) {
				cars.add(new ShoppingCar(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getDouble(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			super.colseconnection();
		}
		return cars;
	}

}
