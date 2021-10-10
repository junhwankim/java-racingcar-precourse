package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberTest {
	@Test
	@DisplayName("RandomNumber는 generateRandomNumber 메소드로 생성할 수 있다.")
	void testGenerateRandomNumber() {
		assertThat(RandomNumber.generateRandomNumber()).isInstanceOf(RandomNumber.class);
	}

	@Test
	@DisplayName("RandomNumber의 값은 RANDOM_NUMBER_RANGE_MIN 이상, RANDOM_NUM_RANGE_MAX 이하이다.")
	void testRandomNumberRange() {
		RandomNumber randomNumber = RandomNumber.generateRandomNumber();

		assertThat(randomNumber.Value()).isGreaterThanOrEqualTo(RandomNumber.RANDOM_NUMBER_RANGE_MIN);
		assertThat(randomNumber.Value()).isLessThanOrEqualTo(RandomNumber.RANDOM_NUM_RANGE_MAX);
	}
}