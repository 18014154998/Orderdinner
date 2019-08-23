package UI;

import java.util.ArrayList;
import java.util.List;

/** 
* @author 刘平远
* @version 创建时间：2019年8月20日 下午2:38:33 
* 类说明 :
*/
public class test {

	public static void main(String[] args) {
		List list=new ArrayList();
		if (null == list || list.size() ==0) {
			System.out.println(111);
		}else {
			System.out.println(list);
		}
	}
}
