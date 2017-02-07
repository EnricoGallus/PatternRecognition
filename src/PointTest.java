import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {
    @Test
    public void SlopeToFailing() {
        Point p1 = new Point(304, 426);
        Point p2 = new Point(209, 426);

        double result = p1.slopeTo(p2);
        assertEquals(0, result);
    }

    @Test
    public void Comparator_With_Null() {
        Point p1 = new Point(304, 426);
        Point p2 = new Point(209, 426);

        //double result = Assertions.assertThrows(IllegalArgumentException.class, () -> { p1.slopeOrder().compare(p2, p2); } );
        //assertEquals(0, result);
    }

    @Test
    public void Comparator_All() {
        Point p = new Point(380, 168);
        Point q = new Point(486, 433);
        Point r = new Point(83, 238);

        assertEquals(1, p.slopeOrder().compare(q, r));
        assertEquals(2.5, p.slopeTo(q));
        assertEquals(-0.2356902356902357, p.slopeTo(r));
    }
}
