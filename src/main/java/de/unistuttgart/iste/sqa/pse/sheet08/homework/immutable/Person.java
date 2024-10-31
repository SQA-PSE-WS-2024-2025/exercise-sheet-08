package de.unistuttgart.iste.sqa.pse.sheet08.homework.immutable;

import java.util.Date;

/**
 * Represents a person with a name and birthdate.
 *
 * Name and birthdate must not be {@code null} and the name must not be blank.
 *
 * @author your name
 */
public class Person {

	public String name;
	public Date birthDate;

	/**
	 * Creates a new person with the given name and birthdate.
	 *
	 * @param name      Name of the person. Must not be {@code null} or blank.
	 * @param birthDate Birth date of the person. Must not be {@code null}.
	 */
	public Person(final String name, final Date birthDate) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("A person must not have a null or blank name");
		}
		if (birthDate == null) {
			throw new IllegalArgumentException("A person's birth date must not be null.");
		}
		this.name = name;
		this.birthDate = birthDate;
	}

	/**
	 * @return This person's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return This person's birth date.
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * Sets this person's name.
	 *
	 * @param name The new name. Must not be {@code null} or blank.
	 * @throws IllegalArgumentException If the preconditions are not satisfied.
	 */
	public void setName(final String name) throws IllegalArgumentException {
		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException("A person must not have a null or blank name.");
		}
		this.name = name;
	}

	/**
	 * Sets this person's birth date.
	 *
	 * @param birthDate The new birth date. Must not be {@code null}.
	 */
	public void setBirthDate(final Date birthDate) {
		if (birthDate == null) {
			throw new IllegalArgumentException("A person's birth date must not be null.");
		}
		this.birthDate = birthDate;
	}
}
