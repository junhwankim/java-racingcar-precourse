package racinggame.domain;

import static nextstep.utils.Randoms.*;

import java.util.Objects;

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

	public int value() {
		return value;
	}

	public boolean isGreaterThanOrEqualTo(int value) {
		return this.value >= value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		RandomNumber that = (RandomNumber)o;
		return value == that.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
