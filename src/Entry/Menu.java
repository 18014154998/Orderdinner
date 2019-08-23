package Entry;
/** 
* @author 刘平远
* @version 创建时间：2019年8月20日 下午4:39:21 
* 类说明 :
*/
public class Menu {
	private int mId;
	private int mtType;
	private String mName;
	private String mtTypeName;
	private double mPrice;
	private int mCount;
	
	@Override
	public String toString() {
		return "Menu [mId=" + mId + ", mtType=" + mtType + ", mName=" + mName + ", mtTypeName=" + mtTypeName
				+ ", mPrice=" + mPrice + ", mCount=" + mCount + "]";
	}
	
	

	public Menu(int mId, int mtType, String mName, String mtTypeName, double mPrice, int mCount) {
		super();
		this.mId = mId;
		this.mtType = mtType;
		this.mName = mName;
		this.mtTypeName = mtTypeName;
		this.mPrice = mPrice;
		this.mCount = mCount;
	}



	public Menu(int mtType, String mName, String mtTypeName, double mPrice, int mCount) {
		super();
		this.mtType = mtType;
		this.mName = mName;
		this.mtTypeName = mtTypeName;
		this.mPrice = mPrice;
		this.mCount = mCount;
	}

	public Menu() {
	}
	
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public int getMtType() {
		return mtType;
	}
	public void setMtType(int mtType) {
		this.mtType = mtType;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getMtTypeName() {
		return mtTypeName;
	}
	public void setMtTypeName(String mtTypeName) {
		this.mtTypeName = mtTypeName;
	}
	public double getmPrice() {
		return mPrice;
	}
	public void setmPrice(double mPrice) {
		this.mPrice = mPrice;
	}
	public int getmCount() {
		return mCount;
	}
	public void setmCount(int mCount) {
		this.mCount = mCount;
	}

	
	
}
