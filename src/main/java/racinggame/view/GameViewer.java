package racinggame.view;

public final class GameViewer {

	public static void printInputNotice() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}

	public static void printTrialInputNotice() {
		System.out.println("시도할 회수는 몇회인가요?");
	}

	public static void printWrongNameErrorMessage() {
		System.out.println("[ERROR] 이름은 1글자 이상, 5글자 이하의 문자만 가능합니다.");
	}

	public static void printWrongTrialErrorMessage() {
		System.out.println("[ERROR] 시행 횟수는 1 이상의 숫자만 입력 가능합니다.");
	}

	public static void printCurrentResult(String result) {
		System.out.println(result);
	}

	public static void printFinalWinner(String winners) {
		System.out.printf("최종 우승자는 %s 입니다.", winners);
	}
}
