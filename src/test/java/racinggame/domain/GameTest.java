package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTest {
	@Test
	void testGameFinished() {
		Cars cars = Cars.createCars("mario,luigi");
		Lap lap = new Lap(3);
		Game game = new Game(cars, lap);

		assertThat(game.isFinished()).isFalse();

		for (int i = 0; i < lap.count(); i++) {
			game.race();
		}

		assertThat(game.isFinished()).isTrue();
	}
}