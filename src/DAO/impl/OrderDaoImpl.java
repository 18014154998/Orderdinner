package DAO.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import DAO.OrderDAO;
import Utils.DatabaseUntils;

/** 
* @author 刘平远
* @version 创建时间：2019年8月21日 下午6:30:54 
* 类说明 :
*/
public class OrderDaoImpl extends DatabaseUntils implements OrderDAO {

	@Override
	public int insert(int uid) {
		String sql="  INSERT INTO `order` ( O_U_ID, consumeAMOUNT  )   SELECT   U_ID , SUM(M_SALES)  FROM shoppingcar    WHERE state = 0    and  U_ID = ?   GROUP BY U_ID   ";
		Object[] object=new Object[] {uid};
		int i=super.excuteupdate(sql, object);
		return i;
	}

	@Override
	public int update(int uid,int oid) {
		String sql=" update `order`  set  ispay = 1 where O_U_ID = ?  and O_ID = ? ";
		Object[] object=new Object[] {uid,oid};
		int i=super.excuteupdate(sql, object);
		return i;
	}

	@Override
	public int getkey0() {
		int key =0;
		String sql="   SELECT MAX(O_ID) FROM  `order`   ";
		key = super.getMaxkey(sql);
		
		return key;
		
	}

	@Override
	public ResultSet findSaleBydate(Timestamp date1,Timestamp date2) {
		String sql=" SELECT O_ID,O_U_ID,O_DATE,CONSUMEAMOUNT  FROM `order` WHERE O_DATE > ?  AND  O_DATE < ?  ";
		Object [] object=new Object[] {date1,date2 };
		ResultSet rs=super.executeQuery(sql, object);
		return rs;
	}

	@Override
	public double findamountsale(Timestamp date1, Timestamp date2) {
		String sql=" SELECT sum(consumeAMOUNT) FROM  `order`  WHERE O_DATE > ?  AND  O_DATE < ?   ";
		Object [] object=new Object[] {date1,date2 };
		ResultSet rs=super.executeQuery(sql, object);
		double amount=0;
		try {
			if (rs.next()) {
				amount=rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return amount;
	}

}
