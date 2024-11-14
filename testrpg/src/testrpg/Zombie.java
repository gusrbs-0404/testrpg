package testrpg;

public class Zombie extends Monster implements Skill{

	public Zombie(String name, int hp, int att, int def, int exp) {
		super(Monster.getname("좀비"), getHp(), getAtt(), getDef(), getExp());
	}

	private static int getHp() {
		int hp = ran.nextInt(200) + 300;
		return hp;
	}

	private static int getAtt() {
		int def = ran.nextInt(20) + 40;
		return def;
	}

	private static int getDef() {
		int def = ran.nextInt(50) + 30;
		return def;
	}

	private static int getExp() {
		int def = ran.nextInt(5) + 1;
		return def;
	}
	
	@Override
	public void Skill() {
		System.out.println("체력 회복하기!");
	}
}
