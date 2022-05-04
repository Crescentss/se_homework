package hotSpot;

import java.util.Scanner;

public class HotSpotFactory {
	public static void order(String city,String style) {
		if(city.equals("CD")) {
			//创建成都火锅
			Factory hotspot = new CDFactory();
			//创建火锅种类
			HotSpot hotSpot = hotspot.creatHotSpot(style);
			
			//判断输入的种类是否在选项内
			if(hotSpot==null) {
				System.out.println("没有该类火锅！");
			}else {
				hotSpot.show();
			}
		}else if(city.equals("CQ")) {
			//创建重庆火锅
			Factory hotspot = new CQFactory();
			//创建火锅种类
			HotSpot hotSpot = hotspot.creatHotSpot(style);
			
			//判断输入的种类是否在选项内
			if(hotSpot==null) {
				System.out.println("没有该类火锅！");
			}else {
				hotSpot.show();
			}
		}else {
			//输入的城市不在选项内
			System.out.println("没有该类火锅！");
		}
	}
	
	public static void main(String[] args) {
		//获取用户需求
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入城市（CQ or CD）:");
		String city = sc.nextLine();
		System.out.print("请输入种类（YY or MD or YR）:");
		String style = sc.nextLine();
		
		//点餐
		order(city,style);
		
		System.out.println("谢谢惠顾！");
	}
}


//抽象产品
abstract class HotSpot {
	public abstract void show();
}


//具体产品（火锅种类）
class YYHotSpot extends HotSpot{
	public void show() {
		System.out.println("鸳鸯火锅");
	}
}

class MDHotSpot extends HotSpot{
	public void show() {
		System.out.println("毛肚火锅");
	}
}

class YRHotSpot extends HotSpot{
	public void show() {
		System.out.println("羊肉火锅");
	}
}


//抽象工厂
abstract class Factory{
	public abstract HotSpot creatHotSpot(String style);
}


//具体工厂（火锅所属城市）
//成都
class CDFactory extends Factory{
	public HotSpot creatHotSpot(String style) {
		System.out.print("成都");
		
		//判断火锅种类
		if(style.equals("YY")) {
			return new YYHotSpot();
		}else if(style.equals("MD")) {
			return new MDHotSpot();
		}else if(style.equals("YR")) {
			return new YRHotSpot();
		}else {
			return null;
		}
	}
}

//重庆
class CQFactory extends Factory{
	public HotSpot creatHotSpot(String style) {
		System.out.print("重庆");
		
		//判断火锅种类
		if(style.equals("YY")) {
			return new YYHotSpot();
		}else if(style.equals("MD")) {
			return new MDHotSpot();
		}else if(style.equals("YR")) {
			return new YRHotSpot();
		}else {
			return null;
		}
	}
}