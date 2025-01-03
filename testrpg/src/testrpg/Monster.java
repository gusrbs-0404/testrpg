package testrpg;

public abstract class Monster extends Unit {
	public Monster(String name, int hp, int att, int def, int exp) {
		this.name = name;
		this.MAX_HP = hp;
		this.hp = hp;
		this.att = att;
		this.def = def;
	}

	protected String name;
	protected int MAX_HP;
	protected int hp;
	protected int att;
	protected int def;
	protected int exp;

	public static String getname(String title) {
		String[] getName = { "강력한", "독", "화염", "얼음", "나무", "바다" };
		int nameSize = ran.nextInt(getName.length);

		String name = getName[nameSize] + " " + title;
		System.out.println(name);
		return name;
	}

	public static int monsterInteger() {
		int monsterInteger = 1;
		return monsterInteger;
	}

	@Override
	public String toString() {
		String msg = String.format("[%s] | [%d/%d]\n [공격력 : %d | 방어력 : %d]", name, hp, MAX_HP, att, def);
		return msg;
	}
}
