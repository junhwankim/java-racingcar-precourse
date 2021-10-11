package racinggame.domain;

public class Lap {
	public static final int LAP_MIN_COUNT = 1;
	private final int lapCount;

	public Lap(int lapCount) {
		validateCount(lapCount);
		this.lapCount = lapCount;
	}

	public Lap() {
		this(LAP_MIN_COUNT);
	}

	private void validateCount(int lapCount) {
		if (lapCount < LAP_MIN_COUNT)
			throw new IllegalArgumentException("[ERROR] 회수는 1 이상이어야 합니다.");
	}

	public int count() {
		return this.lapCount;
	}
}
