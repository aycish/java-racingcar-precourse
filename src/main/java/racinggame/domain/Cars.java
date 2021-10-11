package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;

public class Cars {

	List<Car> cars = new ArrayList<>();

	public Cars() {}
	public Cars(List<String> names) {
		for (String name : names) {
			cars.add(new Car(name));
		}
	}

	public List<Car> getWinners() {
		Position maxPosition = getMaxPosition();
		List<Car> winners = new ArrayList<>();

		for(Car car : cars) {
			addSamePositionCar(winners, car, maxPosition);
		}

		return winners;
	}

	public void goForwardAll() {
		for(Car car : cars) {
			int number = Randoms.pickNumberInRange(0,9);
			car.goForward(number);
		}
	}

	private void addSamePositionCar(List<Car> winners, Car car, Position maxPosition) {
		if (maxPosition.isSamePosition(car.getPosition())) {
			winners.add(car);
		}
	}

	private Position getMaxPosition() {
		Position maxPosition = new Position();

		for (Car car : cars) {
			maxPosition = maxPosition.getPositionAhead(car.getPosition());
		}

		return maxPosition;
	}

	public List<Car> getCars() {
		return cars;
	}

}
