public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap map = new HashMap<>();
        for(int i=0;i < nums.length; i++){
            if (map.get(nums[i])!=null){
                return true;
            }
            map.put(nums[i],1);
        }
        return false;
    }
}
