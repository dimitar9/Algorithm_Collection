public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        k = k % nums.length;
        reverse(nums, 0, nums.length-k-1);
        reverse(nums, nums.length-k, nums.length-1);
        reverse(nums, 0, nums.length-1);
    }
    private void reverse(int[] num, int left, int right) {
        while (left < right) {
            int t = num[left];
            num[left] = num[right];
            num[right] = t;
            left++;
            right--;
        }
    }
}

