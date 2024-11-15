package testrpg;

public class Guild extends Stage implements Runnable {

	private boolean isGuild = true;

	@Override
	public void run() {
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
		// 새로운 길드원 랜덤으로 5명 표시
		// 원하는 길드원 이름 입력받아서 대려오기

	}

	private void ranUnit() {
		int r = ran.nextInt();
	}

	private void deport() {
		// 추방
		// 길드원 출력
		// 선택한 길드원 이름 으로 추방

	}
}
