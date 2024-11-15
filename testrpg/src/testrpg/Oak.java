package testrpg;

public class Oak extends Monster implements Skill, Attack{

	public Oak() {
		super(Monster.getname("오크"), getHp(), getAtt(), getDef(), getExp());
	}

	private static int getHp() {
		int hp = ran.nextInt(300) + 500;
		return hp;
	}

	private static int getAtt() {
		int def = ran.nextInt(30) + 50;
		return def;
	}

	private static int getDef() {
		int def = ran.nextInt(30) + 30;
		return def;
	}

	private static int getExp() {
		int def = ran.nextInt(10) + 1;
		return def;
	}

	@Override
	public void Skill() {
		System.out.println("구르기!");
	}
}
