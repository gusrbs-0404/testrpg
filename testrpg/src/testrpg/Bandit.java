package testrpg;

public class Bandit extends Player implements Skill, Attack{

	public Bandit() {
		super(Player.getname("도적"), getHp(), 200, Player.getAtt(), getDef());
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
