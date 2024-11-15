package testrpg;

public class ItemArmor extends Item {

	public ItemArmor() {
		super(ARMOR, getName(title()), Item.plusAttAnddet(), Item.plusAttAnddet(), Item.price());
	}

	public static String title() {
		String[] armor = { "모자", "상의", "바지", "신발" };

		int ranIndex = ran.nextInt(armor.length);

		return armor[ranIndex];
	}
}
