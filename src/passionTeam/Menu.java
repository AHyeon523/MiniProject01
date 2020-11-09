package passionTeam;


public class Menu {
	//멤버필드 
	private String[] coffee_menu = null; 
	private int[] coffee_price = null; 

	private String[] smoothie_menu = null; 
	private int[] smoothie_price = null;

	private String[] side_menu = null;
	private int[] side_price = null;

	String id;
	int pw;

	//생성자 //변수 초기화
	public Menu() {
		coffee_menu = new String[] {"아메리카노(hot)", "아메리카노(iced)", "카페모카\t", "카라멜 마키아또"};
		coffee_price = new int[] {4500, 5000, 6000, 7000};
		smoothie_menu = new String[] {"딸기스무디", "요거트스무디"};
		smoothie_price = new int[] {6000, 5000};
		side_menu = new String[] {"치즈케익", "초코케익"};
		side_price = new int[] {5000, 6000};   
		id = "hanna";
		pw = 1234;	
	}
	
	//get, set을 써서 메뉴와 가격 변수 셋팅하고 꺼내오기
	public String[] getCoffee_menu() {
		return coffee_menu;
	}

	public void setCoffee_menu(String[] coffee_menu) {
		this.coffee_menu = coffee_menu;
	}

	public int[] getCoffee_price() {
		return coffee_price;
	}

	public void setCoffee_price(int[] coffee_price) {
		this.coffee_price = coffee_price;
	}

	public String[] getSmoothie_menu() {
		return smoothie_menu;
	}

	public void setSmoothie_menu(String[] smoothie_menu) {
		this.smoothie_menu = smoothie_menu;
	}

	public int[] getSmoothie_price() {
		return smoothie_price;
	}

	public void setSmoothie_price(int[] smoothie_price) {
		this.smoothie_price = smoothie_price;
	}

	public String[] getSide_menu() {
		return side_menu;
	}

	public void setSide_menu(String[] side_menu) {
		this.side_menu = side_menu;
	}

	public int[] getSide_price() {
		return side_price;
	}

	public void setSide_price(int[] side_price) {
		this.side_price = side_price;
	}

	//get, set을 써서 회원 아이디와 비밀번호 변수(스캐너로 입력받는 변수) 셋팅하고 꺼내오기
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPw() {
		return pw;
	}

	public void setPw(int pw) {
		this.pw = pw;
	}

}

