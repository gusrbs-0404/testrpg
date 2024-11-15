package testrpg;

public class Pirate extends Player implements Skill, Attack{

	public Pirate() {
		super(Player.getname("해적"), getHp(), 200, Player.getAtt(), getDef());
	}

	private static int getHp() {
		int hp = ran.nextInt(400) + 300;
		return hp;
	}

	private static int getDef() {
		int def = ran.nextInt(50) + 30;
		return def;
	}
	
	@Override
	public void Skill() {

	}
}
