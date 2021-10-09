package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

	private Position position;

	@BeforeEach
	void setUp() {
		position = new Position();
	}

	@Test
	@DisplayName("초기값은 0이다.")
	void testInitialValueIsZero() {
		assertThat(position.getPosition()).isEqualTo(0);
	}

	@Test
	@DisplayName("전진하면 position이 1 증가한다.")
	void testPosition() {
		position.moveForward();

		assertThat(position.getPosition()).isEqualTo(1);
	}
}