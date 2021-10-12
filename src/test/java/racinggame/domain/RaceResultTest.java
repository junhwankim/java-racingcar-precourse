package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceResultTest {

	private List<CarStatus> statuses;
	private CarStatus testStatus1;
	private CarStatus testStatus2;

	@BeforeEach
	void setUp() {
		statuses = new ArrayList<>();
		testStatus1 = new CarStatus("mario", 2);
		testStatus2 = new CarStatus("luigi", 3);

		statuses.add(testStatus1);
		statuses.add(testStatus2);
	}

	@Test
	@DisplayName("RaceResult는 Lap별 CarStatus를 관리한다.")
	void testRaceResult() {
		RaceResult raceResult = new RaceResult(statuses);

		assertThat(raceResult.getCarStatuses()).hasSize(2);
		assertThat(raceResult.getCarStatuses().get(0)).isEqualTo(testStatus1);
		assertThat(raceResult.getCarStatuses().get(1)).isEqualTo(testStatus2);
	}
}