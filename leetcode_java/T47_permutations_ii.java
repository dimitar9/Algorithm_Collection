public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        permute(nums, 0, permutations);
        return permutations;
    }

    public void permute(int[] nums, int begin, List<List<Integer>> permutations) {
        if ( begin == nums.length-1 ) {
            permutations.add( convertArrayToList(nums) );
        } else if ( begin < nums.length-1 ) {
            for ( int i = begin; i < nums.length; i++ ) {
                if ( i == begin || nums[begin] != nums[i] ) {
                    swap(nums, i, begin);
                    permute(nums, begin+1, permutations);
                }
            }
            for ( int i = begin; i+1 < nums.length; i++ ) {
                swap(nums, i, i+1);
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        if ( i != j ) {
            int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
        }
    }

    public List<Integer> convertArrayToList(int[] nums) {
        List<Integer> list = new ArrayList<Integer>(nums.length);
        for ( int num : nums ) { list.add(num); }
        return list;
    }
}
