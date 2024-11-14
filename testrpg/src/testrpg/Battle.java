package testrpg;

public class Battle implements Stage, Runnable {

	@Override
	public void run() {
		System.out.println("=====[BATTLE]=====");
		System.out.println("[1. 좀비] [2. 오크(LV3↑)] [3. 드래곤(LV5↑)] [4. 종료]");
	}

}
