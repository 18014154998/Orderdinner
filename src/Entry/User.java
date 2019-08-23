package Entry;
/** 
* @author 刘平远
* @version 创建时间：2019年8月20日 上午10:09:25 
* 类说明 :用户类
*/
public class User {
	private int uId;
	private String uName;
	private String uPwd;
	private String uPhone;
	private double uBalance;
	private int uState;
	private int uRole;
	
	public User() {
	}
	
	//方便注册 只需要姓名，密码和电话号码
	public User(String uName, String uPwd, String uPhone) {
		super();
		this.uName = uName;
		this.uPwd = uPwd;
		this.uPhone = uPhone;
	}

	public User(int uId, String uName, String uPwd, String uPhone, double uBalance, int uState, int uRole) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uPwd = uPwd;
		this.uPhone = uPhone;
		this.uBalance = uBalance;
		this.uState = uState;
		this.uRole = uRole;
	}

	//get  set 
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPwd() {
		return uPwd;
	}
	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}
	public String getuPhone() {
		return uPhone;
	}
	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}
	public double getuBalance() {
		return uBalance;
	}
	public void setuBalance(double uBalance) {
		this.uBalance = uBalance;
	}
	public int getuState() {
		return uState;
	}
	public void setuState(int uState) {
		this.uState = uState;
	}
	public int getuRole() {
		return uRole;
	}
	public void setuRole(int uRole) {
		this.uRole = uRole;
	}

	
	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", uPwd=" + uPwd + ", uPhone=" + uPhone + ", uBalance="
				+ uBalance + ", uState=" + uState + ", uRole=" + uRole + "]";
	}
	
	
	
	
	
	
}
