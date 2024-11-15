package testrpg;

public class Inventory extends Stage implements Runnable {

	private boolean isInventory = true;

	@Override
	public void run() {
		while (isInventory) {
			try {
				System.out.println("=====[INVENTORY]=====");
				System.out.println("[1. 장비] [2. 가방] [3. 종료]");
				buffer.setLength(0);
				System.out.print("메뉴 입력 : ");
				String select = reader.readLine();
				menu(select);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	private void menu(String select) {
		if (select.equals("장비")) {
			equipment();
		} else if (select.equals("가방")) {
			inventory();
		} else if (select.equals("종료")) {
			System.out.println("상점에서 나왔습니다.");
			Thread lobbyThread = new Thread(Lobby.lobby);
			isInventory = false;
			lobbyThread.start();
		}
	}

	private void equipment() {
		// 착용중인 장비들 보여준다

	}

	private void inventory() {
		// 가방에 있는 장비들 보여준다
		// 아이템 이름 입력하면 사용, 장착가능

	}
}
