package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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
		assertThat(car.getName()).isEqualTo(name);
		assertThat(car.getPosition()).isEqualTo(0);
	}

	@Test
	@DisplayName("이동 명령에 따라 움직여야 한다.")
	void testMoveCommandForward() {
		car.move(MoveCommand.FORWARD);

		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("이동 명령에 따라 움직여야 한다.")
	void testMoveCommandStop() {
		car.move(MoveCommand.STOP);

		assertThat(car.getPosition()).isEqualTo(0);
	}
}