package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

	Position position;

	@BeforeEach
	void setup() {
		position = new Position();
	}

	@Test
	@DisplayName("초기_위치_검증")
	void verifyIntializingPosition() {
		assertThat(position.getValue()).isEqualTo(0);
	}

	@Test
	@DisplayName("전진_검증")
	void verifyGoingForward() {
		position.goForward();
		assertThat(position.getValue()).isEqualTo(1);
	}

}
