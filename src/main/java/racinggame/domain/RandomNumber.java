package racinggame.domain;

import static nextstep.utils.Randoms.*;

public class RandomNumber {
	public static final int RANDOM_NUMBER_RANGE_MIN = 0;
	public static final int RANDOM_NUM_RANGE_MAX = 9;
	private final int value;

	private RandomNumber() {
		this.value = pickNumberInRange(RANDOM_NUMBER_RANGE_MIN, RANDOM_NUM_RANGE_MAX);
	}

	public static RandomNumber generateRandomNumber() {
		return new RandomNumber();
	}

	public int Value() {
		return value;
	}
}
