package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarStatusTest {
	@ParameterizedTest
	@DisplayName("Car Status는 이름과 position으로 구성된다.")
	@CsvSource(value = {"mario:2", "luigi:3", "yoshi:1"}, delimiter = ':')
	void testCarStatus(String name, int position) {
		CarStatus status = new CarStatus(name, position);

		assertThat(status.name()).isEqualTo(name);
		assertThat(status.position()).isEqualTo(position);
	}
}