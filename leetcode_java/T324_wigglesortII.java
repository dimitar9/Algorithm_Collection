class Solution {

public:

void wiggleSort(vector<int>& nums) {

    vector<int> sorted(nums);

    sort(sorted.begin(), sorted.end());

    for (int i=nums.size()-1, j=0, k=i/2+1; i>=0; i--)

        nums[i] = sorted[i&1 ? k++ : j++];

}

};
