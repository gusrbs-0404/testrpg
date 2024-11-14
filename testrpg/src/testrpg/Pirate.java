package testrpg;

public class Pirate extends Player {

	public Pirate(String name, int hp, int mp, int att, int def) {
		super(Player.getname(), getHp(), 200, Player.getAtt(), getDef());
	}

	private static int getHp() {
		int hp = ran.nextInt(400) + 300;
		return hp;
	}

	private static int getDef() {
		int def = ran.nextInt(50) + 30;
		return def;
	}
}
