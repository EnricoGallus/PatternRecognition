import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {
    @Test
    public void SlopeToHorizontal() {
        Point p1 = new Point(304, 426);
        Point p2 = new Point(209, 426);

        double result = p1.slopeTo(p2);
        assertEquals(0.0, result);
    }

    @Test
    public void SlopeToVertical() {
        Point p1 = new Point(209, 427);
        Point p2 = new Point(209, 426);

        double result = p1.slopeTo(p2);
        assertEquals(Double.POSITIVE_INFINITY, result);
    }

    @Test
    public void SlopeToNotDefined() {
        Point p1 = new Point(209, 427);
        Point p2 = new Point(209, 427);

        double result = p1.slopeTo(p2);
        assertEquals(Double.NEGATIVE_INFINITY, result);
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

    @Test
    public void Comparator_Wrong_sign() {
        Point p = new Point(311, 248);
        Point q = new Point(311, 205);
        Point r = new Point(409, 396);

        assertEquals(1, p.slopeOrder().compare(q, r));
        assertEquals(Double.POSITIVE_INFINITY, p.slopeTo(q));
        assertEquals(1.510204081632653, p.slopeTo(r));
    }

    @Test
    public void Comparator_Failing_Transitiv() {
        Point p = new Point(305, 340);
        Point q = new Point(396, 182);
        Point r = new Point(7, 340);

        assertEquals(-1, p.slopeOrder().compare(q, r));
        assertEquals(-1.7362637362637363, p.slopeTo(q));
        assertEquals(0.0, p.slopeTo(r));
    }

    @Test
    public void Comparator_Failing_Transitiv_2() {
        Point p = new Point(1, 9);
        Point q = new Point(5, 0);
        Point r = new Point(7, 9);

        assertEquals(-1, p.slopeOrder().compare(q, r));
        assertEquals(-2.25, p.slopeTo(q));
        assertEquals(0.0, p.slopeTo(r));
    }

    @Test
    public void SlopeTo_Failing() {
        Point p = new Point(4, 3);
        Point q = new Point(1, 3);

        assertEquals(0.0, p.slopeTo(q));
    }
}
