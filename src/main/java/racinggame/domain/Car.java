package racinggame.domain;

import java.util.Objects;

public class Car {
	private final Name name;
	private Position position;

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
			this.position = new Position(this.getPosition() + 1);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car)o;
		return Objects.equals(name, car.name) && Objects.equals(position, car.position);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, position);
	}
}
