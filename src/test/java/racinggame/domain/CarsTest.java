package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

	@Test
	@DisplayName("자동차_그룹_생성_검증")
	void createCarsTest() {
		List<String> names = Arrays.asList("pobi","tobi","crong");
		Cars cars = new Cars(names);
		assertThat(cars.getSize()).isEqualTo(3);
	}

	@Test
	@DisplayName("자동차_그룹_비정상_입력_생성_검증")
	void createCarsTest2() {
		List<String> names = Arrays.asList("wrongName","longer");

		assertThatIllegalArgumentException()
			.isThrownBy(() -> {
				Cars cars = new Cars(names);
			});
	}

}
