package racinggame.controller;

import racinggame.domain.ValidationUtils;

public class Trial {
	private Integer trial;

	private Trial(String trial) {
		this.trial = Integer.parseInt(trial);
	}

	public static Trial createTrial(String userInputTrial){
		if (!ValidationUtils.checkTrial(userInputTrial)) {
			throw new IllegalArgumentException();
		}
		return new Trial(userInputTrial);
	}

	public Integer getTrial() {
		return trial;
	}
}
