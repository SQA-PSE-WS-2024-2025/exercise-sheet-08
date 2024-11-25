package de.unistuttgart.iste.sqa.pse.sheet08.presence.transportation;

/**
 * A passenger jet plane.
 */
public final class Plane extends PublicTransportation {

	/**
	 * Creates a new plane object.
	 */
	public Plane() {
		super("Plane");
	}

	@Override
	public int getTotalCapacity() {
		return 250;
	}

	@Override
	public float getSpeed() {
		return 800f;
	}

	@Override
	public TransportationType getTransportationType() {
		return TransportationType.AIR;
	}

	@Override
	public void printTransportationInfo() {
		System.out.format("This plane can reach a speed up to %f km/h", this.getSpeed());
	}
}
