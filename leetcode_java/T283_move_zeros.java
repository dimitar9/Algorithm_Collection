public class Solution {

  public void moveZeroes(int[] nums) {

    int p = 0;// Index of none-zero number

    for (int i : nums) 

        if (i != 0) 

          nums[p++] = i;

    while (p < nums.length) nums[p++] = 0;

}

}
