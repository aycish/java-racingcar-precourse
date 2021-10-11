package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

	Car car;

	@BeforeEach
	void setup() {
		car = new Car("test");
	}

	@ParameterizedTest
	@DisplayName("자동차_정상_생성_검증")
	@ValueSource(strings = {"pobi", "uni", "crong"})
	void createCarTest(String userInput) {
		Car car = new Car(userInput);
		assertThat(car.getName().getString()).isEqualTo(userInput);
		assertThat(car.getPosition().getValue()).isEqualTo(0);
	}

	@ParameterizedTest
	@DisplayName("자동차_비정상_생성_검증")
	@ValueSource(strings = {"javajigi", "aycish", "wrongName"})
	void createCarTest2(String userInput) {
		assertThatIllegalArgumentException()
			.isThrownBy(()-> {
				new Car(userInput);
			});
	}

	@ParameterizedTest
	@DisplayName("자동차_4_미만_전진_검증")
	@ValueSource(ints = {0,1,2,3})
	void moveCarTest(int randomNumber) {
		car.goForward(randomNumber);
		assertThat(car.getPosition().getValue()).isEqualTo(0);
	}

	@ParameterizedTest
	@DisplayName("자동차_4_이상_전진_검증")
	@ValueSource(ints = {4,5,6,7,8,9})
	void moveCarTest2(int randomNumber) {
		car.goForward(randomNumber);
		assertThat(car.getPosition().getValue()).isEqualTo(1);
	}

}
