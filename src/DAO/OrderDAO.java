package DAO;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

/** 
* @author 刘平远
* @version 创建时间：2019年8月21日 下午6:28:55 
* 类说明 :
*/
public interface OrderDAO {

	//插入
	public int insert(int uid); 
	
	//更新ispay=1
	public int  update(int a ,int b);

	public int getkey0();

	public ResultSet findSaleBydate(Timestamp date1,Timestamp date2);

	public double findamountsale(Timestamp date1, Timestamp date2);
	
}
