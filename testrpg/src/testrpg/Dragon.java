package testrpg;

public class Dragon extends Monster implements Fly, Skill, Attack {

	public Dragon() {
		super(Monster.getname("드래곤"), RanHp(), RanAtt(), RanDef(), RanExp());
	}

	private static int RanHp() {
		int hp = ran.nextInt(200) + 800;
		return hp;
	}

	private static int RanAtt() {
		int def = ran.nextInt(50) + 80;
		return def;
	}

	private static int RanDef() {
		int def = ran.nextInt(50) + 100;
		return def;
	}

	private static int RanExp() {
		int def = ran.nextInt(30) + 10;
		return def;
	}

	public int getAtt() {
		return att;
	}

	public int getHp() {
		return hp;
	}

	@Override
	public void Skill() {
		System.out.println("드래곤 브레스!");
	}

	@Override
	public void fly(Dragon dragon) {
		System.out.println("드래곤 날기!");
	}

	@Override
	public int attack(Unit unit) {
		int attack = 0;
		if (unit instanceof Dragon) {
			Dragon target = (Dragon) unit;

			attack = target.getAtt();

			if (ranCritical() == critical) {
				attack += attack / 2;
			}
			return attack;
		}
		return attack;
	}

	@Override
	public int critical() {
		return ranCritical();
	}
}
