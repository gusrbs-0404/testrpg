package testrpg;

public class Warrior extends Player {

	public Warrior(String name, int hp, int mp, int att, int def) {
		super(Player.getname(), getHp(), 150, Player.getAtt(), getDef());
	}

	private static int getHp() {
		int hp = ran.nextInt(500) + 400;
		return hp;
	}

	private static int getDef() {
		int def = ran.nextInt(80) + 50;
		return def;
	}

}
