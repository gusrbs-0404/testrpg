package testrpg;

import java.util.ArrayList;

public class RPGGame {

	public static ArrayList<Player> player = new ArrayList<>();

	public static ArrayList<Player> party = new ArrayList<>();

	public static ArrayList<Item> inventory = new ArrayList<>();

	public static ArrayList<Item> storeItem = new ArrayList<>();

	public static int partyMoney = 0; 

	private void RPGGame() {
	}

	private static RPGGame instance = new RPGGame();

	public static RPGGame getInstance() {
		return instance;
	}

	public void run() {
		Lobby.lobbyThread.start();
	}

}
