package Service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import DAO.OrderDAO;
import DAO.impl.OrderDaoImpl;
import Service.OrderService;

/** 
* @author 刘平远
* @version 创建时间：2019年8月21日 下午6:36:42 
* 类说明 :
*/
public class OrderServiceImpl implements OrderService {

	OrderDAO dao=new OrderDaoImpl();
	
	@Override
	public void addorder(int uid) {
		int i=dao.insert(uid);
		if (i>0) {
			System.out.println("订单表生成成功");
		}else {
			System.out.println("订单表生成失败");
		}
	}

	@Override
	public void updateorder(int uid,int oid) {
		int i = dao.update(uid, oid);
		if (i>0) {
			System.out.println("订单已经被结算");
		}else {
			System.out.println("订单结算失败");
		}
	}

	@Override
	public int getkey() {
		int key=dao.getkey0();
		return key;
	}

	@Override
	public void showsalesoneday(Timestamp date1,Timestamp date2) {
		ResultSet rs=dao.findSaleBydate(date1,date2);
		//对rs进行处理
		System.out.println("订单编号"+"\t"+"顾客编号"+"\t"+"\t"+"日期"+"\t"+"\t"+"消费总额"+"\t");
		try {
			while (rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getInt(2)+"\t"+"\t"+rs.getDate(3)+"\t"+"\t"+rs.getDouble(4)+"\t");
			}
			System.out.println("改日销售总额为："+dao.findamountsale(date1,date2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
