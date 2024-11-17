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
			if (RPGGame.party.size() < 4) {
				System.err.println("충분한 파티원을 모집하고 전투하세요!");
				return;
			}
			zombie();
		} else if (select.equals("오크")) {
			if (RPGGame.party.size() < 4) {
				System.err.println("충분한 파티원을 모집하고 전투하세요!");
				return;
			}
			oak();
		} else if (select.equals("드래곤")) {
			if (RPGGame.party.size() < 4) {
				System.err.println("충분한 파티원을 모집하고 전투하세요!");
				return;
			}
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

		battlePlay(zombie);
	}

	private void oak() {
		oak = new Oak();
		battlePlay(oak);
	}

	private void dragon() {
		dragon = new Dragon();
		battlePlay(dragon);
	}

	private void battlePlay(Monster monster) {
		boolean isrun = true;
		while (isrun) {
			int action = action();

			int playreIndex = actionplayerIndex();

			int damage;
			switch (action) {
			case 0:
				damage = RPGGame.party.get(playreIndex).att;
				System.out.println(RPGGame.party.get(playreIndex).name + "이(가) 일반 공격! 데미지: " + damage);
				break;
			case 1:
				damage = RPGGame.party.get(playreIndex).att + 50;
				System.out.println(RPGGame.party.get(playreIndex).name + "이(가) 치명타 공격! 데미지: " + damage);
				break;
			case 2:
				damage = RPGGame.party.get(playreIndex).att + 100;
				System.out.println(RPGGame.party.get(playreIndex).name + "이(가) 스킬 공격! 데미지: " + damage);
				break;
			default:
				damage = 0;
				break;
			}

			System.out.println("남은 몬스터의 체력 : " + monster.hp);

			if (!isHpMonster(monster)) {
				System.out.println("플레이어 승리!");
				isrun = false;
				return;
			}
			monster.hp -= damage;

			action = action();
			damage = 0;
			switch (action) {
			case 0:
				damage = monster.att;
				System.out.println(monster.name + "이(가) 일반 공격! 데미지: " + damage);
				break;
			case 1:
				damage = zombie.att + 50;
				System.out.println(monster.name + "이(가) 치명타 공격! 데미지: " + damage);
				break;
			case 2:
				damage = zombie.att + 100;
				System.out.println(monster.name + "이(가) 스킬 공격! 데미지: " + damage);
				break;
			default:
				damage = 0;
				break;
			}

			if (!isHpUnit(RPGGame.party.get(playreIndex))) {
				System.out.println("몬스터 승리!");
				isrun = false;
				return;
			}

			System.out.println("남은 플레이어의 체력 : " + RPGGame.party.get(playreIndex).hp);
		}
	}

	private boolean isHpMonster(Monster monster) {
		if (monster.hp < 0) {
			monster.hp = 0;
			return false;
		}
		return true;
	}

	private boolean isHpUnit(Player player) {
		if (player.hp < 0) {
			player.hp = 0;
		}
		return true;
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
