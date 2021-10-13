package racinggame.domain;

import nextstep.utils.Randoms;

public class Car implements Comparable<Car> {

	private static final int MOVE_CRITERION = 4;
	private static final int START_INCLUSIVE = 0;
	private static final int END_INCLUSIVE = 9;

	private final Name carName;
	private final Position carPosition;

	public Car(String name) {
		this.carName = Name.createName(name);
		this.carPosition = new Position();
	}

	public void goForward() {
		if (judge(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE))) {
			this.carPosition.goForward();
		}
	}

	public String getName() {
		return this.carName.getString();
	}

	public int getPosition() {
		return this.carPosition.getValue();
	}

	public boolean isSamePosition(Car car) {
		return this.getPosition() == car.getPosition();
	}

	private static boolean judge(int randomNumber) {
		return randomNumber >= MOVE_CRITERION;
	}

	private String getPositionBar() {
		String positionBar = "";

		for (int i = 0; i < this.getPosition(); i++) {
			positionBar += "-";
		}

		return positionBar;
	}

	@Override
	public String toString() {
		return this.getName() + " : " + this.getPositionBar();
	}

	@Override
	public int compareTo(Car car) {
		return this.getPosition() - car.getPosition();
	}
}
