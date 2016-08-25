/*
大概就是一个数组
1,4,2,6....
每次调用一个函数，按照数组里面的数字的大小，返回相应的Index。
比如， 上面的例子就是
1/13 的概率返回0,
4/13的概率返回1.
* */
public class WeightedRandom {

    int[] sum; // sum[i] is the sum of weight [0, i]

    public WeightedRandom(int weight[]) {
        int n = weight.length;
        sum = new int[n];
        sum[0] = weight[0];
        for (int i = 1; i < n; ++i)
            sum[i] = sum[i - 1] + weight[i];
    }

    private int search(int w) {
        int l = 0, r = sum.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (sum[mid] < w)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    public int nextIndex() {
        // generate random weight in [1, sum[n-1]]
        return search((int) (Math.random() * (sum[sum.length - 1])) + 1);
    }

    public static void main(String... args) {
        WeightedRandom wr = new WeightedRandom(new int[]{0, 1, 4, 2, 0, 6});
        for (int i = 1; i < 14; ++i) {
            System.out.printf("%d ", wr.search(i));
        }
        System.out.println();
    }
}
