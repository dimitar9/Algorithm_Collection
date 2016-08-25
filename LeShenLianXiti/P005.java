/*
平面上一堆点，找两个点使由这两个点确定的直线平分剩余所有点。只说了下思路，并没有写代码。
我的思路是先找到最下面的点P，然后根据其余点与P的连线和P所在水平线的夹角找中位点。
又说了可能有共线的情况，小哥说不用考虑共线。不知道思路对不对。

follow up 假定不存在重合点 但可以共线 
解法:
(1) 如果不存在共线,则只需找到一个极点(比如最小y值的最小x),然后按照极角序排序,取中间那个即可
点的个数是奇数可以提前退出。
O(nlogn)

(2) 当存在共线时,枚举每一个点,按按照极角序排序,双指针比较某个连线左右两侧是否等个数。
O(n^2logn)
*/

class Solution {
    public static void main(String... args) {
        int[] x = {-1, 1, 0, -2, -1, 0, 1, 2};
        int[] y = {2, 2, 1, 0, 0, 0, 0, 0};
        Point[] points = new Point[x.length];
        for (int i = 0; i < x.length; ++i) {
            points[i] = new Point(x[i], y[i]);
        }
        System.out.println(Arrays.toString(partition(points)));
    }

    public static Point[] partition(Point[] points) {
        int N = points.length;
        for (int i = 0; i < N; ++i) {
            Point[] ans = partition(points, i, N);
            if (ans != null) return ans;
        }
        return null;
    }

    private static Point[] partition(Point[] points, int me, int N) {
        double eps = 1E-15;
        int R = N - 1;
        Arrow[] arrows = new Arrow[2 * R];
        for (int i = 0, j = 0; i < N; ++i)
            if (i != me) arrows[j++] = new Arrow(points[me], points[i]);
        Arrays.sort(arrows, 0, R);
        for (int i = R; i < 2 * R; ++i)
            arrows[i] = arrows[i - R].plus(2 * Math.PI);

        for (int i = 0, j = 0, k = 0, u = 0, v = 0; i < R; ++i) {
            while (j + 1 < 2 * R && arrows[j].diff(arrows[i]) < eps) j++;
            while (k < 2 * R && arrows[k].diff(arrows[i]) < Math.PI - eps) k++;
            while (u < 2 * R && arrows[u].diff(arrows[i]) < Math.PI + eps) u++;
            while (v < 2 * R && arrows[v].diff(arrows[i]) < 2 * Math.PI - eps) v++;
            if (k - j == v - u) return new Point[]{points[me], arrows[i].q};
        }
        return null;
    }
}


class Arrow implements Comparable<Arrow> {
    double theta;
    Point p, q;
    public Arrow(Point p, Point q) {
        this(p.angle(q), p, q);
    }

    public Arrow(double theta, Point p, Point q) {
        this.theta = theta;
        this.p = p;
        this.q = q;
    }

    public Arrow plus(double delta) {
        return new Arrow(theta + delta, p, q);
    }

    public double diff(Arrow that) {
        return this.theta - that.theta;
    }
    @Override
    public int compareTo(Arrow that) {
        if (this.theta < that.theta) return -1;
        if (this.theta > that.theta) return +1;
        return 0;
    }
}
class Point {

    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    double angle(Point that) {
        return Math.atan2(that.y - this.y, that.x - this.x);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
