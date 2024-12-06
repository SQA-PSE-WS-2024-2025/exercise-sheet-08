package de.unistuttgart.iste.sqa.pse.sheet08.presence.transportation;

import de.unistuttgart.iste.sqa.pse.sheet08.presence.transportation.energyefficiency.EnergyType;

/**
 * A hyperloop train that carries passengers at extremely high speeds.
 */
public final class Hyperloop extends Train {

	/**
	 * Creates a new hyperloop object.
	 */
	public Hyperloop() {
		super("Hyperloop", EnergyType.ELECTRIC);
	}

	@Override
	public float getSpeed() {
		return 1200f;
	}

	@Override
	public int getTotalCapacity() {
		return 28;
	}
}
