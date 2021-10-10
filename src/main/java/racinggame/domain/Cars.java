package racinggame.domain;

import java.util.List;

public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		validateNotNull(cars);
		validateCarsSize(cars);

		this.cars = cars;
	}

	public List<Car> getCars() {
		return this.cars;
	}

	public void moveCars() {
		for (Car car : this.cars) {
			RandomNumber randomNumber = RandomNumber.generateRandomNumber();
			MoveCommand command = MoveCommand.convertMoveCommand(randomNumber);
			car.move(command);
		}
	}

	private void validateNotNull(List<Car> cars) {
		if (cars == null)
			throw new IllegalArgumentException("[ERROR] 자동차는 2대 이상이어야 합니다.");
	}

	private void validateCarsSize(List<Car> cars) {
		if (cars.size() < 2)
			throw new IllegalArgumentException("[ERROR] 자동차는 2대 이상이어야 합니다.");
	}
}
