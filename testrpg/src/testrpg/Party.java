package testrpg;

public class Party extends Stage implements Runnable {

	private boolean isParty = true;

	@Override
	public void run() {
		while (isParty) {
			try {
				System.out.println("=====[PARTY]=====");
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
			System.out.println("파티메뉴를 종료합니다.");
			Thread lobbyThread = new Thread(Lobby.lobby);
			isParty = false;
			lobbyThread.start();
		}

	}

	private void inquiry() {
		// 전부 출력
		if (RPGGame.party.size() == 0) {
			System.err.println("파티원이 없습니다.");
			return;
		}
		printParty();
	}

	public void printParty() {
		int count = 1;
		for (Player i : RPGGame.party) {
			System.out.print(count++ + "번 | ");
			System.out.println(i);
		}
		System.out.printf("총인원 수 : %d\n", RPGGame.party.size());
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
		// 파티원 4명
		if (RPGGame.party.size() == 4) {
			System.err.println("파티원 모집이 끝났습니다.");
			return;
		}

		if (RPGGame.player.size() == 0) {
			System.err.println("길드원이 없습니다.");
			return;
		}

		printPlayer();
		try {
			System.out.print("파티 모집할 길드원 번호 입력 : ");
			buffer.setLength(0);
			String number = reader.readLine();
			inputParty(number);
		} catch (Exception e) {
		}
	}

	private void inputParty(String number) {
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

		String name = RPGGame.player.get(num).name;
		for (Player i : RPGGame.party) {
			if (i.name.equals(name)) {
				System.err.println("이미 파티에 모집한 길드원입니다.");
				return;
			}
		}

		System.out.printf("%s\n 를 파티모집 합니다.\n", name);
		RPGGame.party.add(RPGGame.player.get(num));
	}

	private void deport() {
		if (RPGGame.party.size() == 0) {
			System.err.println("파티원이 없습니다.");
			return;
		}
		printParty();
		try {
			System.out.print("추방할 파티원 번호 입력 : ");
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
			if (num < 0 || num >= RPGGame.party.size()) {
				System.err.println("잘못입력했습니다.");
			}
		} catch (Exception e) {
			System.err.println("잘못입력했습니다.");
			return;
		}

		System.out.printf("%s\n 를 추방합니다.\n", RPGGame.party.get(num));
		RPGGame.party.remove(num);

	}
}
