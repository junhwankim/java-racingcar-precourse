package racinggame.domain;

public enum MoveCommand {
	FORWARD, STOP;

	static final int FORWARD_NUMBER = 4;

	public static MoveCommand convertMoveCommand(RandomNumber randomNumber) {
		if (randomNumber.isGreaterThanOrEqualTo(FORWARD_NUMBER))
			return FORWARD;

		return STOP;
	}
}
