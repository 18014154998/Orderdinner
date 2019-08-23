package Service;

import java.sql.Timestamp;
import java.util.Date;

/** 
* @author 刘平远
* @version 创建时间：2019年8月21日 下午6:35:34 
* 类说明 :
*/
public interface OrderService {
	
		//插入
		public void addorder(int uid); 
		
		//更新ispay=1
		public void updateorder(int uid,int oid);

		//获取插入的主键
		public int getkey();
		
		//查询莫一天的销售额
		public void showsalesoneday(Timestamp date1,Timestamp date2);
}
