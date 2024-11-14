package testrpg;

public class Wizard extends Player implements Skill{

	public Wizard(String name, int hp, int mp, int att, int def) {
		super(Player.getname(), getHp(), 300, Player.getAtt(), getDef());
	}

	private static int getHp() {
		int hp = ran.nextInt(100) + 200;
		return hp;
	}

	private static int getDef() {
		int def = ran.nextInt(30) + 10;
		return def;
	}

	@Override
	public void Skill() {
		System.out.println("메테오!");
	}
}
