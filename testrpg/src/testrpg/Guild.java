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
		if(player.size() == 0) {
			System.out.println("길드원이 없습니다.");
			return;
		}
		printPlayer();
	}

	private void printPlayer() {
		for (Player i : player) {
			System.out.println(i);
		}
		System.out.printf("총인원 수 : %d\n", player.size());
	}

	private void recruit() {
		// 영입
		// 랜덤으로 아무나 대리고옴
		if (player.size() == 10) {
			System.out.println("최대인원 입니다!");
			return;
		}

		int ranNum = ran.nextInt(5) + 1;

		if (ranNum == ARCHER) {
			Archer archer = new Archer();
			player.add(archer);
			System.out.println("궁수 영입완료!");
		} else if (ranNum == WARRIOR) {
			Warrior warrior = new Warrior();
			player.add(warrior);
			System.out.println("전사 영입완료!");
		} else if (ranNum == WIZARD) {
			Wizard wizard = new Wizard();
			player.add(wizard);
			System.out.println("마법사 영입완료!");
		} else if (ranNum == BANDIT) {
			Bandit bandit = new Bandit();
			player.add(bandit);
			System.out.println("도적 영입완료!");
		} else if (ranNum == PIRATE) {
			Pirate pirate = new Pirate();
			player.add(pirate);
			System.out.println("해적 영입완료!");
		}
	}

	private void deport() {
		// 추방
		// 길드원 출력
		printPlayer();
		// 선택한 길드원 이름 으로 추방
		
	}
}
