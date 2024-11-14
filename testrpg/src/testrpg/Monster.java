package testrpg;

public abstract class Monster {
	protected String name;
	protected int MAX_HP;
	protected int hp;
	protected int att;
	protected int def;
	protected int exp;

	public Monster(String name, int hp, int att, int def, int exp) {
		this.name = name;
		this.hp = hp;
		this.att = att;
		this.def = def;
	}
	
	
}
