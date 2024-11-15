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
		} else if (select.equals("추방")) {
			System.out.println("전투 종료합니다.");
			Thread lobbyThread = new Thread(Lobby.lobby);
			isParty = false;
			lobbyThread.start();
		}

	}
	private void inquiry() {
		// 길드원 조회 최대 10명
		// 전부 출력
		if (RPGGame.party.size() == 0) {
			System.out.println("길드원이 없습니다.");
			return;
		}
		printPlayer();
	}

	public void printPlayer() {
		int count = 1;
		for (Player i : RPGGame.player) {
			System.out.print(count++ + "번 | ");
			System.out.println(i);
		}
		System.out.printf("총인원 수 : %d\n", RPGGame.player.size());
	}

	private void recruit() {
		// TODO Auto-generated method stub
		
	}

	private void deport() {
		// TODO Auto-generated method stub
		
	}
}
