package testrpg;

import java.util.ArrayList;

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
			}
		}
	}

	private void menu(String select) {
		if (select.equals("장비")) {
			equipment();
		} else if (select.equals("가방")) {
			inventory();
		} else if (select.equals("종료")) {
			System.out.println("가방을 닫았습니다.");
			Thread lobbyThread = new Thread(Lobby.lobby);
			isInventory = false;
			lobbyThread.start();
		}
	}

	private void equipment() {
		// 착용중인 장비들 보여준다

	}

	private void inventory() {
		if (RPGGame.inventory.size() == 0) {
			System.out.println("인벤토리에 아무것도 없다..");
			return;
		}
		partyPlayre();
		// 가방에 있는 장비들 보여준다
		print(RPGGame.inventory);
		// 아이템 이름 입력하면 사용, 장착가능
		try {
			System.out.print("장착할 아이템 번호 입력 : ");
			buffer.setLength(0);
			String number = reader.readLine();;
			install(number);
		} catch (Exception e) {
		}
	}
	
	private void partyPlayre() {
		// 파티 번호를 축력하고
		// 번호를 선택하고
		// 선택한 플레이어로 아이템 장착 한다

	}

	private void install(String number) {
		// 아이템 입력받고 
		int num = -1;
		try {
			num = Integer.parseInt(number) - 1;
			if (num < 0 || num >= RPGGame.inventory.size()) {
				System.err.println("잘못입력했습니다.");
			}
		} catch (Exception e) {
			System.err.println("잘못입력했습니다.");
			return;
		}
		// 장착 가능한 아이템이면 장착하고 불가능하면 장착 X
	}

	private void print(ArrayList<Item> list) {
		int count = 1;
		for (Item i : list) {
			System.out.print(count++ + "번 | ");
			System.out.println(i);
		}
	}
}
