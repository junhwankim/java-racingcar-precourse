package racinggame.controller;

import racinggame.domain.Cars;
import racinggame.domain.Game;
import racinggame.domain.Lap;
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
		Cars cars = getCars();
		Lap lap = getLap();

		Game game = new Game(cars, lap);

		while (!game.isFinished()) {
			game.race();
		}
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
			this.outputView.printMessage("[ERROR] 1이상의 숫자를 입력해주세요.");
		} catch (IllegalArgumentException e) {
			this.outputView.printMessage(e.getMessage());
		}
		return null;
	}
}
