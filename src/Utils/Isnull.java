package Utils;
/** 
* @author 刘平远
* @version 创建时间：2019年8月21日 下午4:21:31 
* 类说明 :
*/
public class Isnull {
	public static boolean isnull(int i) {
		if (i==0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public static boolean isnull(String str) {
		if (str.trim().isEmpty()||str==null||str.equals("")) {
			return true;
		}
		else {
			return false;
		}
	}
}
