package racinggame.domain;

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
			throw new IllegalArgumentException("[ERROR] 이름은 최소 1글자에서 최대 5글자로 입력해주세요.");
		}
	}

	private void validateNotEmpty(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException("[ERROR] 이름은 최소 1글자에서 최대 5글자로 입력해주세요.");
		}
	}

	private void validateLength(String name) {
		if (name.length() > NAME_MAX_LEN) {
			throw new IllegalArgumentException("[ERROR] 이름의 길이는 최대 5글자 입니다.");
		}
	}

	private void validateNotContainsWhiteSpace(String name) {
		if (name.contains(" ")) {
			throw new IllegalArgumentException("[ERROR] 이름에는 공백을 포함할 수 없습니다.");
		}
	}
}
