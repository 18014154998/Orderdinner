package Service.impl;

import DAO.OrderDAO;
import DAO.OrderDetailsDAO;
import DAO.impl.OrderDaoImpl;
import DAO.impl.OrderDetailsDAOImpl;
import Entry.OrderDetails;
import Service.OrderDatilsService;

/** 
* @author 刘平远
* @version 创建时间：2019年8月21日 下午7:00:31 
* 类说明 :
*/
public class OrderDatilsServiceImpl implements OrderDatilsService {
	
	OrderDetailsDAO dao=new OrderDetailsDAOImpl();
	
	@Override
	public void adddatils() {
		int i=dao.insert();
		if (i>0) {
			System.out.println("购物信息录入订单详细信息表成功");
		}else {
			System.out.println("购物信息录入订单详细信息表失败");
		}
		
	}

}
