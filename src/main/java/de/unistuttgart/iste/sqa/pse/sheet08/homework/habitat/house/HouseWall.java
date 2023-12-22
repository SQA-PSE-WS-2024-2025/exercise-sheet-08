package de.unistuttgart.iste.sqa.pse.sheet08.homework.habitat.house;

import java.util.Optional;

import de.hamstersimulator.objectsfirst.datatypes.Location;

/**
 * A wall in a {@link House}.
 *
 * All walls in a {@link House}, must adhere to the following invariants:
 * <p>
 * Every housewall consist of a start and end location, both are inclusive, i.e.
 * the start and the end location are part of the housewall. The start location
 * must be closer to the territories origin (the upper left corner) than the end
 * location. In addition, the start and end location must be in line, i.e. for a
 * horizontal housewall, they must be in the same row, and for a vertical
 * housewall, they must be in the same column.
 *
 * <p>
 * A housewall must at least be two tiles long, i.e. start and end must not be
 * the same location.
 *
 * <p>
 * In addition, housewall have an optional door. If there is no door, i.e. the
 * door is an empty {@code Optional}, no further restrictions apply. If the
 * housewall has a door, that door must be located in between start and end. In
 * addition, the door must not be at the very start or end of the housewall.
 *
 * @author (your name)
 */
public final class HouseWall {
	private final Location start;
	private final Location end;

	private Optional<Location> door;

	/**
	 * Constructs a new wall, which may or may not have a door.
	 *
	 * Requires that neither start nor end are null and that start and end form a
	 * valid housewall, according to the class' invariants. Ensures the creation of
	 * a new housewall according to the class' invariants.
	 *
	 * @param start location of the wall's first part
	 * @param end   location of the wall's last part
	 */
	public HouseWall(final Location start, final Location end) {
		// TODO implement exercise 2 (b) here.

		this.start = start;
		this.end = end;
		this.door = Optional.empty();
	}

	/**
	 * Add a door into a house wall.
	 *
	 * Requires that {@code newDoor} is not null, and that {@code newDoor} is a
	 * valid door according to the class' invariants. In addition, this operation
	 * requires that the housewall does not yet have a door, i.e.
	 * {@code this.door.isEmpty()}.
	 *
	 * Ensures that {@code this.door} is not empty.
	 *
	 * @param newDoor door to be added into the housewall.
	 */
	public void addDoor(final Location newDoor) {
		// TODO implement exercise 2 (c) here.
	}

	/**
	 * Get the first tile of the wall.
	 *
	 * @return the first tile of the wall.
	 */
	public Location getStart() {
		return start;
	}

	/**
	 * Get the last tile of the wall.
	 *
	 * @return the last tile of the wall.
	 */
	public Location getEnd() {
		return end;
	}

	/**
	 * Get the door of the wall.
	 *
	 * @return the door of the wall.
	 */
	public Optional<Location> getDoor() {
		return door;
	}

	/**
	 * Checks if the wall is vertical.
	 *
	 * @return true if the wall is vertical, false otherwise.
	 */
	public boolean isVertical() {
		return start.getColumn() == end.getColumn();
	}

	/**
	 * Checks if the wall is horizontal.
	 *
	 * @return true if the wall is horizontal, false otherwise.
	 */
	public boolean isHorizontal() {
		return start.getRow() == end.getRow();
	}

	/**
	 * Checks whether the given start and end locations are in line.
	 * <p>
	 * Requires that start and end are not null.
	 *
	 * @param start first tile of the wall
	 * @param end   last tile of the wall
	 * @return true iff the start and end location are in line.
	 */
	private boolean areInLine(final Location start, final Location end) {
		assert start != null && end != null;
		return start.getColumn() == end.getColumn() || start.getRow() == end.getRow();
	}

	/**
	 * Checks whether the given start location is closer to the origin than the end
	 * location.
	 * <p>
	 * Requires that start and end are not null.
	 *
	 * @param start first tile of the wall
	 * @param end   last tile of the wall
	 * @return true iff the start location is closer to the origin than the end
	 *         location.
	 */
	private boolean isStartSmallerThanEnd(final Location start, final Location end) {
		assert start != null && end != null;
		return (start.getRow() == end.getRow() && start.getColumn() < end.getColumn())
				|| (start.getColumn() == end.getColumn() && start.getRow() < end.getRow());
	}

	/**
	 * Checks whether the door is an a valid position on a vertical wall.
	 * <p>
	 * Requires that door is not null.
	 *
	 * @param door tile of the door
	 * @return true iff the door has a valid position on a vertical wall.
	 */
	private boolean isValidDoorOnVerticalWall(final Location door) {
		assert door != null;
		return this.isVertical()
				&& (door.getColumn() == start.getColumn()
						&& door.getRow() > start.getRow()
						&& door.getRow() < end.getRow());
	}

	/**
	 * Checks whether the door is an a valid position on a horizontal wall.
	 * <p>
	 * Requires that door is not null.
	 *
	 * @param door tile of the door
	 * @return true iff the door has a valid position on a horizontal wall.
	 */
	private boolean isValidDoorOnHorizontalWall(final Location door) {
		assert door != null;
		return this.isHorizontal()
				&& (door.getRow() == start.getRow()
						&& door.getColumn() > start.getColumn()
						&& door.getColumn() < end.getColumn());
	}

	/**
	 * Checks whether the current wall overlaps with another wall.
	 * <p>
	 * Requires that otherWall is not null.
	 *
	 * @param otherWall another wall
	 * @return true if the walls overlap, false otherwise.
	 */
	public boolean overlapsWith(final HouseWall otherWall) {
		if (otherWall == null) {
			throw new IllegalArgumentException("Parameter is null, but must not be.");
		}
		return this.horizontalWallsOverlap(otherWall)
				|| this.verticallyOverlapsWith(otherWall)
				|| this.intersectionWallsOverlap(otherWall);
	}

	/**
	 * Checks whether another wall vertically overlaps with the current wall.
	 * <p>
	 * Requires that otherWall is not null.
	 *
	 * @param otherWall another wall
	 * @return true if the walls overlap vertically, false otherwise.
	 */
	private boolean verticallyOverlapsWith(final HouseWall otherWall) {
		assert otherWall != null;
		if (!(this.isVertical() && otherWall.isVertical())) {
			return false;
		}
		return isInSameColumn(otherWall)
				&& (isStartRowWithinOtherWall(otherWall) || isEndRowWithinOtherWall(otherWall));
	}

	/**
	 * Checks whether the given wall is in the same column as the current wall.
	 * <p>
	 * Requires that otherWall is not null.
	 *
	 * @param otherWall another wall
	 * @return true if the walls are in the same column, false otherwise.
	 */
	private boolean isInSameColumn(final HouseWall otherWall) {
		assert otherWall != null;
		return start.getColumn() == otherWall.getStart().getColumn();
	}

	/**
	 * Checks whether the row of the end of the current wall is within the other
	 * wall.
	 * <p>
	 * Requires that otherWall is not null.
	 *
	 * @param otherWall another wall
	 * @return true if the row of the end of the current wall is within the other
	 *         wall, false otherwise.
	 */
	private boolean isEndRowWithinOtherWall(final HouseWall otherWall) {
		assert otherWall != null;
		return end.getRow() >= otherWall.getStart().getRow()
				&& end.getRow() <= otherWall.getStart().getRow();
	}

	/**
	 * Checks whether the row of the start of the current wall is within the other
	 * wall.
	 * <p>
	 * Requires that otherWall is not null.
	 *
	 * @param otherWall another wall
	 * @return true if the row of the start of the current wall is within the other
	 *         wall, false otherwise.
	 */
	private boolean isStartRowWithinOtherWall(final HouseWall otherWall) {
		assert otherWall != null;
		return start.getRow() >= otherWall.getStart().getRow()
				&& start.getRow() <= otherWall.getEnd().getRow();
	}

	/**
	 * Checks whether another wall horizontally overlaps with the current wall.
	 *
	 * @param otherWall another wall
	 * @return true if the walls overlap horizontally, false otherwise.
	 */
	private boolean horizontalWallsOverlap(final HouseWall otherWall) {
		assert otherWall != null;
		if (!(this.isHorizontal() && otherWall.isHorizontal())) { // one is not horizontal.
			return false;
		}
		return this.isInSameRow(otherWall)
				&& (isStartColumnWithinOtherWall(otherWall) || isEndColumnWithinOtherWall(otherWall));
	}

	/**
	 * Checks whether the given wall is in the same row as the current wall.
	 * <p>
	 * Requires that otherWall is not null.
	 *
	 * @param otherWall another wall
	 * @return true if the walls are in the same row, false otherwise.
	 */
	private boolean isInSameRow(final HouseWall otherWall) {
		assert otherWall != null;
		return start.getRow() == otherWall.getStart().getRow();
	}

	/**
	 * Checks whether the column of the end of the current wall is within the other
	 * wall.
	 * <p>
	 * Requires that otherWall is not null.
	 *
	 * @param otherWall another wall
	 * @return true if the column of the end of the current wall is within the other
	 *         wall, false otherwise.
	 */
	private boolean isEndColumnWithinOtherWall(final HouseWall otherWall) {
		assert otherWall != null;
		return end.getColumn() >= otherWall.getStart().getColumn()
				&& end.getColumn() <= otherWall.getStart().getColumn();
	}

	/**
	 * Checks whether the column of the start of the current wall is within the
	 * other wall.
	 * <p>
	 * Requires that otherWall is not null.
	 *
	 * @param otherWall another wall
	 * @return true if the column of the start of the current wall is within the
	 *         other wall, false otherwise.
	 */
	private boolean isStartColumnWithinOtherWall(final HouseWall otherWall) {
		assert otherWall != null;
		return start.getColumn() >= otherWall.getStart().getColumn()
				&& start.getColumn() <= otherWall.getEnd().getColumn();
	}

	/**
	 * Checks whether another wall intersects with the current wall.
	 * <p>
	 * Requires that otherWall is not null.
	 *
	 * @param otherWall the other wall
	 * @return true if the walls overlap, false otherwise.
	 */
	private boolean intersectionWallsOverlap(final HouseWall otherWall) {
		assert otherWall != null;

		final HouseWall horizontalWall;
		final HouseWall verticalWall;

		if (this.isHorizontal() && otherWall.isVertical()) {
			horizontalWall = this;
			verticalWall = otherWall;
		} else if (this.isVertical() && otherWall.isHorizontal()) {
			horizontalWall = otherWall;
			verticalWall = this;
		} else {
			return false;
		}

		for (int i = horizontalWall.getStart().getColumn();
				i <= horizontalWall.getEnd().getColumn();
				i++) {
			Location horizontalLoc = Location.from(horizontalWall.getStart().getRow(), i);

			for (int j = verticalWall.getStart().getRow();
					j <= verticalWall.getEnd().getRow();
					j++) {
				Location verticalLoc = Location.from(j, verticalWall.getStart().getColumn());
				if (verticalLoc.equals(horizontalLoc)) {
					return true;
				}
			}
		}
		return false;
	}
}
