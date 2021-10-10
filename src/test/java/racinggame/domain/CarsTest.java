package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
	@Test
	@DisplayName("자동차 목록은 null 일 수 없다.")
	void testCarsNotAllowedNull() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Cars(null));
	}

	@Test
	@DisplayName("자동차는 2대 이상이어야 한다.")
	void testCarsSizeGreaterOrEqualsTwo() {
		List<Car> cars = Arrays.asList(new Car("mario"));

		assertThatIllegalArgumentException().isThrownBy(() -> new Cars(cars));
	}

	@Test
	@DisplayName("Car List를 얻어올 수 있다.")
	void testGetCars() {
		Car car1 = new Car("mario");
		Car car2 = new Car("luigi");

		Cars cars = new Cars(Arrays.asList(car1, car2));
		List<Car> carList = cars.getCars();

		assertThat(carList).hasSize(2);
		assertThat(carList.get(0).getName()).isEqualTo(car1.getName());
		assertThat(carList.get(1).getName()).isEqualTo(car2.getName());
	}

	@Test
	@DisplayName("자동차 이동 테스트, 자동차는 전진했거나 멈춰있다.")
	void testMoveCars() {
		Car car1 = new Car("mario");
		Car car2 = new Car("luigi");

		Cars cars = new Cars(Arrays.asList(car1, car2));
		cars.moveCars();

		assertThat(car1.getPosition()).isIn(0, 1);
		assertThat(car2.getPosition()).isIn(0, 1);
	}
}