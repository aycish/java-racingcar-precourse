package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;

public class CarTest {

	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;

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
		assertThat(car.getName()).isEqualTo(userInput);
		assertThat(car.getPosition()).isEqualTo(0);
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

	@Test
	@DisplayName("자동차_4_미만_전진_검증")
	void moveCarTest() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(STOP);
			car.goForward();
		}
		assertThat(car.getPosition()).isEqualTo(0);
	}

	@Test
	@DisplayName("자동차_4_이상_전진_검증")
	void moveCarTest2() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(MOVING_FORWARD);
			car.goForward();
		}
		assertThat(car.getPosition()).isEqualTo(1);
	}

}
