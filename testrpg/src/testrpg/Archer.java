package testrpg;

public class Archer extends Player implements Skill, Attack {

	public Archer() {
		super(Player.getname("궁수"), getHp(), 150, Player.getAtt(), getDef());
	}

	private static int getHp() {
		int hp = ran.nextInt(300) + 100;
		return hp;
	}

	private static int getDef() {
		int def = ran.nextInt(50) + 30;
		return def;
	}

	@Override
	public void Skill() {
		System.out.println("더블샷!");
	}

	@Override
	public int attack(Unit unit) {
		int attack = unit.att;
		return attack;
		
	}

	@Override
	public int critical() {
		int critical = ran.nextInt(30)+1;
		return critical;
	}
}
