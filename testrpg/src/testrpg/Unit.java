package testrpg;

import java.util.Random;

public abstract class Unit {
	protected String name;
	protected int hp;
	protected int MAX_HP;
	protected int mp;
	protected int MAX_MP;
	protected int level;
	protected int MAX_EXP;
	protected int exp;
	protected int att;
	protected int def;

	protected Item weapon;
	protected Item armor;
	protected Item ring;

	protected boolean party;
	
	public static Random ran = new Random();

	public Unit(String name, int hp, int mp, int att, int def) {
		this.name = name;
		this.MAX_HP = hp;
		this.hp = hp;
		this.MAX_MP = mp;
		this.mp = mp;
		this.level = 1;
		this.MAX_EXP = 10;
		this.exp = 0;
		this.att = att;
		this.def = def;
		this.weapon = null;
		this.armor = null;
		this.ring = null;
	}

	public Unit() {
		this.name = name;
		this.MAX_HP = hp;
		this.hp = hp;
		this.att = att;
		this.def = def;
	}
}
