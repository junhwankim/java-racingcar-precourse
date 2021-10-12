package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import racinggame.config.message;

public class Cars {
	static final String CAR_NAME_SEPARATOR = ",";
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

	public void move() {
		for (Car car : this.cars) {
			RandomNumber randomNumber = RandomNumber.generateRandomNumber();
			MoveCommand command = MoveCommand.convertMoveCommand(randomNumber);
			car.move(command);
		}
	}

	private static void validateNotNull(String carNames) {
		if (carNames == null)
			throw new IllegalArgumentException(message.ERROR_CARS_LENGTH_NOT_CORRECT);
	}

	private void validateCarsSize(List<Car> cars) {
		if (cars.size() < 2)
			throw new IllegalArgumentException(message.ERROR_CARS_LENGTH_NOT_CORRECT);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Cars cars1 = (Cars)o;
		return Objects.equals(cars, cars1.cars);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cars);
	}
}
