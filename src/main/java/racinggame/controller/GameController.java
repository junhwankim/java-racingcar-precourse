package racinggame.controller;

import racinggame.config.message;
import racinggame.domain.Cars;
import racinggame.domain.Game;
import racinggame.domain.Lap;
import racinggame.domain.RaceResult;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class GameController {
	private final InputView inputView;
	private final OutputView outputView;

	public GameController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void run() {
		Game game = new Game(getCars(), getLap());
		this.outputView.printMessage(message.EMPTY_STRING);
		this.outputView.printMessage(message.RUN_RESULT);
		RaceResult raceResult = null;
		while (!game.isFinished()) {
			raceResult = game.race();
			this.outputView.printRaceResult(raceResult);
		}
		Winners winner = new Winners(raceResult);
		this.outputView.printWinners(winner);
	}

	private Lap getLap() {
		Lap lap;

		do {
			lap = convertUserInputToLap();
		} while (lap == null);

		return lap;
	}

	private Cars getCars() {
		Cars cars;

		do {
			cars = convertUserInputToCars();
		} while (cars == null);

		return cars;
	}

	private Cars convertUserInputToCars() {
		try {
			String carNames = inputView.getCarNames();
			return Cars.createCars(carNames);
		} catch (IllegalArgumentException e) {
			this.outputView.printMessage(e.getMessage());
			return null;
		}
	}

	private Lap convertUserInputToLap() {
		try {
			String moveTryNumber = inputView.getMoveTryNumber();
			int tryNumber = Integer.parseInt(moveTryNumber);
			return new Lap(tryNumber);
		} catch (NumberFormatException e) {
			this.outputView.printMessage(message.ERROR_INPUT_NOT_CORRECT);
		} catch (IllegalArgumentException e) {
			this.outputView.printMessage(e.getMessage());
		}
		return null;
	}
}
