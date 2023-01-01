/**
 * Represents a mower that can be programmed to move on a square lawn.
 * The mower's position is represented by coordinates (x, y) and an
 * orientation (N, E, W, S). The mower can be controlled by a simple
 * sequence of instructions (G, D, A). G and D turn the mower 90 degrees
 * to the left or right without moving the mower. A moves the mower
 * forward one space in the direction it is facing. If the position after
 * moving is outside the lawn, the mower retains its position and orientation
 * and continues to the next instruction.
 */
package org.example;


import org.apache.log4j.Logger;

public class Mower {
    private static final Logger logger = Logger.getLogger(Mower.class.getName());
    private final String instructions;
    private int x;
    private int y;
    private Orientation orientation;

    /**
     * Constructs a new mower with the given position, orientation, and instructions.
     *
     * @param x            the x coordinate of the mower's position
     * @param y            the y coordinate of the mower's position
     * @param orientation  the mower's orientation (N, E, W, S)
     * @param instructions the instructions for the mower to follow
     */
    public Mower(int x, int y, Orientation orientation, String instructions) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.instructions = instructions;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public String getInstructions() {
        return instructions;
    }

    /**
     * Processes the instructions for the mower and updates the mower's position and orientation.
     * If the mower tries to move off the edge of the lawn, it retains its position and orientation.
     *
     * @param maxX the maximum x coordinate of the lawn
     * @param maxY the maximum y coordinate of the lawn
     * @throws IllegalArgumentException if the instructions contain an invalid character
     */
    public void processInstructions(int maxX, int maxY) throws IllegalArgumentException {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'G':
                    orientation = orientation.left();
                    logger.debug("Turn left : Mower at position (" + x + ", " + y + ") with orientation " + orientation);
                    break;
                case 'D':
                    orientation = orientation.right();
                    logger.debug("Turn right : Mower at position (" + x + ", " + y + ") with orientation " + orientation);
                    break;
                case 'A':
                    moveForward(maxX, maxY);
                    logger.debug("Move forward : Mower at position (" + x + ", " + y + ") with orientation " + orientation);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid instruction: " + instruction);
            }
        }
        logger.debug("Mower at position (" + x + ", " + y + ") with orientation " + orientation);
        // Communicate the mower's position and orientation
        System.out.println(x + " " + y + " " + orientation.getValue());
    }

    /**
     * Moves the mower forward one space in the current orientation.
     * If the mower tries to move off the edge of the lawn, it retains its position and orientation.
     *
     * @param maxX the maximum x coordinate of the lawn
     * @param maxY the maximum y coordinate of the lawn
     */
    private void moveForward(int maxX, int maxY) {
        switch (orientation) {
            case NORTH:
                if (y < maxY) {
                    y++;
                }
                break;
            case EAST:
                if (x < maxX) {
                    x++;
                }
                break;
            case SOUTH:
                if (y > 0) {
                    y--;
                }
                break;
            case WEST:
                if (x > 0) {
                    x--;
                }
                break;
        }
    }

    @Override
    public String toString() {
        return "Mower{" +
                "x=" + x +
                ", y=" + y +
                ", orientation=" + orientation +
                ", instructions='" + instructions + '\'' +
                '}';
    }
}
