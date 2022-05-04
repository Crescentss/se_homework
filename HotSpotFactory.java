package hotSpot;

import java.util.Scanner;

public class HotSpotFactory {
	public static void order(String city,String style) {
		if(city.equals("CD")) {
			//�����ɶ����
			Factory hotspot = new CDFactory();
			//�����������
			HotSpot hotSpot = hotspot.creatHotSpot(style);
			
			//�ж�����������Ƿ���ѡ����
			if(hotSpot==null) {
				System.out.println("û�и�������");
			}else {
				hotSpot.show();
			}
		}else if(city.equals("CQ")) {
			//����������
			Factory hotspot = new CQFactory();
			//�����������
			HotSpot hotSpot = hotspot.creatHotSpot(style);
			
			//�ж�����������Ƿ���ѡ����
			if(hotSpot==null) {
				System.out.println("û�и�������");
			}else {
				hotSpot.show();
			}
		}else {
			//����ĳ��в���ѡ����
			System.out.println("û�и�������");
		}
	}
	
	public static void main(String[] args) {
		//��ȡ�û�����
		Scanner sc = new Scanner(System.in);
		System.out.print("��������У�CQ or CD��:");
		String city = sc.nextLine();
		System.out.print("���������ࣨYY or MD or YR��:");
		String style = sc.nextLine();
		
		//���
		order(city,style);
		
		System.out.println("лл�ݹˣ�");
	}
}


//�����Ʒ
abstract class HotSpot {
	public abstract void show();
}


//�����Ʒ��������ࣩ
class YYHotSpot extends HotSpot{
	public void show() {
		System.out.println("ԧ����");
	}
}

class MDHotSpot extends HotSpot{
	public void show() {
		System.out.println("ë�ǻ��");
	}
}

class YRHotSpot extends HotSpot{
	public void show() {
		System.out.println("������");
	}
}


//���󹤳�
abstract class Factory{
	public abstract HotSpot creatHotSpot(String style);
}


//���幤��������������У�
//�ɶ�
class CDFactory extends Factory{
	public HotSpot creatHotSpot(String style) {
		System.out.print("�ɶ�");
		
		//�жϻ������
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

//����
class CQFactory extends Factory{
	public HotSpot creatHotSpot(String style) {
		System.out.print("����");
		
		//�жϻ������
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