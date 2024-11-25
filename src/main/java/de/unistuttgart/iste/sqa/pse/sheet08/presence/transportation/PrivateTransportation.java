package de.unistuttgart.iste.sqa.pse.sheet08.presence.transportation;

/**
 * A private transportation method for people.
 */
public abstract class PrivateTransportation implements Transportation {
	// Invariant: The registrationNumber may not be {@code null}.

	private final String registrationNumber;

	/**
	 * Creates a new private transportation object.
	 *
	 * Requires that the {@code registrationNumber} is not {@code null}.
	 * Ensures that the class attribute this.registrationNumber is equal to {@code registrationNumber}.
	 *
	 * @param registrationNumber The registration number of the transportation method.
	 * @throws IllegalArgumentException If the preconditions are not satisfied.
	 */
	public PrivateTransportation(final String registrationNumber) throws IllegalArgumentException {
		if (registrationNumber == null) {
			throw new IllegalArgumentException("Registration number may not be null.");
		}
		this.registrationNumber = registrationNumber;
	}

	/**
	 * Ensures that the returned result is equal to {@code this.registrationNumber}.
	 *
	 * @return The registration number of this transportation method.
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * Ensures that the returned speed is greater than 0.
	 *
	 * @return The speed of this transportation method in km/h
	 */
	public abstract float getSpeed();

	/**
	 * Prints the general vehicle information of the corresponding transportation method
	 */
	public void printTransportationInfo() {
		System.out.format("Registration number: %s, Speed: %f kmh/h", registrationNumber, this.getSpeed());
	}
}
