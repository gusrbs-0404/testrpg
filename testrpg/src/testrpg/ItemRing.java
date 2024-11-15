package testrpg;

public class ItemRing extends Item {

	public ItemRing() {
		super(RING, getName(title()), Item.plusAttAnddet(), Item.plusAttAnddet(), Item.price());
	}

	public static String title() {
		String[] ring = { "반지", "목걸이", "팔찌", "귀걸이", "벨트" };

		int ranIndex = ran.nextInt(ring.length);

		return ring[ranIndex];
	}

}
