package testrpg;

public class ItemWeapon extends Item {

	public ItemWeapon() {
		super(WEAPON, ranName(), Item.plusAttAnddet(), Item.plusAttAnddet(), Item.price());
	}

	public String Name() {
		String[] weapon = { "검", "활", "완드", "단검", "아대", "너클", "총" };

		int ranIndex = ran.nextInt(weapon.length);

		String name = Item.ranName() + " " + weapon[ranIndex];
		return name;
	}
}
