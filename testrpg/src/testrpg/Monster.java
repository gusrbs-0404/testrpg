package testrpg;

import java.util.Random;

public abstract class Monster {
	protected String name;
	protected int MAX_HP;
	protected int hp;
	protected int att;
	protected int def;
	protected int exp;

	public static Random ran = new Random();

	public Monster(String name, int hp, int att, int def, int exp) {
		this.name = name;
		this.hp = hp;
		this.att = att;
		this.def = def;
	}

	public static String getname(String title) {
		String[] getName = { "강력한", "활기찬", "굶주린", "인간 사냥꾼", "겁쟁이", "똑똑한", "현명한", "독", "화염", "얼음", "멍청한" };
		int nameSize = ran.nextInt(getName.length);

		String name = getName + " " + title;
		return name;
	}
}
