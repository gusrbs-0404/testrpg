package testrpg;

public class Dragon extends Monster implements Fly, Skill{

	public Dragon(String name, int hp, int att, int def, int exp) {
		super(Monster.getname("드래곤"), getHp(), getAtt(), getDef(), getExp());
	}

	private static int getHp() {
		int hp = ran.nextInt(200) + 800;
		return hp;
	}

	private static int getAtt() {
		int def = ran.nextInt(50) + 80;
		return def;
	}

	private static int getDef() {
		int def = ran.nextInt(50) + 100;
		return def;
	}

	private static int getExp() {
		int def = ran.nextInt(30) + 10;
		return def;
	}

	@Override
	public void Skill() {
		System.out.println("드래곤 브레스!");
	}

	@Override
	public void fly(Dragon dragon) {
		System.out.println("드래곤 날기!");
	}
}
