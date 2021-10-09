package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {
	@ParameterizedTest
	@ValueSource(strings = {"apple", "tea", "milk", "k", "jh"})
	@DisplayName("동일한 이름을 반환해야 한다.")
	void testSameName(String input) {
		Name name = new Name(input);

		assertThat(name.getName()).isEqualTo(input);
	}

	@ParameterizedTest
	@ValueSource(strings = {"apple", "tea", "milk", "k", "jh"})
	@DisplayName("동일한 길이여야 한다.")
	void testSameLength(String input) {
		Name name = new Name(input);

		assertThat(name.length()).isEqualTo(input.length());
	}

	@Test
	@DisplayName("이름은 null 일 수 없다.")
	void testNameNotAllowedNull() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Name(null));
	}

	@Test
	@DisplayName("이름은 길이가 0인 빈 문자열 일 수 없다.")
	void testNameNotAllowedEmptyString() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Name(""));
	}

	@Test
	@DisplayName("이름의 길이는 5자를 초과할 수 없다.")
	void testNameLengthNotAllowedGreaterThanFiveChar() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Name("pororo"));
	}

	@Test
	@DisplayName("이름에 공백을 포함할 수 없다.")
	void testNameNotAllowedContainsWhiteSpace() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Name("얼 그레이"));
	}
}
