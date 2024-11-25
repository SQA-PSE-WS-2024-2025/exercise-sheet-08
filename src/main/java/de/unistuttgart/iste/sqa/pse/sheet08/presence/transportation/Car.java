package de.unistuttgart.iste.sqa.pse.sheet08.presence.transportation;

/**
 * A privately owned car.
 */
public class Car {
	// Invariant: The registrationNumber must not be {@code null}.

	private final String registrationNumber;

	/**
	 * Creates a new car object.
	 *
	 * Requires that {@code registrationNumber} is not {@code null}.
	 *
	 * @param registrationNumber Registration number of the car.
	 * @throws IllegalArgumentException If the preconditions are not satisfied.
	 */
	public Car(String registrationNumber) throws IllegalArgumentException {
		if (registrationNumber == null) {
			throw new IllegalArgumentException("Registration number may not be null.");
		}
		this.registrationNumber = registrationNumber;
	}

	/**
	 * Ensures that the returned total capacity is bigger than 0;
	 *
	 * @return The maximum number of people the car can carry at a time.
	 */
	public int getTotalCapacity() {
		return 5;
	}

	/**
	 * Ensures that the returned transportation type is not {@code null}.
	 *
	 * @return The transportation type of the car.
	 */
	public TransportationType getTransportationType() {
		return TransportationType.LAND;
	}

	/**
	 * Ensures that the returned efficiency category is not {@code null}.
	 *
	 * @return The efficiency category of the car.
	 */
	public EfficiencyCategory getEfficiencyCategory() {
		return EfficiencyCategory.D;
	}

	/**
	 * Ensures that the returned speed is greater than 0.
	 *
	 * @return The speed of this car in km/h
	 */
	public float getSpeed() {
		return 180;
	}

	/**
	 * Ensures that the returned registration number is equal to {@code this.registrationNumber}.
	 *
	 * @return The registration number of this car.
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * Prints the general vehicle information of the corresponding transportation method
	 */
	public void printTransportationInfo() {
		System.out.println("Registration number: " + registrationNumber + ", Speed: " + this.getSpeed() + " km/h");
	}
}
