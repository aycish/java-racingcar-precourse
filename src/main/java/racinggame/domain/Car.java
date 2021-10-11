package racinggame.domain;

import java.net.HttpCookie;

public class Car {
	private static final int MOVE_CRITERION = 4;

	private final Name carName;
	private final Position carPosition;

	public Car(String name) {
		this.carName = Name.createName(name);
		this.carPosition = new Position();
	}

	public void goForward(int randomNumber) {
		if (judge(randomNumber)) {
			carPosition.goForward();
		}
	}

	public Name getName() {
		return carName;
	}

	public Position getPosition() {
		return carPosition;
	}

	private static boolean judge(int randomNumber) {
		return randomNumber >= MOVE_CRITERION;
	}

}
