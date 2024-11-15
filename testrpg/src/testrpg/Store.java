package testrpg;

public class Store extends Stage implements Runnable {

	private boolean isStore = true;

	@Override
	public void run() {
		isStore = true;
		while (isStore) {
			try {
				System.out.println("=====[STORE]=====");
				System.out.println("[1. 구매] [2. 판매] [3. 종료]");
				buffer.setLength(0);
				System.out.print("메뉴 입력 : ");
				String select = reader.readLine();
				menu(select);
			} catch (Exception e) {
			}
		}
	}

	private void menu(String select) {
		if (select.equals("구매")) {
			purchase();
		} else if (select.equals("판매")) {
			sale();
		} else if (select.equals("종료")) {
			System.out.println("상점에서 나왔습니다.");
			Thread lobbyThread = new Thread(Lobby.lobby);
			isStore = false;
			lobbyThread.start();
		}
	}

	private void purchase() {
		// 구매
		// 구매 목록 보여주고
		// 무기 갑옷 반지 포션 
	}

	private void sale() {
		// 판매
		// 인벤토리의 목록을 보여준다
	}
}
