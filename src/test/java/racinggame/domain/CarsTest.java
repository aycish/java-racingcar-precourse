package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;

public class CarsTest {
	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;

	@Test
	@DisplayName("자동차_그룹_생성_검증")
	void createCarsTest() {
		Cars cars = new Cars("pobi,tobi,crong");
		assertThat(cars.getWinners()).contains("pobi", "tobi", "crong");
	}

	@Test
	@DisplayName("자동차_그룹_비정상_입력_생성_검증")
	void createCarsTest2() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> {
				Cars cars = new Cars("wrongName,longer");
			});
	}

	@Test
	@DisplayName("우승자_선별_테스트")
	void getWinnersTest() {
		Cars cars = new Cars("pobi,tobi");

		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(STOP, MOVING_FORWARD);
			cars.goForwardAll();
		}

		assertThat(cars.getWinners()).contains("tobi").doesNotContain("pobi");
	}

	@Test
	@DisplayName("다중_우승자_선별_테스트")
	void getWinnersTest2() {
		Cars cars = new Cars(" pobi , tobi, crong ");

		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(STOP, MOVING_FORWARD, MOVING_FORWARD);
			cars.goForwardAll();
		}

		assertThat(cars.getWinners()).contains("tobi", "crong").doesNotContain("pobi");
	}
}
