package Entry;
/** 
* @author 刘平远
* @version 创建时间：2019年8月21日 上午9:49:38 
* 类说明 :
*/
public class ShoppingCar {
	private int uId;
	private int mId;
	private String mName;
	private double mPrice;
	private int mcount;//每道菜点的数量
	private double mtotal;//每道菜的总价

	public ShoppingCar() {
		super();
	}

	
	
	public ShoppingCar(  int mid,String mName, double mPrice, int mcount, double mtotal) {
		super();
		this.mId=mid;
		this.mName = mName;
		this.mPrice = mPrice;
		this.mcount = mcount;
		this.mtotal = mtotal;
	}

 

	public ShoppingCar(int uId, int mId, int mcount) {
		super();
		this.uId = uId;
		this.mId = mId;
		this.mcount = mcount;
	}



	public ShoppingCar(int uId, int mId, String mName, double mPrice, int mcount) {
		super();
		this.uId = uId;
		this.mId = mId;
		this.mName = mName;
		this.mPrice = mPrice;
		this.mcount = mcount;
		this.mtotal=mPrice*mcount;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public double getmPrice() {
		return mPrice;
	}

	public void setmPrice(double mPrice) {
		this.mPrice = mPrice;
	}

	public int getMcount() {
		return mcount;
	}

	public void setMcount(int mcount) {
		this.mcount = mcount;
	}

	public double getMtotal() {
		return mtotal;
	}

	public void setMtotal() {
		this.mtotal = this.mPrice*this.mcount;
	}

	@Override
	public String toString() {
		return "ShoppingCar [uId=" + uId + ", mId=" + mId + ", mName=" + mName + ", mPrice=" + mPrice + ", mcount="
				+ mcount + ", mtotal=" + mtotal + "]";
	}
	
	
	
	
	
}
