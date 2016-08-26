/*
24. 给一个API，O(1)时间计算 slidingwindow avg, global avg, update(insert) value;

LC 346
*/
import java.util.ArrayDeque;
import java.util.Queue;

public class MovingAverage {

    Queue<Integer> window;
    int windowLimit;
    int globalSize;
    double globalSum;
    double windowSum;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.windowLimit = size;
        this.globalSize = 0;
        this.globalSum = 0;
        this.windowSum = 0;
        this.window = new ArrayDeque<>();
    }


    public void add(int val) {
        window.add(val);
        windowSum += val;
        globalSum += val;
        if (window.size() > windowLimit)
            windowSum -= window.poll();
        globalSize++;
    }

    public double windowAvg() {
        if (window.size() == 0)
            throw new IllegalStateException("Empty window.");
        return windowSum / window.size();
    }

    public double globalAvg() {
        if (globalSize == 0)
            throw new IllegalStateException("Empty collection.");
        return globalSum / globalSize;
    }

    @Override
    public String toString() {
        return "(windowAvg: " + windowAvg() + ", globalAvg: " + globalAvg() + ")";
    }
}

class Tests {
    public static void main(String... args) {
        MovingAverage ma = new MovingAverage(10);
        for (int i = 0; i< 100; ++i) {
            ma.add(i);
            System.out.println(ma);
        }
    }
}
