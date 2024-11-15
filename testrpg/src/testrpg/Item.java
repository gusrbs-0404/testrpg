package testrpg;

import java.util.Random;

public class Item {
	static final int WEAPON = 1;
	static final int ARMOR = 2;
	static final int RING = 3;

	int kind; // 종류
	String name; // 이름
	int plusAtt; // 공격력
	int plusdet; // 방어력
	int price; // 가격

	public static Random ran = new Random();

	public Item(int kind, String name, int plusAtt, int plusdet, int price) {
		this.kind = kind;
		this.name = name;
		this.plusAtt = plusAtt;
		this.plusdet = plusdet;
		this.price = price;
	}

	public static String ranName() {
		String[] kind = { "나무", "철", "금", "다이아몬드" };
		int kindIndex = ran.nextInt(kind.length);
		return kind[kindIndex];
	}

	public static int plusAttAnddet() {
		int ranAttDet = ran.nextInt(90) + 10;
		return ranAttDet;
	}

	public static int price() {
		int ranPrice = ran.nextInt(2400) + 500;
		return ranPrice;
	}

	@Override
	public String toString() {
		String msg = String.format("%s | [공격력 %d] | [방어력 %d]\n[가격 %d]", name, plusAtt, plusdet, price);
		return super.toString();
	}
}
