package testrpg;

public class Warrior extends Player implements Skill{

	public Warrior() {
		super(Player.getname("마법사"), getHp(), 150, Player.getAtt(), getDef());
	}

	private static int getHp() {
		int hp = ran.nextInt(500) + 400;
		return hp;
	}

	private static int getDef() {
		int def = ran.nextInt(80) + 50;
		return def;
	}

	@Override
	public void Skill() {
		System.out.println("내려찍기!");
	}
}
