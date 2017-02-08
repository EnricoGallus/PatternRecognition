import java.util.Arrays;

public class BruteCollinearPoints {

    private LineSegment[] result = new LineSegment[0];
    private int counter = 0;

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

        result = new LineSegment[points.length / 4 + 1];
        Point[] parts = new Point[4];

        int n = points.length;
        for (int i = 0; i < n - 3; i++) {
            parts[0] = points[i];

            for (int j = i+1; j < n-2; j++) {
                parts[1] = points[j];

                for (int k = j+1; k < n-1; k++) {
                    if (points[j].slopeOrder().compare(points[i], points[k]) != 0) {
                        continue;
                    }

                    parts[2] = points[k];
                    for (int l = k+1; l < n; l++) {
                        if (points[k].slopeOrder().compare(points[j], points[l]) == 0) {
                            parts[3] = points[l];
                            Arrays.sort(parts);
                            result[counter++] = new LineSegment(parts[0], parts[3]);
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
        return counter;
    }

    /**
     * the line segments
     * @return
     */
    public LineSegment[] segments() {
        return Arrays.copyOf(result, counter);
    }
}
