package racinggame.view;

import java.util.List;

import racinggame.controller.Winners;
import racinggame.domain.CarStatus;
import racinggame.domain.RaceResult;

public class OutputView {
	private static final String WINNER_DELIMITER = ",";
	private static final String WINNER_PRINT_MESSAGE = "최종 우승자는 %s 입니다.";
	private static final String STATUS_PRINT_DELIMITER = " : ";
	private static final String PROGRESS_SIGN_CHAR = "-";

	public void printMessage(String message) {
		System.out.println(message);
	}

	public void printRaceResult(RaceResult raceResult) {
		List<CarStatus> carStatuses = raceResult.getCarStatuses();

		for (CarStatus status: carStatuses) {
			String progressString = makeProgressString(status);
			System.out.println(progressString);
		}

		System.out.println();
	}

	private String makeProgressString(CarStatus status) {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(status.name());
		stringBuilder.append(STATUS_PRINT_DELIMITER);
		for (int i = 0; i < status.position(); i++) {
			stringBuilder.append(PROGRESS_SIGN_CHAR);
		}

		return stringBuilder.toString();
	}

	public void printWinners(Winners winners) {
		String winnerNames = String.join(WINNER_DELIMITER, winners.getWinnerNames());
		String printString = String.format(WINNER_PRINT_MESSAGE, winnerNames);

		System.out.println(printString);
	}
}
