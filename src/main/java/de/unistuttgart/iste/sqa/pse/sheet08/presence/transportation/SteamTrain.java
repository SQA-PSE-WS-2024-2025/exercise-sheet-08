package de.unistuttgart.iste.sqa.pse.sheet08.presence.transportation;

/**
 * A steam train that carries passengers.
 */
public final class SteamTrain extends Train {

	/**
	 * Creates a new steam train object.
	 */
	public SteamTrain() {
		super("SteamTrain", EnergyType.STEAM);
	}

	@Override
	public float getSpeed() {
		return 100f;
	}

	@Override
	public int getTotalCapacity() {
		return 300;
	}

	@Override
	public void printTransportationInfo() {
		System.out.format("The steam train has a total passenger capacity of %d persons.", this.getTotalCapacity());
	}
}
