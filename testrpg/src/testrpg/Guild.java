package testrpg;

public class Guild extends Stage implements Runnable {

	private final int ARCHER = 1;
	private final int WARRIOR = 2;
	private final int WIZARD = 3;
	private final int BANDIT = 4;
	private final int PIRATE = 5;

	private boolean isGuild = true;

	@Override
	public void run() {
		while (isGuild) {
			try {
				System.out.println("=====[GUILD]=====");
				System.out.println("[1. 조회] [2. 영입] [3. 추방] [4. 종료]");
				buffer.setLength(0);
				System.out.print("메뉴 입력 : ");
				String select = reader.readLine();
				menu(select);
			} catch (Exception e) {
			}
		}
	}

	private void menu(String select) {
		if (select.equals("조회")) {
			inquiry();
		} else if (select.equals("영입")) {
			recruit();
		} else if (select.equals("추방")) {
			deport();
		} else if (select.equals("종료")) {
			System.out.println("전투 종료합니다.");
			Thread lobbyThread = new Thread(Lobby.lobby);
			isGuild = false;
			lobbyThread.start();
		}

	}

	private void inquiry() {
		// 길드원 조회 최대 10명
		// 전부 출력
		
	}

	private void recruit() {
		// 영입
		// 랜덤으로 아무나 대리고옴
		ranUnit();
		System.out.println(player);

	}

	private void ranUnit() {
		int ranNum = ran.nextInt(5) + 1;
		System.out.println(ranNum);
		if (ranNum == ARCHER) {
			Archer archer = new Archer();
			player.add(archer);
		} else if (ranNum == WARRIOR) {
			Warrior warrior = new Warrior();
			player.add(warrior);
		} else if (ranNum == WIZARD) {
			Wizard wizard = new Wizard();
			player.add(wizard);
		} else if (ranNum == BANDIT) {
			Bandit bandit = new Bandit();
			player.add(bandit);
		} else if (ranNum == PIRATE) {
			Pirate pirate = new Pirate();
			player.add(pirate);
		}
	}

	private void deport() {
		// 추방
		// 길드원 출력
		// 선택한 길드원 이름 으로 추방

	}
}
