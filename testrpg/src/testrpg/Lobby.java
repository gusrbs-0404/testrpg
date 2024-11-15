package testrpg;

public class Lobby extends Stage implements Runnable {

	// 메뉴 배틀 상점 길드 각각 스레드로 돌린다.
	// 입력 buffer wirter
	static Lobby lobby = new Lobby();

	static Thread lobbyThread = new Thread(lobby);

	public static boolean isLobby = true;

	@Override
	public void run() {
		isLobby = true;
		while (isLobby) {
			try {
				System.out.println("=====[LOBBY]=====");
				System.out.println("[1. 전투] [2. 상점] [3. 길드] [4. 파티] [5. 인벤토리] [6. 종료]");
				buffer.setLength(0);
				System.out.print("메뉴 입력 : ");
				String select = reader.readLine();
				menu(select);
			} catch (Exception e) {

			}
		}
	}

	private void menu(String select) {
		if (select.equals("전투")) {
			battle();
			isLobby = false;
		} else if (select.equals("상점")) {
			store();
			isLobby = false;
		} else if (select.equals("길드")) {
			guild();
			isLobby = false;
		} else if (select.equals("파티")) {
			party();
			isLobby = false;
		} else if (select.equals("인벤토리")) {
			inventory();
			isLobby = false;
		} else if (select.equals("종료")) {
			System.out.println("종료합니다.");
			isLobby = false;
		} else {
			System.out.println("메뉴 잘못입력했습니다.");
		}
	}

	private void battle() {
		Battle battle = new Battle();
		Thread battleThread = new Thread(battle);

		battleThread.start();
	}

	private void store() {
		Store store = new Store();
		Thread storeThread = new Thread(store);

		storeThread.start();
	}

	private void guild() {
		Guild guild = new Guild();
		Thread guildThread = new Thread(guild);

		guildThread.start();
	}

	private void party() {
		Party party = new Party();
		Thread partyThread = new Thread(party);

		partyThread.start();
	}

	private void inventory() {
		Inventory inventory = new Inventory();
		Thread inventoryThread = new Thread(inventory);

		inventoryThread.start();
	}

}
