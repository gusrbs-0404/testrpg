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
			System.out.println("길드메뉴룰 종료합니다.");
			Thread lobbyThread = new Thread(Lobby.lobby);
			isGuild = false;
			lobbyThread.start();
		}

	}

	private void inquiry() {
		// 길드원 조회 최대 10명
		// 전부 출력
		if (RPGGame.player.size() == 0) {
			System.err.println("길드원이 없습니다.");
			return;
		}
		printPlayer();
	}

	private void printPlayer() {
		int count = 1;
		for (Player i : RPGGame.player) {
			System.out.print(count++ + "번 | ");
			System.out.println(i);
		}
		System.out.printf("총인원 수 : %d\n", RPGGame.player.size());
	}

	private void recruit() {
		// 영입
		// 랜덤으로 아무나 대리고옴
		if (RPGGame.player.size() == 10) {
			System.err.println("최대인원 입니다!");
			return;
		}

		int ranNum = ran.nextInt(5) + 1;

		if (ranNum == ARCHER) {
			Archer archer = new Archer();
			RPGGame.player.add(archer);
			System.out.println("궁수 영입완료!");
		} else if (ranNum == WARRIOR) {
			Warrior warrior = new Warrior();
			RPGGame.player.add(warrior);
			System.out.println("전사 영입완료!");
		} else if (ranNum == WIZARD) {
			Wizard wizard = new Wizard();
			RPGGame.player.add(wizard);
			System.out.println("마법사 영입완료!");
		} else if (ranNum == BANDIT) {
			Bandit bandit = new Bandit();
			RPGGame.player.add(bandit);
			System.out.println("도적 영입완료!");
		} else if (ranNum == PIRATE) {
			Pirate pirate = new Pirate();
			RPGGame.player.add(pirate);
			System.out.println("해적 영입완료!");
		}
	}

	private void deport() {
		// 추방
		if (RPGGame.player.size() == 0) {
			System.err.println("길드원이 없습니다.");
			return;
		}
		// 길드원 출력
		printPlayer();
		// 선택한 길드원 이름 으로 추방
		try {
			System.out.print("추방할 길드원 번호 입력 : ");
			buffer.setLength(0);
			String number = reader.readLine();
			inputIndex(number);
		} catch (Exception e) {
		}
	}

	private void inputIndex(String number) {
		int num = -1;
		try {
			num = Integer.parseInt(number) - 1;
			if (num < 0 || num >= RPGGame.player.size()) {
				System.err.println("잘못입력했습니다.");
			}
		} catch (Exception e) {
			System.err.println("잘못입력했습니다.");
			return;
		}

		System.out.printf("%s\n 를 추방합니다.\n", RPGGame.player.get(num));
		RPGGame.player.remove(num);
	}
}
