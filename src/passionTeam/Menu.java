package passionTeam;


public class Menu {
	//����ʵ� 
	private String[] coffee_menu = null; 
	private int[] coffee_price = null; 

	private String[] smoothie_menu = null; 
	private int[] smoothie_price = null;

	private String[] side_menu = null;
	private int[] side_price = null;

	String id;
	int pw;

	//������ //���� �ʱ�ȭ
	public Menu() {
		coffee_menu = new String[] {"�Ƹ޸�ī��(hot)", "�Ƹ޸�ī��(iced)", "ī���ī\t", "ī��� ��Ű�ƶ�"};
		coffee_price = new int[] {4500, 5000, 6000, 7000};
		smoothie_menu = new String[] {"���⽺����", "���Ʈ������"};
		smoothie_price = new int[] {6000, 5000};
		side_menu = new String[] {"ġ������", "��������"};
		side_price = new int[] {5000, 6000};   
		id = "hanna";
		pw = 1234;	
	}
	
	//get, set�� �Ἥ �޴��� ���� ���� �����ϰ� ��������
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

	//get, set�� �Ἥ ȸ�� ���̵�� ��й�ȣ ����(��ĳ�ʷ� �Է¹޴� ����) �����ϰ� ��������
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

