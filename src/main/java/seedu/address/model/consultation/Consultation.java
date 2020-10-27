package seedu.address.model.consultation;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.model.person.Address;
import seedu.address.model.person.Name;

/**
 * Represents a Consultation in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Consultation {
    // Identity fields
    private final Name name;
    private final Day date;
    private final Time time;
    private final Address location;
    private final Type type;

    /**
     * Every field must be present and not null.
     */
    public Consultation(Name name, Day date, Time time, Address location, Type type) {
        requireAllNonNull(name, date, time, location, type);
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.type = type;
    }
    public Name getName() {
        return name;
    }
    public Day getDate() {
        return date;
    }

    public Address getLocation() {
        return location;
    }

    public Time getTime() {
        return time;
    }

    public Type getType() {
        return type;
    }
    /**
     * Returns true if both consultation of the same date, time have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two consultations.
     */
    public boolean isSameConsultation(Consultation consultation) {
        if (consultation == this) {
            return true;
        }

        return consultation != null
                && consultation.getDate().equals(getDate())
                && consultation.getTime().equals(getTime())
                && consultation.getName().equals(getName());
    }

    /**
     * Returns true if both consultation have the same data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Consultation)) {
            return false;
        }

        Consultation consultation = (Consultation) other;
        return consultation.getName().equals(getName())
                && consultation.getType().equals(getType())
                && consultation.getTime().equals(getTime())
                && consultation.getDate().equals(getDate())
                && consultation.getLocation().equals(getLocation());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, date, location, time, type);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Date: ")
                .append(getDate())
                .append(" Time: ")
                .append(getTime())
                .append(" Location: ")
                .append(getLocation())
                .append(" Type: ")
                .append(getType());
        return builder.toString();
    }
}
