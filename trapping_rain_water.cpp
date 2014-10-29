//http://obcerver.com/post/view/p/21
/*题目：给一个凹凸不平的积木组合，问能盛住的水的体积为多少？

思路：每一点能接住的水量取决于它左边的最高高度，和右边的最高高度中相对低的那个。

water[i] = min(leftHighest[i], rightHighest[i]) - A[i];

如果左右两边的最高高度都比它低，water[i] < 0，说明没法接住水。

leftHighest[]和rightHighest[]可以通过两遍扫描，用O(n)的时间求出来。

代码：*/

int trap(int A[], int n) {
    int leftHighest[n], rightHighest[n];
    int max;
 
    max = 0;
    leftHighest[0] = 0;
    for (int i=1; i<n; i++) {
        if (A[i-1] > max) {
            max = A[i-1];
        }
        leftHighest[i] = max;
    }
 
    max = 0;
    rightHighest[n-1] = 0;
    for (int i=n-2; i>=0; i--) {
        if (A[i+1] > max) {
            max = A[i+1];
        }
        rightHighest[i] = max;
    }
 
    int sum = 0;
    for (int i=0; i<n; i++) {
        int water = min(leftHighest[i], rightHighest[i]) - A[i];
        if (water > 0) {
            sum += water;
        }
    }
 
    return sum;
}
