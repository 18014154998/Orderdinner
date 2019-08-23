package DAO.impl;

import DAO.OrderDetailsDAO;
import Entry.OrderDetails;
import Utils.DatabaseUntils;

/** 
* @author 刘平远
* @version 创建时间：2019年8月21日 下午6:53:20 
* 类说明 :
*/
public class OrderDetailsDAOImpl extends DatabaseUntils implements OrderDetailsDAO {

	@Override
	public int insert() {
		String sql="  INSERT INTO orderdetails (OD_ID,OD_M_ID,OD_M_PRICE,OD_M_COUNT,OD_M_SALES)\r\n" + 
				"SELECT O_ID, M_ID,M_PRICE,M_COUNT,M_SALES FROM  shoppingcar  JOIN `order`  on  order.O_U_ID = shoppingcar.U_ID     ";
		int i = super.excuteupdate(sql, null);

		return i;
	}

}
