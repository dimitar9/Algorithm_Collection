public int findDuplicate(int[] nums) {

    int entry=0;





    int fast = 0;

    int slow = 0;



    do {

        fast = nums[nums[fast]];

        slow = nums[slow];

    } while (fast != slow);



    slow = entry;

    while (slow != fast) {

        slow = nums[slow];

        fast = nums[fast];

    }



    return slow;



}
