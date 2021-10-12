package racinggame.domain;

import java.util.List;
import java.util.Objects;

public class RaceResult {
	private final List<CarStatus> carStatuses;

	public RaceResult(List<CarStatus> carStatuses) {
		this.carStatuses = carStatuses;
	}

	public List<CarStatus> getCarStatuses() {
		return this.carStatuses;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		RaceResult that = (RaceResult)o;
		return Objects.equals(carStatuses, that.carStatuses);
	}

	@Override
	public int hashCode() {
		return Objects.hash(carStatuses);
	}
}
