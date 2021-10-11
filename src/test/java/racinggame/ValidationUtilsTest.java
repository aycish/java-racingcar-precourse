package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.domain.ValidationUtils;

public class ValidationUtilsTest {

	@ParameterizedTest
	@DisplayName("이름_생성시_글자수_정상_검증")
	@ValueSource(strings = {"abc","1","12345"})
	void nameLengthTest(String userInput) {
		assertThat(ValidationUtils.checkNameLength(userInput)).isTrue();
	}

	@ParameterizedTest
	@DisplayName("이름_생성시_글자수_비정상_검증")
	@ValueSource(strings = {"123456", "",})
	void nameLengthTest2(String userInput) {
		assertThat(ValidationUtils.checkNameLength(userInput)).isFalse();
	}

	@ParameterizedTest
	@DisplayName("시행_횟수_정상_입력_검증")
	@ValueSource(strings = {"5", "123"})
	void trialInputTest(String userInput) {
		assertThat(ValidationUtils.checkTrial(userInput)).isTrue();
	}

	@ParameterizedTest
	@DisplayName("시행_횟수_비정상_입력_검증")
	@ValueSource(strings = {"a","0","-"})
	void trialInputTest2(String userInput) {
		assertThat(ValidationUtils.checkTrial(userInput)).isFalse();
	}

}
