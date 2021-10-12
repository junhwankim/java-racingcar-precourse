package racinggame.domain;

import java.util.Objects;

import racinggame.config.message;

public class Name {
	public static final int NAME_MAX_LEN = 5;

	private final String name;

	public Name(String name) {
		validateNotNull(name);
		validateNotEmpty(name);
		validateLength(name);
		validateNotContainsWhiteSpace(name);

		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public int length() {
		return this.name.length();
	}

	private void validateNotNull(String name) {
		if (name == null) {
			throw new IllegalArgumentException(message.ERROR_CAR_NAME_NOT_CORRECT);
		}
	}

	private void validateNotEmpty(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(message.ERROR_CAR_NAME_NOT_CORRECT);
		}
	}

	private void validateLength(String name) {
		if (name.length() > NAME_MAX_LEN) {
			throw new IllegalArgumentException(message.ERROR_CAR_NAME_LENGTH_LIMIT_EXCEED);
		}
	}

	private void validateNotContainsWhiteSpace(String name) {
		if (name.contains(" ")) {
			throw new IllegalArgumentException(message.ERROR_CAR_NAME_CONTAINS_WHITESPACE);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Name name1 = (Name)o;
		return Objects.equals(name, name1.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
