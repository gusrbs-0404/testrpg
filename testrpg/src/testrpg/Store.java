package testrpg;

public class Store implements Stage, Runnable {
	
	@Override
	public void run() {
		System.out.println("=====[STORE]=====");
		System.out.println("[1. 구매] [2. 판매] [3. 종료]");
	}
}
