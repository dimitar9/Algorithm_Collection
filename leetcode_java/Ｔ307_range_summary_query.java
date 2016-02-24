public class NumArray {
    /**
     * Binary Indexed Trees (BIT or Fenwick tree):
     * https://www.topcoder.com/community/data-science/data-science-
     * tutorials/binary-indexed-trees/
     * 
     * Example: given an array a[0]...a[7], we use a array BIT[9] to
     * represent a tree, where index [2] is the parent of [1] and [3], [6]
     * is the parent of [5] and [7], [4] is the parent of [2] and [6], and
     * [8] is the parent of [4]. I.e.,
     * 
     * BIT[] as a binary tree:
     *            ______________*
     *            ______*
     *            __*     __*
     *            *   *   *   *
     * indices: 0 1 2 3 4 5 6 7 8
     * 
     * BIT[i] = ([i] is a left child) ? the partial sum from its left most
     * descendant to itself : the partial sum from its parent (exclusive) to
     * itself. (check the range of "__").
     * 
     * Eg. BIT[1]=a[0], BIT[2]=a[1]+BIT[1]=a[1]+a[0], BIT[3]=a[2],
     * BIT[4]=a[3]+BIT[3]+BIT[2]=a[3]+a[2]+a[1]+a[0],
     * BIT[6]=a[5]+BIT[5]=a[5]+a[4],
     * BIT[8]=a[7]+BIT[7]+BIT[6]+BIT[4]=a[7]+a[6]+...+a[0], ...
     * 
     * Thus, to update a[1]=BIT[2], we shall update BIT[2], BIT[4], BIT[8],
     * i.e., for current [i], the next update [j] is j=i+(i&-i) //double the
     * last 1-bit from [i].
     * 
     * Similarly, to get the partial sum up to a[6]=BIT[7], we shall get the
     * sum of BIT[7], BIT[6], BIT[4], i.e., for current [i], the next
     * summand [j] is j=i-(i&-i) // delete the last 1-bit from [i].
     * 
     * To obtain the original value of a[7] (corresponding to index [8] of
     * BIT), we have to subtract BIT[7], BIT[6], BIT[4] from BIT[8], i.e.,
     * starting from [idx-1], for current [i], the next subtrahend [j] is
     * j=i-(i&-i), up to j==idx-(idx&-idx) exclusive. (However, a quicker
     * way but using extra space is to store the original array.)
     */

    int[] nums;
    int[] BIT;
    int n;

    public NumArray(int[] nums) {
        this.nums = nums;

        n = nums.length;
        BIT = new int[n + 1];
        for (int i = 0; i < n; i++)
            init(i, nums[i]);
    }

    public void init(int i, int val) {
        i++;
        while (i <= n) {
            BIT[i] += val;
            i += (i & -i);
        }
    }

    void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        init(i, diff);
    }

    public int getSum(int i) {
        int sum = 0;
        i++;
        while (i > 0) {
            sum += BIT[i];
            i -= (i & -i);
        }
        return sum;
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
