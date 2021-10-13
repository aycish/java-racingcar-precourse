package racinggame.domain;

public class Name {

	private String name;

	private Name(String name) {
		this.name = name;
	}

	public static Name createName(String userInputName) {
		if (!ValidationUtils.checkNameLength(userInputName)) {
			throw new IllegalArgumentException();
		}
		return new Name(userInputName);
	}

	public String getString() {
		return name;
	}
}
