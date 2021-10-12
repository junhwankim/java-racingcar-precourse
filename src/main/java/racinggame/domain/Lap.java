package racinggame.domain;

import racinggame.config.message;

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
			throw new IllegalArgumentException(message.ERROR_LAP_COUNT_NOT_CORRECT);
	}

	public int count() {
		return this.lapCount;
	}
}
