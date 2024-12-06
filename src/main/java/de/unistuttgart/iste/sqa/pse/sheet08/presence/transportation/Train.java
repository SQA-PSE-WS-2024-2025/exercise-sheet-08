package de.unistuttgart.iste.sqa.pse.sheet08.presence.transportation;

import de.unistuttgart.iste.sqa.pse.sheet08.presence.transportation.energyefficiency.Efficiency;
import de.unistuttgart.iste.sqa.pse.sheet08.presence.transportation.energyefficiency.EfficiencyCategory;
import de.unistuttgart.iste.sqa.pse.sheet08.presence.transportation.energyefficiency.EnergyType;

/**
 * A train that carries passengers.
 */
public abstract class Train extends PublicTransportation {
	// Invariant: The energyType may not be null.

	private final EnergyType energyType;

	/**
	 * Creates a new train object.
	 *
	 * Requires that {@code transportationTypeName} is not {@code null}.
	 * Requires that {@code energyType} is not {@code null}.
	 * Ensures that this.energyType is set equal to {@code energyType}.
	 *
	 * @param transportationTypeName Name of the transportation method.
	 * @param energyType the corresponding Energy type of the transportation method.
	 * @throws IllegalArgumentException If the preconditions are not satisfied.
	 */
	public Train(final String transportationTypeName, final EnergyType energyType) throws IllegalArgumentException {
		super(transportationTypeName);

		if (energyType == null) {
			throw new IllegalArgumentException("Energy type of a train may not be null.");
		}
		this.energyType = energyType;
	}

	/**
	 * Calculates the efficiency category of this train, based on either capacity and speed or the energy type used.
	 *
	 * Ensures that the returned efficiency category is not {@code null}.
	 *
	 * @param useEnergyType If true, the energy type is used for the calculation, otherwise the capacity and speed are used.
	 * @return The efficiency category of the current transportation method.
	 */
	public EfficiencyCategory getEfficiencyCategory(final boolean useEnergyType) {
		if (useEnergyType) {
			return Efficiency.calculateEfficiency(energyType);
		} else {
			return super.getEfficiencyCategory();
		}
	}

	@Override
	public void printTransportationInfo() {
		System.out.format("This train has the energy type %s", energyType);
	}
}
