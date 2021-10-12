package racinggame.domain;

import java.util.Objects;

public class CarStatus {
	private final String carName;
	private final int carPosition;

	public CarStatus(String name, int position) {
		this.carName = name;
		this.carPosition = position;
	}

	public String name() {
		return this.carName;
	}

	public int position() {
		return this.carPosition;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CarStatus carStatus = (CarStatus)o;
		return carPosition == carStatus.carPosition && Objects.equals(carName, carStatus.carName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(carName, carPosition);
	}
}
