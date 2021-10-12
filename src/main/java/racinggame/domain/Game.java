package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private final Cars cars;
	private final Lap maxLap;
	private Lap currentLap;

	public Game(Cars cars, Lap lap) {
		this.cars = cars;
		this.maxLap = lap;
		this.currentLap = new Lap();
	}

	public boolean isFinished() {
		return this.currentLap.count() > this.maxLap.count();
	}

	public RaceResult race() {
		cars.move();
		this.currentLap = new Lap(currentLap.count() + 1);
		return createRaceResult(cars);
	}

	public RaceResult createRaceResult(Cars cars) {
		List<CarStatus> statuses = new ArrayList<>();

		for (Car car: cars.getCars()) {
			CarStatus status = new CarStatus(car.name(), car.position());
			statuses.add(status);
		}

		return new RaceResult(statuses);
	}
}
