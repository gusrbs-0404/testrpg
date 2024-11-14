package testrpg;

public class Bandit extends Player implements Skill{

	public Bandit(String name, int hp, int mp, int att, int def) {
		super(Player.getname(), getHp(), 200, Player.getAtt(), getDef());
	}

	private static int getHp() {
		int hp = ran.nextInt(300) + 200;
		return hp;
	}

	private static int getDef() {
		int def = ran.nextInt(40) + 30;
		return def;
	}

	@Override
	public void Skill() {
		System.out.println("치명적인 공격!");
	}

}
