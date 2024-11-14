package testrpg;

public class Lobby implements Stage, Runnable {

	// 메뉴 배틀 상점 길드 각각 스레드로 돌린다.
	// 입력 buffer wirter
	
	@Override
	public void run() {
		System.out.println("=====[LOBBY]=====");
		System.out.println("[1. 전투] [2. 상점] [3. 길드] [4. 인벤토리] [5. 종료]");
		
		try {
			buffer.setLength(0);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
