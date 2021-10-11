package racinggame.domain;

public class Car {
	private final Name name;
	private final Position position;

	private Car(String name) {
		this.name = new Name(name);
		this.position = new Position();
	}

	public static Car createCar(String name) {
		return new Car(name);
	}

	public String getName() {
		return this.name.getName();
	}

	public int getPosition() {
		return this.position.getPosition();
	}

	public void move(MoveCommand command) {
		if (command.equals(MoveCommand.FORWARD))
			position.moveForward();
	}
}
