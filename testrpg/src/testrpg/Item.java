package testrpg;

public class Item {
	final int WEAPON = 1;
	final int ARMOR = 2;
	final int RING = 3;

	int kind; // 종류
	String name; // 이름
	int plusAtt; // 공격력
	int plusdet; // 방어력
	int price; // 가격

	public void setItem(int kind, String name, int plusAtt, int plusdet, int price) {
		this.kind = kind;
		this.name = name;
		this.plusAtt = plusAtt;
		this.plusdet = plusdet;
		this.price = price;
	}
}
