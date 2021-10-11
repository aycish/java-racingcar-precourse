package racinggame.domain;

public class Position {

	private Integer value = 0;

	public Position () {
		value = 0;
	}

	public int getValue() {
		return value;
	}

	public void goForward() {
		value ++;
	}

	public Position getPositionAhead(Position position) {
		if (getValue() > position.getValue()) {
			return this;
		}
		return position;
	}

	public boolean isSamePosition(Position position) {
		return getValue() == position.getValue();
	}
}
