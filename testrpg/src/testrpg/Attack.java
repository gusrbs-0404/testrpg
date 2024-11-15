package testrpg;

interface Attack {
	public final int critical = 1;

	public int attack(Unit unit);

	public int critical();
}
