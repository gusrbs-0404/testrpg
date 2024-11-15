package testrpg;

public class Store implements Stage, Runnable {

	private boolean isStore = true;

	@Override
	public void run() {
		isStore = true;
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

	}

	private void sale() {

	}
}
