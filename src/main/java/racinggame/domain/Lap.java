package racinggame.domain;

import java.util.Objects;

import racinggame.config.message;

public class Lap {
	static final int LAP_MIN_COUNT = 1;
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lap lap = (Lap)o;
		return lapCount == lap.lapCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lapCount);
	}
}
