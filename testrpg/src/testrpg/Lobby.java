package testrpg;

public class Lobby implements Stage, Runnable {

	// 메뉴 배틀 상점 길드 각각 스레드로 돌린다.
	// 입력 buffer wirter
	public static Lobby lobby = new Lobby();
	public static Thread lobbyThread = new Thread(lobby);

	@Override
	public void run() {
		System.out.println("=====[LOBBY]=====");
		System.out.println("[1. 전투] [2. 상점] [3. 길드] [4. 인벤토리] [5. 종료]");
		try {
			buffer.setLength(0);
			System.out.print("메뉴 입력 : ");
			String select = reader.readLine();
			menu(select);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void menu(String select) {
		if (select.equals("전투")) {
			battle();
			Battle battle = new Battle();
			Thread battleThread = new Thread(battle);
		} else if (select.equals("상점")) {
			store();
		} else if (select.equals("길드")) {
			guild();
		} else if (select.equals("인벤토리")) {
			inventory();
		} else if (select.equals("종료")) {
			lobbyThread.interrupt();
		} else {
			System.out.println("메뉴 잘못입력했습니다.");
		}
	}

	private void battle() {
		// TODO Auto-generated method stub

	}

	private void store() {
		// TODO Auto-generated method stub

	}

	private void guild() {
		// TODO Auto-generated method stub

	}

	private void inventory() {
		// TODO Auto-generated method stub

	}

}
