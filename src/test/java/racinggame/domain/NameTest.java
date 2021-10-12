package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

	@ParameterizedTest
	@DisplayName("이름_5글자_초과_검증")
	@ValueSource(strings = {"javajigi", "aycish", "wrongName"})
	void 이름_5글자_초과_검증(String userInput) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> {
				Name.createName(userInput);
			});
	}

	@ParameterizedTest
	@DisplayName("이름_생성_검증")
	@ValueSource(strings = {"woni", "pobi", "crong"})
	void 이름_생성_검증(String userInput) {
		Name name  = Name.createName(userInput);
		assertThat(name.getString()).isEqualTo(userInput);
	}
}
