package UI;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import DAO.OrderDetailsDAO;
import DAO.impl.OrderDaoImpl;
import Entry.Menu;
import Entry.User;
import Service.MenuService;
import Service.OrderDatilsService;
import Service.OrderService;
import Service.ShoppingCarService;
import Service.impl.MenuServiceImpl;
import Service.impl.OrderDatilsServiceImpl;
import Service.impl.OrderServiceImpl;
import Service.impl.ShoppingCarServiceImpl;
import Service.impl.UserServiceImpl;
import Utils.Isnull;

/** 
* @author 刘平远
* @version 创建时间：2019年8月20日 下午3:20:36 
* 类说明 :
*/
public class MainPage {
	 public static User customer=new User();
	
	//主方法
	public static void main(String[] args) {
		int num=0;
		System.out.println("***********************************************");
		System.out.println("**           欢迎来到平远七星酒店                                       ****");
		System.out.println("**           请选择以下服务项目 :               ****");
		System.out.println("**           1 注册    2 登陆    3 点餐    4 退出                 *****");
		System.out.println("***************5   注册用户查看历史菜单**************");
		System.out.println("**********************************************");
		System.out.print("请选择服务项目:  ");
		while(true) {
			num=getintnum();
			if (num==1) {
				//调用注册函数
				userregister();
			}else if (num==2) {
				//调用登陆函数
				userlogin();
			}else if (num==3) {
				//调用点餐函数
				orderDinner();
				
			}else if (num==4) {
				System.exit(0);
			}else if (num==5) {
				//判断用户是否为注册用户
				if (customer.getuId()==0) {
					System.out.println("您不是注册用户，请先注册！请重新输入！");
				}else {
					System.out.println(customer.getuName()+"先生，您好"+"您的历史账单如下：");
					//调用查看历史购物车的信息
					ShoppingCarService car=new ShoppingCarServiceImpl();
					car.showhostry(customer.getuId());
				}
			}
			else {
				System.out.println("您输入的有误，请重新输入！");
			}
		}
		
	}
	
	//以下方法是顾客的方法
	//点菜种类选项/
	public static void orderDinner() {
		MenuService menuService=new MenuServiceImpl();
		ShoppingCarService carService=new ShoppingCarServiceImpl();
		OrderService orderService=new OrderServiceImpl();
		OrderDatilsService datilsService=new OrderDatilsServiceImpl();
		int key = 0 ;
		System.out.println("请选择种类：1 荤菜  2 素菜 3 饮品 4 所有菜单  其他数字则退出 ");
		outer:while (true) {
			int num=getintnum();
			switch (num) {
			case 1:
				menuService.findAMenuBytype(1);
				//调用点菜函数。
				//调用service里面的函数  进行点菜
				carService.addmenu(customer.getuId());
				//打印出现在已经点的菜单
				System.out.println("这是你的菜单：");
				carService.showmymenu(customer.getuId());
				System.out.println();
				System.out.println("请选择种类：1 荤菜  2 素菜 3 饮品 4 所有菜单  其他数字则退出");
				     break;
			case 2:
				menuService.findAMenuBytype(2);
				//调用点菜函数。
				carService.addmenu(customer.getuId());
				//打印出现在已经点的菜单
				System.out.println("这是你的菜单：");
				carService.showmymenu(customer.getuId());
				System.out.println();
				System.out.println("请选择种类：1 荤菜  2 素菜 3 饮品 4 所有菜单  其他数字则退出");
			     	break;
			case 3:
				menuService.findAMenuBytype(3);	
				//调用点菜函数。
				carService.addmenu(customer.getuId());
				//打印出现在已经点的菜单
				System.out.println("这是你的菜单：");
				carService.showmymenu(customer.getuId());
				System.out.println();
				System.out.println("请选择种类：1 荤菜  2 素菜 3 饮品 4 所有菜单  其他数字则退出");
					break;
			case 4:
				//调用查看全部菜单函数
				putallmenu();
				//调用点菜函数。
				carService.addmenu(customer.getuId());
				//打印出现在已经点的菜单
				System.out.println("这是你的菜单：");
				carService.showmymenu(customer.getuId());
				System.out.println();
				System.out.println("请选择种类：1 荤菜  2 素菜 3 饮品 4 所有菜单  其他数字则退出");
					break;
			default:
				   break outer;
			}
		
		}//while结束了，即点菜结束了。
		System.out.println("这是您的最终菜谱:");
		carService.showmymenu(customer.getuId());
		System.out.println("如果需要修改，则输入1，其他键则不必修改，那么将生成订单");
		int xxxx= getintnum();
		//修改菜谱
		if (xxxx==1) {
			outer:while(true) {
				carService.changemenu(customer.getuId());
				System.out.println("继续修改按1， 修改完毕安其他键");
				int m=getintnum();
				if (m!=1) {
					break outer; 
				}
			}//修改完成了  打印最终的账单
		System.out.println("这是您的最终菜谱:");
		carService.showmymenu(customer.getuId());
		System.out.println();
		//生成订单, 订单生成后用户点餐程序结束,将用户的购物车信息存入订单表和订单详情表。
		orderService.addorder(customer.getuId());
		key=orderService.getkey();
		System.out.println("订单生成，后厨正在给您做，请耐心等待一下。");
		}
		//不需要修改
		else {
			//生成订单, 订单生成后用户点餐程序结束,将用户的购物车信息存入订单表和订单详情表。
			orderService.addorder(customer.getuId());
			key=orderService.getkey();
			System.out.println("key is "+key);
			System.out.println("订单生成，后厨正在给您做，请耐心等待一下。");
		}
		//以上，订单生成完毕。
		System.out.println();
		System.out.println("您在平远七星酒店吃点很happy，并且时不时的傻笑。");
		//让他睡5s  再运行下面。
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("过了2个小时。。。。。。。。。。。。。。。。。。。。。。。");
		System.out.println();
		//下面，先进行结算，在生成订单详情表
		System.out.println("这是您的账单,请结算一下。");
		//显示账单
		carService.showmymenu(customer.getuId());
		//结算了账单。//如何获取订单编号？
		System.out.println(" 主键  和 uid 分别是 "+ customer.getuId()+"  "+ key);
		orderService.updateorder(customer.getuId(), key);
		//生成订单详情表
		datilsService.adddatils();
		carService.set1(customer.getuId());
		System.out.println("欢迎下次在来！！！！！！");
		
	}
	
	//查看全部菜单函数
	public static void putallmenu() {
		MenuService menuService=new MenuServiceImpl();
		menuService.findAllMenu();
	}

	//用户注册
	public static void userregister() {
		System.out.println("请输入您的用户名,密码和手机号码：");
		String  name=getstringstr();boolean checkname=Isnull.isnull(name);
		String  pwd=getstringstr();boolean checkpwd=Isnull.isnull(pwd);
		String  phone=getstringstr();boolean checkphone=Isnull.isnull(phone);
		//判空
		if (checkname||checkphone||checkpwd) {
			System.out.println("都不能为空！！");
			userregister();
		}else {
			User user=new User(name, pwd, phone);
			UserServiceImpl impl=UserServiceImpl.getInstance();
			boolean b=impl.checkRegister(user);
			if (b) {
				System.out.println("恭喜你注册成功！现在可以登陆了！");
				main(null);
			}else {
				System.out.println("注册失败！请重新输入提示信息！");
				userregister();
			}
		}
	}
	
	//用户登陆
	public static void userlogin() {
		System.out.println("请输入您的账号和密码：");
		String  name=getstringstr();
		String  pwd=getstringstr();
		if (name.equals("admin")) {
			
			if (pwd.equals("123456")) {
				System.out.println("欢迎进入管理员界面，请选择您的操作：");
				outer:while (true) {
					System.out.println("1 添加新的菜单   2  删除旧的菜单   3 更新菜谱的信息   4 查看指定日期的销售额   其他值为退出，回到主界面 ");
					//显示管理员界面
					int num=getintnum();
					switch (num) {
					case 1:
						addnewmenu();
						     break;
					case 2:
						deleteoldmenu();
					     	break;
					case 3:
						addmuencount();
							break;
					case 4:
						getdatesales();
							break;
					default:
						   break outer;
					}
				}
				main(null);
			}
			else {
				System.out.println("你输入的账号密码不正确，请重新输入！");
				userlogin();
			}
			
		}else if (!name.equals("admin")) {
			User user=new User();
			user.setuName(name);
			user.setuPwd(pwd);
			UserServiceImpl impl=UserServiceImpl.getInstance();
			boolean b=impl.userLogin(user);
			if (b) {
				customer.setuId(user.getuId());
				customer.setuName(user.getuName());
				System.out.println(customer.getuName()+"先生,恭喜您登陆成功！现在可以点菜了！");
				//显示主界面
				main(null);
			}else {
				System.out.println("登陆失败！请重新输入提示信息！");
				userlogin();
			}
		}
	
	}
	
	//以下是管理员特有的权限
	//  4 查看指定日期的销售额
	public static void getdatesales() {
		OrderService orderService=new OrderServiceImpl();
		System.out.println("haimei shixian ");
		System.out.println("请输入需要查询的日期：格式按照  1970-01-01");
		String d=getstringstr();
		String d1=d+" 00:00:01.0" ;
		String d2=d+" 23:59:59.0" ;
		System.out.println(d1);
		//使用数据库的timestamp
		Timestamp ts1=new Timestamp(System.currentTimeMillis());
		Timestamp ts2=new Timestamp(System.currentTimeMillis());
		ts1=Timestamp.valueOf(d1);
		ts2=Timestamp.valueOf(d2);
	//	System.out.println(ts2);
		//调用orderservice中的showsaleonday中的函数，将data传入。
		orderService.showsalesoneday(ts1,ts2);
		
		
	}

	//3 更新菜谱的信息
	public static void addmuencount() {
		MenuService menuService=new MenuServiceImpl();
		System.out.println("请输入需要修改的菜谱的id，并且输入修改后的价格和余量");
		int mid=getintnum();
		double price=(double)getintnum();
		int count=getintnum();
		menuService.findMenuBymid(mid);
		menuService.updateMenuBymid(mid, price, count);
	}

	// 2  删除旧的菜单    
	public static void deleteoldmenu() {
		System.out.println("请输入需要删除的菜谱的编号mId");
		int id=getintnum();
		MenuService menuService=new MenuServiceImpl();
		menuService.deleteoldmenu(id);
	}

	//1 添加新的菜单
	public static void addnewmenu() {
		System.out.println("请输入新加的菜谱信息： 类型编号int  菜名string   菜谱类型名string   价格double   数量int    ");
		int typeid=getintnum();
		String name=getstringstr();
		String typename=getstringstr();
		double price=(double)getintnum();
		int count=getintnum();
		//这样写容易出错
		/*String [] mitem=info.split(" ");
		for (int i = 0; i < mitem.length; i++) {
			mitem[i]=mitem[i].trim();
		}*/
		Menu menu=new Menu(typeid,name,typename,price,count);
		MenuService menuService=new MenuServiceImpl();
		boolean b =menuService.addnewmenu0(menu);
		if (b) {
			System.out.println("添加成功!");
		}else {
			System.out.println("添加失败！");
		}
	}


	//获取输入的数字和字符
		public static int getintnum() {
			Scanner scanner=new Scanner(System.in);
			int num=scanner.nextInt();
			return num;
		}
		public static String getstringstr() {
			Scanner scanner=new Scanner(System.in);
			String str=scanner.nextLine();
			return str;
		}
		
}
