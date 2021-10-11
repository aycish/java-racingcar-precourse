package racinggame.domain;

public class ValidationUtils {

	private static final int MAX_NAME_LENGTH = 5;
	private static final int MIN_NAME_LENGTH = 1;
	private static final String NUMBER_REGULAR_EXPRESION = "^[1-9]+";

	public static boolean checkNameLength(String name) {
		return name.length() >= MIN_NAME_LENGTH && name.length() <= MAX_NAME_LENGTH;
	}

	public static boolean checkTrial(String trial) {
		return trial.matches(NUMBER_REGULAR_EXPRESION);
	}

}
