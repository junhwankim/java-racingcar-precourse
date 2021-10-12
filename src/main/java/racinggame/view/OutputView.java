package racinggame.view;

import java.util.List;

import racinggame.domain.CarStatus;
import racinggame.domain.RaceResult;

public class OutputView {
	public void printMessage(String message) {
		System.out.println(message);
	}

	public void printRaceResult(RaceResult raceResult) {
		List<CarStatus> carStatuses = raceResult.getCarStatuses();

		for (CarStatus status: carStatuses) {
			String result = makePrintString(status);
			System.out.println(result);
		}

		System.out.println();
	}

	private String makePrintString(CarStatus status) {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(status.name());
		stringBuilder.append(" : ");
		for (int i = 0; i < status.position(); i++) {
			stringBuilder.append("-");
		}

		return stringBuilder.toString();
	}
}
