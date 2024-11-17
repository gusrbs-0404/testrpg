package testrpg;

import java.util.ArrayList;
import java.util.Random;

public class Battle extends Stage implements Runnable {
	private boolean isBattle = true;

	private Zombie zombie;
	private Oak oak;
	private Dragon dragon;

	private Random ran = new Random();

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
		zombie = new Zombie();

		while (true) {
			int action = action();

			switch (action) {
			case 0:
				damage = member.attack();
				System.out.println(member.getName() + "이(가) 일반 공격! 데미지: " + damage);
				break;
			case 1:
				damage = member.criticalHit();
				System.out.println(member.getName() + "이(가) 치명타 공격! 데미지: " + damage);
				break;
			case 2:
				damage = member.skillAttack();
				System.out.println(member.getName() + "이(가) 스킬 공격! 데미지: " + damage);
				break;
			default:
				damage = 0;
				break;
			}
		}
	}

	private void oak() {
		oak = new Oak();
		System.out.println(oak);
	}

	private void dragon() {
		dragon = new Dragon();
		System.out.println(dragon);
		int a = dragon.attack(dragon);
		System.out.println(a);
	}

	private boolean isHpMonster(Monster monster, Unit unit) {
		if (monster.hp < 0) {
			monster.hp = 0;
			return false;
		}
		return true;
	}

	private boolean isHpUnit(ArrayList<Player> party) {
		int count = 0;
		for (int i = 0; i < RPGGame.party.size(); i++) {
			if (party.get(i).hp < 0) {
				party.get(i).hp = 0;
				count++;
			}

			if (count == 4) {
				return false;
			}
		}
	}

	private int action() {
		int action = ran.nextInt(3);
		// 0 공격 1 치명타 2 스킬
		return action;
	}

	private int actionplayerIndex() {
		int playerIndex = ran.nextInt(4);
		return playerIndex;
	}

}
