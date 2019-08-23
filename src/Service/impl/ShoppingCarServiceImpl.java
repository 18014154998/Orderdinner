package Service.impl;

import java.util.List;
import java.util.Scanner;

import DAO.ShoppingCarDao;
import DAO.impl.ShoppingCarDaoImpl;
import Entry.ShoppingCar;
import Service.MenuService;
import Service.ShoppingCarService;
import UI.MainPage;
import jdk.nashorn.internal.ir.BreakableNode;
import sun.applet.Main;

/** 
* @author 刘平远
* @version 创建时间：2019年8月21日 上午10:18:29 
* 类说明 :
*/
public class ShoppingCarServiceImpl  implements ShoppingCarService {

	ShoppingCarDao dao=new ShoppingCarDaoImpl();
	MenuService menuService=new MenuServiceImpl();
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
	
	@Override
	public void addmenu(int uid) {
		ShoppingCar car=new ShoppingCar();
		System.out.println("亲，请输入菜谱的编号和数量：");
		int mid=getintnum();
		int mcount=getintnum();
		car.setuId(uid);car.setmId(mid);car.setMcount(mcount);
		int i =dao.insert(car);
		if (i>0) {
			menuService.updatemcount(mcount, mid);
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败");
		}
		
	}
	//修改自己点的菜单，分为再添加新的菜谱，和修改当前的菜的数量 
	@Override
	public boolean changemenu(int uid) {
		System.out.println();
		System.out.println("请选择需要修改的项目：1 修改当前菜谱的数量   2 添加新的菜谱   其他键则退出修改界面  ");
		int num=getintnum();
		if (num==1) {
			System.out.println("请输入需要修改的菜编号，后修改后的数量，修改为0就是删除");
			int mid=getintnum();
			int mcount=getintnum();
			
			//用户在第一次点菜的时候，菜单余量就变化了，当他在最后修改的时候，菜的余量并没有增加或者减少
			//现在要做的是 -> 当用户修改菜单的时候，购物车的信息变化，（菜的数量，和总价变化）->    实现了
			//菜单表中菜的余量变化。   ->  
			//如果使用map集合 就比较简单了。
			
			ShoppingCar car=new ShoppingCar(uid, mid, mcount);
			int i=dao.update(car);
			if (i>0) {
				System.out.println("修改成功");
				return true;
			}else {
				System.out.println("修改失败");
				return false;
			}
		}else if (num==2) {
			//添加新的菜谱
			MenuService menuService=new MenuServiceImpl();
			menuService.findAllMenu();
			addmenu(uid);
			return true;
		}else {
			return true;
		}
		
		
		
	}
	
	//打印出我自己点的菜单
	@Override
	public void showmymenu(int uid) {
		
		List<ShoppingCar> cars=dao.findmymenu(uid);
		System.out.println("菜编号"+"\t"+"菜名"+"\t"+"价格"+"\t"+"数量"+"\t"+"总价"+"\t" );
		for (int i = 0; i < cars.size(); i++) {
			System.out.println(cars.get(i).getmId()+"\t"+cars.get(i).getmName()+"\t"+cars.get(i).getmPrice()+"\t"+cars.get(i).getMcount()+"\t"+cars.get(i).getMtotal()+"\t");
		}
		
	}
	@Override
	public void set1(int getuId) {
		int i = dao.set11(getuId);
		if (i>0) {
			System.out.println("操作均已经完成，that‘s  grate ！！！");
		}
		else {
			System.out.println("最后一步出篓子了！！！");
		}
	}
	@Override
	public void showhostry(int getuId) {
		List<ShoppingCar> cars= dao.showhostryinfo(getuId);
		System.out.println("菜编号"+"\t"+"菜名"+"\t"+"价格"+"\t"+"数量"+"\t"+"总价"+"\t" );
		for (int i = 0; i < cars.size(); i++) {
			System.out.println(cars.get(i).getmId()+"\t"+cars.get(i).getmName()+"\t"+cars.get(i).getmPrice()+"\t"+cars.get(i).getMcount()+"\t"+cars.get(i).getMtotal()+"\t");
		}
		
	}

}
