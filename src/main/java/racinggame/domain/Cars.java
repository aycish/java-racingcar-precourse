package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

	List<Car> cars = new ArrayList<>();

	public Cars(List<String> names) {
		for (String name : names) {
			cars.add(new Car(name));
		}
	}

	public int getSize() {
		return cars.size();
	}
}
