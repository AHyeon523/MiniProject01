package passionTeam;

import java.util.Scanner;

public class Action {
	Scanner scan = new Scanner(System.in);
	
	//Menu클래스 선언
	Menu in;
	
	//선택한 메뉴를 담아놓는 변수
	String[] orderMenu;
	int[] orderPrice;
	
	//주문한 메뉴 수와 총 금액
	int count; 
	int total;

	//회원 ID와 PW는 미리 셋팅
	String settingId = null;
	int settingPwd;

	int coffeeCount;
	int shotPrice;
	int coupon; //커피 쿠폰


	public Action() {	//생성자에서 변수 초기화
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
		System.out.println("  메가커피에 오신 것을 환영합니다.  ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("선택하세요.");
		System.out.println("1.포장하기\t 2.먹고가기");
		int whereTo = scan.nextInt();
		
		cafeFrontDesk();
	} //choose
	
	public void cafeFrontDesk() {
		while(true) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("1.주문하기\t 2.계산하기");
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
		System.out.println("~~~~~~~~~~~~메뉴~~~~~~~~~~~~");
		System.out.println("1.커피\t 2.스무디\t 3.사이드메뉴");
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
		System.out.println("~~~~~~~~~~~~커피~~~~~~~~~~~~");
		for(int i = 0; i<in.getCoffee_menu().length; i++) {
			//커피 메뉴판
			System.out.println( (i+1) + "." +in.getCoffee_menu()[i] + "\t" + in.getCoffee_price()[i] + "원");
		}
		int coffee = scan.nextInt();

		if(coffee == 1) {
			orderMenu[count] = "아메리카노(hot)";
			orderPrice[count] = 4500;
			total = total + in.getCoffee_price()[0];
			count++;
			coffeeCount++;
			
		} else if(coffee == 2) {
			orderMenu[count] = "아메리카노(iced)";
			orderPrice[count] = 5000;
			total = total + in.getCoffee_price()[1];
			count++;
			coffeeCount++;
			
		} else if(coffee == 3) {
			orderMenu[count] = "카페모카\t";
			orderPrice[count] = 6000;
			total = total + in.getCoffee_price()[2];
			count++;
			coffeeCount++;
			
		} else {
			orderMenu[count] = "카라멜 마키아또";
			orderPrice[count] = 7000;
			total = total + in.getCoffee_price()[3];
			count++;
			coffeeCount++;
		}
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("샷을 추가 하시겠습니까?");
		System.out.println("1.예 | 2.아니오");
		int shot = scan.nextInt();

		if(shot == 1) {
			System.out.println("얼마나 추가하실건가요?");
			int shot_num = scan.nextInt();
			orderMenu[count] = "└샷 추가\t";
			orderPrice[count] = shotPrice*shot_num;                    
			total = total + orderPrice[count];   
			count++;
		}
	} //coffee()
	
	public void smoothieMenu() {
		System.out.println("~~~~~~~~~~~~스무디~~~~~~~~~~~");
		for(int i = 0; i<in.getSmoothie_menu().length; i++) {
			//스무디 메뉴판
			System.out.println((i+1) + "." + in.getSmoothie_menu()[i] + "\t" + in.getSmoothie_price()[i] + "원");                   
		}
		int smoothie = scan.nextInt();

		if(smoothie == 1) {
			orderMenu[count] = "딸기 스무디";
			orderPrice[count] = 6000;
			total = total + in.getSmoothie_price()[0];
			count++;

		}else {
			orderMenu[count] = "요거트 스무디";
			orderPrice[count] = 5000;
			total = total + in.getSmoothie_price()[1];
			count++;

		}
	} //smoothie()
	
	public void sideMenu() {
		System.out.println("~~~~~~~~~~~~사이드~~~~~~~~~~~");
		for(int i = 0; i<in.getSide_menu().length; i++) {
			//사이드 메뉴판
			System.out.println( (i+1) + "." + in.getSide_menu()[i] + "\t\t" + in.getSide_price()[i] + "원");                   
		}
		int side = scan.nextInt();

		if(side == 1) {
			orderMenu[count] = "치즈케이크\t";
			orderPrice[count] = 5000;
			total = total + in.getSide_price()[0];
			count++;

		}else {
			orderMenu[count] = "초코케이크\t";
			orderPrice[count] = 6000;
			total = total + in.getSide_price()[1];
			count++;

		}          
	} //side
	
	public void pay() {
		System.out.println("메가커피 회원이십니까?");
		System.out.println("1.예 | 2.아니오");
		int member = scan.nextInt();
		
		while(true){
			if(member == 1) {	
				//회원인 경우
				System.out.println("아이디를 입력해주세요.");
				in.setId(scan.next());
				
				System.out.println("비밀번호를 입력해주세요.");
				in.setPw(scan.nextInt());
				
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");

				if(in.getId().equals(settingId) && in.getPw() == settingPwd) {
					//ID와 PW가 일치하는 경우
					System.out.println("\t누적 커피잔: "+coffeeCount +"잔");
					System.out.println("(*커피 3잔이 적립되면 커피 1잔 무료)");
					
					if(coffeeCount/3 >= 0) {
						coupon = coffeeCount/3;
						System.out.println("\t커피 무료 쿠폰"+ coupon +" 개");
						receipt();
						break;
					}                  
				}
				//ID와 PW가 일치하지 않는 경우
				else if(in.getId().equals(settingId) || in.getPw() == settingPwd) {
					System.out.println("ID와 PW가 일치하지 않습니다.");
					System.out.println("다시 확인해주세요.");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				}else {
					System.out.println("ID와 PW가 일치하지 않습니다.");
					System.out.println("다시 확인해주세요.");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				}

			}else {
				//회원이 아닌 경우
				receipt();
				break;
			}
		}//while
	}//public void pay() {

	public void receipt() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("           영수증            ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for(int i=0; i<count; i++) {
			System.out.println(orderMenu[i] + "\t" + orderPrice[i] + "원");                  
		}
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.printf("총 결제금액: %d원",total);
		System.out.println(); 

	}
	
} 


