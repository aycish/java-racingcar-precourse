package racinggame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import nextstep.test.NSTest;

public class ApplicationTest extends NSTest {

	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;
	private static final String ERROR_MESSAGE = "[ERROR]";

	@BeforeEach
	void beforeEach() {
		setUp();
	}

	@Test
	@DisplayName("전진_정지")
	void goAndStopTest() {
		assertRandomTest(() -> {
			run("pobi,woni", "1");
			verify("pobi : -", "woni : ", "최종 우승자는 pobi 입니다.");
		}, MOVING_FORWARD, STOP);
	}

	@Test
	@DisplayName("공동_우승자_검증")
	void verifyManyWinnerCase() {
		assertRandomTest(() -> {
			run("pobi,woni", "3");
			verify("pobi : ---", "woni : ---", "최종 우승자는 pobi,woni 입니다.");
		}, MOVING_FORWARD);
	}

	@Test
	@DisplayName("이름에_대한_예외_처리")
	void verifyWrongNameCase() {
		assertSimpleTest(() -> {
			runNoLineFound("pobi,javaji");
			verify(ERROR_MESSAGE);
		});
	}

	@ParameterizedTest
	@DisplayName("시행_횟수에_대한_예외_처리")
	@ValueSource(strings = {"-1", "0", "a"})
	void verifyWrongTrialInputCase(String userInput) {
		assertSimpleTest(() -> {
			runNoLineFound("pobi,java", userInput);
			verify(ERROR_MESSAGE);
		});
	}

	@AfterEach
	void tearDown() {
		outputStandard();
	}

	@Override
	public void runMain() {
		Application.main(new String[]{});
	}
}
