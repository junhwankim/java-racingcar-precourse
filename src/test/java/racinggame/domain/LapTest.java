package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LapTest {
	@Test
	@DisplayName("지정한 Lap Count를 반환한다.")
	void testLapCount() {
		int lapCount = 2;
		Lap lap = new Lap(lapCount);
		assertThat(lap.count()).isEqualTo(lapCount);
	}

	@Test
	@DisplayName("Lap Count를 지정하지 않으면 Lap Count는 LAP_MIN_COUNT이다.")
	void testDefaultLap() {
		Lap lap = new Lap();
		assertThat(lap.count()).isEqualTo(Lap.LAP_MIN_COUNT);
	}

	@Test
	@DisplayName("회수는 1이상이어야 한다.")
	void testCountGreaterOrEqualsOne() {
		int lapCount = 0;
		assertThatIllegalArgumentException().isThrownBy(() -> new Lap(lapCount));
	}
}