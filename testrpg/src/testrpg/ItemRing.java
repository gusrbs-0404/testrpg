package testrpg;

public class ItemRing extends Item {

	public ItemRing() {
		super(RING, ranName(), Item.plusAttAnddet(), Item.plusAttAnddet(), Item.price());
	}

	public String Name() {
		String[] weapon = { "반지", "목걸이", "팔찌", "귀걸이", "벨트" };

		int ranIndex = ran.nextInt(weapon.length);

		String name = Item.ranName() + " " + weapon[ranIndex];
		return name;
	}

}
