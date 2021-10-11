package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	public static final String CAR_NAME_SEPARATOR = ",";
	private final List<Car> cars;

	private Cars(List<Car> cars) {
		validateCarsSize(cars);

		this.cars = cars;
	}

	public static Cars createCars(String carNames) {
		validateNotNull(carNames);

		String[] names = carNames.split(CAR_NAME_SEPARATOR);
		ArrayList<Car> cars = new ArrayList<>();

		for (String name: names) {
			cars.add(Car.createCar(name));
		}

		return new Cars(cars);
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

	private static void validateNotNull(String carNames) {
		if (carNames == null)
			throw new IllegalArgumentException("[ERROR] 자동차는 2대 이상이어야 합니다.");
	}

	private void validateCarsSize(List<Car> cars) {
		if (cars.size() < 2)
			throw new IllegalArgumentException("[ERROR] 자동차는 2대 이상이어야 합니다.");
	}
}
