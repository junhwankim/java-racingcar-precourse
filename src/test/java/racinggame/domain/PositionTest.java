package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {
	@Test
	@DisplayName("기본 값은 0이다.")
	void testInitialValueIsZero() {
		Position position = new Position();
		assertThat(position.position()).isEqualTo(0);
	}

	@Test
	@DisplayName("위치 값을 지정해서 생성할 수 있다.")
	void testSpecificPosition() {
		Position position = new Position(3);
		assertThat(position.position()).isEqualTo(3);
	}

	@Test
	@DisplayName("0보다 작은 위치 값은 허용되지 않는다.")
	void testNotAllowedLessThanZero() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Position(-2));
	}
}