package racinggame.domain;

import java.util.Objects;

import racinggame.config.message;

public class Position {
	private int position;

	public Position() {
		this(0);
	}

	public Position(int position) {
		validatePositionGreaterThanOrEqualToZero(position);
		this.position = position;
	}

	private void validatePositionGreaterThanOrEqualToZero(int position) {
		if (position < 0)
			throw new IllegalArgumentException(message.ERROR_POSITION_NOT_LESS_THAN_ZERO);
	}

	public int position() {
		return this.position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Position position1 = (Position)o;
		return position == position1.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}
}
