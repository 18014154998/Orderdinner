package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.org.apache.bcel.internal.generic.Select;

/** 
* @author 刘平远
* @version 创建时间：2019年8月19日 上午10:18:52 
* 类说明 :
*/
public class DatabaseUntils {
	
	private static final String driver="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://127.0.1:3306/dc?characterEncoding=UTF-8";
	private static final String root="root";
	private static final String pwd="123456789";

	private static  Connection conn=null;
	private static  PreparedStatement ps=null;
	private static  ResultSet rs=null;
	
	//加载类驱动
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//连接数据库
	protected static void getconnection() {
		try {
			conn=DriverManager.getConnection(url, root, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//开启事务方法
	protected static void begtransacaton() {
		//首先获取连接
		getconnection();
		//把自动提交功能关闭
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//提交事务
	protected static void commit() {
		try {
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//回滚事务
	protected static void rollback() {
		try {
			conn.rollback();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获取最大的主键值
	protected static int getMaxkey(String sql) {
		begtransacaton();//开启事务，包括获取连接。
		int key =0;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				key=rs.getInt(1);
			}
			commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			rollback();
		}
		
		return key ;
	}
	
	
	
	//增删改操作
	protected static int excuteupdate(String sql,Object[] object) {
		int count=0;//计算多少条数据被操作了，返回这个值
		begtransacaton();//开启事务，包括获取连接。
		try {
			//sql中的值以？来传入sql preparestatement中
			// update `order`  set  ispay = 1 where O_U_ID = ?  and O_ID = ?   uid,oid
			ps=conn.prepareStatement(sql);
			if (null!=object) {
				for (int i = 0; i < object.length; i++) {
					ps.setObject(i+1, object[i]);
				}
			}
			//将影响的条数返回出来
			count=ps.executeUpdate();
			//没有错误就提交事务
			commit();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
			//出现错误就回滚
			rollback();
		}finally {
			//最终关闭连接
			colseconnection();
		}
		return count;
		
	}
	
	//公共的查询方法
	protected static ResultSet executeQuery(String sql,Object[] obj){
			begtransacaton();
			try {
				ps = conn.prepareStatement(sql);
				//obj有内容  进行sql语句拼装
				if(null!=obj){
					for(int i=0;i<obj.length;i++){
						ps.setObject(i+1, obj[i]);//将Object[]数组中  每个位置的内容  替换? 内容  
					}
				}
				//如果Object[] 中没有内容，则认为sql文是完整的   可以直接使用 
				rs = ps.executeQuery();
				commit();//提交事务
			} catch (SQLException e) {
				// 如果操作失败，肯定会发生异常，这个时候进行回滚事务
				e.printStackTrace();
				rollback();//回滚事务
			}//在这个公共方法里  不要使用finally  进行关闭资源操作   因为结果集rs对象  需要处理，关闭后  无法处理
			return rs;
		}
	
	//分页查询
	protected static ResultSet list(String sql,int start,int count) {
		begtransacaton();
		try {
			sql=sql+"  limit "+(start-1)*count+" , "+count*start+" ";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rollback();
		}
		return rs;
	}
	
	//关闭连接
	protected static void colseconnection() {
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps==null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn==null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
}
