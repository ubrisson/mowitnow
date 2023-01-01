import org.example.Mower;
import org.example.Orientation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MowerTest {

    @Test
    public void testTurningLeft() {
        Mower mower = new Mower(0, 0, Orientation.NORTH, "G");
        mower.processInstructions(5, 5);
        assertEquals(Orientation.WEST, mower.getOrientation());
    }

    @Test
    public void testTurningRight() {
        Mower mower = new Mower(0, 0, Orientation.NORTH, "D");
        mower.processInstructions(5, 5);
        assertEquals(Orientation.EAST, mower.getOrientation());
    }

    @Test
    public void testMovingForward() {
        Mower mower = new Mower(0, 0, Orientation.NORTH, "A");
        mower.processInstructions(5, 5);
        assertEquals(0, mower.getX());
        assertEquals(1, mower.getY());

    }

    @Test
    public void testEdges() {
        Mower mower;
        mower = new Mower(0, 0, Orientation.NORTH, "AAAAAAAAAAA");
        mower.processInstructions(5, 5);
        assertEquals(0, mower.getX());
        assertEquals(5, mower.getY());

        mower = new Mower(0, 0, Orientation.EAST, "AAAAAAAAAAA");
        mower.processInstructions(5, 5);
        assertEquals(5, mower.getX());
        assertEquals(0, mower.getY());
    }
}
