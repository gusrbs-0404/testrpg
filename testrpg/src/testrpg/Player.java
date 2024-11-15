package testrpg;

public class Player extends Unit {

	public int money;

	public Player(String name, int hp, int mp, int att, int def) {
		super(name, hp, mp, att, def);
	}

	public static String getname(String title) {
		String[] name1 = { "나약한", "배고픈", "강력한", "무기력한", "다재다능한", "다재무능한", "현란한", "묵직한", "장난쓰러운", "왕족", "귀족", "노비", "평민",
				"재빠른" };
		String[] name2 = { "길동이", "둘리", "희동이", "짱구", "도라애몽", "노진구", "퉁퉁이", "훈이", "맹구", "철수", "유리", "비실이", "이슬이", "흰둥이",
				"검둥이", "누렁이" };

		int name1Size = ran.nextInt(name1.length);
		int name2Size = ran.nextInt(name2.length);

		String name = name1[name1Size] + " " + name2[name2Size] + " " + title;
		return name;
	}

	public static int getAtt() {
		int att = ran.nextInt(70) + 30;
		return att;
	}

	@Override
	public String toString() {
		String msg = String.format("%s |[LV %d] | [체력 %d/%d] | [마나 %d/%d]\n\t[공격력 %d] | [방어력 %d] | [경험치 %d/%d] ", name,
				level, hp, MAX_HP, mp, MAX_MP, att, def, exp, MAX_EXP);
		return msg;
	}

}
