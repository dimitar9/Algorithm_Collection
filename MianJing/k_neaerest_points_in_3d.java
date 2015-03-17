import java.util.ArrayList;



//Using heap as implementation of priority queue to store the fist k points. So the complexity is O(n log k) with O(k) memory.


public class ClosestPoints {

    public static void main(String[] args) {
        Collection<Point> points = new ArrayList<Point>();
        Point origin = new Point(0, 0);
        points.add(new Point(1, 1, origin));
        points.add(new Point(1, 3, origin));
        points.add(new Point(-1, 1, origin));
        points.add(new Point(-1, 3, origin));
        points.add(new Point(1, -1, origin));
        points.add(new Point(3, -1, origin));
        points.add(new Point(-1, -1, origin));
        points.add(new Point(-1, 3, origin));
        points.add(new Point(2, 2, origin));

        Collection<Point> closestPoints = new ClosestPoints().getClosestPoints(points, 5);
        System.out.print(closestPoints);
    }

    public Collection<Point> getClosestPoints(Collection<Point> points, int k) {
        PriorityQueue<Point> queue = new PriorityQueue<Point>(k);

        for (Point point : points) {
            if (queue.size() < k) {
                queue.offer(point);
            } else {
                if (point.compareTo(queue.peek()) > 0) {
                    queue.poll();
                    queue.offer(point);
                }
            }
        }

        return queue;
    }

}

class Point implements Comparable<Point> {
    int x, y;
    double dist;

    public Point(int x, int y, Point originPoint) {
        this.x = x;
        this.y = y;
        this.dist = Math.hypot(x - originPoint.x, y - originPoint.y);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point that) {
        return Double.valueOf(that.dist).compareTo(dist);
    }

    @Override
    public String toString() {
        return "x: " + x + " y: " + y;
    }
}
