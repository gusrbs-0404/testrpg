package testrpg;

public class Inventory implements Stage, Runnable {

	@Override
	public void run() {
		System.out.println("=====[INVENTORY]=====");
		System.out.println("[1. 장비] [2. 가방] [3. 종료]");
	}
}
