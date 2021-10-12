package racinggame.controller;

import java.util.ArrayList;
import java.util.List;

import racinggame.domain.CarStatus;
import racinggame.domain.RaceResult;

public class Winners {
	private final List<String> winnerNames;

	public Winners(RaceResult raceResult) {
		this.winnerNames = checkWinners(raceResult);
	}

	public List<String> getWinnerNames() {
		return this.winnerNames;
	}

	private List<String> checkWinners(RaceResult raceResult) {
		int maxPosition = checkMaxPosition(raceResult);

		List<String> winners = new ArrayList<>();
		for (CarStatus carStatus : raceResult.getCarStatuses()) {
			addWinners(winners, carStatus, maxPosition);
		}

		return winners;
	}

	private void addWinners(List<String> winners, CarStatus carStatus, int maxPosition) {
		if (carStatus.position() == maxPosition) {
			winners.add(carStatus.name());
		}
	}

	private int checkMaxPosition(RaceResult raceResult) {
		int maxPosition = 0;

		for (CarStatus carStatus : raceResult.getCarStatuses()) {
			maxPosition = Math.max(maxPosition, carStatus.position());
		}

		return maxPosition;
	}
}
