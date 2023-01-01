package org.example;

public enum Orientation {
    NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");

    private final String value;

    Orientation(String value) {
        this.value = value;
    }

    /**
     * Returns the orientation corresponding to the given character.
     *
     * @param string the string to map to an orientation
     * @return the orientation corresponding to the given character
     * @throws IllegalArgumentException if the character is not a valid orientation
     */
    public static Orientation fromString(String string) {
        for (Orientation orientation : Orientation.values()) {
            if (orientation.getValue().equals(string)) {
                return orientation;
            }
        }
        throw new IllegalArgumentException("Invalid orientation: " + string);
    }

    public String getValue() {
        return value;
    }

    /**
     * Returns the orientation to the left of the current orientation.
     *
     * @return the orientation to the left of the current orientation
     */
    public Orientation left() {
        switch (this) {
            case NORTH:
                return WEST;
            case EAST:
                return NORTH;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
            default:
                throw new IllegalArgumentException("Invalid orientation: " + this);
        }
    }

    /**
     * Returns the orientation to the right of the current orientation.
     *
     * @return the orientation to the right of the current orientation
     */
    public Orientation right() {
        switch (this) {
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            default:
                throw new IllegalArgumentException("Invalid orientation: " + this);
        }
    }
}