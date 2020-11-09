package passionTeam;

import java.util.Scanner;

public class Action {
	Scanner scan = new Scanner(System.in);
	
	//MenuŬ���� ����
	Menu in;
	
	//������ �޴��� ��Ƴ��� ����
	String[] orderMenu;
	int[] orderPrice;
	
	//�ֹ��� �޴� ���� �� �ݾ�
	int count; 
	int total;

	//ȸ�� ID�� PW�� �̸� ����
	String settingId = null;
	int settingPwd;

	int coffeeCount;
	int shotPrice;
	int coupon; //Ŀ�� ����


	public Action() {	//�����ڿ��� ���� �ʱ�ȭ
		in = new Menu();
		orderMenu = new String[20];
		orderPrice = new int[20];
		count = 0;
		total = 0;
		settingId = "hanna";
		settingPwd = 1234;
		coffeeCount = 0;
		shotPrice = 500;
		coupon = 0;
		choose();
	}
	public void choose() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("  �ް�Ŀ�ǿ� ���� ���� ȯ���մϴ�.  ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("�����ϼ���.");
		System.out.println("1.�����ϱ�\t 2.�԰���");
		int whereTo = scan.nextInt();
		
		cafeFrontDesk();
	} //choose
	
	public void cafeFrontDesk() {
		while(true) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("1.�ֹ��ϱ�\t 2.����ϱ�");
			int frontDesk = scan.nextInt();
			if(frontDesk == 1) {
				mainMenu();
			}else {
				pay();
				break;
			}
		} //while
	}

	public void mainMenu() {
		System.out.println("~~~~~~~~~~~~�޴�~~~~~~~~~~~~");
		System.out.println("1.Ŀ��\t 2.������\t 3.���̵�޴�");
		int whichOne = scan.nextInt();
		switch(whichOne) {
		case 1:   
			coffeeMenu();
			break;
		case 2:   
			smoothieMenu();
			break;
		case 3:
			sideMenu();
			break;   
		}
	} //mainMenu()
	
	public void coffeeMenu() {
		System.out.println("~~~~~~~~~~~~Ŀ��~~~~~~~~~~~~");
		for(int i = 0; i<in.getCoffee_menu().length; i++) {
			//Ŀ�� �޴���
			System.out.println( (i+1) + "." +in.getCoffee_menu()[i] + "\t" + in.getCoffee_price()[i] + "��");
		}
		int coffee = scan.nextInt();

		if(coffee == 1) {
			orderMenu[count] = "�Ƹ޸�ī��(hot)";
			orderPrice[count] = 4500;
			total = total + in.getCoffee_price()[0];
			count++;
			coffeeCount++;
			
		} else if(coffee == 2) {
			orderMenu[count] = "�Ƹ޸�ī��(iced)";
			orderPrice[count] = 5000;
			total = total + in.getCoffee_price()[1];
			count++;
			coffeeCount++;
			
		} else if(coffee == 3) {
			orderMenu[count] = "ī���ī\t";
			orderPrice[count] = 6000;
			total = total + in.getCoffee_price()[2];
			count++;
			coffeeCount++;
			
		} else {
			orderMenu[count] = "ī��� ��Ű�ƶ�";
			orderPrice[count] = 7000;
			total = total + in.getCoffee_price()[3];
			count++;
			coffeeCount++;
		}
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("���� �߰� �Ͻðڽ��ϱ�?");
		System.out.println("1.�� | 2.�ƴϿ�");
		int shot = scan.nextInt();

		if(shot == 1) {
			System.out.println("�󸶳� �߰��Ͻǰǰ���?");
			int shot_num = scan.nextInt();
			orderMenu[count] = "���� �߰�\t";
			orderPrice[count] = shotPrice*shot_num;                    
			total = total + orderPrice[count];   
			count++;
		}
	} //coffee()
	
	public void smoothieMenu() {
		System.out.println("~~~~~~~~~~~~������~~~~~~~~~~~");
		for(int i = 0; i<in.getSmoothie_menu().length; i++) {
			//������ �޴���
			System.out.println((i+1) + "." + in.getSmoothie_menu()[i] + "\t" + in.getSmoothie_price()[i] + "��");                   
		}
		int smoothie = scan.nextInt();

		if(smoothie == 1) {
			orderMenu[count] = "���� ������";
			orderPrice[count] = 6000;
			total = total + in.getSmoothie_price()[0];
			count++;

		}else {
			orderMenu[count] = "���Ʈ ������";
			orderPrice[count] = 5000;
			total = total + in.getSmoothie_price()[1];
			count++;

		}
	} //smoothie()
	
	public void sideMenu() {
		System.out.println("~~~~~~~~~~~~���̵�~~~~~~~~~~~");
		for(int i = 0; i<in.getSide_menu().length; i++) {
			//���̵� �޴���
			System.out.println( (i+1) + "." + in.getSide_menu()[i] + "\t\t" + in.getSide_price()[i] + "��");                   
		}
		int side = scan.nextInt();

		if(side == 1) {
			orderMenu[count] = "ġ������ũ\t";
			orderPrice[count] = 5000;
			total = total + in.getSide_price()[0];
			count++;

		}else {
			orderMenu[count] = "��������ũ\t";
			orderPrice[count] = 6000;
			total = total + in.getSide_price()[1];
			count++;

		}          
	} //side
	
	public void pay() {
		System.out.println("�ް�Ŀ�� ȸ���̽ʴϱ�?");
		System.out.println("1.�� | 2.�ƴϿ�");
		int member = scan.nextInt();
		
		while(true){
			if(member == 1) {	
				//ȸ���� ���
				System.out.println("���̵� �Է����ּ���.");
				in.setId(scan.next());
				
				System.out.println("��й�ȣ�� �Է����ּ���.");
				in.setPw(scan.nextInt());
				
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");

				if(in.getId().equals(settingId) && in.getPw() == settingPwd) {
					//ID�� PW�� ��ġ�ϴ� ���
					System.out.println("\t���� Ŀ����: "+coffeeCount +"��");
					System.out.println("(*Ŀ�� 3���� �����Ǹ� Ŀ�� 1�� ����)");
					
					if(coffeeCount/3 >= 0) {
						coupon = coffeeCount/3;
						System.out.println("\tĿ�� ���� ����"+ coupon +" ��");
						receipt();
						break;
					}                  
				}
				//ID�� PW�� ��ġ���� �ʴ� ���
				else if(in.getId().equals(settingId) || in.getPw() == settingPwd) {
					System.out.println("ID�� PW�� ��ġ���� �ʽ��ϴ�.");
					System.out.println("�ٽ� Ȯ�����ּ���.");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				}else {
					System.out.println("ID�� PW�� ��ġ���� �ʽ��ϴ�.");
					System.out.println("�ٽ� Ȯ�����ּ���.");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				}

			}else {
				//ȸ���� �ƴ� ���
				receipt();
				break;
			}
		}//while
	}//public void pay() {

	public void receipt() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("           ������            ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0; i<count; i++) {
			System.out.println(orderMenu[i] + "\t" + orderPrice[i] + "��");                  
		}
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.printf("�� �����ݾ�: %d��",total);
		System.out.println(); 

	}
	
} 


