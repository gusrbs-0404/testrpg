package testrpg;

import java.util.ArrayList;

public class Store extends Stage implements Runnable {
	static final int WEAPON = 1;
	static final int ARMOR = 2;
	static final int RING = 3;

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

	private void setStoreItem() {
		for (int i = 0; i < 6; i++) {
			int ranNum = ran.nextInt(3) + 1;
			if (ranNum == WEAPON) {
				ItemWeapon weapon = new ItemWeapon();
				RPGGame.storeItem.add(weapon);
			} else if (ranNum == ARMOR) {
				ItemArmor armor = new ItemArmor();
				RPGGame.storeItem.add(armor);
			} else if (ranNum == RING) {
				ItemRing ring = new ItemRing();
				RPGGame.storeItem.add(ring);
			}
		}
	}

	private void purchase() {
		// 구매
		// 구매 목록 보여주고
		// 무기 갑옷 반지
		RPGGame.storeItem.clear();
		setStoreItem();
		print(RPGGame.storeItem);

		try {
			System.out.println("=====[STOREITEM]=====");
			buffer.setLength(0);
			System.out.print("구매할 아이템 번호 입력 : ");
			String number = reader.readLine();
			inputPurcgase(number);
		} catch (Exception e) {
		}
	}

	private void inputPurcgase(String number) {
		int num = -1;
		try {
			num = Integer.parseInt(number) - 1;
			if (num < 0 || num >= RPGGame.storeItem.size()) {
				System.err.println("잘못입력했습니다.");
			}
		} catch (Exception e) {
			System.err.println("잘못입력했습니다.");
			return;
		}

		System.out.printf("%s\n 아이템을 구매합니다.\n", RPGGame.storeItem.get(num));
		RPGGame.inventory.add(RPGGame.storeItem.get(num));
	}

	private void sale() {
		if (RPGGame.inventory.size() == 0) {
			System.out.println("아이템이 없습니다.");
			return;
		}
		// 판매
		// 인벤토리의 목록을 보여준다
		print(RPGGame.inventory);

		try {
			System.out.println("=====[INVENTORY]=====");
			buffer.setLength(0);
			System.out.print("판매할 아이템 번호 입력 : ");
			String number = reader.readLine();
			inputSale(number);
		} catch (Exception e) {
		}
	}

	private void inputSale(String number) {
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

		System.out.printf("%s\n 아이템을 판매합니다.\n", RPGGame.inventory.get(num));
		RPGGame.inventory.remove(num);
	}

	private void print(ArrayList<Item> list) {
		int count = 1;
		for (Item i : list) {
			System.out.print(count++ + "번 | ");
			System.out.println(i);
		}
	}
}
