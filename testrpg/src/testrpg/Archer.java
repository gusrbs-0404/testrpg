package testrpg;

public class Archer extends Player {

	public Archer(String name, int hp, int mp, int att, int def) {
		super(Player.getname(), getHp(), 150, Player.getAtt(), getDef());
	}

	private static int getHp() {
		int hp = ran.nextInt(300) + 100;
		return hp;
	}

	private static int getDef() {
		int def = ran.nextInt(50) + 30;
		return def;
	}
}
