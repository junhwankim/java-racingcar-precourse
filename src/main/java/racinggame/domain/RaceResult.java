package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {
	private final List<CarStatus> carStatuses;

	public RaceResult(List<CarStatus> carStatuses) {
		this.carStatuses = carStatuses;
	}

	public List<CarStatus> getCarStatuses() {
		return this.carStatuses;
	}
}
