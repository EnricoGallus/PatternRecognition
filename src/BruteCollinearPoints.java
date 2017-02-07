import java.util.Arrays;

public class BruteCollinearPoints {

    private LineSegment[] result = new LineSegment[0];

    /**
     * finds all line segments containing 4 points
     * @param points
     */
    public BruteCollinearPoints(Point[] points) {

        if (points == null) {
            throw new NullPointerException();
        }

        if (points.length < 4) {
            return;
        }

        boolean found;
        int n = points.length;
        for (int i = 0; i < n - 3; i++) {
            LineSegment[] part = new LineSegment[3];
            found = false;

            for (int j = i+1; j < n-2; j++) {
                if (found) break;
                part[0] = new LineSegment(points[i], points[j]);

                for (int k = j+1; k < n-1; k++) {
                    if (found || points[j].slopeOrder().compare(points[i], points[k]) != 0) {
                        break;
                    }

                    part[1] = new LineSegment(points[j], points[k]);
                    for (int l = k+1; l < n; l++) {
                        if (points[k].slopeOrder().compare(points[j], points[l]) == 0) {
                            part[2] = new LineSegment(points[k], points[l]);
                            result = concat(result, part);
                            found = true;
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * the number of line segments
     * @return
     */
    public int numberOfSegments() {
        return result.length;
    }

    /**
     * the line segments
     * @return
     */
    public LineSegment[] segments() {
        return result.clone();
    }

    private static <T> T[] concat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
}
