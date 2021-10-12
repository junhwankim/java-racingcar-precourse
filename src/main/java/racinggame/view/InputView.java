package racinggame.view;

import nextstep.utils.Console;

public class InputView {
	private static final String CAR_NAME_INPUT_REQUEST = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String CAR_MOVE_TRY_NUMBER_REQUEST = "시도할 회수는 몇회인가요?";

	public String getCarNames() {
		System.out.println(CAR_NAME_INPUT_REQUEST);
		return Console.readLine();
	}

	public String getMoveTryNumber() {
		System.out.println(CAR_MOVE_TRY_NUMBER_REQUEST);
		return Console.readLine();
	}
}
