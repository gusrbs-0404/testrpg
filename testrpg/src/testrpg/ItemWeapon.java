package testrpg;

public class ItemWeapon extends Item {

	public ItemWeapon() {
		super(WEAPON, getName(title()), Item.plusAttAnddet(), Item.plusAttAnddet(), Item.price());
	}

	public static String title() {
		String[] weapon = { "검", "활", "완드", "단검", "아대", "너클", "총" };

		int ranIndex = ran.nextInt(weapon.length);

		return weapon[ranIndex];
	}
}
