package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

	List<Car> cars = new ArrayList<>();

	public Cars(List<String> names) {
		for (String name : names) {
			cars.add(new Car(name));
		}
	}

	public void goForwardAll() {
		for(Car car : cars) {
			car.goForward();
		}
	}

	public String getWinners() {
		List<String> winners = new ArrayList<>();
		Car leadCar = getLeadCar();

		for(Car car : cars) {
			addSamePositionCar(winners, leadCar, car);
		}

		return String.join(",", winners);
	}

	private void addSamePositionCar(List<String> winners, Car leadCar, Car targetCar) {
		if (leadCar.isSamePosition(targetCar)) {
			winners.add(targetCar.getName());
		}
	}

	private Car getLeadCar() {
		return Collections.max(cars, Car::compareTo);
	}
}
