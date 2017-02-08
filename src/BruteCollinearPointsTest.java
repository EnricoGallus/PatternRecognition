import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BruteCollinearPointsTest {

    @Test
    public void FailingTest() {
        Point[] points = new Point[10];
        points[0] = new Point(1000, 17000);

        points[1] = new Point(1, 0);
        points[2] = new Point(7, 1);
        points[3] = new Point(312, 2);
        points[4] = new Point(21441, 3);
        points[5] = new Point(223, 4);
        points[6] = new Point(5612, 5);

        points[7] = new Point(29000, 17000);
        points[8] = new Point(13000, 17000);
        points[9] = new Point(17000, 17000);

        BruteCollinearPoints bcp = new BruteCollinearPoints(points);

        assertEquals(1, bcp.numberOfSegments());

        assertEquals("(1000, 17000) -> (29000, 17000)", bcp.segments()[0].toString());
    }
}
