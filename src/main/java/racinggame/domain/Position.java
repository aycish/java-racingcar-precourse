package racinggame.domain;

public class Position {

	private Integer value;

	public Position() {
		value = 0;
	}

	public int getValue() {
		return value;
	}

	public void goForward() {
		value++;
	}

}
