package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	private String name;
	private Car car;

	@BeforeEach
	void setUp() {
		name = "mario";
		car = Car.createCar(name);
	}

	@Test
	@DisplayName("생성 테스트")
	void testCar() {
		assertThat(car.name()).isEqualTo(name);
		assertThat(car.position()).isEqualTo(0);
	}

	@Test
	@DisplayName("FORWARD 명령을 받으면 이동한다.")
	void testMoveCommandForward() {
		car.move(MoveCommand.FORWARD);

		assertThat(car.position()).isEqualTo(1);
	}

	@Test
	@DisplayName("STOP 명령을 받으면 이동하지 않는다.")
	void testMoveCommandStop() {
		car.move(MoveCommand.STOP);

		assertThat(car.position()).isEqualTo(0);
	}
}