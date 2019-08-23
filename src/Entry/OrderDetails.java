package Entry;
/** 
* @author 刘平远
* @version 创建时间：2019年8月21日 上午9:59:07 
* 类说明 :
*/
public class OrderDetails {
	private int oId;
	private int mId;
	private double mPrice;
	private int mcount;//每道菜点的数量
	private double mtotal;//每道菜的总价	

	public OrderDetails(int oId, int mId, double mPrice, int mcount, double mtotal) {
		super();
		this.oId = oId;
		this.mId = mId;
		this.mPrice = mPrice;
		this.mcount = mcount;
		this.mtotal = mtotal;
	}
	public OrderDetails() {
	}
	@Override
	public String toString() {
		return "OrderDetails [oId=" + oId + ", mId=" + mId + ", mPrice=" + mPrice + ", mcount=" + mcount + ", mtotal="
				+ mtotal + "]";
	}
	public int getoId() {
		return oId;
	}
	public void setoId(int oId) {
		this.oId = oId;
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
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
	public void setMtotal(double mtotal) {
		this.mtotal = mtotal;
	}
	
	
	
}
