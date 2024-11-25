package de.unistuttgart.iste.sqa.pse.sheet08.presence.transportation;

/**
 * A transportation method for people.
 */
public interface Transportation {

	/**
	 * Ensures that the returned total capacity is greater than 0.
	 *
	 * @return The maximum number of people the transportation method can carry at a time.
	 */
	public int getTotalCapacity();

	/**
	 * Ensures that the returned transportation type is not {@code null}.
	 *
	 * @return The transportation type of the transportation method.
	 */
	public TransportationType getTransportationType();

	/**
	 * Ensures that the return efficiency category is not {@code null}.
	 *
	 * @return The efficiency category of the current transportation method.
	 */
	public EfficiencyCategory getEfficiencyCategory();
}
