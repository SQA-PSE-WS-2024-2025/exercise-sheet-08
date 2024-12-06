package de.unistuttgart.iste.sqa.pse.sheet08.presence.transportation.energyefficiency;

/**
 * Provides static methods for efficiency calculations.
 */
public final class Efficiency {

	/**
	 * Calculates the efficiency category based on the maxPersonCount and speed of the corresponding transportation method
	 *
	 * Requires that the {@code maxPersonCount} is greater than 0.
	 * Requires that the {@code maxSpeed} is greater than 0.
	 * Ensures that the returned efficiency category is not {@code null}.
	 *
	 * @param maxPersonCount maximal person count of the corresponding transportation method
	 * @param maxSpeed overall speed of the corresponding transportation method
	 * @return the calculated efficiency category
	 * @throws IllegalArgumentException If the preconditions are not satisfied.
	 */
	public static EfficiencyCategory calculateEfficiency(final int maxPersonCount, final float maxSpeed)
			throws IllegalArgumentException {
		if (maxPersonCount < 0 || maxSpeed < 0) {
			throw new IllegalArgumentException("Parameters have to be > 0");
		}

		float efficiency = maxPersonCount / maxSpeed;

		if (efficiency < 0.2) {
			return EfficiencyCategory.D;
		} else if (efficiency < 0.3) {
			return EfficiencyCategory.C;
		} else if (efficiency < 0.4) {
			return EfficiencyCategory.B;
		} else {
			return EfficiencyCategory.A;
		}
	}

	/**
	 * Calculates the efficiency category based on the used energy type of the corresponding transportation method
	 *
	 * Requires that the {@code energyType} is not {@code null}.
	 * Ensures that the returned efficiency category is not {@code null}.
	 *
	 * @param energyType the type of energy to use for the efficiency calculation.
	 * @return the calculated efficiency category
	 * @throws IllegalArgumentException If the preconditions are not satisfied.
	 */
	public static EfficiencyCategory calculateEfficiency(final EnergyType energyType) throws IllegalArgumentException {
		switch (energyType) {
			case ELECTRIC:
				return EfficiencyCategory.A;
			case STEAM:
				return EfficiencyCategory.B;
			case GASOLINE:
				return EfficiencyCategory.C;
			default:
				throw new IllegalArgumentException("Energy type may not be null.");
		}
	}
}
