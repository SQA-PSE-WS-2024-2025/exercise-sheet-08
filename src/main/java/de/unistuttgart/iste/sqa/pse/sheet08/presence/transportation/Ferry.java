package de.unistuttgart.iste.sqa.pse.sheet08.presence.transportation;

/**
 * A ferry that can carry passengers across short or medium distances over water.
 */
public class Ferry extends PublicTransportation {

	/**
	 * Creates a new Ferry object.
	 */
	public Ferry() {
		super("Ferry");
	}

	@Override
	public int getTotalCapacity() {
		return 150;
	}

	@Override
	public float getSpeed() {
		return 50;
	}

	/**
	 * @return The minimum water depth that can be safely navigated by this ferry, in meters.
	 */
	public float getMinimumWaterDepth() {
		return 20;
	}
}
