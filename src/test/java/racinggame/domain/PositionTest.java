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
	void 초기_위치_검증() {
		assertThat(position.getValue()).isEqualTo(0);
	}

	@Test
	@DisplayName("전진_검증")
	void 전진_테스트() {
		position.goForward();
		assertThat(position.getValue()).isEqualTo(1);
	}

}
