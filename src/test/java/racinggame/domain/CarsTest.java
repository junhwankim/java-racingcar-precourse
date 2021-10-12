package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
	@Test
	@DisplayName("자동차 목록은 null 일 수 없다.")
	void testCarsNotAllowedNull() {
		assertThatIllegalArgumentException().isThrownBy(() -> Cars.createCars(null));
	}

	@Test
	@DisplayName("자동차는 2대 이상이어야 한다.")
	void testCarsSizeGreaterOrEqualsTwo() {
		assertThatIllegalArgumentException().isThrownBy(() -> Cars.createCars("mario"));
	}

	@Test
	@DisplayName("Car List를 얻어올 수 있다.")
	void testGetCars() {
		Cars cars = Cars.createCars("mario,luigi");
		List<Car> carList = cars.getCars();

		assertThat(carList).hasSize(2);
		assertThat(carList.get(0).name()).isEqualTo("mario");
		assertThat(carList.get(1).name()).isEqualTo("luigi");
	}

	@Test
	@DisplayName("자동차 이동 테스트, 자동차는 전진했거나 멈춰있다.")
	void testMoveCars() {
		Cars cars = Cars.createCars("mario,luigi");
		cars.move();

		for (Car car : cars.getCars()) {
			assertThat(car.position()).isIn(0, 1);
		}
	}
}