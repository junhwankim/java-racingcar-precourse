package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
	@Test
	@DisplayName("생성 테스트")
	void testCar() {
		String name = "mario";
		Car car = new Car(name);

		assertThat(car.getName()).isEqualTo(name);
		assertThat(car.getPosition()).isEqualTo(0);
	}
}