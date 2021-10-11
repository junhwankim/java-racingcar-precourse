package racinggame.domain;

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

	public void race() {
		cars.moveCars();
		this.currentLap = new Lap(currentLap.count() + 1);
	}
}
