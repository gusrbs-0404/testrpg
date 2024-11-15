package testrpg;

import java.util.ArrayList;

public class RPGGame {

	public static ArrayList<Player> player = new ArrayList<>();

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
