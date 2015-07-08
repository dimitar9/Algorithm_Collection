public class Solution {
    public int findMin(int[] nums) {
        
        if(nums.length <2) return nums[0];
        int st = 0;
        int end = nums.length-1;
        int mid = 0;
        while(st < end ){
            mid = st + (end-st)/2;
            if(nums[mid] > nums[end]){
                st = mid + 1;
            } else if (nums[mid] < nums[st]){
                end = mid ;
            } else {
                end--;
            }
        }
        return nums[st];
    }
}
