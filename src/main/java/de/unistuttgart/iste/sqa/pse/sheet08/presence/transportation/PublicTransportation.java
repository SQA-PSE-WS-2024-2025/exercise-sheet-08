package de.unistuttgart.iste.sqa.pse.sheet08.presence.transportation;

import de.unistuttgart.iste.sqa.pse.sheet08.presence.transportation.energyefficiency.Efficiency;
import de.unistuttgart.iste.sqa.pse.sheet08.presence.transportation.energyefficiency.EfficiencyCategory;

/**
 * A public transportation method for people.
 */
public abstract class PublicTransportation implements Transportation {
	// Invariant: The transportationMethodName may not be {@code null}.

	private final String transportationMethodName;

	/**
	 * Creates a new public transportation object.
	 *
	 * Requires that the {@code transportationMethodName} is not {@code null}.
	 * Ensures that this.transportationMethodName is equal to the provided {@code transportationMethodName}.
	 *
	 * @param transportationMethodName The name of the transportation method.
	 * @throws IllegalArgumentException If the preconditions are not satisfied.
	 */
	public PublicTransportation(final String transportationMethodName) throws IllegalArgumentException {
		if (transportationMethodName == null) {
			throw new IllegalArgumentException("Transportation type name may not be null.");
		}
		this.transportationMethodName = transportationMethodName;
	}

	/**
	 * Prints the name of the transportation method to the console.
	 */
	public void printTransportationMethodName() {
		System.out.format("Transportation method name: %s%n", transportationMethodName);
	}

	@Override
	public EfficiencyCategory getEfficiencyCategory() {
		return Efficiency.calculateEfficiency(this.getTotalCapacity(), this.getSpeed());
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
		System.out.format("Transportation method name: %s, Speed: %f km/h", transportationMethodName, this.getSpeed());
	}
}
