package racinggame.controller;

import nextstep.utils.Console;
import racinggame.domain.Cars;
import racinggame.view.GameViewer;

public class GameController {

	private Cars racingCars;
	private Trial trial;

	public void startGame() {
		getNamesFromUser();
		getTrialFromUser();
		run();
		end();
	}

	private void getNamesFromUser() {
		try {
			GameViewer.printInputNotice();
			racingCars = new Cars(Console.readLine());
		} catch (IllegalArgumentException e) {
			GameViewer.printWrongNameErrorMessage();
			getNamesFromUser();
		}
	}

	private void getTrialFromUser() {
		try {
			GameViewer.printTrialInputNotice();
			trial = Trial.createTrial(Console.readLine());
		} catch (IllegalArgumentException e) {
			GameViewer.printWrongTrialErrorMessage();
			getTrialFromUser();
		}
	}

	private void run() {
		for (int i = 0; i < trial.getTrial(); i++) {
			racingCars.goForwardAll();
			GameViewer.printCurrentResult(racingCars.getCurrentResult());
		}
	}

	private void end() {
		GameViewer.printFinalWinner(racingCars.getWinners());
	}
}
