package testrpg;

public class Battle extends Stage implements Runnable {
	private boolean isBattle = true;

	@Override
	public void run() {
		isBattle = true;
		while (isBattle) {
			try {
				System.out.println("=====[BATTLE]=====");
				System.out.println("[1. 좀비] [2. 오크(LV3↑)] [3. 드래곤(LV5↑)] [4. 종료]");
				buffer.setLength(0);
				System.out.print("메뉴 입력 : ");
				String select = reader.readLine();
				menu(select);
			} catch (Exception e) {

			}
		}
	}

	private void menu(String select) {
		if (select.equals("좀비")) {
			zombie();
		} else if (select.equals("오크")) {
			oak();
		} else if (select.equals("드래곤")) {
			dragon();
		} else if (select.equals("종료")) {
			System.out.println("전투 종료합니다.");
			Thread lobbyThread = new Thread(Lobby.lobby);
			isBattle = false;
			lobbyThread.start();
		}

	}

	private void zombie() {
		Zombie zombie = new Zombie();
		System.out.println(zombie);
	}

	private void oak() {
		Oak oak = new Oak();
		System.out.println(oak);
	}

	private void dragon() {
		Dragon dragon = new Dragon();
		System.out.println(dragon);
		int a = dragon.attack(dragon);
		System.out.println(a);
	}
	
	

}
