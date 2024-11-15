package testrpg;

public class ItemArmor extends Item {

	public ItemArmor() {
		super(ARMOR, ranName(), Item.plusAttAnddet(), Item.plusAttAnddet(), Item.price());
	}

	public String Name() {
		String[] weapon = { "모자", "상의", "바지", "신발" };

		int ranIndex = ran.nextInt(weapon.length);

		String name = Item.ranName() + " " + weapon[ranIndex];
		return name;
	}
}
