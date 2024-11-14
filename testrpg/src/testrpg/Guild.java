package testrpg;

public class Guild implements Stage, Runnable {

	@Override
	public void run() {
		System.out.println("=====[GUILD]=====");
		System.out.println("[1. 길드원조회] [2. 길드원영입] [3. 길드원추방] [4. 종료]");
	}
}
