package racinggame.domain;

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

	public int getPosition() {
		return this.position;
	}
}
