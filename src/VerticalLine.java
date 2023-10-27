import java.util.*;

// 1,3;3,3;6,3 -> false
// 1,3;3,3 -> true

public class VerticalLine {
    static class Point {
        public float x;
        public float y;

        public Point(float x, float y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.nextLine().split(";");
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            String[] coordinates = a[i].split(",");
            points.add(new Point(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])));
        }
        System.out.println(verticalLineExists(points));
    }

    private static boolean verticalLineExists(List<Point> points) {
        Set<Point> unpairedPoints = new HashSet<>();
        float mean = mean(points);
        for (Point point: points) {
            if (point.x == mean) {
                continue;
            }
            Point symmetricPoint = new Point(mean * 2 - point.x, point.y);
            if (unpairedPoints.contains(symmetricPoint)) {
                unpairedPoints.remove(symmetricPoint);
            } else {
                unpairedPoints.add(point);
            }
        }
        return unpairedPoints.isEmpty();
    }

    private static float mean(List<Point> points) {
        float sum = 0;
        for (Point point: points) {
            sum += point.x;
        }
        return sum / points.size();
    }
}
