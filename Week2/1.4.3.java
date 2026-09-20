package edu.princeton.cs.algs4;

/**
 *  The {@code DoublingTest} class provides a client for measuring
 *  the running time of a method using a doubling test.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/14analysis">Section 1.4</a>
 *  of <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class DoublingTest {
    private static final int MAXIMUM_INTEGER = 1000000;
    private static final int MAX_POINTS = 30; // Lưu tối đa 30 điểm để tránh tràn số nguyên

    // This class should not be instantiated.
    private DoublingTest() { }

    /**
     * Returns the amount of time to call {@code ThreeSum.count()} with <em>n</em>
     * random 6-digit integers.
     * @param n the number of integers
     * @return amount of time (in seconds) to call {@code ThreeSum.count()}
     *   with <em>n</em> random 6-digit integers
     */
    public static double timeTrial(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniformInt(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        Stopwatch timer = new Stopwatch();
        int ignore = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    private static void drawNormal(double[] n, double[] time, int count) {
        // X và Y lớn nhất hiện tại.
        double maxN = n[count - 1];
        double maxTime = time[0];

        for (int i = 0; i < count; i++) {
            if (time[i] > maxTime) {
                maxTime = time[i];
            }
        }

        StdDraw.setXscale(0, maxN * 1.10);
        StdDraw.setYscale(0, maxTime * 1.10);

        StdDraw.clear();

        StdDraw.setPenRadius(0.006);
        StdDraw.setPenColor(StdDraw.BLUE);

        // Nối các điểm đo.
        for (int i = 1; i < count; i++) {
            StdDraw.line(
                    n[i - 1], time[i - 1],
                    n[i], time[i]
            );
        }

        // Vẽ các điểm.
        StdDraw.setPenRadius(0.015);

        for (int i = 0; i < count; i++) {
            StdDraw.point(n[i], time[i]);
        }

        StdDraw.setPenRadius();
    }

    private static void drawLogLog(double[] n, double[] time, int count) {

        double minX = Math.log(n[0]);
        double maxX = Math.log(n[count - 1]);

        double minY = Math.log(time[0]);
        double maxY = Math.log(time[0]);

        for (int i = 0; i < count; i++) {
            double logTime = Math.log(time[i]);

            if (logTime < minY) {
                minY = logTime;
            }

            if (logTime > maxY) {
                maxY = logTime;
            }
        }

        // Thêm khoảng trống để đồ thị chiếm phần lớn cửa sổ.
        double xMargin = (maxX - minX) * 0.10;
        double yMargin = (maxY - minY) * 0.10;

        // Trường hợp chỉ mới có 1 điểm.
        if (xMargin == 0) {
            xMargin = 1.0;
        }

        if (yMargin == 0) {
            yMargin = 1.0;
        }

        StdDraw.setXscale(
                minX - xMargin,
                maxX + xMargin
        );

        StdDraw.setYscale(
                minY - yMargin,
                maxY + yMargin
        );

        StdDraw.clear();

        StdDraw.setPenRadius(0.006);
        StdDraw.setPenColor(StdDraw.RED);

        // Nối các điểm trong hệ tọa độ log-log.
        for (int i = 1; i < count; i++) {
            double x1 = Math.log(n[i - 1]);
            double y1 = Math.log(time[i - 1]);

            double x2 = Math.log(n[i]);
            double y2 = Math.log(time[i]);

            StdDraw.line(x1, y1, x2, y2);
        }

        // Vẽ các điểm.
        StdDraw.setPenRadius(0.015);

        for (int i = 0; i < count; i++) {
            StdDraw.point(
                    Math.log(n[i]),
                    Math.log(time[i])
            );
        }

        StdDraw.setPenRadius();
    }

    /**
     * Prints table of running times to call {@code ThreeSum.count()}
     * for arrays of size 250, 500, 1000, 2000, and so forth.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        double[] n = new double[MAX_POINTS];
        double[] time = new double[MAX_POINTS];
        int count = 0;
        for (int size = 250; count < MAX_POINTS; size += size) {
            double elapsedTime = timeTrial(size);
            n[count] = size;
            time[count] = elapsedTime;
            count++;
            StdOut.printf("%7d %7.3f\n", size, elapsedTime);

            drawNormal(n, time, count);
            drawLogLog(n, time, count);
        }
    }
}
