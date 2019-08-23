package Entry;
/** 
* @author 刘平远
* @version 创建时间：2019年8月21日 上午9:55:24 
* 类说明 :
*/

import java.util.Date;

public class Order {
	private int oId;
	private int ouId;
	private Date date;
	private double consumeamount;
	private int  ispay;
	
	public Order() {
	}

	public Order(int oId, int ouId, Date date) {
		super();
		this.oId = oId;
		this.ouId = ouId;
		this.date = date;
	}

	public Order(int oId, int ouId, Date date, double consumeamount) {
		super();
		this.oId = oId;
		this.ouId = ouId;
		this.date = date;
		this.consumeamount = consumeamount;
	}

	@Override
	public String toString() {
		return "Order [oId=" + oId + ", ouId=" + ouId + ", date=" + date + ", consumeamount=" + consumeamount
				+ ", ispay=" + ispay + "]";
	}

	public int getoId() {
		return oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
	}

	public int getOuId() {
		return ouId;
	}

	public void setOuId(int ouId) {
		this.ouId = ouId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getConsumeamount() {
		return consumeamount;
	}

	public void setConsumeamount(double consumeamount) {
		this.consumeamount = consumeamount;
	}

	public int getIspay() {
		return ispay;
	}

	public void setIspay(int ispay) {
		this.ispay = ispay;
	}
	
	

	
	
}
