/*Trapping Rain Water
 *http://yucoding.blogspot.com/2013/05/leetcode-question-111-trapping-rain.html
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.*/

int trap(int A[], int n) {
    if (n<2) { return 0;}

    int *l = new int[n];
    int *r = new int[n];

    int water = 0;

    l[0] = 0;
    for (int  i=1; i<n; i++) {
        l[i] = max(A[i-1],l[i-1]);
    }
    r[n-1]=0;
    for (int i=n-2; i>=0; i--){
        r[i] = max(A[i+1],r[i+1]);
    }

    for (int i=0; i<n; i++)
    {
        if((min(l[i],r[i]) - A[i]) > 0 {
            water += min(l[i],r[i]);        
        }
    }

    return water;


}
